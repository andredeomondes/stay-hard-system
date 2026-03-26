# 📚 FASE 2 — REST API + Autenticação

## REST API

### Controller básico
```java
@RestController
@RequestMapping("/api/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public ResponseEntity<List<HabitResponse>> listAll() {
        return ResponseEntity.ok(habitService.getAll());
    }

    @PostMapping
    public ResponseEntity<HabitResponse> create(@Valid @RequestBody CreateHabitRequest request) {
        return ResponseEntity.status(201).body(habitService.create(request));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<HabitResponse> complete(@PathVariable Long id) {
        return ResponseEntity.ok(habitService.complete(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        habitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
```

### DTOs
```java
// Request (o que o cliente envia)
public record CreateHabitRequest(
    @NotBlank String name,
    @NotNull Priority priority
) {}

// Response (o que o servidor retorna)
public record HabitResponse(
    Long id,
    String name,
    Priority priority,
    Status status
) {}
```

### HTTP Status Codes
```
200 OK              → GET sucesso
201 Created         → POST sucesso
204 No Content      → DELETE sucesso
400 Bad Request     → dados inválidos
401 Unauthorized    → sem autenticação
403 Forbidden       → sem permissão
404 Not Found       → recurso não existe
500 Internal Error  → erro no servidor
```

---

## Exception Handling

### Custom Exception
```java
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " não encontrado com id: " + id);
    }
}
```

### Global Handler
```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(404)
            .body(new ErrorResponse(404, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(e -> e.getField() + ": " + e.getDefaultMessage())
            .toList();
        return ResponseEntity.status(400)
            .body(new ErrorResponse(400, "Validação falhou", errors));
    }
}
```

---

## JWT Authentication

### Fluxo
```
1. Cliente envia POST /api/auth/login com {email, senha}
2. Server valida credenciais
3. Server gera JWT token
4. Cliente salva token (localStorage)
5. Cliente envia token no header: Authorization: Bearer <token>
6. Server valida token em cada request
```

### JwtTokenProvider
```java
@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String email) {
        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
```

### SecurityConfig
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(s -> s.sessionCreationPolicy(STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

---

## Swagger / OpenAPI

### Dependência (pom.xml)
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.5</version>
</dependency>
```

### Uso
```java
@Operation(summary = "Cria novo hábito")
@ApiResponses({
    @ApiResponse(responseCode = "201", description = "Hábito criado"),
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
})
@PostMapping
public ResponseEntity<HabitResponse> create(@Valid @RequestBody CreateHabitRequest request) {
    // ...
}
```

### Acessar
```
http://localhost:8080/swagger-ui.html
```
