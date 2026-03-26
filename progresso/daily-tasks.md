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

### Dia 106 — Fase 6 — MongoDB Setup
- [ ] O que é MongoDB (documents, collections, NoSQL)
- [ ] MongoDB via Docker (docker-compose com mongo + mongo-express)
- [ ] CRUD básico no mongo shell (insertOne, find, updateOne, deleteOne)
- [ ] Mongo Express UI: http://localhost:8081
- 📝 Commit: "feat: MongoDB Docker setup"

### Dia 107 — Fase 6 — Spring Data MongoDB
- [ ] spring-boot-starter-data-mongodb
- [ ] @Document annotation (AuditLog, AnalyticsEvent)
- [ ] MongoRepository<AuditLog, String>
- [ ] application.properties com MongoDB URI
- [ ] Testar save e findAll
- 📝 Commit: "feat: Spring Data MongoDB"

### Dia 108 — Fase 6 — Stay Hard MongoDB
- [ ] AuditLog entity (userId, action, timestamp, details)
- [ ] AuditLogRepository com MongoRepository
- [ ] Salvar log quando hábito é completado
- [ ] Salvar log quando dia é finalizado
- [ ] Buscar logs por userId e por período
- 📝 Commit: "feat: Stay Hard MongoDB analytics"

### Dia 109 — Fase 6 — Microservices Concepts
- [ ] O que são microservices (independentes, deploy separado)
- [ ] Quando usar vs monólito (complexidade, escala, equipe)
- [ ] Desafios: comunicação, dados, deploy, debugging
- [ ] Padrões: API Gateway, Service Discovery, Circuit Breaker
- 📝 Commit: "study: Microservices concepts"

### Dia 110 — Fase 6 — Eureka Server
- [ ] Spring Cloud Eureka Server (Service Discovery)
- [ ] Criar projeto eureka-server
- [ ] @EnableEurekaServer
- [ ] Services se registram automaticamente
- [ ] Eureka Dashboard: http://localhost:8761
- 📝 Commit: "feat: Eureka Service Discovery"

### Dia 111 — Fase 6 — API Gateway
- [ ] Spring Cloud Gateway
- [ ] Routing: /api/users/** → user-service
- [ ] Routing: /api/habits/** → habit-service
- [ ] Filters (add header, rate limit, logging)
- [ ] Gateway roda na porta 8080
- 📝 Commit: "feat: API Gateway"

### Dia 112 — Fase 6 — Feign Client
- [ ] OpenFeign para comunicação entre services
- [ ] @FeignClient(name = "user-service")
- [ ] Chamar user-service do habit-service via Feign
- [ ] Load balancing automático (Ribbon)
- [ ] Tratar erros de comunicação
- 📝 Commit: "feat: Feign inter-service communication"

### Dia 113 — Fase 6 — Circuit Breaker
- [ ] Resilience4j dependency
- [ ] @CircuitBreaker annotation
- [ ] Fallback method (resposta alternativa quando service cai)
- [ ] @Retry para tentar novamente
- [ ] Configuração (failure rate, wait duration)
- 📝 Commit: "feat: Circuit Breaker with Resilience4j"

### Dia 114 — Fase 6 — Kafka Concepts + Setup
- [ ] O que é Kafka (event streaming, distributed log)
- [ ] Concepts: Topic, Partition, Consumer Group, Offset
- [ ] Kafka vs RabbitMQ (quando usar cada)
- [ ] Kafka via Docker (docker-compose com Zookeeper + Kafka + Kafka UI)
- [ ] Kafka UI: http://localhost:8090
- 📝 Commit: "study: Kafka concepts + Docker setup"

### Dia 115 — Fase 6 — Kafka Producer
- [ ] spring-kafka dependency
- [ ] KafkaTemplate<String, String>
- [ ] Criar topic (stay-hard-events)
- [ ] Enviar mensagem: habit.completed
- [ ] Enviar mensagem como JSON
- 📝 Commit: "feat: Kafka Producer"

### Dia 116 — Fase 6 — Kafka Consumer
- [ ] @KafkaListener(topics = "stay-hard-events")
- [ ] Consumer group configuration
- [ ] Deserializar JSON messages
- [ ] Processar mensagem recebida
- [ ] Testar Producer → Consumer flow
- 📝 Commit: "feat: Kafka Consumer"

### Dia 117 — Fase 6 — Stay Hard Kafka Events
- [ ] Event: habit.completed → topic stay-hard-events
- [ ] Event: day.finished → topic stay-hard-events
- [ ] Analytics service consome events e salva no MongoDB
- [ ] Notification service consome events
- [ ] Testar fluxo completo
- 📝 Commit: "feat: Stay Hard Kafka events"

### Dia 118 — Fase 6 — RabbitMQ Concepts + Setup
- [ ] O que é RabbitMQ (message broker, AMQP protocol)
- [ ] Concepts: Producer, Consumer, Queue, Exchange, Binding, Routing Key
- [ ] Exchange types: Direct, Fanout, Topic
- [ ] RabbitMQ via Docker (port 5672 + management UI 15672)
- [ ] Management UI: http://localhost:15672 (guest/guest)
- 📝 Commit: "study: RabbitMQ concepts + Docker setup"

### Dia 119 — Fase 6 — RabbitMQ Producer
- [ ] spring-boot-starter-amqp dependency
- [ ] RabbitMQConfig (Queue, Exchange, Binding beans)
- [ ] TopicExchange "stay-hard.exchange"
- [ ] Queue "habit.completed.queue"
- [ ] RabbitTemplate para enviar mensagens
- 📝 Commit: "feat: RabbitMQ Producer"

### Dia 120 — Fase 6 — RabbitMQ Consumer
- [ ] @RabbitListener(queues = "habit.completed.queue")
- [ ] Receber Map<String, Object> message
- [ ] Processar: enviar notificação
- [ ] Testar Producer → Consumer flow
- [ ] Verificar mensagem no Management UI
- 📝 Commit: "feat: RabbitMQ Consumer"

### Dia 121 — Fase 6 — RabbitMQ Advanced
- [ ] Dead Letter Queues (DLQ) para mensagens que falham
- [ ] Manual acknowledgment (channel.basicAck, basicNack)
- [ ] Message retry (rejeita e recoloca na fila)
- [ ] Topic Exchange com routing keys (habit.#, notification.*)
- 📝 Commit: "feat: RabbitMQ advanced (DLQ, ack)"

### Dia 122 — Fase 6 — Stay Hard RabbitMQ
- [ ] Event: habit completed → RabbitMQ exchange
- [ ] Notification service consome via @RabbitListener
- [ ] Async email/push notification (simulado)
- [ ] DLQ para mensagens que falham após 3 tentativas
- [ ] Kafka + RabbitMQ coexistindo (Kafka analytics, RabbitMQ notifications)
- 📝 Commit: "feat: Stay Hard RabbitMQ notifications"

### Dia 123 — Fase 6 — Stay Hard Microservices Architecture
- [ ] Definir serviços: user-service, habit-service, analytics-service, notification-service
- [ ] Eureka Server para discovery
- [ ] API Gateway para routing
- [ ] Comunicação via Feign
- [ ] Diagrama de arquitetura
- 📝 Commit: "feat: Stay Hard microservices architecture"

### Dia 124 — Fase 6 — Docker Compose Microservices (Parte 1)
- [ ] docker-compose.yml com postgres + mongo + redis + rabbitmq + kafka
- [ ] Dockerfile para cada microservice
- [ ] Health checks para cada service
- [ ] Networks separadas (backend, messaging)
- 📝 Commit: "feat: Docker Compose microservices (infra)"

### Dia 125 — Fase 6 — Docker Compose Microservices (Parte 2)
- [ ] Adicionar eureka-server ao docker-compose
- [ ] Adicionar api-gateway ao docker-compose
- [ ] Adicionar user-service e habit-service
- [ ] Configurar depends_on com health checks
- [ ] Testar: docker-compose up
- 📝 Commit: "feat: Docker Compose microservices (services)"

### Dia 126 — Fase 6 — Docker Compose Microservices (Parte 3)
- [ ] Adicionar analytics-service (MongoDB consumer)
- [ ] Adicionar notification-service (RabbitMQ consumer)
- [ ] Adicionar Kafka + Zookeeper
- [ ] Testar fluxo completo: user → habit → Kafka → analytics
- [ ] Testar fluxo: habit → RabbitMQ → notification
- 📝 Commit: "feat: Docker Compose microservices (complete)"

### Dia 127 — Fase 6 — Microservices Testing
- [ ] Testes de integração entre services
- [ ] Testar com @SpringBootTest + MockMvc
- [ ] Testcontainers para MongoDB + PostgreSQL
- [ ] Testar circuit breaker (mock service down)
- 📝 Commit: "test: Microservices integration tests"

### Dia 128 — Fase 6 — Microservices Logging
- [ ] Correlation ID passando entre services
- [ ] Structured logging em cada service
- [ ] Centralizar logs (ELK stack conceito)
- [ ] Actuator health checks em cada service
- 📝 Commit: "feat: Microservices logging + correlation"

### Dia 129 — Fase 6 — Revisão Microservices
- [ ] Revisão: microservices, Kafka, RabbitMQ
- [ ] Consegue desenhar arquitetura completa?
- [ ] Todos services se comunicando?
- [ ] docker-compose up funciona?
- 📝 Commit: "chore: Microservices review"

### Dia 130 — Fase 6 — Revisão Mensageria
- [ ] Revisão: Kafka (event streaming) vs RabbitMQ (message queue)
- [ ] Quando usar cada um?
- [ ] Stay Hard: Kafka para analytics, RabbitMQ para notificações
- [ ] Testar cenários de falha (service down, retry, DLQ)
- 📝 Commit: "chore: Messaging review"

### Dia 131 — Fase 6 — Revisão MongoDB
- [ ] Revisão: MongoDB, documents, collections
- [ ] Spring Data MongoDB queries
- [ ] Aggregation pipeline básico
- [ ] MongoDB vs PostgreSQL (quando usar cada)
- 📝 Commit: "chore: MongoDB review"

### Dia 132 — Fase 6 — Revisão Geral Fase 6
- [ ] Revisão geral: MongoDB, Microservices, Kafka, RabbitMQ
- [ ] Checklist da Fase 6 completo?
- [ ] Documentar aprendizados
- 📝 Commit: "chore: Phase 6 review"

### Dia 133 — Fase 6 — Tag v6.0
- [ ] Todos testes passando?
- [ ] docker-compose.yml completo?
- [ ] Git tag v6.0
- [ ] Ler docs/06-fase5-ia-rag.md
- 📝 Commit: "chore: v6.0 release"

---

## FASE 7 — IA + RAG + Spring AI (Dias 134-153)

### Dia 134 — Fase 7 — IA Concepts
- [ ] O que é LLM (Large Language Model)
- [ ] Tokens, context window, temperature
- [ ] Modelos: GPT-4, Claude, Gemini, Llama
- [ ] Quando usar IA em aplicações
- 📝 Commit: "study: IA/LLM concepts"

### Dia 135 — Fase 7 — Prompt Engineering
- [ ] System prompt vs User prompt
- [ ] Few-shot learning (dar exemplos na prompt)
- [ ] Chain of thought (passo a passo)
- [ ] Structured output (pedir JSON na resposta)
- [ ] Prática: criar prompts para diferentes cenários
- 📝 Commit: "study: Prompt Engineering"

### Dia 136 — Fase 7 — OpenAI/Ollama Setup
- [ ] Criar conta OpenAI + API key (ou instalar Ollama local)
- [ ] Testar API com curl/Postman
- [ ] POST /v1/chat/completions
- [ ] Gerar primeira resposta com prompt
- [ ] Entender billing e rate limits
- 📝 Commit: "feat: OpenAI/Ollama setup"

### Dia 137 — Fase 7 — Spring AI
- [ ] spring-ai-openai-spring-boot-starter dependency
- [ ] ChatClient (enviar prompt e receber resposta)
- [ ] application.properties com API key
- [ ] Testar: service que chama OpenAI e retorna resposta
- [ ] System prompt configurado
- 📝 Commit: "feat: Spring AI setup"

### Dia 138 — Fase 7 — RAG Concepts
- [ ] O que é RAG (Retrieval Augmented Generation)
- [ ] Embeddings (converter texto em vetor numérico)
- [ ] Vector databases (pgvector, ChromaDB, Pinecone)
- [ ] Similarity search (cosine distance)
- [ ] Chunking strategies (dividir documentos em pedaços)
- [ ] RAG pipeline: ingest → chunk → embed → store → query → search → answer
- 📝 Commit: "study: RAG concepts"

### Dia 139 — Fase 7 — pgvector Setup
- [ ] pgvector extension no PostgreSQL
- [ ] CREATE EXTENSION vector
- [ ] Criar tabela com coluna vector(1536)
- [ ] Inserir embeddings manualmente
- [ ] Busca por similaridade: ORDER BY embedding <=> query_vector
- [ ] Testar: buscar documentos similares
- 📝 Commit: "feat: pgvector setup"

### Dia 140 — Fase 7 — RAG Pipeline Completa
- [ ] Ingestão: ler documentos (textos, PDFs)
- [ ] Chunking: dividir em pedaços de 500 tokens
- [ ] Embedding: gerar vetores com OpenAI ada-002
- [ ] Storage: salvar no pgvector
- [ ] Query: embed pergunta → buscar similares → montar contexto
- [ ] Answer: enviar [contexto + pergunta] → LLM → resposta
- 📝 Commit: "feat: RAG pipeline completa"

### Dia 141 — Fase 7 — Stay Hard Coach IA
- [ ] POST /api/ai/chat endpoint
- [ ] System prompt: "Você é um coach de hábitos motivacional"
- [ ] Contexto: stats do usuário (streak, nível, hábitos)
- [ ] IA responde baseado nos dados do usuário
- [ ] ChatRequest e ChatResponse DTOs
- 📝 Commit: "feat: Stay Hard Coach IA"

### Dia 142 — Fase 7 — Stay Hard RAG Analytics
- [ ] "Como estão meus hábitos esta semana?"
- [ ] Buscar dados do usuário no MongoDB
- [ ] Embedding dos dados → pgvector
- [ ] RAG: buscar chunks relevantes → LLM gera análise
- [ ] GET /api/ai/analytics/{userId}
- 📝 Commit: "feat: Stay Hard RAG Analytics"

### Dia 143 — Fase 7 — Stay Hard Smart Suggestions
- [ ] IA analisa padrões de hábitos do usuário
- [ ] Sugere novos hábitos baseado no histórico
- [ ] "Você completou 90% dos HIGH. Que tal adicionar Meditação?"
- [ ] POST /api/ai/suggest-habit/{userId}
- [ ] Daily summary motivacional (GET /api/ai/daily-summary/{userId})
- 📝 Commit: "feat: Smart Suggestions + Daily Summary"

### Dia 144 — Fase 7 — Mini: Chat com PDF
- [ ] Criar mini-projetos/chat-pdf-rag/
- [ ] Upload de PDF
- [ ] Chunking do PDF em pedaços
- [ ] Gerar embeddings e salvar no pgvector
- [ ] Usuário pergunta sobre o PDF → RAG → resposta
- [ ] Spring Boot + OpenAI + pgvector
- 📝 Commit: "feat: Chat com PDF (RAG)"

### Dia 145 — Fase 7 — Mini: Code Reviewer IA
- [ ] Criar mini-projetos/code-reviewer-ia/
- [ ] Usuário envia código via API
- [ ] System prompt: "Você é um code reviewer sênior"
- [ ] IA analisa e retorna: bugs, melhorias, security issues
- [ ] Spring Boot + OpenAI
- 📝 Commit: "feat: Code Reviewer IA"

### Dia 146 — Fase 7 — Mini: Document Q&A
- [ ] Criar mini-projetos/document-qa/
- [ ] Upload de documentos (texto)
- [ ] Indexar com embeddings no pgvector
- [ ] Busca por similaridade
- [ ] IA responde baseado no contexto encontrado
- 📝 Commit: "feat: Document Q&A"

### Dia 147 — Fase 7 — Mini: Recipe Suggester
- [ ] Criar mini-projetos/recipe-suggester/
- [ ] Usuário informa ingredientes disponíveis
- [ ] IA sugere receitas com esses ingredientes
- [ ] Spring Boot + OpenAI
- [ ] Structured output (JSON com receitas)
- 📝 Commit: "feat: Recipe Suggester IA"

### Dia 148 — Fase 7 — Mini: Sentiment Analyzer
- [ ] Criar mini-projetos/sentiment-analyzer/
- [ ] Usuário envia texto
- [ ] IA analisa sentimento (positivo, negativo, neutro)
- [ ] Retorna score e explicação
- [ ] Spring Boot + OpenAI
- 📝 Commit: "feat: Sentiment Analyzer"

### Dia 149 — Fase 7 — Revisão IA
- [ ] Revisão: LLM, prompts, embeddings, RAG
- [ ] Consegue criar pipeline RAG do zero?
- [ ] Spring AI configurado e funcionando?
- [ ] Stay Hard Coach IA respondendo?
- 📝 Commit: "chore: IA review"

### Dia 150 — Fase 7 — Revisão RAG
- [ ] Revisão: pgvector, similarity search, chunking
- [ ] Mini-projetos de IA funcionando?
- [ ] Entende quando usar RAG vs prompt simples?
- 📝 Commit: "chore: RAG review"

### Dia 151 — Fase 7 — Revisão Spring AI
- [ ] Revisão: Spring AI, ChatClient, configurações
- [ ] Stay Hard com IA funcional?
- [ ] Testes com mocks para IA?
- 📝 Commit: "chore: Spring AI review"

### Dia 152 — Fase 7 — Revisão Geral Fase 7
- [ ] Revisão geral: IA, RAG, Spring AI
- [ ] Checklist da Fase 7 completo?
- [ ] Documentar aprendizados
- 📝 Commit: "chore: Phase 7 review"

### Dia 153 — Fase 7 — Tag v7.0
- [ ] Todos mini-projetos de IA funcionando?
- [ ] Stay Hard com Coach IA + RAG Analytics?
- [ ] Git tag v7.0
- [ ] Ler docs/04-fase3-react-typescript.md
- 📝 Commit: "chore: v7.0 release"

---

## FASE 8 — TypeScript + React + Tailwind (Dias 154-178)

### Dia 154 — Fase 8 — TypeScript Basics
- [ ] Tipos: string, number, boolean, array, tuple
- [ ] Interfaces (definir forma de objetos)
- [ ] Type aliases (type Name = string)
- [ ] Optional properties (?)
- [ ] tsconfig.json configuração
- 📝 Commit: "study: TypeScript basics"

### Dia 155 — Fase 8 — TypeScript Advanced
- [ ] Generics (<T>)
- [ ] Enums
- [ ] Union types (string | number)
- [ ] Type narrowing (typeof, instanceof)
- [ ] Utility types (Partial, Pick, Omit)
- 📝 Commit: "study: TypeScript advanced"

### Dia 156 — Fase 8 — Vite + React Setup
- [ ] npm create vite@latest (React + TypeScript template)
- [ ] npm install + npm run dev
- [ ] Estrutura do projeto (src, public, index.html)
- [ ] tsconfig.json + vite.config.ts
- [ ] Primeiro componente App.tsx
- 📝 Commit: "feat: React + TS project init"

### Dia 157 — Fase 8 — Components + Props
- [ ] Componentes funcionais com TypeScript
- [ ] Props com interfaces (interface HabitCardProps)
- [ ] Renderização condicional (&&, ternário)
- [ ] Listas com .map() e key
- [ ] Children prop
- 📝 Commit: "study: React components + props"

### Dia 158 — Fase 8 — Hooks
- [ ] useState (estado local com tipos)
- [ ] useEffect (efeitos colaterais, cleanup)
- [ ] Ciclo de vida: mount, update, unmount
- [ ] useMemo, useCallback (performance)
- 📝 Commit: "study: React hooks"

### Dia 159 — Fase 8 — React Router
- [ ] react-router-dom v6
- [ ] BrowserRouter, Routes, Route
- [ ] Link, useNavigate, useParams
- [ ] Nested routes
- [ ] Protected routes (redirect se não autenticado)
- 📝 Commit: "feat: React Router setup"

### Dia 160 — Fase 8 — Axios + JWT
- [ ] Instalar axios
- [ ] Criar api.ts (baseURL configurado)
- [ ] Request interceptor: adicionar Bearer token do localStorage
- [ ] Response interceptor: 401 → redirect /login
- [ ] Tipar responses com TypeScript interfaces
- 📝 Commit: "feat: Axios + JWT interceptors"

### Dia 161 — Fase 8 — Tailwind CSS
- [ ] Instalar Tailwind CSS (npm install tailwindcss)
- [ ] Configurar tailwind.config.js
- [ ] PostCSS config
- [ ] Utilitários: flex, grid, spacing, colors, typography
- [ ] Responsive: sm:, md:, lg:
- 📝 Commit: "feat: Tailwind CSS setup"

### Dia 162 — Fase 8 — Context API
- [ ] createContext para autenticação
- [ ] AuthContext com user, token, login, logout
- [ ] AuthProvider no App.tsx
- [ ] useContext para consumir
- [ ] Tipar context com TypeScript
- 📝 Commit: "feat: AuthContext"

### Dia 163 — Fase 8 — Custom Hooks
- [ ] useAuth() — consumir AuthContext
- [ ] useHabits() — CRUD de hábitos via API
- [ ] useFetch() — hook genérico para requisições
- [ ] useLocalStorage() — persistir estado no localStorage
- [ ] Tipar hooks com TypeScript generics
- 📝 Commit: "feat: custom hooks"

### Dia 164 — Fase 8 — Stay Hard Login/Register
- [ ] Login.tsx (formulário com email + senha)
- [ ] Register.tsx (formulário com nome + email + senha)
- [ ] Chamar API (POST /api/auth/login, /api/auth/register)
- [ ] Salvar JWT no localStorage após login
- [ ] Redirecionar para Dashboard após login
- [ ] ProtectedRoute.tsx (bloqueia acesso sem token)
- 📝 Commit: "feat: Stay Hard Login/Register pages"

### Dia 165 — Fase 8 — Stay Hard Dashboard
- [ ] Dashboard.tsx (página principal após login)
- [ ] LevelBadge.tsx (visual do nível atual)
- [ ] StreakCounter.tsx (streak atual + maior streak)
- [ ] StatsChart.tsx (gráfico de progresso com Recharts)
- [ ] Dados vindos da API (GET /api/users/me/stats)
- [ ] Design responsivo com Tailwind
- 📝 Commit: "feat: Stay Hard Dashboard"

### Dia 166 — Fase 8 — Stay Hard Habits CRUD
- [ ] Habits.tsx (página de hábitos)
- [ ] HabitCard.tsx (visual de cada hábito: nome, prioridade, status)
- [ ] Criar hábito (formulário modal)
- [ ] Iniciar/Completar hábito (botões)
- [ ] Editar hábito (formulário modal)
- [ ] Deletar hábito (confirmação)
- [ ] Finish Day button (chama POST /api/daily/finish)
- 📝 Commit: "feat: Stay Hard Habits CRUD page"

### Dia 167 — Fase 8 — Stay Hard Profile
- [ ] Profile.tsx (dados do usuário)
- [ ] Estatísticas: dias completos, falhos, streak, nível
- [ ] Histórico de dias (success/fail)
- [ ] Gráfico de progresso (Recharts line chart)
- [ ] Logout button
- 📝 Commit: "feat: Stay Hard Profile page"

### Dia 168 — Fase 8 — Dockerize React
- [ ] Dockerfile multi-stage (Node build → Nginx serve)
- [ ] nginx.conf (try_files para SPA, proxy_pass para /api)
- [ ] Build: docker build -t stay-hard-frontend .
- [ ] Run: docker run -p 3000:80 stay-hard-frontend
- [ ] Adicionar ao docker-compose.yml
- 📝 Commit: "feat: Dockerize React frontend"

### Dia 169 — Fase 8 — Full Stack Integration
- [ ] React frontend + Spring Boot API + PostgreSQL + Redis
- [ ] docker-compose.yml com tudo (postgres, redis, api, frontend)
- [ ] Nginx reverse proxy configurado
- [ ] CORS configurado no backend
- [ ] Testar fluxo completo: login → criar hábito → completar → finalizar dia
- 📝 Commit: "feat: Full stack integration"

### Dia 170 — Fase 8 — Mini: React Weather
- [ ] Criar mini-projetos/react-weather/
- [ ] React + TypeScript + Tailwind
- [ ] Buscar cidade e mostrar clima
- [ ] Consumir API pública (OpenWeatherMap)
- [ ] useState, useEffect, fetch
- 📝 Commit: "feat: React Weather App"

### Dia 171 — Fase 8 — Mini: React Todo
- [ ] Criar mini-projetos/react-todo/
- [ ] React + TypeScript + Tailwind
- [ ] CRUD de tarefas no frontend
- [ ] LocalStorage persistence
- [ ] Filtro (todas, ativas, concluídas)
- 📝 Commit: "feat: React Todo List"

### Dia 172 — Fase 8 — Mini: React Kanban
- [ ] Criar mini-projetos/react-kanban/
- [ ] React + TypeScript + Tailwind
- [ ] Board com colunas (To Do, In Progress, Done)
- [ ] Drag and drop básico (HTML5 API ou library)
- 📝 Commit: "feat: React Kanban Board"

### Dia 173 — Fase 8 — Mini: React Chat UI
- [ ] Criar mini-projetos/react-chat/
- [ ] React + TypeScript + Tailwind
- [ ] Interface de chat (messages list + input)
- [ ] WebSocket intro (simular com setInterval)
- 📝 Commit: "feat: React Chat UI"

### Dia 174 — Fase 8 — Mini: React E-commerce
- [ ] Criar mini-projetos/react-ecommerce/
- [ ] React + TypeScript + Tailwind
- [ ] Catálogo de produtos + carrinho
- [ ] Context API para state do carrinho
- 📝 Commit: "feat: React E-commerce Cart"

### Dia 175 — Fase 8 — Revisão React
- [ ] Revisão: TypeScript, React, hooks, router, context
- [ ] TypeScript sem erros (`npx tsc --noEmit`)
- [ ] Stay Hard frontend funcional?
- [ ] Todos mini-projetos React funcionando?
- 📝 Commit: "chore: React review"

### Dia 176 — Fase 8 — Revisão Full Stack
- [ ] Revisão: front-end + back-end + DB integrados
- [ ] Fluxo completo funciona? (login → API → DB → response → UI)
- [ ] Docker Compose sobe tudo?
- [ ] Nginx proxy funciona?
- 📝 Commit: "chore: Full stack review"

### Dia 177 — Fase 8 — Revisão Geral Fase 8
- [ ] Revisão geral: TypeScript, React, Tailwind, Docker
- [ ] Checklist da Fase 8 completo?
- [ ] Documentar aprendizados
- 📝 Commit: "chore: Phase 8 review"

### Dia 178 — Fase 8 — Tag v4.0
- [ ] Todos testes passando?
- [ ] Stay Hard v4.0 (React frontend) completo?
- [ ] Git tag v4.0
- [ ] Ler docs/08-saas-erp-ia.md
- 📝 Commit: "chore: v4.0 release"

---

## FASE 9 — SaaS + ERPs com IA + DevOps + Portfolio (Dias 179-209)

### Dia 179 — Fase 9 — Multi-tenancy
- [ ] O que é multi-tenancy (múltiplos clientes no mesmo sistema)
- [ ] 3 estratégias: shared DB + tenant_id, schema per tenant, DB per tenant
- [ ] Decidir qual estratégia para cada projeto
- [ ] TenantContext (ThreadLocal para armazenar tenant_id)
- 📝 Commit: "study: Multi-tenancy concepts"

### Dia 180 — Fase 9 — Tenant Resolution
- [ ] TenantFilter (extrair tenant_id do JWT claim)
- [ ] Repository com filtro automático de tenant
- [ ] @Column(name = "tenant_id") em todas entities
- [ ] Testar isolamento entre tenants
- 📝 Commit: "feat: Tenant resolution implementation"

### Dia 181 — Fase 9 — RBAC
- [ ] Role enum (ADMIN, MANAGER, USER)
- [ ] @PreAuthorize("hasRole('ADMIN')")
- [ ] SecurityConfig com roles
- [ ] Endpoints protegidos por role
- [ ] Testar: ADMIN acessa tudo, USER só próprio
- 📝 Commit: "feat: RBAC implementation"

### Dia 182 — Fase 9 — Stripe Billing
- [ ] Criar conta Stripe
- [ ] Stripe Java SDK dependency
- [ ] Criar subscription plans (Free, Pro)
- [ ] Endpoint para criar checkout session
- [ ] Webhook para eventos (subscription created, cancelled)
- 📝 Commit: "feat: Stripe billing integration"

### Dia 183 — Fase 9 — Stay Hard SaaS
- [ ] Multi-tenant no Stay Hard (cada usuário = tenant)
- [ ] Planos Free (5 hábitos) vs Pro (ilimitado + IA)
- [ ] Verificação de plano antes de criar hábito
- [ ] Endpoint de upgrade (/api/billing/upgrade)
- 📝 Commit: "feat: Stay Hard SaaS multi-tenant"

### Dia 184 — Fase 9 — MedTrack AI Schema
- [ ] Entities: Patient, Doctor, Appointment, Prescription, MedicalRecord
- [ ] Repositories com JpaRepository
- [ ] Services com CRUD
- [ ] knowledge_base table (pgvector) para RAG médico
- [ ] REST endpoints
- 📝 Commit: "feat: MedTrack AI schema + CRUD"

### Dia 185 — Fase 9 — MedTrack AI IA + RAG
- [ ] Triagem: paciente descreve sintomas → IA sugere especialidade
- [ ] POST /api/ai/triage
- [ ] RAG: base de conhecimento médico (protocolos, guidelines)
- [ ] Médico pergunta → IA responde com base nos protocolos
- [ ] POST /api/ai/medical-query
- 📝 Commit: "feat: MedTrack AI triagem + RAG"

### Dia 186 — Fase 9 — MedTrack AI Frontend
- [ ] React + TypeScript + Tailwind
- [ ] Pages: Dashboard, Patients, Appointments, AI Chat
- [ ] Conectar com API
- [ ] Design responsivo
- 📝 Commit: "feat: MedTrack AI frontend"

### Dia 187 — Fase 9 — LegalMind AI Schema
- [ ] Entities: Client, Case, Deadline, Document
- [ ] jurisprudencia table (pgvector) para RAG jurídico
- [ ] legislacao table (pgvector)
- [ ] CRUD endpoints
- [ ] File upload para documentos
- 📝 Commit: "feat: LegalMind AI schema + CRUD"

### Dia 188 — Fase 9 — LegalMind AI IA + RAG
- [ ] Análise de contratos: upload PDF → IA analisa cláusulas, riscos
- [ ] POST /api/ai/analyze-contract
- [ ] Busca jurisprudência: "Tem jurisprudência sobre dano moral?"
- [ ] RAG: jurisprudência + legislação + documentos do escritório
- [ ] POST /api/ai/jurisprudencia
- 📝 Commit: "feat: LegalMind AI contratos + RAG"

### Dia 189 — Fase 9 — LegalMind AI Frontend
- [ ] React + TypeScript + Tailwind
- [ ] Pages: Dashboard, Cases, Documents, AI Query
- [ ] Upload de contratos para análise IA
- [ ] Busca de jurisprudência via interface
- 📝 Commit: "feat: LegalMind AI frontend"

### Dia 190 — Fase 9 — BuildFlow AI Schema
- [ ] Entities: Project, Team, Material, Milestone
- [ ] normas_tecnicas table (pgvector)
- [ ] historico_projetos table (pgvector)
- [ ] CRUD endpoints
- [ ] Gantt chart data endpoint
- 📝 Commit: "feat: BuildFlow AI schema + CRUD"

### Dia 191 — Fase 9 — BuildFlow AI IA + RAG
- [ ] Estimativa de custos: IA analisa projetos passados → estima custo
- [ ] POST /api/ai/estimate-cost
- [ ] RAG: normas técnicas (NBR, ABNT)
- [ ] Engenheiro pergunta → IA responde com normas
- [ ] POST /api/ai/normas
- 📝 Commit: "feat: BuildFlow AI custos + RAG"

### Dia 192 — Fase 9 — BuildFlow AI Frontend
- [ ] React + TypeScript + Tailwind
- [ ] Pages: Dashboard, Projects, Gantt, Materials, AI
- [ ] Conectar com API
- [ ] Gráficos de progresso
- 📝 Commit: "feat: BuildFlow AI frontend"

### Dia 193 — Fase 9 — TelecomPro Schema
- [ ] Entities: Customer, Plan, Subscription, Ticket, Invoice
- [ ] faqs table (pgvector) para RAG suporte
- [ ] CRUD endpoints
- [ ] Faturamento automático
- 📝 Commit: "feat: TelecomPro schema + CRUD"

### Dia 194 — Fase 9 — TelecomPro IA + RAG
- [ ] Previsão de churn: IA prevê probabilidade de cliente cancelar
- [ ] POST /api/ai/churn-prediction
- [ ] Chatbot suporte: RAG com FAQs + conhecimento técnico
- [ ] POST /api/ai/support-chat
- 📝 Commit: "feat: TelecomPro churn + chatbot RAG"

### Dia 195 — Fase 9 — TelecomPro Frontend
- [ ] React + TypeScript + Tailwind
- [ ] Pages: Dashboard, Customers, Plans, Tickets, AI Chat
- [ ] Conectar com API
- [ ] Design responsivo
- 📝 Commit: "feat: TelecomPro frontend"

### Dia 196 — Fase 9 — Docker Compose SaaS
- [ ] docker-compose.yml completo para SaaS (postgres, mongo, redis, rabbitmq, kafka, api, frontend)
- [ ] Health checks para todos services
- [ ] .env com todas variáveis
- [ ] Nginx reverse proxy
- [ ] Testar: docker-compose up → tudo funciona
- 📝 Commit: "feat: Docker Compose SaaS full stack"

### Dia 197 — Fase 9 — Stay Hard SaaS Completo
- [ ] Stay Hard com multi-tenant + IA + React + Docker
- [ ] Coach IA + RAG Analytics + Smart Suggestions
- [ ] Frontend React + TypeScript completo
- [ ] Docker Compose rodando tudo
- 📝 Commit: "feat: Stay Hard SaaS complete"

### Dia 198 — Fase 9 — Deploy
- [ ] Criar conta AWS (free tier)
- [ ] Criar instância EC2 (Ubuntu, t3.micro)
- [ ] SSH na instância + instalar Java 21
- [ ] Copiar JAR para EC2 via scp
- [ ] Rodar Spring Boot na EC2
- [ ] Configurar Security Group (portas 80, 443, 8080)
- 📝 Commit: "feat: Deploy to AWS EC2"

### Dia 199 — Fase 9 — CI/CD SaaS
- [ ] GitHub Actions workflow para SaaS
- [ ] Pipeline: test → build → Docker build → push ECR → deploy ECS
- [ ] Environment variables (secrets no GitHub)
- [ ] Coverage report
- [ ] Auto-deploy no push para main
- 📝 Commit: "feat: CI/CD for SaaS projects"

### Dia 200 — Fase 9 — AWS RDS
- [ ] Criar instância RDS (PostgreSQL, db.t3.micro)
- [ ] Configurar Security Group (porta 5432 da EC2)
- [ ] Migrar Spring Boot de localhost para RDS
- [ ] Testar conexão
- [ ] Backup automático configurado
- 📝 Commit: "feat: AWS RDS PostgreSQL"

### Dia 201 — Fase 9 — AWS S3 + ECS
- [ ] Criar bucket S3 para uploads
- [ ] AWS SDK no Spring Boot (upload/download de arquivos)
- [ ] ECS: criar cluster + task definition + service
- [ ] ECR: push Docker image para container registry
- [ ] Deploy via ECS (alternativa ao EC2 direto)
- 📝 Commit: "feat: AWS S3 + ECS deployment"

### Dia 202 — Fase 9 — SSL/HTTPS
- [ ] O que é SSL/TLS (criptografia HTTPS)
- [ ] Let's Encrypt + Certbot (certificado gratuito)
- [ ] sudo certbot --nginx -d meudominio.com
- [ ] Auto-renovação (certbot renew)
- [ ] Nginx config com SSL (listen 443 ssl)
- [ ] Redirect HTTP → HTTPS
- 📝 Commit: "feat: SSL/HTTPS with Let's Encrypt"

### Dia 203 — Fase 9 — Deploy Completo
- [ ] Fluxo completo: EC2 + RDS + S3 + Nginx + SSL
- [ ] Docker Compose na EC2
- [ ] Nginx reverse proxy com SSL
- [ ] Spring Boot + PostgreSQL (RDS) + Redis + MongoDB
- [ ] React frontend servido pelo Nginx
- [ ] Testar: https://meudominio.com funciona
- 📝 Commit: "feat: Deploy completo end-to-end"

### Dia 204 — Fase 9 — Nginx Reverse Proxy
- [ ] Nginx config avançada (upstream, proxy_pass, gzip)
- [ ] Rate limiting no Nginx
- [ ] Caching de arquivos estáticos
- [ ] Custom error pages (404, 500)
- [ ] Access logs e error logs
- 📝 Commit: "feat: Nginx advanced config"

### Dia 205 — Fase 9 — Logging em Produção
- [ ] SLF4J + Logback configurado
- [ ] Log levels em produção (INFO para app, WARN para framework)
- [ ] Structured logging (JSON para CloudWatch/ELK)
- [ ] Correlation IDs entre services
- [ ] Log rotation (max 10MB, 30 dias)
- 📝 Commit: "feat: Production logging"

### Dia 206 — Fase 9 — Observabilidade
- [ ] Spring Boot Actuator em produção (/actuator/health, /actuator/metrics)
- [ ] Health check do banco, Redis, RabbitMQ
- [ ] Métricas customizadas (hábitos criados, dias completados)
- [ ] Alertas básicos (service down, high error rate)
- 📝 Commit: "feat: Production observability"

### Dia 207 — Fase 9 — Portfolio READMEs
- [ ] README profissional no stay-hard-system (badges, screenshots, como rodar)
- [ ] README profissional nos mini-projetos
- [ ] Diagrama de arquitetura no README
- [ ] Changelog.md
- [ ] LICENSE file
- 📝 Commit: "docs: Portfolio READMEs"

### Dia 208 — Fase 9 — LinkedIn + GitHub Profile
- [ ] Atualizar LinkedIn com projetos e tecnologias
- [ ] GitHub profile README (andredeomondes/andredeomondes)
- [ ] Pin repos principais (stay-hard-system, mini-projetos)
- [ ] Repositórios organizados e com READMEs
- 📝 Commit: "chore: Portfolio finalized"

### Dia 209 — Fase 9 — 🏆 STAY HARD
- [ ] Celebre sua conquista!
- [ ] 209 dias completos
- [ ] Documentar jornada no README
- [ ] Revisar checklist: todos itens marcados?
- [ ] Planejar próximos passos (estágio, freelas, projetos reais)
- 📝 Commit: "🏆 STAY HARD — 209 days complete. Journey never ends."

---

> *"Who's gonna carry the boats?!"* — David Goggins
> **209 dias. 10 fases. De iniciante a Full-Stack. Stay Hard.**
