# 🔴 Redis — Guia Completo

---

## 1. O que é Redis?

Redis (**Re**mote **Di**ctionary **S**erver) é um banco de dados **in-memory**, **key-value**, **NoSQL** com persistência opcional.

| Característica | Detalhe |
|---|---|
| Velocidade | ~100.000 ops/seg (single thread) |
| Modelo | Key → Value (vários tipos de value) |
| Persistência | RDB snapshot + AOF log |
| Protocolo | RESP (binário, simples) |
| Padrão | Single-threaded event loop (como Node.js) |
| Cluster | Redis Cluster para sharding horizontal |

**Por que usar?**
- Cache ultra-rápido
- Session store distribuído
- Rate limiting
- Pub/Sub messaging
- Leaderboard / ranking
- Distributed locks
- Queue (com Streams)

---

## 2. Data Types

### 2.1 — String
```
SET name "Stay Hard"
GET name                     → "Stay Hard"
SETEX session:abc 3600 "ok"  → expira em 1h
INCR page_views              → incrementa counter
MSET a 1 b 2 c 3             → múltiplos de uma vez
MGET a b c                   → ["1", "2", "3"]
```

### 2.2 — Hash (Map)
```
HSET user:1 name "João" email "joao@mail.com" age "28"
HGET user:1 name             → "João"
HGETALL user:1               → todos os campos
HINCRBY user:1 age 1         → incrementa campo
HDEL user:1 email            → deleta campo
```

### 2.3 — List
```
LPUSH notifications "msg1" "msg2"    → adiciona no início
RPUSH notifications "msg3"           → adiciona no fim
LLEN notifications                   → tamanho
LRANGE notifications 0 9             → pega primeiros 10
LPOP notifications                   → remove do início
RPOP notifications                   → remove do fim
```

### 2.4 — Set
```
SADD tags "java" "spring" "redis"
SMEMBERS tags                 → todos os membros
SISMEMBER tags "java"         → true/false
SINTER tags tags2             → interseção
SUNION tags tags2             → união
SDIFF tags tags2              → diferença
SCARD tags                    → quantidade
```

### 2.5 — Sorted Set (ZSet)
```
ZADD leaderboard 100 "player1" 200 "player2" 150 "player3"
ZRANGE leaderboard 0 -1 WITHSCORES    → rank crescente
ZREVRANGE leaderboard 0 2 WITHSCORES  → top 3
ZRANK leaderboard "player1"           → posição
ZINCRBY leaderboard 50 "player1"      → incrementa score
ZSCORE leaderboard "player1"          → score atual
```

### 2.6 — Stream
```
XADD events * type "login" user "joao"    → cria evento
XLEN events                               → quantidade
XRANGE events - +                         → todos os eventos
XREAD COUNT 10 STREAMS events 0           → lê últimos 10
XGROUP CREATE events group1 0             → cria consumer group
XREADGROUP GROUP group1 consumer1 COUNT 5 STREAMS events >
```

---

## 3. Docker + Redis

### docker-compose.yml
```yaml
version: "3.9"
services:
  redis:
    image: redis:7-alpine
    container_name: redis
    ports:
      - "6379:6379"
    volumes:
      - redis_data:/data
    command: redis-server --appendonly yes --requirepass "sua_senha"
    healthcheck:
      test: ["CMD", "redis-cli", "-a", "sua_senha", "ping"]
      interval: 10s
      timeout: 5s
      retries: 3

volumes:
  redis_data:
```

```bash
docker-compose up -d
docker exec -it redis redis-cli -a "sua_senha"
```

---

## 4. Redis CLI — Comandos Essenciais

```bash
# Conexão
redis-cli                         # conecta localhost:6379
redis-cli -h host -p 6379 -a senha

# Info
INFO                             # info geral do servidor
INFO memory                      # uso de memória
INFO stats                       # estatísticas
DBSIZE                           # quantidade de keys
CONFIG GET maxmemory             # configuração

# Keys
KEYS *                           # lista TODAS as keys (NÃO usar em produção!)
SCAN 0 MATCH user:* COUNT 100   # cursor-based, seguro
TYPE user:1                      # tipo da key
TTL user:1                       # tempo restante (-1 sem expiração, -2 não existe)
EXPIRE user:1 3600               # expira em 1h
PERSIST user:1                   # remove expiração
DEL user:1                       # deleta key
FLUSHDB                          # limpa DB atual
FLUSHALL                         # limpa TODOS os DBs

# Pub/Sub
SUBSCRIBE canal_notificacoes     # escuta canal
PUBLISH canal_notificacoes "msg" # publica mensagem

# Monitor
MONITOR                          # mostra todos comandos em tempo real
SLOWLOG GET 10                   # queries lentas
```

---

## 5. Spring Boot + Redis

### 5.1 — Dependências (pom.xml)
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
</dependency>
```

### 5.2 — application.yml
```yaml
spring:
  data:
    redis:
      host: localhost
      port: 6379
      password: sua_senha
      timeout: 2000ms
      lettuce:
        pool:
          max-active: 8
          max-idle: 8
          min-idle: 0
          max-wait: -1ms
  cache:
    type: redis
    redis:
      time-to-live: 600000  # 10 min em ms
      cache-null-values: false
```

### 5.3 — RedisConfig.java
```java
@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(
            RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration config = RedisCacheConfiguration
            .defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(10))
            .serializeKeysWith(
                RedisSerializationContext.SerializationPair
                    .fromSerializer(new StringRedisSerializer()))
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair
                    .fromSerializer(new GenericJackson2JsonRedisSerializer()))
            .disableCachingNullValues();

        return RedisCacheManager.builder(factory)
            .cacheDefaults(config)
            .withCacheConfiguration("users",
                config.entryTtl(Duration.ofMinutes(30)))
            .withCacheConfiguration("habits",
                config.entryTtl(Duration.ofMinutes(5)))
            .build();
    }
}
```

### 5.4 — RedisService.java (RedisTemplate direto)
```java
@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate,
                        StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    // --- String ---
    public void set(String key, Object value, Duration ttl) {
        redisTemplate.opsForValue().set(key, value, ttl);
    }

    public <T> T get(String key, Class<T> type) {
        Object value = redisTemplate.opsForValue().get(key);
        return type.cast(value);
    }

    // --- Hash ---
    public void hSet(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    public Object hGet(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    public Map<Object, Object> hGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    // --- List ---
    public void lPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    public List<Object> lRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    // --- Set ---
    public void sAdd(String key, Object... values) {
        redisTemplate.opsForSet().add(key, values);
    }

    public Set<Object> sMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    // --- Sorted Set ---
    public void zAdd(String key, Object value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    public Set<Object> zRangeTop(String key, int count) {
        return redisTemplate.opsForZSet().reverseRange(key, 0, count - 1);
    }

    public Double zScore(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    // --- Expiry ---
    public boolean delete(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public void expire(String key, Duration ttl) {
        redisTemplate.expire(key, ttl);
    }
}
```

### 5.5 — @Cacheable, @CacheEvict, @CachePut
```java
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RedisService redisService;

    // @Cacheable: busca no cache primeiro; se não tem, executa o método
    @Cacheable(value = "users", key = "#id")
    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Cacheable(value = "users", key = "'email:' + #email")
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // @CachePut: sempre executa o método e atualiza o cache
    @CachePut(value = "users", key = "#result.id")
    public User update(Long id, UserDTO dto) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return userRepository.save(user);
    }

    // @CacheEvict: remove do cache
    @CacheEvict(value = "users", key = "#id")
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // allEntries = true: limpa TODO o cache "users"
    @CacheEvict(value = "users", allEntries = true)
    public void clearAllUserCache() {
        log.info("Cache de usuários limpo");
    }

    // @Caching: combina múltiplas operações
    @Caching(
        put = @CachePut(value = "users", key = "#result.id"),
        evict = @CacheEvict(value = "users", key = "'email:' + #result.email")
    )
    public User create(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return userRepository.save(user);
    }
}
```

### 5.6 — LeaderboardService.java (Sorted Sets)
```java
@Service
public class LeaderboardService {

    private final StringRedisTemplate redisTemplate;
    private static final String LEADERBOARD_KEY = "leaderboard:streak";

    public LeaderboardService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addScore(String username, double score) {
        redisTemplate.opsForZSet().add(LEADERBOARD_KEY, username, score);
    }

    public void incrementScore(String username, double increment) {
        redisTemplate.opsForZSet().incrementScore(
            LEADERBOARD_KEY, username, increment);
    }

    public Set<ZSetOperations.TypedTuple<String>> getTopN(int n) {
        return redisTemplate.opsForZSet()
            .reverseRangeWithScores(LEADERBOARD_KEY, 0, n - 1);
    }

    public Long getRank(String username) {
        return redisTemplate.opsForZSet()
            .reverseRank(LEADERBOARD_KEY, username);
    }

    public Double getScore(String username) {
        return redisTemplate.opsForZSet()
            .score(LEADERBOARD_KEY, username);
    }

    public Set<ZSetOperations.TypedTuple<String>> getAround(
            String username, int range) {
        Long rank = getRank(username);
        if (rank == null) return Collections.emptySet();
        long start = Math.max(0, rank - range);
        long end = rank + range;
        return redisTemplate.opsForZSet()
            .reverseRangeWithScores(LEADERBOARD_KEY, start, end);
    }
}
```

```java
@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    @PostMapping("/score")
    public void updateScore(@RequestParam String user,
                            @RequestParam double score) {
        leaderboardService.addScore(user, score);
    }

    @GetMapping("/top")
    public Set<ZSetOperations.TypedTuple<String>> top(
            @RequestParam(defaultValue = "10") int n) {
        return leaderboardService.getTopN(n);
    }

    @GetMapping("/rank/{user}")
    public Map<String, Object> rank(@PathVariable String user) {
        Map<String, Object> result = new HashMap<>();
        result.put("rank", leaderboardService.getRank(user));
        result.put("score", leaderboardService.getScore(user));
        return result;
    }
}
```

---

## 6. Rate Limiting (Sliding Window)

```java
@Component
public class RateLimiter {

    private final StringRedisTemplate redisTemplate;

    public RateLimiter(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Sliding Window Log: armazena cada request com timestamp.
     * Remove requests antigas e conta as restantes.
     */
    public boolean isAllowed(String clientId, int maxRequests, Duration window) {
        String key = "ratelimit:" + clientId;
        long now = System.currentTimeMillis();
        long windowStart = now - window.toMillis();

        // script Lua para atomicidade
        String luaScript = """
            redis.call('ZREMRANGEBYSCORE', KEYS[1], 0, ARGV[1])
            local count = redis.call('ZCARD', KEYS[1])
            if count < tonumber(ARGV[2]) then
                redis.call('ZADD', KEYS[1], ARGV[3], ARGV[3])
                redis.call('PEXPIRE', KEYS[1], ARGV[4])
                return 1
            end
            return 0
            """;

        Long result = redisTemplate.execute(
            new DefaultRedisScript<>(luaScript, Long.class),
            List.of(key),
            String.valueOf(windowStart),
            String.valueOf(maxRequests),
            String.valueOf(now),
            String.valueOf(window.toMillis())
        );

        return Long.valueOf(1L).equals(result);
    }

    /**
     * Token Bucket: mais suave, permite bursts.
     */
    public boolean tokenBucket(String clientId, int capacity, int refillRate,
                                Duration refillInterval) {
        String key = "bucket:" + clientId;
        long now = System.currentTimeMillis();

        String luaScript = """
            local bucket = redis.call('HMGET', KEYS[1], 'tokens', 'last')
            local tokens = tonumber(bucket[1]) or ARGV[1]
            local last = tonumber(bucket[2]) or ARGV[3]
            local elapsed = (ARGV[3] - last) / ARGV[4]
            tokens = math.min(ARGV[1], tokens + elapsed * ARGV[2])
            if tokens >= 1 then
                tokens = tokens - 1
                redis.call('HMSET', KEYS[1], 'tokens', tokens, 'last', ARGV[3])
                redis.call('PEXPIRE', KEYS[1], ARGV[4])
                return 1
            end
            redis.call('HMSET', KEYS[1], 'tokens', tokens, 'last', ARGV[3])
            return 0
            """;

        Long result = redisTemplate.execute(
            new DefaultRedisScript<>(luaScript, Long.class),
            List.of(key),
            String.valueOf(capacity),
            String.valueOf(refillRate),
            String.valueOf(now),
            String.valueOf(refillInterval.toMillis())
        );

        return Long.valueOf(1L).equals(result);
    }
}
```

### RateLimitFilter.java
```java
@Component
@Order(1)
public class RateLimitFilter extends OncePerRequestFilter {

    private final RateLimiter rateLimiter;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                     HttpServletResponse response,
                                     FilterChain chain)
            throws ServletException, IOException {

        String clientId = extractClientId(request);

        if (!rateLimiter.isAllowed(clientId, 100, Duration.ofMinutes(1))) {
            response.setStatus(429);
            response.getWriter().write("""
                {"error": "Rate limit exceeded. Try again later."}
                """);
            return;
        }

        chain.doFilter(request, response);
    }

    private String extractClientId(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        if (auth != null && auth.startsWith("Bearer ")) {
            return "user:" + JwtUtil.extractSubject(auth.substring(7));
        }
        return "ip:" + request.getRemoteAddr();
    }
}
```

---

## 7. JWT Blacklist (Logout com Redis)

```java
@Service
public class JwtBlacklistService {

    private final StringRedisTemplate redisTemplate;
    private static final String PREFIX = "blacklist:jwt:";

    public JwtBlacklistService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void blacklist(String token, Duration ttl) {
        redisTemplate.opsForValue().set(PREFIX + token, "revoked", ttl);
    }

    public boolean isBlacklisted(String token) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(PREFIX + token));
    }
}
```

```java
@Service
public class AuthService {

    private final JwtBlacklistService blacklistService;
    private final JwtUtil jwtUtil;

    public void logout(String token) {
        Date expiration = jwtUtil.extractExpiration(token);
        Duration ttl = Duration.between(
            Instant.now(), expiration.toInstant());
        if (ttl.isNegative()) ttl = Duration.ofSeconds(1);
        blacklistService.blacklist(token, ttl);
    }
}
```

---

## 8. Pub/Sub

### RedisPubSubConfig.java
```java
@Configuration
public class RedisPubSubConfig {

    @Bean
    public ChannelTopic notificationTopic() {
        return new ChannelTopic("notifications");
    }

    @Bean
    public ChannelTopic habitCompletedTopic() {
        return new ChannelTopic("habit:completed");
    }

    @Bean
    public RedisMessageListenerContainer container(
            RedisConnectionFactory factory,
            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container =
            new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(listenerAdapter, notificationTopic());
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(
            NotificationSubscriber subscriber) {
        return new MessageListenerAdapter(subscriber, "onMessage");
    }
}
```

### NotificationSubscriber.java
```java
@Component
public class NotificationSubscriber implements MessageListener {

    private static final Logger log =
        LoggerFactory.getLogger(NotificationSubscriber.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String body = new String(message.getBody());
        log.info("Received on [{}]: {}", channel, body);

        // processar notificação
        // ex: enviar push notification, email, websocket
    }
}
```

### NotificationPublisher.java
```java
@Service
public class NotificationPublisher {

    private final StringRedisTemplate redisTemplate;
    private final ChannelTopic notificationTopic;

    public void publish(String message) {
        redisTemplate.convertAndSend(
            notificationTopic.getTopic(), message);
    }

    public void notifyHabitCompleted(Long userId, String habitName) {
        String payload = """
            {"type":"HABIT_COMPLETED","userId":%d,"habit":"%s","timestamp":"%s"}
            """.formatted(userId, habitName, Instant.now());
        redisTemplate.convertAndSend("habit:completed", payload);
    }
}
```

---

## 9. Distributed Lock (Redisson)

### Dependência
```xml
<dependency>
    <groupId>org.redisson</groupId>
    <artifactId>redisson-spring-boot-starter</artifactId>
    <version>3.27.2</version>
</dependency>
```

### RedissonConfig.java
```java
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
            .setAddress("redis://localhost:6379")
            .setPassword("sua_senha");
        return Redisson.create(config);
    }
}
```

### DistributedLockService.java
```java
@Service
public class DistributedLockService {

    private final RedissonClient redissonClient;

    public <T> T executeWithLock(String lockKey, Duration waitTime,
                                  Duration leaseTime, Supplier<T> action) {
        RLock lock = redissonClient.getLock(lockKey);
        boolean acquired = false;
        try {
            acquired = lock.tryLock(
                waitTime.toSeconds(),
                leaseTime.toSeconds(),
                TimeUnit.SECONDS);
            if (!acquired) {
                throw new RuntimeException(
                    "Could not acquire lock: " + lockKey);
            }
            return action.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Lock interrupted", e);
        } finally {
            if (acquired && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    // Exemplo: processar pagamento só uma vez
    public void processPayment(String orderId) {
        executeWithLock(
            "payment:lock:" + orderId,
            Duration.ofSeconds(5),
            Duration.ofSeconds(30),
            () -> {
                // lógica de pagamento
                paymentService.charge(orderId);
                return null;
            }
        );
    }
}
```

---

## 10. Docker Compose — Stack Completa

```yaml
version: "3.9"

services:
  app:
    build: .
    container_name: stay-hard-app
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/stayhard
      - SPRING_DATA_REDIS_HOST=redis
      - SPRING_DATA_REDIS_PASSWORD=sua_senha
    depends_on:
      postgres:
        condition: service_healthy
      redis:
        condition: service_healthy

  postgres:
    image: postgres:16-alpine
    container_name: postgres
    environment:
      POSTGRES_DB: stayhard
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: senha123
    ports:
      - "5432:5432"
    volumes:
      - pg_data:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U admin -d stayhard"]
      interval: 10s
      timeout: 5s
      retries: 5

  redis:
    image: redis:7-alpine
    container_name: redis
    ports:
      - "6379:6379"
    volumes:
      - redis_data:/data
    command: redis-server --appendonly yes --requirepass "sua_senha"
    healthcheck:
      test: ["CMD", "redis-cli", "-a", "sua_senha", "ping"]
      interval: 10s
      timeout: 5s
      retries: 3

  redis-commander:
    image: rediscommander/redis-commander:latest
    container_name: redis-commander
    ports:
      - "8081:8081"
    environment:
      - REDIS_HOSTS=local:redis:6379:0:sua_senha
    depends_on:
      - redis

volumes:
  pg_data:
  redis_data:
```

---

## 11. Stay Hard — Integração com Redis

### 11.1 — Cache de Estatísticas
```java
@Service
public class StatsService {

    @Cacheable(value = "user:stats", key = "#userId")
    public UserStatsDTO getUserStats(Long userId) {
        // query pesada — cache por 5 min
        long totalHabits = habitRepository.countByUserId(userId);
        long completedToday = completionRepository
            .countByUserIdAndDate(userId, LocalDate.now());
        long currentStreak = calculateStreak(userId);
        double completionRate = calculateRate(userId);

        return new UserStatsDTO(
            totalHabits, completedToday,
            currentStreak, completionRate);
    }

    @CacheEvict(value = "user:stats", key = "#userId")
    public void invalidateStats(Long userId) {
        // chamado quando há mudança nos dados
    }
}
```

### 11.2 — Rate Limiting por Endpoint
```java
@RestController
@RequestMapping("/api/habits")
public class HabitController {

    private final RateLimiter rateLimiter;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody HabitDTO dto,
                                     HttpServletRequest request) {
        String clientId = extractClientId(request);
        if (!rateLimiter.isAllowed(clientId, 10, Duration.ofMinutes(1))) {
            return ResponseEntity.status(429)
                .body(Map.of("error", "Muitas requisições. Aguarde."));
        }
        return ResponseEntity.ok(habitService.create(dto));
    }
}
```

### 11.3 — Pub/Sub para Notificações em Tempo Real
```java
@Service
public class HabitService {

    private final NotificationPublisher publisher;

    @Transactional
    public CompletionDTO completeHabit(Long habitId, Long userId) {
        Completion completion = completionRepository.save(
            new Completion(habitId, userId, LocalDateTime.now()));

        // notifica via pub/sub
        publisher.notifyHabitCompleted(userId, getHabitName(habitId));

        return toDTO(completion);
    }
}
```

```java
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final SimpMessagingTemplate messaging;

    @EventListener
    public void handleHabitCompleted(HabitCompletedEvent event) {
        // envia via WebSocket para o frontend
        messaging.convertAndSendToUser(
            event.getUserId().toString(),
            "/queue/notifications",
            Map.of("type", "HABIT_COMPLETED",
                   "habit", event.getHabitName(),
                   "time", Instant.now())
        );
    }
}
```

### 11.4 — Session Cache (JWT + Redis)
```java
@Service
public class SessionService {

    private final RedisService redisService;
    private static final String SESSION_PREFIX = "session:";
    private static final Duration SESSION_TTL = Duration.ofHours(24);

    public void createSession(String token, User user) {
        String key = SESSION_PREFIX + user.getId();
        redisService.set(key, user, SESSION_TTL);

        // também armazena token → userId para blacklist
        redisService.set("token:" + token, user.getId(), SESSION_TTL);
    }

    public boolean isValidSession(String token) {
        Object userId = redisService.get("token:" + token, Object.class);
        return userId != null;
    }

    public void destroySession(String token, Long userId) {
        redisService.delete("token:" + token);
        redisService.delete(SESSION_PREFIX + userId);
    }
}
```

---

## 12. Cheatsheet Rápido

| Operação | Comando |
|---|---|
| Set string | `SET key value EX 3600` |
| Get string | `GET key` |
| Hash set | `HSET key field value` |
| Hash get all | `HGETALL key` |
| List push | `LPUSH key value` |
| List range | `LRANGE key 0 -1` |
| Set add | `SADD key member` |
| Set members | `SMEMBERS key` |
| Sorted set add | `ZADD key score member` |
| Sorted set top | `ZREVRANGE key 0 9 WITHSCORES` |
| Publish | `PUBLISH channel message` |
| Expire | `EXPIRE key seconds` |
| TTL | `TTL key` |
| Delete | `DEL key` |
| Exists | `EXISTS key` |
| Increment | `INCR key` |
| Scan keys | `SCAN 0 MATCH pattern COUNT 100` |
| Info | `INFO memory` |
| Lua script | `EVAL "script" numkeys key [key ...] arg [arg ...]` |
