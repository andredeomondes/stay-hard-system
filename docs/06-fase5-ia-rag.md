# 📚 FASE 5 — IA + RAG + Microservices

## MongoDB

### Conceitos
```
SQL (PostgreSQL)     →  MongoDB (NoSQL)
Database             →  Database
Table                →  Collection
Row                  →  Document
Column               →  Field
Primary Key          →  _id
JOIN                 →  Embedding / Reference
```

### Document Example
```json
{
    "_id": "65a1b2c3d4e5f6a7b8c9d0e1",
    "userId": 1,
    "action": "HABIT_COMPLETED",
    "habitName": "Treinar",
    "timestamp": "2025-01-15T10:30:00Z",
    "metadata": {
        "priority": "HIGH",
        "streak": 5
    }
}
```

### Spring Data MongoDB
```java
@Document(collection = "audit_logs")
public class AuditLog {
    @Id
    private String id;
    private Long userId;
    private String action;
    private String details;
    private LocalDateTime timestamp;
}

public interface AuditLogRepository extends MongoRepository<AuditLog, String> {
    List<AuditLog> findByUserId(Long userId);
    List<AuditLog> findByAction(String action);
    List<AuditLog> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}
```

---

## Microservices

### Arquitetura
```
                    ┌─────────────┐
                    │   Client    │
                    │  (React)    │
                    └──────┬──────┘
                           │
                    ┌──────▼──────┐
                    │ API Gateway │  (:8080)
                    │  (routing)  │
                    └──────┬──────┘
                           │
         ┌─────────────────┼─────────────────┐
         │                 │                 │
   ┌─────▼─────┐   ┌──────▼──────┐   ┌──────▼──────┐
   │   User    │   │   Habit     │   │  Analytics  │
   │  Service  │   │  Service    │   │  Service    │
   │ (:8081)   │   │  (:8082)    │   │  (:8083)    │
   │ PostgreSQL│   │ PostgreSQL  │   │  MongoDB    │
   └───────────┘   └─────────────┘   └─────────────┘
         │                 │                 │
         └─────────────────┼─────────────────┘
                           │
                    ┌──────▼──────┐
                    │   Eureka    │  (:8761)
                    │  Discovery  │
                    └─────────────┘
```

### Service Discovery (Eureka)
```java
// eureka-server: pom.xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>

// EurekaServerApplication.java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

### API Gateway
```java
// api-gateway: application.yml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://user-service
          predicates:
            - Path=/api/users/**
        - id: habit-service
          uri: lb://habit-service
          predicates:
            - Path=/api/habits/**
```

### Inter-service Communication (Feign)
```java
@FeignClient(name = "user-service")
public interface UserServiceClient {
    @GetMapping("/api/users/{id}")
    UserResponse getUserById(@PathVariable Long id);
}
```

### Circuit Breaker (Resilience4j)
```java
@Service
public class HabitService {
    
    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackGetUser")
    public UserResponse getUser(Long id) {
        return userServiceClient.getUserById(id);
    }

    public UserResponse fallbackGetUser(Long id, Exception ex) {
        return new UserResponse(id, "Unknown User");
    }
}
```

---

## IA + RAG

### O que é LLM?
```
LLM = Large Language Model
- Treinado em海量texto da internet
- Pode gerar, resumir, traduzir, analisar texto
- Exemplos: GPT-4, Claude, Gemini, Llama
```

### Prompt Engineering
```
System Prompt (definição de persona):
  "Você é um coach de hábitos motivacional.
   Responda em português, seja conciso e motivador."

User Prompt (pergunta do usuário):
  "Como estão meus hábitos esta semana?"

Few-shot (exemplos):
  "Exemplo 1: Usuário pergunta X, responda Y
   Exemplo 2: Usuário pergunta Z, responda W
   Agora responda: [pergunta real]"
```

### O que é RAG?
```
RAG = Retrieval Augmented Generation

Problema: LLM não conhece SEUS dados
Solução: Buscar dados relevantes e dar como contexto ao LLM

Fluxo:
  1. Usuário pergunta: "Como estão meus hábitos?"
  2. Sistema busca dados do usuário no banco
  3. Converte dados em texto
  4. Envia: [dados do usuário] + [pergunta] → LLM
  5. LLM responde baseado nos dados reais
```

### RAG Pipeline
```
INGESTÃO (offline):
  Documento → Chunking → Embedding → Vector DB

QUERY (online):
  Pergunta → Embedding → Similarity Search → Top-K chunks
  → [chunks relevantes] + [pergunta] → LLM → Resposta
```

### Embeddings
```
Embedding = converter texto em vetor numérico

"Eu gosto de café"  →  [0.2, -0.5, 0.8, 0.1, ...]  (1536 dimensões)
"Adoro tomar café"  →  [0.19, -0.48, 0.82, 0.12, ...]  (similar!)
"O céu é azul"      →  [-0.3, 0.7, -0.1, 0.9, ...]  (diferente)

Similarity = distância entre vetores (cosine similarity)
```

### Vector Databases
```
pgvector   → PostgreSQL extension (já usa PostgreSQL)
ChromaDB   → Standalone, fácil de usar
Pinecone   → Cloud, managed
Weaviate   → Open source, feature-rich
Milvus     → High performance
```

### Spring AI
```java
// Dependência
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-openai-spring-boot-starter</artifactId>
</dependency>

// Chat
@Service
public class AiCoachService {
    private final ChatClient chatClient;

    public AiCoachService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String getAdvice(String userStats) {
        return chatClient.prompt()
            .system("Você é um coach de hábitos motivacional.")
            .user("Meus stats: " + userStats + ". Me dê conselhos.")
            .call()
            .content();
    }
}

// RAG
@Service
public class RagService {
    private final VectorStore vectorStore;
    private final ChatClient chatClient;

    public String ask(String question) {
        // 1. Buscar chunks relevantes
        List<Document> docs = vectorStore.similaritySearch(question);
        
        // 2. Montar contexto
        String context = docs.stream()
            .map(Document::getContent)
            .collect(Collectors.joining("\n"));
        
        // 3. Gerar resposta com contexto
        return chatClient.prompt()
            .system("Responda baseado apenas no contexto fornecido.")
            .user("Contexto: " + context + "\n\nPergunta: " + question)
            .call()
            .content();
    }
}
```

### Stay Hard — AI Service
```java
@RestController
@RequestMapping("/api/ai")
public class AiCoachController {

    private final AiCoachService coachService;
    private final RagService ragService;

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        String answer = coachService.chat(request.message());
        return ResponseEntity.ok(new ChatResponse(answer));
    }

    @GetMapping("/daily-summary/{userId}")
    public ResponseEntity<ChatResponse> dailySummary(@PathVariable Long userId) {
        UserStats stats = statsService.getStats(userId);
        String summary = coachService.generateDailySummary(stats);
        return ResponseEntity.ok(new ChatResponse(summary));
    }

    @PostMapping("/suggest-habit/{userId}")
    public ResponseEntity<ChatResponse> suggestHabit(@PathVariable Long userId) {
        List<Habit> habits = habitService.getAll(userId);
        String suggestion = coachService.suggestNewHabit(habits);
        return ResponseEntity.ok(new ChatResponse(suggestion));
    }
}
```

---

## Projetos Mini de IA

### Chat com PDF (RAG)
```
1. Upload PDF
2. Chunk PDF em pedaços
3. Gerar embeddings (OpenAI ada-002)
4. Salvar em pgvector
5. Usuário pergunta sobre o PDF
6. Buscar chunks similares
7. Enviar chunks + pergunta → LLM
8. Retornar resposta com fontes
```

### Code Reviewer IA
```
1. Usuário envia código
2. System prompt: "Você é um code reviewer sênior..."
3. LLM analisa e retorna:
   - Bugs encontrados
   - Melhorias de performance
   - Sugestões de clean code
   - Security issues
```
