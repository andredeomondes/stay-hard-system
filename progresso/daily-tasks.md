# 📅 TAREFAS DIÁRIAS — JAVA STUDY

> Cada "dia" = 2 horas de estudo. Não é por calendário — é sequencial.
> Quando sentar pra estudar, olha o próximo dia e faz.

---

## FASE 0 — Fundação + GitHub (Dias 1-10)

### Dia 1 — Fase 0 — Maven + Git
- [ ] Criar pom.xml no stay-hard-system (spring-boot-starter-parent, dependencies)
- [ ] Migrar src/ para estrutura Maven (src/main/java/com/stayhard/)
- [ ] Testar: `mvn clean compile`
- 📝 Commit: "feat: migrate to Maven structure"

### Dia 2 — Fase 0 — Testes JUnit (Parte 1)
- [ ] Escrever testes para User.java (criar, addCompletedDay, addFailedDay)
- [ ] Escrever testes para Habit.java (criar, start, complete, reset)
- [ ] Rodar: `mvn test`
- 📝 Commit: "test: User + Habit unit tests"

### Dia 3 — Fase 0 — Testes JUnit (Parte 2)
- [ ] Escrever testes para LevelService (5 níveis)
- [ ] Escrever testes para HabitService (add, start, complete, delete, update)
- [ ] Escrever testes para UserService (registerCompletedDay, registerFailedDay)
- 📝 Commit: "test: Service layer tests"

### Dia 4 — Fase 0 — README + GitHub
- [ ] README.md profissional (badges, descrição, como rodar)
- [ ] git remote add origin + push
- [ ] Criar branch develop
- 📝 Commit: "docs: professional README + GitHub init"

### Dia 5 — Fase 0 — Calculadora CLI
- [ ] Criar mini-projetos/calculadora-cli/
- [ ] Operações: +, -, *, /
- [ ] Input via Scanner, tratamento de erros
- 📝 Commit: "feat: calculator CLI"

### Dia 6 — Fase 0 — Validador CPF
- [ ] Criar mini-projetos/validador-cpf/
- [ ] Algoritmo de validação dos dígitos verificadores
- [ ] Testes com CPFs válidos e inválidos
- 📝 Commit: "feat: CPF validator"

### Dia 7 — Fase 0 — Git Logger
- [ ] Criar mini-projetos/git-logger/
- [ ] Usar ProcessBuilder para executar git log
- [ ] Formatar output colorido
- 📝 Commit: "feat: git logger"

### Dia 8 — Fase 0 — Gerador de Senhas
- [ ] Criar mini-projetos/gerador-senhas/
- [ ] Configurar: tamanho, maiúsculas, números, símbolos
- [ ] Usar SecureRandom
- 📝 Commit: "feat: password generator"

### Dia 9 — Fase 0 — Ordenação de Arrays
- [ ] Criar mini-projetos/ordenacao-arrays/
- [ ] Implementar: Bubble Sort, Selection Sort, Insertion Sort
- [ ] Medir tempo de execução de cada
- 📝 Commit: "feat: sorting algorithms"

### Dia 10 — Fase 0 — Revisão + Prep Fase 1
- [ ] Revisar todos testes (`mvn test` passando?)
- [ ] Git: criar tag v1.0
- [ ] Ler docs/02-fase1-java-backend.md
- 📝 Commit: "chore: v1.0 release"

---

## FASE 1 — Java Backend + DB (Dias 11-30)

### Dia 11 — Fase 1 — PostgreSQL Setup
- [ ] Instalar PostgreSQL
- [ ] Instalar DBeaver
- [ ] Criar database stay_hard_db
- [ ] Criar usuário stayhard
- 📝 Commit: "feat: PostgreSQL setup"

### Dia 12 — Fase 1 — SQL DDL
- [ ] Criar tabela users (id, name, email, created_at)
- [ ] Criar tabela habits (id, user_id, name, priority, status)
- [ ] Adicionar constraints (PK, FK, NOT NULL, UNIQUE)
- 📝 Commit: "study: SQL DDL"

### Dia 13 — Fase 1 — SQL DML
- [ ] INSERT de dados de teste
- [ ] SELECT com WHERE, ORDER BY
- [ ] UPDATE e DELETE registros
- 📝 Commit: "study: SQL DML"

### Dia 14 — Fase 1 — SQL JOINs
- [ ] INNER JOIN users + habits
- [ ] LEFT JOIN (usuários sem hábitos)
- [ ] RIGHT JOIN, FULL JOIN
- 📝 Commit: "study: SQL JOINs"

### Dia 15 — Fase 1 — SQL GROUP BY
- [ ] GROUP BY com COUNT, AVG, SUM
- [ ] HAVING para filtrar grupos
- [ ] Subqueries básicas
- 📝 Commit: "study: SQL aggregations"

### Dia 16 — Fase 1 — Spring Boot Setup
- [ ] Spring Initializr (web, jpa, postgresql)
- [ ] application.properties com PostgreSQL
- [ ] `mvn spring-boot:run` funciona
- 📝 Commit: "feat: Spring Boot init"

### Dia 17 — Fase 1 — IoC e DI
- [ ] Estudar Inversion of Control
- [ ] Estudar Dependency Injection
- [ ] Annotations: @Component, @Service, @Repository
- [ ] Bean lifecycle e scopes
- 📝 Commit: "study: IoC + DI concepts"

### Dia 18 — Fase 1 — JPA Entities
- [ ] @Entity User com @Id @GeneratedValue
- [ ] @Entity Habit com @ManyToOne User
- [ ] @Enumerated para Priority e Status
- 📝 Commit: "feat: JPA entities"

### Dia 19 — Fase 1 — JPA Repositories
- [ ] UserRepository extends JpaRepository
- [ ] HabitRepository extends JpaRepository
- [ ] Métodos customizados (findByEmail, findByUserId)
- 📝 Commit: "feat: JPA repositories"

### Dia 20 — Fase 1 — Migrar Services
- [ ] Adaptar UserService para usar JpaRepository
- [ ] Adaptar HabitService para usar JpaRepository
- [ ] @Transactional onde necessário
- 📝 Commit: "refactor: services using JPA"

### Dia 21 — Fase 1 — Migrar Controllers
- [ ] Adaptar UserController para Spring
- [ ] Adaptar HabitController para Spring
- [ ] Testar via Postman/curl
- 📝 Commit: "refactor: Spring controllers"

### Dia 22 — Fase 1 — CommandLineRunner
- [ ] Criar CliRunner implements CommandLineRunner
- [ ] Manter CLI funcionando via Spring
- [ ] Transição suave de CLI → Spring Boot
- 📝 Commit: "feat: CLI runner with Spring"

### Dia 23 — Fase 1 — Testes com H2
- [ ] Configurar H2 in-memory para testes
- [ ] @DataJpaTest para repositories
- [ ] @SpringBootTest para services
- 📝 Commit: "test: integration tests with H2"

### Dia 24 — Fase 1 — Flyway
- [ ] Configurar Flyway
- [ ] V1__create_users_table.sql
- [ ] V2__create_habits_table.sql
- 📝 Commit: "feat: Flyway migrations"

### Dia 25 — Fase 1 — Validações
- [ ] @NotNull, @NotBlank nas entities
- [ ] Custom exceptions (ResourceNotFoundException)
- [ ] Exception handler básico
- 📝 Commit: "feat: validation + exceptions"

### Dia 26 — Fase 1 — CRUD Produtos
- [ ] Criar mini-projetos/crud-produtos/
- [ ] Spring Boot + H2, CRUD completo
- [ ] JPA + Validation + REST
- 📝 Commit: "feat: CRUD products"

### Dia 27 — Fase 1 — API Contatos
- [ ] Criar mini-projetos/api-contatos/
- [ ] Spring Boot + PostgreSQL
- [ ] CRUD de contatos com validação
- 📝 Commit: "feat: contacts API"

### Dia 28 — Fase 1 — Blog Simples
- [ ] Criar mini-projetos/blog-simples/
- [ ] Spring Boot + Thymeleaf
- [ ] Posts com título, conteúdo, data
- 📝 Commit: "feat: simple blog"

### Dia 29 — Fase 1 — Gerenciador Livros
- [ ] Criar mini-projetos/gerenciador-livros/
- [ ] Spring Boot + PostgreSQL
- [ ] CRUD de livros + busca por título/autor
- 📝 Commit: "feat: book manager"

### Dia 30 — Fase 1 — Revisão
- [ ] Revisão geral Fase 1
- [ ] Todos testes passando?
- [ ] Git tag v2.0
- [ ] Ler docs/03-fase2-rest-api.md
- 📝 Commit: "chore: v2.0 release"

---

## FASE 2 — REST API + Auth (Dias 31-48)

### Dia 31 — Fase 2 — REST Concepts
- [ ] Estudar REST (resources, HTTP methods, status codes)
- [ ] @RestController vs @Controller
- [ ] @RequestMapping
- 📝 Commit: "study: REST concepts"

### Dia 32 — Fase 2 — GET e POST
- [ ] @GetMapping para listar/buscar
- [ ] @PostMapping para criar
- [ ] @PathVariable e @RequestParam
- [ ] Retornar ResponseEntity com status 200/201
- 📝 Commit: "feat: GET + POST endpoints"

### Dia 33 — Fase 2 — PUT e DELETE
- [ ] @PutMapping para atualizar
- [ ] @DeleteMapping para deletar
- [ ] Retornar status 204 No Content
- 📝 Commit: "feat: PUT + DELETE endpoints"

### Dia 34 — Fase 2 — DTOs
- [ ] Criar request DTOs (CreateHabitRequest, LoginRequest)
- [ ] Criar response DTOs (HabitResponse, UserResponse)
- [ ] Separar entities de DTOs
- 📝 Commit: "feat: DTO layer"

### Dia 35 — Fase 2 — Bean Validation
- [ ] @Valid no @RequestBody
- [ ] @NotNull, @NotBlank, @Size, @Email
- [ ] Mensagens de erro legíveis
- 📝 Commit: "feat: bean validation"

### Dia 36 — Fase 2 — Exception Handling
- [ ] @ControllerAdvice global
- [ ] @ExceptionHandler para cada exception
- [ ] Custom exceptions (ResourceNotFoundException, ValidationException)
- [ ] ErrorResponse DTO
- 📝 Commit: "feat: global exception handling"

### Dia 37 — Fase 2 — JWT Concepts
- [ ] Estudar JWT (Header, Payload, Signature)
- [ ] Fluxo: login → token → authenticated requests
- [ ] BCrypt para hash de senhas
- 📝 Commit: "study: JWT concepts"

### Dia 38 — Fase 2 — JWT Implementation
- [ ] JwtTokenProvider (generate, validate, getSubject)
- [ ] JwtAuthenticationFilter
- [ ] SecurityFilterChain
- 📝 Commit: "feat: JWT auth filter"

### Dia 39 — Fase 2 — Login + Register
- [ ] POST /api/auth/register
- [ ] POST /api/auth/login → retorna JWT
- [ ] Endpoints protegidos exigem token
- 📝 Commit: "feat: auth endpoints"

### Dia 40 — Fase 2 — Swagger
- [ ] springdoc-openapi dependency
- [ ] Swagger UI em /swagger-ui.html
- [ ] @Operation, @ApiResponse nos endpoints
- 📝 Commit: "feat: Swagger documentation"

### Dia 41 — Fase 2 — Stay Hard v3.0 Auth
- [ ] /api/auth/register com validação
- [ ] /api/auth/login retornando JWT
- [ ] /api/users/me (perfil autenticado)
- [ ] /api/users/me/stats
- 📝 Commit: "feat: stay hard auth v3.0"

### Dia 42 — Fase 2 — Stay Hard v3.0 Habits
- [ ] POST /api/habits (criar)
- [ ] GET /api/habits (listar)
- [ ] PUT /api/habits/{id}/start
- [ ] PUT /api/habits/{id}/complete
- [ ] DELETE /api/habits/{id}
- [ ] PUT /api/habits/{id} (update)
- [ ] PUT /api/habits/reset
- 📝 Commit: "feat: stay hard habits CRUD v3.0"

### Dia 43 — Fase 2 — Stay Hard v3.0 Daily
- [ ] POST /api/daily/finish (calcula success/fail)
- [ ] GET /api/daily/stats
- [ ] Lógica: allHighCompleted → registerCompletedDay
- 📝 Commit: "feat: stay hard daily v3.0"

### Dia 44 — Fase 2 — Mini: Auth API JWT
- [ ] Criar mini-projetos/auth-api-jwt/
- [ ] Login, registro, endpoints protegidos
- [ ] Spring Security + JWT
- 📝 Commit: "feat: auth API JWT"

### Dia 45 — Fase 2 — Mini: Task Manager
- [ ] Criar mini-projetos/task-manager-api/
- [ ] CRUD de tarefas com JWT
- [ ] Swagger documentado
- 📝 Commit: "feat: task manager API"

### Dia 46 — Fase 2 — Mini: Library API
- [ ] Criar mini-projetos/library-api/
- [ ] CRUD de livros + autores
- [ ] Swagger + PostgreSQL
- 📝 Commit: "feat: library API"

### Dia 47 — Fase 2 — Mini: Contact Book
- [ ] Criar mini-projetos/contact-book-api/
- [ ] CRUD de contatos com grupos
- [ ] JWT auth + REST
- 📝 Commit: "feat: contact book API"

### Dia 48 — Fase 2 — Revisão
- [ ] Revisão geral Fase 2
- [ ] Todos endpoints funcionando?
- [ ] Git tag v3.0
- [ ] Ler docs/04-fase3-react-typescript.md
- 📝 Commit: "chore: v3.0 release"

---

## FASE 3 — React + TypeScript (Dias 49-72)

### Dia 49 — Fase 3 — JS ES6
- [ ] let, const, template literals
- [ ] Arrow functions
- [ ] Destructuring (object + array)
- [ ] Spread / Rest operator
- 📝 Commit: "study: JavaScript ES6"

### Dia 50 — Fase 3 — JS Arrays
- [ ] map, filter, reduce
- [ ] find, some, every
- [ ] forEach, flat, flatMap
- 📝 Commit: "study: JS array methods"

### Dia 51 — Fase 3 — JS Async
- [ ] Promises (resolve, reject, then, catch)
- [ ] async/await
- [ ] fetch API
- [ ] try/catch com async
- 📝 Commit: "study: JS async/await"

### Dia 52 — Fase 3 — JS Modules
- [ ] import/export (ES Modules)
- [ ] Node.js basics (npm, package.json)
- [ ] Rodar JS com Node
- 📝 Commit: "study: JS modules + Node"

### Dia 53 — Fase 3 — TypeScript Basics
- [ ] Tipos: string, number, boolean, array, tuple
- [ ] Interfaces
- [ ] Type aliases
- [ ] Optional properties (?)
- 📝 Commit: "study: TypeScript basics"

### Dia 54 — Fase 3 — TypeScript Advanced
- [ ] Generics (<T>)
- [ ] Enums
- [ ] Union types (string | number)
- [ ] Type narrowing
- 📝 Commit: "study: TypeScript advanced"

### Dia 55 — Fase 3 — React Setup
- [ ] `npm create vite@latest` (React + TypeScript)
- [ ] `npm install` + `npm run dev`
- [ ] Estrutura do projeto
- [ ] tsconfig.json + vite.config.ts
- 📝 Commit: "feat: React + TS project init"

### Dia 56 — Fase 3 — Components
- [ ] Componentes funcionais com TypeScript
- [ ] Props com interfaces
- [ ] Renderização condicional
- [ ] Listas com .map()
- 📝 Commit: "study: React components"

### Dia 57 — Fase 3 — Hooks
- [ ] useState (estado local)
- [ ] useEffect (efeitos colaterais)
- [ ] Ciclo de vida: mount, update, unmount
- 📝 Commit: "study: React hooks"

### Dia 58 — Fase 3 — React Router
- [ ] react-router-dom v6
- [ ] BrowserRouter, Routes, Route
- [ ] Link, useNavigate
- [ ] Route params (useParams)
- 📝 Commit: "feat: React Router setup"

### Dia 59 — Fase 3 — Axios + JWT
- [ ] Instalar axios
- [ ] Criar api.ts (baseURL + interceptors)
- [ ] Request interceptor: adicionar Bearer token
- [ ] Response interceptor: 401 → redirect login
- 📝 Commit: "feat: Axios + JWT interceptors"

### Dia 60 — Fase 3 — Tailwind CSS
- [ ] Instalar Tailwind CSS
- [ ] Configurar tailwind.config.js
- [ ] Utilitários básicos (flex, grid, spacing, colors)
- 📝 Commit: "feat: Tailwind CSS setup"

### Dia 61 — Fase 3 — Context API
- [ ] AuthContext (user, token, login, logout)
- [ ] AuthProvider no App.tsx
- [ ] useAuth() custom hook
- 📝 Commit: "feat: AuthContext"

### Dia 62 — Fase 3 — Custom Hooks
- [ ] useAuth() — autenticação
- [ ] useHabits() — CRUD de hábitos
- [ ] useFetch() — requisições genéricas
- 📝 Commit: "feat: custom hooks"

### Dia 63 — Fase 3 — Stay Hard Login/Register
- [ ] Login.tsx (formulário + chamada API)
- [ ] Register.tsx (formulário + chamada API)
- [ ] ProtectedRoute.tsx
- [ ] Redirecionamento após login
- 📝 Commit: "feat: login/register pages"

### Dia 64 — Fase 3 — Stay Hard Dashboard
- [ ] Dashboard.tsx (stats, streak, nível)
- [ ] LevelBadge.tsx (visual do nível)
- [ ] StreakCounter.tsx
- [ ] Dados vindos da API
- 📝 Commit: "feat: dashboard page"

### Dia 65 — Fase 3 — Stay Hard Habits
- [ ] Habits.tsx (CRUD de hábitos)
- [ ] HabitCard.tsx (visual de cada hábito)
- [ ] Criar, iniciar, completar, editar, deletar
- 📝 Commit: "feat: habits page"

### Dia 66 — Fase 3 — Stay Hard Profile
- [ ] Profile.tsx (dados do usuário)
- [ ] StatsChart.tsx (gráfico de progresso)
- [ ] FinishDay button
- 📝 Commit: "feat: profile page"

### Dia 67 — Fase 3 — Mini: Weather App
- [ ] Criar mini-projetos/react-weather/
- [ ] Consultar API pública de clima
- [ ] useState, useEffect, fetch
- 📝 Commit: "feat: weather app"

### Dia 68 — Fase 3 — Mini: Todo List
- [ ] Criar mini-projetos/react-todo/
- [ ] CRUD de tarefas no frontend
- [ ] LocalStorage persistence
- 📝 Commit: "feat: todo list"

### Dia 69 — Fase 3 — Mini: Kanban
- [ ] Criar mini-projetos/react-kanban/
- [ ] Board com colunas (To Do, In Progress, Done)
- [ ] Drag and drop básico
- 📝 Commit: "feat: kanban board"

### Dia 70 — Fase 3 — Mini: Chat UI
- [ ] Criar mini-projetos/react-chat/
- [ ] Interface de chat
- [ ] WebSocket intro
- 📝 Commit: "feat: chat UI"

### Dia 71 — Fase 3 — Mini: E-commerce
- [ ] Criar mini-projetos/react-ecommerce/
- [ ] Catálogo de produtos + carrinho
- [ ] Context API para state
- 📝 Commit: "feat: e-commerce cart"

### Dia 72 — Fase 3 — Revisão
- [ ] Revisão geral Fase 3
- [ ] TypeScript sem erros (`npx tsc --noEmit`)
- [ ] Git tag v4.0
- [ ] Ler docs/05-fase4-docker-systemdesign.md
- 📝 Commit: "chore: v4.0 release"

---

## FASE 4 — Docker + Redis + System Design + CI/CD (Dias 73-92)

### Dia 73 — Fase 4 — Docker Concepts
- [ ] Imagens, Containers, Volumes, Networks
- [ ] Dockerfile syntax
- [ ] Comandos: build, run, ps, logs, stop
- 📝 Commit: "study: Docker concepts"

### Dia 74 — Fase 4 — Dockerfile Spring Boot
- [ ] Multi-stage build (Maven → JAR → runtime)
- [ ] Build: `docker build -t stay-hard-api .`
- [ ] Run: `docker run -p 8080:8080 stay-hard-api`
- 📝 Commit: "feat: Dockerfile Spring Boot"

### Dia 75 — Fase 4 — Dockerfile React
- [ ] Multi-stage (Node build → Nginx serve)
- [ ] nginx.conf para SPA (try_files)
- [ ] Build + run container
- 📝 Commit: "feat: Dockerfile React"

### Dia 76 — Fase 4 — Docker Compose
- [ ] docker-compose.yml com postgres + api + frontend
- [ ] Networks entre containers
- [ ] Volumes para persistência
- [ ] `docker-compose up -d`
- 📝 Commit: "feat: Docker Compose"

### Dia 77 — Fase 4 — Health Checks
- [ ] Healthcheck no docker-compose
- [ ] Spring Boot Actuator health endpoint
- [ ] depends_on com condition
- [ ] .env files para variáveis
- 📝 Commit: "feat: health checks + env"

### Dia 78 — Fase 4 — Redis Concepts
- [ ] O que é Redis (in-memory key-value store)
- [ ] Tipos: String, Hash, List, Set, Sorted Set
- [ ] Use cases: cache, session, rate limiting, pub/sub
- 📝 Commit: "study: Redis concepts"

### Dia 79 — Fase 4 — Redis Docker
- [ ] Redis no docker-compose
- [ ] redis-cli comandos básicos (SET, GET, DEL, KEYS)
- [ ] TTL (EXPIRE, TTL)
- 📝 Commit: "feat: Redis Docker setup"

### Dia 80 — Fase 4 — Spring Boot + Redis
- [ ] spring-boot-starter-data-redis
- [ ] RedisTemplate<String, Object>
- [ ] @Cacheable, @CacheEvict, @CachePut
- [ ] Config: RedisConnectionFactory
- 📝 Commit: "feat: Spring Boot + Redis"

### Dia 81 — Fase 4 — Redis Advanced
- [ ] Rate Limiting com Redis (sliding window)
- [ ] Pub/Sub (publish + subscribe)
- [ ] Distributed lock básico
- 📝 Commit: "feat: Redis rate limiting + pub/sub"

### Dia 82 — Fase 4 — Stay Hard v5.0 Redis
- [ ] Cache de stats do usuário
- [ ] Rate limiting nos endpoints
- [ ] Pub/Sub para notificações
- 📝 Commit: "feat: Stay Hard Redis integration"

### Dia 83 — Fase 4 — System Design HLD
- [ ] Functional vs Non-Functional Requirements
- [ ] Monolithic vs Microservices
- [ ] Event-Driven, Serverless, Pub/Sub architectures
- 📝 Commit: "study: System Design HLD"

### Dia 84 — Fase 4 — Scaling + CAP
- [ ] Horizontal vs Vertical Scaling
- [ ] CAP Theorem
- [ ] Database Replication + Sharding
- [ ] SQL vs NoSQL decision
- 📝 Commit: "study: Scaling + CAP"

### Dia 85 — Fase 4 — Caching + Load Balancing
- [ ] Caching strategies (Redis, CDN)
- [ ] Cache eviction policies (LRU, LFU, TTL)
- [ ] Load Balancing algorithms (round robin, least connections)
- [ ] Consistent Hashing
- 📝 Commit: "study: Caching + Load Balancing"

### Dia 86 — Fase 4 — API Gateway + Queues
- [ ] API Gateway pattern
- [ ] Message Queues (RabbitMQ, Kafka)
- [ ] Rate Limiting algorithms
- [ ] CDN, Proxies, WebSockets
- 📝 Commit: "study: Gateway + Queues"

### Dia 87 — Fase 4 — SOLID
- [ ] S: Single Responsibility
- [ ] O: Open/Closed
- [ ] L: Liskov Substitution
- [ ] I: Interface Segregation
- [ ] D: Dependency Inversion
- 📝 Commit: "study: SOLID principles"

### Dia 88 — Fase 4 — Design Patterns 1
- [ ] Singleton
- [ ] Factory
- [ ] Builder
- [ ] Aplicar no Stay Hard
- 📝 Commit: "study: Creational patterns"

### Dia 89 — Fase 4 — Design Patterns 2
- [ ] Strategy
- [ ] Observer
- [ ] Command
- [ ] Repository (já implementado)
- 📝 Commit: "study: Behavioral patterns"

### Dia 90 — Fase 4 — CI/CD
- [ ] GitHub Actions workflow (.github/workflows/)
- [ ] Pipeline: test → build → deploy
- [ ] Coverage report (JaCoCo)
- 📝 Commit: "feat: GitHub Actions CI/CD"

### Dia 91 — Fase 4 — Stay Hard Docker
- [ ] docker-compose.yml completo (postgres + api + frontend + redis + pgadmin)
- [ ] Tudo sobe com `docker-compose up`
- [ ] Health checks funcionando
- 📝 Commit: "feat: Stay Hard v5.0 Docker"

### Dia 92 — Fase 4 — Revisão
- [ ] Revisão geral Fase 4
- [ ] Consegue desenhar HLD do Stay Hard?
- [ ] Git tag v5.0
- [ ] Ler docs/06-fase5-ia-rag.md
- 📝 Commit: "chore: v5.0 release"

---

## FASE 5 — MongoDB, Microservices, Kafka, RabbitMQ, IA, RAG (Dias 93-120)

### Dia 93 — Fase 5 — MongoDB Setup
- [ ] MongoDB via Docker
- [ ] Mongo Express (UI admin)
- [ ] CRUD básico no mongo shell
- 📝 Commit: "feat: MongoDB Docker setup"

### Dia 94 — Fase 5 — Spring Data MongoDB
- [ ] spring-boot-starter-data-mongodb
- [ ] @Document + MongoRepository
- [ ] Audit logs em MongoDB
- 📝 Commit: "feat: Spring Data MongoDB"

### Dia 95 — Fase 5 — Stay Hard MongoDB
- [ ] Audit log de ações (quem fez o quê)
- [ ] Analytics de hábitos (tendências)
- [ ] Mongo Express rodando
- 📝 Commit: "feat: Stay Hard MongoDB analytics"

### Dia 96 — Fase 5 — Microservices Concepts
- [ ] O que são microservices
- [ ] Quando usar vs monólito
- [ ] Desafios: rede, dados, deploy
- 📝 Commit: "study: Microservices concepts"

### Dia 97 — Fase 5 — Eureka Server
- [ ] Spring Cloud Eureka Server
- [ ] Services se registram automaticamente
- [ ] Eureka Dashboard
- 📝 Commit: "feat: Eureka Service Discovery"

### Dia 98 — Fase 5 — API Gateway
- [ ] Spring Cloud Gateway
- [ ] Routing para microservices
- [ ] Filters (auth, logging)
- 📝 Commit: "feat: API Gateway"

### Dia 99 — Fase 5 — Inter-service
- [ ] OpenFeign Client
- [ ] Communication entre services
- [ ] Load balancing (Ribbon)
- 📝 Commit: "feat: Feign inter-service"

### Dia 100 — Fase 5 — Circuit Breaker
- [ ] Resilience4j
- [ ] @CircuitBreaker annotation
- [ ] Fallback methods
- [ ] Retry, RateLimiter
- 📝 Commit: "feat: Circuit Breaker"

### Dia 101 — Fase 5 — Kafka Concepts
- [ ] O que é Kafka (event streaming)
- [ ] Topics, Partitions, Consumer Groups
- [ ] Kafka via Docker (docker-compose)
- [ ] Kafka UI
- 📝 Commit: "study: Kafka concepts"

### Dia 102 — Fase 5 — Kafka Producer
- [ ] spring-kafka dependency
- [ ] KafkaTemplate<String, String>
- [ ] Enviar mensagens para topic
- 📝 Commit: "feat: Kafka Producer"

### Dia 103 — Fase 5 — Kafka Consumer
- [ ] @KafkaListener
- [ ] Consumer groups
- [ ] Deserialize JSON messages
- 📝 Commit: "feat: Kafka Consumer"

### Dia 104 — Fase 5 — Stay Hard Kafka
- [ ] Event: habit.completed → topic
- [ ] Analytics service consome events
- [ ] Notification service consome events
- 📝 Commit: "feat: Stay Hard Kafka events"

### Dia 105 — Fase 5 — RabbitMQ Concepts
- [ ] O que é RabbitMQ (message broker, AMQP)
- [ ] RabbitMQ vs Kafka (quando usar cada)
- [ ] Concepts: Producer, Consumer, Queue, Exchange, Binding
- [ ] Exchange types: Direct, Fanout, Topic
- 📝 Commit: "study: RabbitMQ concepts"

### Dia 106 — Fase 5 — RabbitMQ + Spring (Producer)
- [ ] spring-boot-starter-amqp
- [ ] RabbitMQ via Docker (port 5672 + 15672)
- [ ] RabbitMQConfig (Queue, Exchange, Binding)
- [ ] RabbitTemplate para enviar
- 📝 Commit: "feat: RabbitMQ Producer"

### Dia 107 — Fase 5 — RabbitMQ + Spring (Consumer)
- [ ] @RabbitListener para consumir
- [ ] Queue, Exchange, Binding config
- [ ] Testar Producer → Consumer flow
- [ ] Management UI: http://localhost:15672
- 📝 Commit: "feat: RabbitMQ Consumer"

### Dia 108 — Fase 5 — RabbitMQ Advanced
- [ ] Dead Letter Queues (DLQ)
- [ ] Manual acknowledgment
- [ ] Message retry
- [ ] Topic Exchange com routing
- 📝 Commit: "feat: RabbitMQ advanced (DLQ, ack)"

### Dia 109 — Fase 5 — Stay Hard RabbitMQ
- [ ] Event: habit completed → RabbitMQ
- [ ] Notification service consome via RabbitMQ
- [ ] Async email/push notification
- [ ] DLQ para mensagens que falham
- 📝 Commit: "feat: Stay Hard RabbitMQ notifications"

### Dia 110 — Fase 5 — IA Concepts
- [ ] O que é LLM (Large Language Model)
- [ ] Tokens, context window
- [ ] Temperature, top_p
- [ ] OpenAI API / Ollama (local)
- 📝 Commit: "study: IA/LLM concepts"

### Dia 111 — Fase 5 — Prompt Engineering
- [ ] System prompt vs User prompt
- [ ] Few-shot learning (exemplos)
- [ ] Chain of thought
- [ ] Structured output
- 📝 Commit: "study: Prompt Engineering"

### Dia 112 — Fase 5 — OpenAI/Ollama Setup
- [ ] Criar conta OpenAI (ou instalar Ollama local)
- [ ] Testar API com curl/Postman
- [ ] Gerar primeira resposta
- 📝 Commit: "feat: OpenAI/Ollama setup"

### Dia 113 — Fase 5 — Spring AI
- [ ] spring-ai-openai-spring-boot-starter
- [ ] ChatClient
- [ ] Gerar resposta com prompt
- 📝 Commit: "feat: Spring AI setup"

### Dia 114 — Fase 5 — RAG Concepts
- [ ] O que é RAG (Retrieval Augmented Generation)
- [ ] Embeddings (text → vectors)
- [ ] Vector databases (pgvector, ChromaDB)
- [ ] Similarity search
- [ ] Chunking strategies
- 📝 Commit: "study: RAG concepts"

### Dia 115 — Fase 5 — pgvector Setup
- [ ] pgvector extension no PostgreSQL
- [ ] Criar tabela com coluna vector
- [ ] Inserir embeddings
- [ ] Busca por similaridade (cosine distance)
- 📝 Commit: "feat: pgvector setup"

### Dia 116 — Fase 5 — RAG Pipeline
- [ ] Ingestão de documentos
- [ ] Chunking (dividir em pedaços)
- [ ] Gerar embeddings (OpenAI ada-002)
- [ ] Salvar no pgvector
- [ ] Query → embed → search → LLM answer
- 📝 Commit: "feat: RAG pipeline completa"

### Dia 117 — Fase 5 — Stay Hard Coach IA
- [ ] POST /api/ai/chat (conversa com coach)
- [ ] System prompt: coach motivacional
- [ ] Contexto: stats do usuário
- 📝 Commit: "feat: Stay Hard Coach IA"

### Dia 118 — Fase 5 — Stay Hard RAG Analytics
- [ ] "Como estão meus hábitos esta semana?"
- [ ] Busca dados no MongoDB (embeddings)
- [ ] IA gera resposta com dados reais
- 📝 Commit: "feat: Stay Hard RAG Analytics"

### Dia 119 — Fase 5 — Stay Hard Smart Suggestions
- [ ] IA analisa histórico de hábitos
- [ ] Sugere novos hábitos baseado em padrões
- [ ] Daily summary motivacional
- 📝 Commit: "feat: Smart Suggestions + Daily Summary"

### Dia 120 — Fase 5 — Revisão
- [ ] Revisão geral Fase 5
- [ ] RAG pipeline funcional?
- [ ] Kafka + RabbitMQ funcionando?
- [ ] Git tag v7.0
- [ ] Ler docs/08-saas-erp-ia.md
- 📝 Commit: "chore: v7.0 release"

---

## FASE 6 — SaaS + ERPs com IA + Portfolio (Dias 121-150)

### Dia 121 — Fase 6 — Multi-tenancy
- [ ] Estudar 3 estratégias (shared DB, schema, DB per tenant)
- [ ] Decidir qual usar para cada projeto
- [ ] TenantFilter (JWT claim)
- 📝 Commit: "study: Multi-tenancy"

### Dia 122 — Fase 6 — Tenant Resolution
- [ ] Implementar TenantContext (ThreadLocal)
- [ ] Filtro que extrai tenant_id do JWT
- [ ] Repository com filtro de tenant
- 📝 Commit: "feat: Tenant resolution"

### Dia 123 — Fase 6 — RBAC
- [ ] Role enum (ADMIN, MANAGER, USER)
- [ ] @PreAuthorize annotations
- [ ] SecurityConfig com roles
- 📝 Commit: "feat: RBAC implementation"

### Dia 124 — Fase 6 — Stripe Billing
- [ ] Criar conta Stripe
- [ ] Stripe Java SDK
- [ ] Criar subscription plans
- [ ] Webhook para eventos
- 📝 Commit: "feat: Stripe billing"

### Dia 125 — Fase 6 — Stay Hard SaaS
- [ ] Multi-tenant no Stay Hard
- [ ] Cada usuário = tenant isolado
- [ ] Planos Free/Pro
- 📝 Commit: "feat: Stay Hard SaaS multi-tenant"

### Dia 126 — Fase 6 — MedTrack Schema
- [ ] Entities: Patient, Doctor, Appointment, Prescription
- [ ] Repositories + Services
- [ ] knowledge_base table (pgvector)
- 📝 Commit: "feat: MedTrack schema"

### Dia 127 — Fase 6 — MedTrack CRUD
- [ ] CRUD patients, doctors, appointments
- [ ] REST endpoints
- [ ] Validação + Exception handling
- 📝 Commit: "feat: MedTrack CRUD"

### Dia 128 — Fase 6 — MedTrack Triagem IA
- [ ] Patient descreve sintomas
- [ ] IA analisa e sugere especialidade
- [ ] /api/ai/triage endpoint
- 📝 Commit: "feat: MedTrack triagem IA"

### Dia 129 — Fase 6 — MedTrack RAG
- [ ] Ingerir base de conhecimento médico
- [ ] RAG: médico pergunta → IA responde com protocolos
- [ ] /api/ai/medical-query endpoint
- 📝 Commit: "feat: MedTrack RAG médico"

### Dia 130 — Fase 6 — MedTrack Frontend
- [ ] React + TypeScript frontend
- [ ] Pages: Dashboard, Patients, Appointments, AI Chat
- [ ] Conectar com API
- 📝 Commit: "feat: MedTrack frontend"

### Dia 131 — Fase 6 — LegalMind Schema
- [ ] Entities: Client, Case, Deadline, Document
- [ ] jurisprudencia table (pgvector)
- [ ] legislacao table (pgvector)
- 📝 Commit: "feat: LegalMind schema"

### Dia 132 — Fase 6 — LegalMind CRUD
- [ ] CRUD cases, clients, deadlines, documents
- [ ] REST endpoints
- [ ] File upload for documents
- 📝 Commit: "feat: LegalMind CRUD"

### Dia 133 — Fase 6 — LegalMind Contratos IA
- [ ] Upload de contrato (PDF)
- [ ] IA analisa cláusulas, riscos, sugestões
- [ ] /api/ai/analyze-contract endpoint
- 📝 Commit: "feat: LegalMind contrato IA"

### Dia 134 — Fase 6 — LegalMind RAG
- [ ] Ingerir jurisprudência + legislação
- [ ] Advogado pergunta → IA retorna casos similares
- [ ] /api/ai/jurisprudencia endpoint
- 📝 Commit: "feat: LegalMind RAG jurídico"

### Dia 135 — Fase 6 — LegalMind Frontend
- [ ] React + TypeScript frontend
- [ ] Pages: Dashboard, Cases, Documents, AI Query
- [ ] Conectar com API
- 📝 Commit: "feat: LegalMind frontend"

### Dia 136 — Fase 6 — BuildFlow Schema
- [ ] Entities: Project, Team, Material, Milestone
- [ ] normas_tecnicas table (pgvector)
- [ ] historico_projetos table (pgvector)
- 📝 Commit: "feat: BuildFlow schema"

### Dia 137 — Fase 6 — BuildFlow CRUD
- [ ] CRUD projects, teams, materials, milestones
- [ ] Gantt chart data endpoint
- [ ] REST endpoints
- 📝 Commit: "feat: BuildFlow CRUD"

### Dia 138 — Fase 6 — BuildFlow Custos IA
- [ ] IA estima custos baseado em projetos passados
- [ ] RAG com histórico de projetos
- [ ] /api/ai/estimate-cost endpoint
- 📝 Commit: "feat: BuildFlow custos IA"

### Dia 139 — Fase 6 — BuildFlow RAG
- [ ] Ingerir normas técnicas (NBR, ABNT)
- [ ] Engenheiro pergunta → IA responde com normas
- [ ] /api/ai/normas endpoint
- 📝 Commit: "feat: BuildFlow RAG normas"

### Dia 140 — Fase 6 — BuildFlow Frontend
- [ ] React + TypeScript frontend
- [ ] Pages: Dashboard, Projects, Gantt, Materials, AI
- [ ] Conectar com API
- 📝 Commit: "feat: BuildFlow frontend"

### Dia 141 — Fase 6 — TelecomPro Schema
- [ ] Entities: Customer, Plan, Subscription, Ticket, Invoice
- [ ] faqs table (pgvector)
- 📝 Commit: "feat: TelecomPro schema"

### Dia 142 — Fase 6 — TelecomPro CRUD
- [ ] CRUD customers, plans, subscriptions, tickets
- [ ] Faturamento automático
- [ ] REST endpoints
- 📝 Commit: "feat: TelecomPro CRUD"

### Dia 143 — Fase 6 — TelecomPro Churn IA
- [ ] IA prevê probabilidade de churn
- [ ] Baseado em: uso, tickets, faturas atrasadas
- [ ] /api/ai/churn-prediction endpoint
- 📝 Commit: "feat: TelecomPro churn IA"

### Dia 144 — Fase 6 — TelecomPro RAG
- [ ] Ingerir FAQs + conhecimento técnico
- [ ] Chatbot de suporte com RAG
- [ ] /api/ai/support-chat endpoint
- 📝 Commit: "feat: TelecomPro chatbot RAG"

### Dia 145 — Fase 6 — TelecomPro Frontend
- [ ] React + TypeScript frontend
- [ ] Pages: Dashboard, Customers, Plans, Tickets, AI Chat
- [ ] Conectar com API
- 📝 Commit: "feat: TelecomPro frontend"

### Dia 146 — Fase 6 — Portfolio READMEs
- [ ] README profissional em cada repo
- [ ] Screenshots, diagramas, como rodar
- [ ] Badges (build, coverage, license)
- 📝 Commit: "docs: Portfolio READMEs"

### Dia 147 — Fase 6 — Deploy
- [ ] Deploy no AWS/Railway/Render
- [ ] CI/CD com GitHub Actions
- [ ] Environment variables configuradas
- 📝 Commit: "feat: Production deploy"

### Dia 148 — Fase 6 — LinkedIn + GitHub
- [ ] Atualizar LinkedIn com projetos
- [ ] GitHub profile organizado
- [ ] Pin repos principais
- 📝 Commit: "chore: Portfolio finalized"

### Dia 149 — Fase 6 — Revisão Geral
- [ ] Revisar TUDO que aprendeu
- [ ] Checklist completo?
- [ ] Todos projetos funcionando?
- 📝 Commit: "chore: Final review"

### Dia 150 — Fase 6 — 🏆 STAY HARD
- [ ] Celebre sua conquista!
- [ ] Documentar jornada no README
- [ ] Planejar próximos passos
- 📝 Commit: "🏆 STAY HARD — Journey complete"

---

> *"Who's gonna carry the boats?!"* — David Goggins
> **150 dias. 7 fases. De iniciante a Full-Stack. Stay Hard.**
