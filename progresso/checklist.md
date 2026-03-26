# ✅ CHECKLIST DE PROGRESSO — JAVA STUDY (200 DIAS)

> Marque cada item ao completar. XP acumulado mostra seu nível.

---

## 🏆 FASE 0 — Fundação + GitHub (Dias 1-10) — ⭐ XP

### Conceitos
- [ ] Entende o que é Maven (pom.xml, dependências, lifecycle)
- [ ] Entende Git avançado (branches, merge, conventional commits)
- [ ] Sabe criar README profissional no GitHub
- [ ] Entende conventional commits (`feat:`, `fix:`, `refactor:`)

### Prática
- [ ] Stay Hard migrado para Maven (`mvn clean install` funciona)
- [ ] Criou .gitignore profissional
- [ ] Criou README.md com badges e descrição
- [ ] Pelo menos 3 testes JUnit 5 escritos e passando
- [ ] Repositório organizado no GitHub

### Mini-Projetos
- [ ] Calculadora CLI em Java
- [ ] Validador de CPF com testes
- [ ] Git Logger
- [ ] Gerador de Senhas
- [ ] Ordenação de Arrays

### 📊 Progresso Fase 0: ___/14

---

## 🏆 FASE 1 — SQLite + JDBC + API sem Spring (Dias 11-20) — ⭐⭐ XP

### SQLite
- [ ] Entende o que é SQLite (serverless, arquivo .db)
- [ ] Configurou SQLite via Maven (sqlite-jdbc)
- [ ] Consegue conectar com DriverManager

### JDBC
- [ ] Entende Connection, Statement, PreparedStatement, ResultSet
- [ ] Implementou INSERT, SELECT, UPDATE, DELETE com JDBC
- [ ] Usa PreparedStatement (nunca Statement com concatenação)
- [ ] Implementou transações (commit, rollback)

### API sem Spring
- [ ] Criou HttpServer com com.sun.net.httpserver
- [ ] Implementou GET, POST, PUT, DELETE handlers
- [ ] Retorna JSON com Gson
- [ ] Roteamento por path (/api/users, /api/habits)
- [ ] Status codes corretos (200, 201, 204, 404)

### Stay Hard v1.5
- [ ] Migrou UserRepository de CSV → JDBC + SQLite
- [ ] Migrou HabitRepository de CSV → JDBC + SQLite
- [ ] API REST funcional sem Spring
- [ ] Testou com curl todos endpoints

### Mini-Projetos
- [ ] API SQLite JDBC completa

### 📊 Progresso Fase 1: ___/16

---

## 🏆 FASE 2 — HTML + CSS + JavaScript (Dias 21-40) — ⭐⭐ XP

### HTML
- [ ] Estrutura HTML (head, body, meta)
- [ ] Tags: h1-h6, p, a, img, div, span, listas
- [ ] Formulários (form, input, select, button)
- [ ] Tabelas (table, tr, td)
- [ ] HTML semântico (header, nav, main, section, footer)

### CSS
- [ ] Seletores (tag, class, id, combinators)
- [ ] Cores, fontes, backgrounds, box model
- [ ] Flexbox (container, items, justify, align)
- [ ] CSS Grid (grid-template, gap)
- [ ] Position (static, relative, absolute, fixed)
- [ ] Media queries + responsivo (mobile-first)
- [ ] Unidades relativas (rem, em, %, vw, vh)

### JavaScript
- [ ] Variáveis (let, const), tipos, operadores
- [ ] Condicionais (if/else, switch), loops (for, while)
- [ ] Arrays (push, pop, splice, slice)
- [ ] Objetos (criar, acessar, métodos)
- [ ] JSON (parse, stringify)
- [ ] DOM (querySelector, addEventListener, createElement)
- [ ] Formulários (capturar valores, validar, feedback)
- [ ] ES6+ (arrow, template literals, destructuring, spread)
- [ ] Array methods (map, filter, reduce, find)
- [ ] Async (Promises, async/await, fetch API)
- [ ] Consumir API REST via fetch

### Mini-Projetos
- [ ] Landing Page responsiva
- [ ] Todo List Web (HTML + CSS + JS + LocalStorage)
- [ ] Calculadora Web
- [ ] Weather App (consumindo API pública)
- [ ] Portfolio Page

### 📊 Progresso Fase 2: ___/29

---

## 🏆 FASE 3 — Spring Boot + PostgreSQL + JPA + Redis (Dias 41-60) — ⭐⭐⭐ XP

### PostgreSQL
- [ ] PostgreSQL instalado e rodando
- [ ] DBeaver configurado
- [ ] Schema criado (users, habits)

### Spring Boot
- [ ] Entende IoC e Dependency Injection
- [ ] Entende ciclo de vida do Bean
- [ ] Sabe usar @Component, @Service, @Repository
- [ ] Consegue configurar application.properties

### Spring Data JPA
- [ ] Criou @Entity com @Id e @GeneratedValue
- [ ] Criou JpaRepository
- [ ] Implementou relacionamento @ManyToOne
- [ ] Implementou relacionamento @OneToMany
- [ ] Sabe escrever JPQL queries

### Redis
- [ ] Configurou Redis via Docker
- [ ] Spring Boot + Redis funcionando
- [ ] @Cacheable implementado no Stay Hard

### Stay Hard v2.0
- [ ] Migrado para Spring Boot + PostgreSQL
- [ ] User + Habit como JPA entities
- [ ] Repositories usando JpaRepository
- [ ] Services com @Transactional
- [ ] Testes com H2 in-memory
- [ ] Redis cache de stats

### Mini-Projetos
- [ ] CRUD Produtos (Spring Boot + H2)
- [ ] API Contatos (Spring Boot + PostgreSQL)
- [ ] Blog Simples (Spring Boot + Thymeleaf)
- [ ] Gerenciador Livros
- [ ] API Redis Cache
- [ ] Redis Rate Limiter

### 📊 Progresso Fase 3: ___/29

---

## 🏆 FASE 4 — REST API + JWT Auth + Swagger (Dias 61-80) — ⭐⭐⭐ XP

### REST API
- [ ] Consegue criar endpoint GET, POST, PUT, DELETE
- [ ] Usa @PathVariable, @RequestParam, @RequestBody
- [ ] Retorna HTTP Status correto (200, 201, 400, 404)
- [ ] Usa DTOs (request/response separados)
- [ ] Implementa @Valid com Bean Validation

### Exception Handling
- [ ] Criou @ControllerAdvice global
- [ ] Criou exceptions customizadas
- [ ] Retorna erros legíveis (400, 404, 500)

### JWT Auth
- [ ] Entende JWT (Header, Payload, Signature)
- [ ] Implementou login que retorna JWT
- [ ] Implementou registro de usuário
- [ ] Endpoints protegidos exigem token
- [ ] Usa BCrypt para senhas

### Swagger
- [ ] Swagger UI acessível em /swagger-ui.html
- [ ] Endpoints documentados com @Operation

### Stay Hard v3.0
- [ ] /api/auth/register funciona
- [ ] /api/auth/login retorna JWT
- [ ] /api/habits CRUD completo
- [ ] /api/daily/finish calcula sucesso/falha
- [ ] /api/users/me/stats com Redis cache
- [ ] Front-end HTML/CSS/JS conectado com API

### Mini-Projetos
- [ ] Auth API JWT
- [ ] Task Manager API
- [ ] Library API com Swagger
- [ ] Contact Book API

### 📊 Progresso Fase 4: ___/24

---

## 🏆 FASE 5 — Docker + Redis + System Design + CI/CD (Dias 79-102) — ⭐⭐⭐⭐ XP

### Docker
- [ ] Entende imagens, containers, volumes
- [ ] Criou Dockerfile para Spring Boot (multi-stage)
- [ ] Criou Dockerfile para HTML/CSS/JS (Nginx)
- [ ] docker-compose.yml funcional (postgres + api + frontend + redis)
- [ ] Health checks configurados

### Redis
- [ ] Entende tipos de dados (String, Hash, List, Set, Sorted Set)
- [ ] Redis CLI (SET, GET, DEL, TTL)
- [ ] Spring Boot + RedisTemplate
- [ ] @Cacheable, @CacheEvict, @CachePut
- [ ] Rate Limiting com Redis (sliding window)
- [ ] Pub/Sub básico
- [ ] Stay Hard com cache de stats + rate limiting

### System Design — HLD
- [ ] Entende Functional vs Non-Functional Requirements
- [ ] Entende Monolithic vs Microservices
- [ ] Entende CAP Theorem
- [ ] Entende Horizontal vs Vertical Scaling
- [ ] Entende Database Replication + Sharding
- [ ] Entende Caching, Load Balancing, API Gateway

### System Design — LLD
- [ ] Aplica SOLID Principles
- [ ] Usa Design Patterns (Singleton, Factory, Builder, Strategy, Observer)

### CI/CD
- [ ] GitHub Actions configurado
- [ ] Pipeline: test → build → deploy
- [ ] Coverage report gerado

### DevOps
- [ ] Nginx reverse proxy (proxy_pass, static files, CORS)
- [ ] Logging com SLF4J + Logback (log levels, structured logging JSON)
- [ ] Correlation IDs para rastrear requests entre services
- [ ] Spring Boot Actuator (health, metrics, info)
- [ ] AWS básico (IAM, console, regions)
- [ ] AWS EC2 (instância Linux, SSH, deploy Spring Boot)
- [ ] AWS RDS (PostgreSQL managed)
- [ ] AWS S3 (storage de arquivos)
- [ ] SSL/HTTPS com Let's Encrypt + Certbot

### Stay Hard v5.0
- [ ] `docker-compose up` sobe tudo (postgres + api + frontend + redis)
- [ ] GitHub Actions passa no push
- [ ] Consegue desenhar HLD do Stay Hard

### Mini-Projetos
- [ ] Dockerize Spring Boot
- [ ] Redis Cache Demo
- [ ] GitHub Actions CI
- [ ] Rate Limiter

### 📊 Progresso Fase 5: ___/39

---

## 🏆 FASE 6 — MongoDB + Microservices + Kafka + RabbitMQ (Dias 103-130) — ⭐⭐⭐⭐ XP

### MongoDB
- [ ] Entende Documents e Collections
- [ ] Spring Data MongoDB configurado
- [ ] @Document + MongoRepository
- [ ] Mongo Express rodando

### Microservices
- [ ] Eureka Server (Service Discovery)
- [ ] API Gateway configurado
- [ ] Serviços se comunicam via Feign
- [ ] Circuit Breaker (Resilience4j)

### Kafka
- [ ] Kafka concepts (topics, partitions, consumer groups)
- [ ] Kafka via Docker
- [ ] Spring Boot + Kafka Producer
- [ ] Spring Boot + Kafka Consumer
- [ ] Stay Hard — Kafka events

### RabbitMQ
- [ ] RabbitMQ concepts (queues, exchanges, bindings, routing keys)
- [ ] RabbitMQ via Docker (management UI)
- [ ] Spring Boot + RabbitMQ Producer (RabbitTemplate)
- [ ] Spring Boot + RabbitMQ Consumer (@RabbitListener)
- [ ] Exchange types (Direct, Fanout, Topic)
- [ ] Dead Letter Queues (DLQ)
- [ ] Manual acknowledgment
- [ ] Stay Hard — RabbitMQ notifications

### 📊 Progresso Fase 6: ___/21

---

## 🏆 FASE 7 — IA + RAG + Spring AI (Dias 131-150) — ⭐⭐⭐⭐ XP

### IA
- [ ] Entende o que é LLM
- [ ] Sabe fazer Prompt Engineering
- [ ] Configurou OpenAI API ou Ollama
- [ ] Spring AI configurado

### RAG
- [ ] Entende o que é RAG
- [ ] Configurou pgvector ou ChromaDB
- [ ] Gerou embeddings de documentos
- [ ] Fez busca por similaridade
- [ ] Pipeline RAG funcional

### Stay Hard v7.0
- [ ] Coach IA responde sobre hábitos
- [ ] RAG Analytics funcional
- [ ] Smart Suggestions funcionam
- [ ] Daily Summary gerado por IA

### Mini-Projetos
- [ ] Chat com PDF (RAG)
- [ ] Code Reviewer IA
- [ ] Document Q&A
- [ ] Recipe Suggester
- [ ] Sentiment Analyzer

### 📊 Progresso Fase 7: ___/14

---

## 🏆 FASE 8 — TypeScript + React + Tailwind (Dias 151-175) — ⭐⭐⭐⭐ XP

### TypeScript
- [ ] Tipos básicos (string, number, boolean, array)
- [ ] Interfaces e Types
- [ ] Generics básicos
- [ ] Union types, optional properties
- [ ] Enums

### React
- [ ] Componentes funcionais com TypeScript
- [ ] Props com interfaces TypeScript
- [ ] useState, useEffect
- [ ] useContext para autenticação
- [ ] React Router DOM v6
- [ ] Axios com interceptors
- [ ] Tailwind CSS configurado
- [ ] Custom Hooks

### Stay Hard v4.0
- [ ] Login chama API e salva JWT
- [ ] ProtectedRoute bloqueia acesso sem auth
- [ ] Dashboard mostra stats reais
- [ ] CRUD de hábitos funcional
- [ ] Dockerize React frontend
- [ ] Full stack: React + Spring API + PostgreSQL + Redis

### Mini-Projetos
- [ ] React Weather App
- [ ] React Todo List
- [ ] React Kanban Board
- [ ] React Chat UI
- [ ] React E-commerce Cart

### 📊 Progresso Fase 8: ___/23

---

## 🏆 FASE 9 — SaaS + ERPs com IA + Portfolio (Dias 176-200) — 🏆 XP

### SaaS Architecture
- [ ] Multi-tenancy implementado
- [ ] Tenant isolation funcional
- [ ] RBAC (Admin, Manager, User)
- [ ] Stripe integration (billing)

### ERPs com IA
- [ ] MedTrack AI — CRUD + triagem IA + RAG médico + React
- [ ] LegalMind AI — CRUD + contratos IA + jurisprudência RAG + React
- [ ] BuildFlow AI — CRUD + custos IA + normas RAG + React
- [ ] TelecomPro — CRUD + churn IA + chatbot RAG + React

### Stay Hard SaaS
- [ ] Multi-tenant funcional
- [ ] Coach IA integrado
- [ ] Docker Compose completo
- [ ] Deploy em produção

### Portfolio
- [ ] READMEs profissionais em todos repos
- [ ] LinkedIn atualizado com projetos
- [ ] GitHub profile organizado
- [ ] Deploy funcionando (AWS/Railway/Render)

### 📊 Progresso Fase 9: ___/15

---

## 📊 PROGRESSO TOTAL

| Fase | Progresso | Status |
|------|-----------|--------|
| 0 - Fundação | ___/14 | ⬜ |
| 1 - SQLite + JDBC + API | ___/16 | ⬜ |
| 2 - HTML + CSS + JS | ___/29 | ⬜ |
| 3 - Spring Boot + DB | ___/29 | ⬜ |
| 4 - REST API + Auth | ___/24 | ⬜ |
| 5 - Docker + Redis + DevOps + SysDesign | ___/39 | ⬜ |
| 6 - MongoDB + Microservices + Kafka + RabbitMQ | ___/21 | ⬜ |
| 7 - IA + RAG | ___/14 | ⬜ |
| 8 - TypeScript + React | ___/23 | ⬜ |
| 9 - SaaS + ERPs + Portfolio | ___/15 | ⬜ |
| **TOTAL** | **___/224** | |

### Níveis
```
0-25   items = 🌱 Iniciante
26-50  items = 🔥 Aprendendo
51-100 items = ⚡ Intermediário
101-160 items = 🛡️ Avançado
161-215 items = 👑 STAY HARD
```
