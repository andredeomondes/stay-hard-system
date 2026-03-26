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

## FASE 1 — Java Puro + SQLite + JDBC + API sem Spring (Dias 11-20)

### Dia 11 — Fase 1 — SQLite Setup
- [ ] Estudar o que é SQLite (serverless, arquivo .db)
- [ ] Adicionar dependência sqlite-jdbc no pom.xml
- [ ] Conectar: `DriverManager.getConnection("jdbc:sqlite:stay_hard.db")`
- [ ] Criar tabela users com CREATE TABLE
- 📝 Commit: "feat: SQLite setup"

### Dia 12 — Fase 1 — JDBC CRUD
- [ ] Estudar JDBC (Connection, Statement, PreparedStatement, ResultSet)
- [ ] Implementar INSERT com PreparedStatement
- [ ] Implementar SELECT (findAll, findById)
- [ ] Implementar UPDATE e DELETE
- 📝 Commit: "feat: JDBC CRUD operations"

### Dia 13 — Fase 1 — JDBC + Stay Hard
- [ ] Criar UserRepository com JDBC (migrar de CSV)
- [ ] Criar HabitRepository com JDBC (migrar de CSV)
- [ ] Criar schema.sql com CREATE TABLE users + habits
- [ ] Testar: dados salvos no arquivo .db
- 📝 Commit: "feat: Stay Hard with JDBC"

### Dia 14 — Fase 1 — JDBC Avançado
- [ ] Transações (setAutoCommit, commit, rollback)
- [ ] JOINs via JDBC (SELECT com JOIN em PreparedStatement)
- [ ] Batch inserts
- [ ] Connection pooling básico
- 📝 Commit: "study: JDBC advanced"

### Dia 15 — Fase 1 — API sem Spring (HttpServer)
- [ ] Estudar com.sun.net.httpserver.HttpServer
- [ ] Criar servidor básico na porta 8080
- [ ] Criar handler para /api/users (GET)
- [ ] Retornar JSON com Gson
- 📝 Commit: "feat: HttpServer basic API"

### Dia 16 — Fase 1 — API REST completa
- [ ] Implementar GET /api/users (listar todos)
- [ ] Implementar POST /api/users (criar)
- [ ] Implementar GET /api/users/{id} (buscar por ID)
- [ ] Implementar PUT /api/users/{id} (atualizar)
- [ ] Implementar DELETE /api/users/{id} (deletar)
- 📝 Commit: "feat: REST API with HttpServer"

### Dia 17 — Fase 1 — API + Habits
- [ ] Implementar CRUD de habits na API
- [ ] Roteamento por path (/api/users, /api/habits)
- [ ] Status codes corretos (200, 201, 204, 404)
- [ ] Content-Type: application/json
- 📝 Commit: "feat: Habits REST API"

### Dia 18 — Fase 1 — API + SQLite integrados
- [ ] Conectar API com SQLite (UserHandler → UserRepository → JDBC)
- [ ] Conectar API com SQLite (HabitHandler → HabitRepository → JDBC)
- [ ] Testar com curl todos os endpoints
- [ ] Tratar erros (404, 400)
- 📝 Commit: "feat: API + SQLite integration"

### Dia 19 — Fase 1 — Mini-projeto: API SQLite JDBC
- [ ] Criar mini-projetos/api-sqlite-jdbc/ completo
- [ ] Arquitetura: ApiServer → Handler → Repository → SQLite
- [ ] CRUD de users + habits
- [ ] Testar com curl/Postman
- 📝 Commit: "feat: API SQLite JDBC mini-project"

### Dia 20 — Fase 1 — Revisão + Prep Spring
- [ ] Revisão: entender JDBC, SQLite, HttpServer, REST
- [ ] Comparar: API manual vs Spring Boot (o que Spring facilita?)
- [ ] Ler docs/02-fase1-java-backend.md (Spring Boot)
- [ ] Git tag v1.5
- 📝 Commit: "chore: v1.5 — pre-Spring review"

---

## FASE 2 — HTML + CSS + JavaScript (Dias 21-40)

### Dia 21 — Fase 2 — HTML Básico
- [ ] Estrutura HTML (head, body, meta, title)
- [ ] Tags: h1-h6, p, a, img, div, span
- [ ] Listas (ul, ol, li)
- [ ] Criar uma página simples sobre você
- 📝 Commit: "study: HTML basics"

### Dia 22 — Fase 2 — HTML Avançado
- [ ] Formulários (form, input, select, button, textarea)
- [ ] Tabelas (table, tr, td, th, thead, tbody)
- [ ] HTML semântico (header, nav, main, section, article, footer)
- [ ] Atributos (id, class, data-*, aria-*)
- 📝 Commit: "study: HTML forms + semantic"

### Dia 23 — Fase 2 — CSS Básico
- [ ] Seletores (tag, class, id, combinators)
- [ ] Cores, fontes, backgrounds
- [ ] Box model (margin, padding, border)
- [ ] Display (block, inline, inline-block, none)
- 📝 Commit: "study: CSS basics"

### Dia 24 — Fase 2 — CSS Layout
- [ ] Flexbox (container, items, justify, align, wrap)
- [ ] CSS Grid (grid-template, gap, grid-area)
- [ ] Position (static, relative, absolute, fixed, sticky)
- [ ] Z-index e overflow
- 📝 Commit: "study: CSS layout (flexbox + grid)"

### Dia 25 — Fase 2 — CSS Responsivo
- [ ] Media queries (@media screen and max-width)
- [ ] Mobile-first design
- [ ] Unidades relativas (rem, em, %, vw, vh)
- [ ] Imagens responsivas (max-width: 100%)
- 📝 Commit: "study: CSS responsive design"

### Dia 26 — Fase 2 — Mini: Landing Page
- [ ] Criar mini-projetos/landing-page/
- [ ] Página responsiva com HTML + CSS
- [ ] Header, hero section, features, footer
- [ ] Deploy no GitHub Pages
- 📝 Commit: "feat: responsive landing page"

### Dia 27 — Fase 2 — JavaScript Básico
- [ ] Variáveis (let, const), tipos (string, number, boolean, null, undefined)
- [ ] Operadores (+, -, *, ===, !==, &&, ||)
- [ ] Condicionais (if/else, switch)
- [ ] Loops (for, while, forEach)
- 📝 Commit: "study: JavaScript basics"

### Dia 28 — Fase 2 — JS Arrays e Objetos
- [ ] Arrays (push, pop, shift, unshift, splice, slice)
- [ ] Objetos (criar, acessar propriedades, métodos)
- [ ] JSON (JSON.parse, JSON.stringify)
- [ ] Desestruturação de objetos e arrays
- 📝 Commit: "study: JS arrays + objects"

### Dia 29 — Fase 2 — JS DOM Manipulation
- [ ] document.querySelector, querySelectorAll
- [ ] createElement, appendChild, removeChild
- [ ] innerHTML, textContent, classList
- [ ] Eventos (addEventListener, click, submit, keydown)
- 📝 Commit: "study: JS DOM manipulation"

### Dia 30 — Fase 2 — JS Forms + Validação
- [ ] Capturar valores de inputs
- [ ] Validar formulários (required, pattern, minLength)
- [ ] Feedback visual (mensagens de erro/sucesso)
- [ ] Prevenir submit padrão (e.preventDefault)
- 📝 Commit: "study: JS form validation"

### Dia 31 — Fase 2 — JS ES6+
- [ ] Arrow functions
- [ ] Template literals
- [ ] Destructuring (object + array)
- [ ] Spread / Rest operator
- [ ] Módulos (import/export)
- 📝 Commit: "study: JavaScript ES6+"

### Dia 32 — Fase 2 — JS Array Methods
- [ ] map (transformar cada elemento)
- [ ] filter (filtrar elementos)
- [ ] reduce (acumular valores)
- [ ] find, some, every
- [ ] Encadear métodos
- 📝 Commit: "study: JS array methods (map, filter, reduce)"

### Dia 33 — Fase 2 — JS Async
- [ ] Callbacks
- [ ] Promises (new Promise, .then, .catch)
- [ ] async/await
- [ ] try/catch com async
- 📝 Commit: "study: JS async/await"

### Dia 34 — Fase 2 — JS Fetch API
- [ ] fetch(url) para GET
- [ ] fetch com POST (body, headers)
- [ ] Tratar resposta (response.json())
- [ ] Tratar erros (network, 404, 500)
- [ ] Consumir API pública (ex: jsonplaceholder)
- 📝 Commit: "study: JS Fetch API"

### Dia 35 — Fase 2 — JS + Stay Hard API
- [ ] Conectar front-end HTML/CSS/JS com API do Stay Hard
- [ ] Login via fetch (POST /api/auth/login)
- [ ] Listar hábitos (GET /api/habits)
- [ ] Criar hábito via formulário (POST /api/habits)
- [ ] Salvar JWT no localStorage
- 📝 Commit: "feat: JS front-end consuming Stay Hard API"

### Dia 36 — Fase 2 — Mini: Todo List Web
- [ ] Criar mini-projetos/todo-list-web/
- [ ] HTML + CSS + JS
- [ ] Adicionar, completar, deletar tarefas
- [ ] LocalStorage para persistência
- [ ] Interface responsiva
- 📝 Commit: "feat: todo list web app"

### Dia 37 — Fase 2 — Mini: Calculadora Web
- [ ] Criar mini-projetos/calculadora-web/
- [ ] HTML + CSS + JS
- [ ] Botões para números e operações
- [ ] Display que mostra resultado
- [ ] Design responsivo
- 📝 Commit: "feat: calculator web app"

### Dia 38 — Fase 2 — Mini: Weather App
- [ ] Criar mini-projetos/weather-app/
- [ ] HTML + CSS + JS
- [ ] Consumir API pública de clima (OpenWeatherMap)
- [ ] Mostrar temperatura, descrição, ícone
- [ ] Buscar por cidade
- 📝 Commit: "feat: weather app"

### Dia 39 — Fase 2 — Mini: Portfolio Page
- [ ] Criar mini-projetos/portfolio-page/
- [ ] HTML + CSS responsivo
- [ ] Seções: Sobre, Projetos, Contato
- [ ] Links para GitHub e projetos
- [ ] Deploy no GitHub Pages
- 📝 Commit: "feat: portfolio page"

### Dia 40 — Fase 2 — Revisão Front-end
- [ ] Revisão: HTML, CSS, JS, DOM, Fetch, ES6+
- [ ] Consegue criar página responsiva do zero?
- [ ] Consegue consumir API via fetch?
- [ ] Git tag v1.5
- 📝 Commit: "chore: v1.5 — front-end fundamentals"

---

## FASE 3 — Spring Boot + PostgreSQL + JPA + Redis (Dias 41-60)

### Dia 41 — Fase 3 — PostgreSQL Setup
- [ ] Instalar PostgreSQL
- [ ] Instalar DBeaver
- [ ] Criar database stay_hard_db
- [ ] Criar usuário stayhard
- 📝 Commit: "feat: PostgreSQL setup"

### Dia 42 — Fase 3 — SQL DDL
- [ ] Criar tabela users (id, name, email, created_at)
- [ ] Criar tabela habits (id, user_id, name, priority, status)
- [ ] Adicionar constraints (PK, FK, NOT NULL, UNIQUE)
- 📝 Commit: "study: SQL DDL"

### Dia 43 — Fase 3 — SQL DML
- [ ] INSERT de dados de teste
- [ ] SELECT com WHERE, ORDER BY
- [ ] UPDATE e DELETE registros
- 📝 Commit: "study: SQL DML"

### Dia 44 — Fase 3 — SQL JOINs
- [ ] INNER JOIN users + habits
- [ ] LEFT JOIN (usuários sem hábitos)
- [ ] RIGHT JOIN, FULL JOIN
- 📝 Commit: "study: SQL JOINs"

### Dia 45 — Fase 3 — SQL GROUP BY
- [ ] GROUP BY com COUNT, AVG, SUM
- [ ] HAVING para filtrar grupos
- [ ] Subqueries básicas
- 📝 Commit: "study: SQL aggregations"

### Dia 46 — Fase 3 — Spring Boot Setup
- [ ] Spring Initializr (web, jpa, postgresql)
- [ ] application.properties com PostgreSQL
- [ ] `mvn spring-boot:run` funciona
- 📝 Commit: "feat: Spring Boot init"

### Dia 47 — Fase 3 — IoC e DI
- [ ] Estudar Inversion of Control
- [ ] Estudar Dependency Injection
- [ ] Annotations: @Component, @Service, @Repository
- [ ] Bean lifecycle e scopes
- 📝 Commit: "study: IoC + DI concepts"

### Dia 48 — Fase 3 — JPA Entities
- [ ] @Entity User com @Id @GeneratedValue
- [ ] @Entity Habit com @ManyToOne User
- [ ] @Enumerated para Priority e Status
- 📝 Commit: "feat: JPA entities"

### Dia 49 — Fase 3 — JPA Repositories
- [ ] UserRepository extends JpaRepository
- [ ] HabitRepository extends JpaRepository
- [ ] Métodos customizados (findByEmail, findByUserId)
- 📝 Commit: "feat: JPA repositories"

### Dia 50 — Fase 3 — Migrar Services
- [ ] Adaptar UserService para usar JpaRepository
- [ ] Adaptar HabitService para usar JpaRepository
- [ ] @Transactional onde necessário
- 📝 Commit: "refactor: services using JPA"

### Dia 51 — Fase 3 — Migrar Controllers
- [ ] Adaptar UserController para Spring
- [ ] Adaptar HabitController para Spring
- [ ] Testar via Postman/curl
- 📝 Commit: "refactor: Spring controllers"

### Dia 52 — Fase 3 — CommandLineRunner
- [ ] Criar CliRunner implements CommandLineRunner
- [ ] Manter CLI funcionando via Spring
- [ ] Transição suave de CLI → Spring Boot
- 📝 Commit: "feat: CLI runner with Spring"

### Dia 53 — Fase 3 — Testes com H2
- [ ] Configurar H2 in-memory para testes
- [ ] @DataJpaTest para repositories
- [ ] @SpringBootTest para services
- 📝 Commit: "test: integration tests with H2"

### Dia 54 — Fase 3 — Flyway
- [ ] Configurar Flyway
- [ ] V1__create_users_table.sql
- [ ] V2__create_habits_table.sql
- 📝 Commit: "feat: Flyway migrations"

### Dia 55 — Fase 3 — Validações
- [ ] @NotNull, @NotBlank nas entities
- [ ] Custom exceptions (ResourceNotFoundException)
- [ ] Exception handler básico
- 📝 Commit: "feat: validation + exceptions"

### Dia 56 — Fase 3 — CRUD Produtos
- [ ] Criar mini-projetos/crud-produtos/
- [ ] Spring Boot + H2, CRUD completo
- [ ] JPA + Validation + REST
- 📝 Commit: "feat: CRUD products"

### Dia 57 — Fase 3 — API Contatos
- [ ] Criar mini-projetos/api-contatos/
- [ ] Spring Boot + PostgreSQL
- [ ] CRUD de contatos com validação
- 📝 Commit: "feat: contacts API"

### Dia 58 — Fase 3 — Blog Simples
- [ ] Criar mini-projetos/blog-simples/
- [ ] Spring Boot + Thymeleaf
- [ ] Posts com título, conteúdo, data
- 📝 Commit: "feat: simple blog"

### Dia 59 — Fase 3 — Gerenciador Livros
- [ ] Criar mini-projetos/gerenciador-livros/
- [ ] Spring Boot + PostgreSQL
- [ ] CRUD de livros + busca por título/autor
- 📝 Commit: "feat: book manager"

### Dia 60 — Fase 3 — Revisão
- [ ] Revisão geral Fase 3
- [ ] Todos testes passando?
- [ ] Git tag v2.0
- [ ] Ler docs/03-fase2-rest-api.md
- 📝 Commit: "chore: v2.0 release"

---

## FASE 4 — REST API + Auth (Dias 61-78)

### Dia 61 — Fase 4 — REST Concepts
- [ ] Estudar REST (resources, HTTP methods, status codes)
- [ ] @RestController vs @Controller
- [ ] @RequestMapping
- 📝 Commit: "study: REST concepts"

### Dia 62 — Fase 4 — GET e POST
- [ ] @GetMapping para listar/buscar
- [ ] @PostMapping para criar
- [ ] @PathVariable e @RequestParam
- [ ] Retornar ResponseEntity com status 200/201
- 📝 Commit: "feat: GET + POST endpoints"

### Dia 63 — Fase 4 — PUT e DELETE
- [ ] @PutMapping para atualizar
- [ ] @DeleteMapping para deletar
- [ ] Retornar status 204 No Content
- 📝 Commit: "feat: PUT + DELETE endpoints"

### Dia 64 — Fase 4 — DTOs
- [ ] Criar request DTOs (CreateHabitRequest, LoginRequest)
- [ ] Criar response DTOs (HabitResponse, UserResponse)
- [ ] Separar entities de DTOs
- 📝 Commit: "feat: DTO layer"

### Dia 65 — Fase 4 — Bean Validation
- [ ] @Valid no @RequestBody
- [ ] @NotNull, @NotBlank, @Size, @Email
- [ ] Mensagens de erro legíveis
- 📝 Commit: "feat: bean validation"

### Dia 66 — Fase 4 — Exception Handling
- [ ] @ControllerAdvice global
- [ ] @ExceptionHandler para cada exception
- [ ] Custom exceptions (ResourceNotFoundException, ValidationException)
- [ ] ErrorResponse DTO
- 📝 Commit: "feat: global exception handling"

### Dia 67 — Fase 4 — JWT Concepts
- [ ] Estudar JWT (Header, Payload, Signature)
- [ ] Fluxo: login → token → authenticated requests
- [ ] BCrypt para hash de senhas
- 📝 Commit: "study: JWT concepts"

### Dia 68 — Fase 4 — JWT Implementation
- [ ] JwtTokenProvider (generate, validate, getSubject)
- [ ] JwtAuthenticationFilter
- [ ] SecurityFilterChain
- 📝 Commit: "feat: JWT auth filter"

### Dia 69 — Fase 4 — Login + Register
- [ ] POST /api/auth/register
- [ ] POST /api/auth/login → retorna JWT
- [ ] Endpoints protegidos exigem token
- 📝 Commit: "feat: auth endpoints"

### Dia 70 — Fase 4 — Swagger
- [ ] springdoc-openapi dependency
- [ ] Swagger UI em /swagger-ui.html
- [ ] @Operation, @ApiResponse nos endpoints
- 📝 Commit: "feat: Swagger documentation"

### Dia 71 — Fase 4 — Stay Hard v3.0 Auth
- [ ] /api/auth/register com validação
- [ ] /api/auth/login retornando JWT
- [ ] /api/users/me (perfil autenticado)
- [ ] /api/users/me/stats
- 📝 Commit: "feat: stay hard auth v3.0"

### Dia 72 — Fase 4 — Stay Hard v3.0 Habits
- [ ] POST /api/habits (criar)
- [ ] GET /api/habits (listar)
- [ ] PUT /api/habits/{id}/start
- [ ] PUT /api/habits/{id}/complete
- [ ] DELETE /api/habits/{id}
- [ ] PUT /api/habits/{id} (update)
- [ ] PUT /api/habits/reset
- 📝 Commit: "feat: stay hard habits CRUD v3.0"

### Dia 73 — Fase 4 — Stay Hard v3.0 Daily
- [ ] POST /api/daily/finish (calcula success/fail)
- [ ] GET /api/daily/stats
- [ ] Lógica: allHighCompleted → registerCompletedDay
- 📝 Commit: "feat: stay hard daily v3.0"

### Dia 74 — Fase 4 — Mini: Auth API JWT
- [ ] Criar mini-projetos/auth-api-jwt/
- [ ] Login, registro, endpoints protegidos
- [ ] Spring Security + JWT
- 📝 Commit: "feat: auth API JWT"

### Dia 75 — Fase 4 — Mini: Task Manager
- [ ] Criar mini-projetos/task-manager-api/
- [ ] CRUD de tarefas com JWT
- [ ] Swagger documentado
- 📝 Commit: "feat: task manager API"

### Dia 76 — Fase 4 — Mini: Library API
- [ ] Criar mini-projetos/library-api/
- [ ] CRUD de livros + autores
- [ ] Swagger + PostgreSQL
- 📝 Commit: "feat: library API"

### Dia 77 — Fase 4 — Mini: Contact Book
- [ ] Criar mini-projetos/contact-book-api/
- [ ] CRUD de contatos com grupos
- [ ] JWT auth + REST
- 📝 Commit: "feat: contact book API"

### Dia 78 — Fase 4 — Revisão
- [ ] Revisão geral Fase 4
- [ ] Todos endpoints funcionando?
- [ ] Git tag v3.0
- [ ] Ler docs/04-fase3-react-typescript.md
- 📝 Commit: "chore: v3.0 release"

---

## FASE 5 — Docker + Redis + System Design + CI/CD (Dias 79-102)

### Dia 79 — Fase 5 — Docker Concepts
- [ ] Imagens, Containers, Volumes, Networks
- [ ] Docker Hub
- [ ] `docker run`, `docker ps`, `docker stop`, `docker rm`
- 📝 Commit: "study: Docker concepts"

### Dia 80 — Fase 5 — Dockerfile Spring Boot
- [ ] Multi-stage build (build + runtime)
- [ ] COPY, EXPOSE, ENTRYPOINT
- [ ] .dockerignore
- 📝 Commit: "feat: Dockerfile Spring Boot"

### Dia 81 — Fase 5 — Dockerfile Static (Nginx)
- [ ] Dockerfile com Nginx para HTML/CSS/JS
- [ ] COPY dist para /usr/share/nginx/html
- [ ] Build e testar container
- 📝 Commit: "feat: Dockerfile Nginx static"

### Dia 82 — Fase 5 — Docker Compose
- [ ] docker-compose.yml (postgres + api + frontend + redis)
- [ ] services, networks, volumes
- [ ] depends_on, environment, ports
- [ ] `docker-compose up` / `docker-compose down`
- 📝 Commit: "feat: Docker Compose multi-service"

### Dia 83 — Fase 5 — Health Checks + .env
- [ ] healthcheck no docker-compose
- [ ] .env para variáveis de ambiente
- [ ] env_file no compose
- [ ] Spring Boot profile (application-docker.yml)
- 📝 Commit: "feat: health checks + .env"

### Dia 84 — Fase 5 — Redis Concepts
- [ ] Data types: String, List, Set, Hash, Sorted Set
- [ ] Use cases (cache, session, rate limiting, pub/sub)
- [ ] Quando usar vs quando não usar
- 📝 Commit: "study: Redis concepts"

### Dia 85 — Fase 5 — Redis via Docker + redis-cli
- [ ] `docker run redis`
- [ ] redis-cli: SET, GET, DEL, TTL, KEYS
- [ ] EXPIRE, PERSIST
- [ ] Monitor com redis-cli
- 📝 Commit: "study: Redis CLI basics"

### Dia 86 — Fase 5 — Spring Boot + Redis
- [ ] spring-boot-starter-data-redis
- [ ] RedisTemplate e StringRedisTemplate
- [ ] @Cacheable, @CacheEvict, @CachePut
- [ ] RedisConnectionFactory config
- 📝 Commit: "feat: Spring Boot + Redis"

### Dia 87 — Fase 5 — Redis Rate Limiting + Pub/Sub
- [ ] Sliding window rate limiting com Redis
- [ ] Redis Pub/Sub (publish, subscribe)
- [ ] Pattern: rate limiter por IP/user
- 📝 Commit: "feat: Redis rate limiting + pub/sub"

### Dia 88 — Fase 5 — Stay Hard v5.0 — Redis Integration
- [ ] Cache de estatísticas (Dashboard)
- [ ] Rate limiting em endpoints críticos
- [ ] Cache de sessões de hábitos
- 📝 Commit: "feat: Stay Hard Redis integration"

### Dia 89 — Fase 5 — Stay Hard v5.0 — Docker Completo
- [ ] docker-compose.yml com postgres + api + frontend + redis
- [ ] Testar `docker-compose up` completo
- [ ] Health checks funcionando
- [ ] .env configurado
- 📝 Commit: "feat: Stay Hard Docker completo"

### Dia 90 — Fase 5 — System Design HLD
- [ ] Requirements (functional + non-functional)
- [ ] Estimation (traffic, storage, bandwidth)
- [ ] Architecture patterns (monolith vs microservices)
- [ ] API design (REST, GraphQL)
- 📝 Commit: "study: System Design HLD"

### Dia 91 — Fase 5 — CAP Theorem + Scaling
- [ ] CAP Theorem (Consistency, Availability, Partition)
- [ ] Horizontal vs Vertical scaling
- [ ] Database sharding strategies
- 📝 Commit: "study: CAP + Scaling"

### Dia 92 — Fase 5 — Caching + Load Balancing + API Gateway
- [ ] Caching strategies (write-through, write-back, TTL)
- [ ] Load Balancing (round-robin, least connections)
- [ ] API Gateway pattern
- [ ] CDN basics
- 📝 Commit: "study: Caching + LB + Gateway"

### Dia 93 — Fase 5 — SOLID Principles
- [ ] Single Responsibility
- [ ] Open/Closed
- [ ] Liskov Substitution
- [ ] Interface Segregation
- [ ] Dependency Inversion
- 📝 Commit: "study: SOLID principles"

### Dia 94 — Fase 5 — Design Patterns
- [ ] Singleton, Factory, Builder
- [ ] Strategy, Observer
- [ ] Aplicar em código Java/Spring Boot
- 📝 Commit: "study: Design Patterns"

### Dia 95 — Fase 5 — GitHub Actions CI/CD
- [ ] Workflows (.github/workflows/)
- [ ] Jobs, steps, triggers
- [ ] Pipeline: test → build → deploy
- [ ] Secrets no GitHub
- 📝 Commit: "study: GitHub Actions CI/CD"

### Dia 96 — Fase 5 — Stay Hard v5.0 — CI/CD Pipeline
- [ ] Workflow para testes (mvn test)
- [ ] Workflow para build Docker image
- [ ] Deploy automático
- 📝 Commit: "feat: Stay Hard CI/CD pipeline"

### Dia 97 — Fase 5 — Mini: docker-spring-boot
- [ ] Criar mini-projetos/docker-spring-boot/
- [ ] Spring Boot app com Dockerfile
- [ ] docker-compose com postgres
- 📝 Commit: "feat: mini docker-spring-boot"

### Dia 98 — Fase 5 — Mini: redis-cache-demo
- [ ] Criar mini-projetos/redis-cache-demo/
- [ ] Spring Boot + Redis (cache de exemplo)
- [ ] Benchmark com e sem cache
- 📝 Commit: "feat: mini redis-cache-demo"

### Dia 99 — Fase 5 — Mini: github-actions-ci
- [ ] Criar mini-projetos/github-actions-ci/
- [ ] Repo com workflow de test + build
- [ ] Badge de status no README
- 📝 Commit: "feat: mini github-actions-ci"

### Dia 100 — Fase 5 — Mini: rate-limiter
- [ ] Criar mini-projetos/rate-limiter/
- [ ] Rate limiter com Redis (sliding window)
- [ ] Testar com Apache Benchmark
- 📝 Commit: "feat: mini rate-limiter"

### Dia 101 — Fase 5 — Connect Frontend + Docker Backend
- [ ] Frontend HTML/CSS/JS conectando ao backend Docker
- [ ] Nginx reverse proxy no docker-compose
- [ ] CORS configurado corretamente
- 📝 Commit: "feat: frontend + Docker backend"

### Dia 102 — Fase 5 — Nginx Reverse Proxy
- [ ] O que é reverse proxy (recebe request → encaminha para backend)
- [ ] Nginx config (upstream, proxy_pass, location)
- [ ] Serve static files (React build)
- [ ] CORS headers no Nginx
- 📝 Commit: "feat: Nginx reverse proxy"

### Dia 103 — Fase 5 — Logging (SLF4J + Logback)
- [ ] Log levels: ERROR, WARN, INFO, DEBUG, TRACE
- [ ] SLF4J no Spring Boot (Logger, LoggerFactory)
- [ ] Logging pattern no console e arquivo
- [ ] application.properties logging config
- [ ] Structured logging (JSON com LogstashEncoder)
- 📝 Commit: "feat: structured logging"

### Dia 104 — Fase 5 — Observabilidade
- [ ] Spring Boot Actuator (health, metrics, info)
- [ ] Correlation ID filter (X-Correlation-ID)
- [ ] MDC (Mapped Diagnostic Context)
- [ ] Monitorar /actuator/health e /actuator/metrics
- 📝 Commit: "feat: observability + correlation IDs"

### Dia 105 — Fase 5 — Revisão
- [ ] Revisão geral Fase 5
- [ ] Docker, Redis, CI/CD, System Design, Logging, Nginx
- [ ] Git tag v5.0
- [ ] Ler docs/06-fase5-ia-rag.md
- 📝 Commit: "chore: v5.0 release"

---

## FASE 6 — MongoDB + Microservices + Kafka + RabbitMQ (Dias 106-133)

Dia 106: MongoDB concepts + Docker setup
Dia 107: Spring Data MongoDB (@Document, MongoRepository)
Dia 108: Stay Hard — MongoDB analytics/audit logs
Dia 109: Microservices concepts (when, why, how)
Dia 110: Eureka Server (Service Discovery)
Dia 111: API Gateway (Spring Cloud Gateway)
Dia 112: Feign inter-service communication
Dia 113: Circuit Breaker (Resilience4j)
Dia 114: Kafka concepts + Docker setup (topics, partitions)
Dia 115: Spring Boot + Kafka Producer
Dia 116: Spring Boot + Kafka Consumer
Dia 117: Stay Hard — Kafka events
Dia 118: RabbitMQ concepts + Docker setup
Dia 119: RabbitMQ Producer (RabbitTemplate)
Dia 120: RabbitMQ Consumer (@RabbitListener)
Dia 121: RabbitMQ advanced (DLQ, ack, exchanges)
Dia 122: Stay Hard — RabbitMQ notifications
Dia 123: Stay Hard microservices (user, habit, analytics, notification services)
Dia 124-128: Docker Compose for full microservices stack
Dia 129-133: Revisão + tag v6.0

---

## FASE 7 — IA + RAG + Spring AI (Dias 134-153)

Dia 134: IA concepts (LLM, tokens, context window)
Dia 135: Prompt Engineering
Dia 136: OpenAI/Ollama setup
Dia 137: Spring AI (ChatClient)
Dia 138: RAG concepts (embeddings, vector DB, similarity)
Dia 139: pgvector setup
Dia 140: RAG pipeline completa
Dia 141: Stay Hard — Coach IA
Dia 142: Stay Hard — RAG Analytics
Dia 143: Stay Hard — Smart Suggestions + Daily Summary
Dia 144: Mini-projeto: Chat com PDF (RAG)
Dia 145: Mini-projeto: Code Reviewer IA
Dia 146: Mini-projeto: Document Q&A
Dia 147: Mini-projeto: Recipe Suggester
Dia 148: Mini-projeto: Sentiment Analyzer
Dia 149-153: Revisão + tag v7.0

---

## FASE 8 — TypeScript + React + Tailwind (Dias 154-178)

Dia 154: TypeScript basics (types, interfaces)
Dia 155: TypeScript advanced (generics, enums, unions)
Dia 156: Vite + React project setup
Dia 157: Components + props + TypeScript
Dia 158: useState + useEffect
Dia 159: React Router DOM v6
Dia 160: Axios + JWT interceptors
Dia 161: Tailwind CSS setup
Dia 162: Context API (AuthContext)
Dia 163: Custom Hooks (useAuth, useHabits)
Dia 164: Stay Hard v4.0 — Login/Register pages
Dia 165: Stay Hard v4.0 — Dashboard
Dia 166: Stay Hard v4.0 — Habits CRUD page
Dia 167: Stay Hard v4.0 — Profile + Stats
Dia 168: Dockerize React frontend (Nginx)
Dia 169: Full stack: React + Spring API + PostgreSQL + Redis
Dia 170: Mini-projeto: React Weather
Dia 171: Mini-projeto: React Todo
Dia 172: Mini-projeto: React Kanban
Dia 173: Mini-projeto: React Chat UI
Dia 174: Mini-projeto: React E-commerce
Dia 175-178: Revisão + tag v4.0

---

## FASE 9 — SaaS + ERPs com IA + Portfolio (Dias 179-209)

Dia 179: Multi-tenancy
Dia 180: Tenant resolution
Dia 181: RBAC
Dia 182: Stripe billing
Dia 183: Stay Hard SaaS multi-tenant
Dia 184: MedTrack AI — schema + CRUD
Dia 185: MedTrack AI — triagem IA + RAG
Dia 186: MedTrack AI — React frontend
Dia 187: LegalMind AI — schema + CRUD
Dia 188: LegalMind AI — contratos IA + RAG
Dia 189: LegalMind AI — React frontend
Dia 190: BuildFlow AI — schema + CRUD
Dia 191: BuildFlow AI — custos IA + RAG
Dia 192: BuildFlow AI — React frontend
Dia 193: TelecomPro — schema + CRUD
Dia 194: TelecomPro — churn IA + RAG
Dia 195: TelecomPro — React frontend
Dia 196: Docker Compose for SaaS (full stack)
Dia 197: Stay Hard SaaS — full stack with IA
Dia 198: Deploy (AWS/Railway)
Dia 199: CI/CD for SaaS
Dia 200: Portfolio READMEs
Dia 201: LinkedIn + GitHub profile
Dia 202: AWS básico (conceitos, IAM, console, regions)
Dia 203: AWS EC2 (instância Linux, SSH, deploy Spring Boot no EC2)
Dia 204: AWS RDS (PostgreSQL managed, conectar do Spring Boot)
Dia 205: AWS S3 (storage de arquivos) + ECS/Beanstalk (deploy containers)
Dia 206: SSL/HTTPS (Let's Encrypt, Certbot, Nginx SSL config)
Dia 207: Deploy completo (Docker + Nginx + SSL + AWS end-to-end)
Dia 208: Revisão geral
Dia 209: 🏆 STAY HARD — 209 dias completos

---

> *"Who's gonna carry the boats?!"* — David Goggins
> **209 dias. 10 fases. De iniciante a Full-Stack. Stay Hard.**
