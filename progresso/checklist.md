# ✅ CHECKLIST DE PROGRESSO — JAVA STUDY

> Marque cada item ao completar. XP acumulado mostra seu nível.

---

## 🏆 FASE 0 — Fundação + GitHub (Semana 1-2) — ⭐ XP

### Conceitos
- [ ] Entende o que é Maven (pom.xml, dependências, lifecycle)
- [ ] Entende Git avançado (branches, merge, rebase)
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

### 📊 Progresso Fase 0: ___/12

---

## 🏆 FASE 1 — Java Backend + DB (Semana 3-6) — ⭐⭐ XP

### SQL
- [ ] Consegue criar tabelas com constraints
- [ ] Consegue fazer SELECT com JOIN
- [ ] Consegue usar GROUP BY, HAVING
- [ ] Entende indexes e quando usar

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

### Stay Hard v2.0
- [ ] PostgreSQL instalado e rodando
- [ ] Schema criado (users, habits)
- [ ] UserRepository usando JPA
- [ ] HabitRepository usando JPA
- [ ] Testes passam com H2

### Mini-Projetos
- [ ] CRUD Produtos (Spring Boot + H2)
- [ ] API Contatos (Spring Boot + PostgreSQL)
- [ ] Blog Simples

### 📊 Progresso Fase 1: ___/18

---

## 🏆 FASE 2 — REST API + Auth (Semana 7-10) — ⭐⭐⭐ XP

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
- [ ] /api/users/me/stats mostra nível

### Mini-Projetos
- [ ] Auth API JWT
- [ ] Task Manager API
- [ ] Library API com Swagger

### 📊 Progresso Fase 2: ___/20

---

## 🏆 FASE 3 — React + TypeScript (Semana 11-16) — ⭐⭐⭐ XP

### JavaScript
- [ ] Arrow functions, destructuring, spread
- [ ] Promises, async/await, fetch
- [ ] Array methods (map, filter, reduce)
- [ ] Modules (import/export)

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
- [ ] TypeScript sem erros (`npx tsc --noEmit`)

### Mini-Projetos
- [ ] Weather App
- [ ] Todo List
- [ ] Kanban Board
- [ ] Chat UI

### 📊 Progresso Fase 3: ___/22

---

## 🏆 FASE 4 — Docker + System Design + CI/CD (Sem 17-21) — ⭐⭐⭐⭐ XP

### Docker
- [ ] Entende imagens, containers, volumes
- [ ] Criou Dockerfile para Spring Boot
- [ ] Criou Dockerfile para React
- [ ] docker-compose.yml funcional
- [ ] Health checks configurados

### System Design — HLD
- [ ] Entende Functional vs Non-Functional Requirements
- [ ] Entende Monolithic vs Microservices
- [ ] Entende CAP Theorem
- [ ] Entende Horizontal vs Vertical Scaling
- [ ] Entende Database Replication + Sharding
- [ ] Entende Caching (Redis, eviction policies)
- [ ] Entende Load Balancing
- [ ] Entende API Gateway
- [ ] Entende Message Queues
- [ ] Entende Rate Limiting
- [ ] Entende CDN, Proxies, WebSockets

### System Design — LLD
- [ ] Aplica SOLID Principles
- [ ] Conhece DRY, KISS, YAGNI
- [ ] Usa Design Patterns:
  - [ ] Singleton
  - [ ] Factory
  - [ ] Builder
  - [ ] Strategy
  - [ ] Observer
  - [ ] Repository

### CI/CD
- [ ] GitHub Actions configurado
- [ ] Pipeline: test → build → deploy
- [ ] Coverage report gerado

### Redis
- [ ] Entende o que é Redis e quando usar
- [ ] Configurou Redis via Docker
- [ ] Spring Boot + Redis funcionando
- [ ] @Cacheable implementado
- [ ] Rate Limiting com Redis
- [ ] Pub/Sub básico funcionando
- [ ] Stay Hard com cache de stats

### Stay Hard v5.0
- [ ] `docker-compose up` sobe tudo
- [ ] GitHub Actions passa no push
- [ ] Consegue desenhar HLD do Stay Hard

### Mini-Projetos
- [ ] Dockerize API
- [ ] Redis Cache Demo
- [ ] GitHub Actions CI
- [ ] Rate Limiter

### 📊 Progresso Fase 4: ___/34

---

## 🏆 FASE 5 — IA + RAG + Microservices + RabbitMQ (Sem 22-30) — ⭐⭐⭐⭐ XP

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
- [ ] Pipeline RAG funcional:
  - [ ] Ingestão de documentos
  - [ ] Chunking
  - [ ] Embedding
  - [ ] Storage no vector DB
  - [ ] Query → search → LLM answer

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

### 📊 Progresso Fase 5: ___/37

---

## 🏆 FASE 6 — SaaS + ERPs + Portfolio (Sem 31+) — 🏆 XP

### SaaS Architecture
- [ ] Multi-tenancy implementado
- [ ] Tenant isolation funcional
- [ ] RBAC (Admin, User roles)
- [ ] Stripe integration (billing)
- [ ] Admin dashboard

### Projetos SaaS
- [ ] MedTrack AI funcional com IA
- [ ] LegalMind AI funcional com RAG
- [ ] BuildFlow AI funcional
- [ ] TelecomPro funcional

### Portfolio
- [ ] GitHub profile organizado
- [ ] READMEs profissionais em todos repos
- [ ] LinkedIn atualizado com projetos
- [ ] Deploy funcionando (AWS/Railway/Render)

### 📊 Progresso Fase 6: ___/13

---

## 📊 PROGRESSO TOTAL

| Fase | Progresso | Status |
|------|-----------|--------|
| 0 - Fundação | ___/12 | ⬜ |
| 1 - Java + DB | ___/18 | ⬜ |
| 2 - REST + Auth | ___/20 | ⬜ |
| 3 - React + TS | ___/22 | ⬜ |
| 4 - Docker + Redis + SysDesign | ___/34 | ⬜ |
| 5 - IA + RAG + Kafka + RabbitMQ | ___/37 | ⬜ |
| 6 - SaaS + Portfolio | ___/13 | ⬜ |
| **TOTAL** | **___/156** | |

### Níveis
```
0-20   items = 🌱 Iniciante
21-40  items = 🔥 Aprendendo
41-80  items = ⚡ Intermediário
81-120 items = 🛡️ Avançado
121-156 items = 👑 STAY HARD
```
