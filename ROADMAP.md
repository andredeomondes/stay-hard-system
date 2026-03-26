# 🎮 ROADMAP FULL-STACK JAVA + REACT + IA

> **Objetivo:** Junior Full-Stack Java (Spring Boot + React/TypeScript + IA/RAG)
> **Duração:** 8-12 meses (estudo diário)
> **Projetos:** Stay Hard System → ERPs → SaaS com IA

---

## 📊 VISÃO GERAL

```
FASE 0 ██░░░░░░░░░░░░░░░░░░░░░░  Fundação + GitHub         (Sem 1-2)
FASE 1 ████░░░░░░░░░░░░░░░░░░░░  Java Backend + DB          (Sem 3-6)
FASE 2 ██████░░░░░░░░░░░░░░░░░░  Spring Boot REST + Auth    (Sem 7-10)
FASE 3 ████████░░░░░░░░░░░░░░░░  React + TypeScript         (Sem 11-16)
FASE 4 ██████████░░░░░░░░░░░░░░  Docker + SysDesign + CI/CD (Sem 17-21)
FASE 5 ████████████░░░░░░░░░░░░  IA + RAG + Microservices   (Sem 22-30)
FASE 6 ████████████████████████  SaaS + ERPs + Portfolio    (Sem 31+)
```

---

## 🏆 FASE 0 — Fundação + GitHub (Semana 1-2)

### O que estudar
- Maven (pom.xml, dependências, lifecycle)
- Git avançado (branches, merge, conventional commits)
- GitHub (README, issues, projects, actions)
- JUnit 5 (testes unitários)
- Clean Code (naming, SRP, DRY)

### O que fazer
- [ ] Migrar Stay Hard para Maven
- [ ] Criar testes JUnit 5 para User, Habit, LevelService
- [ ] README profissional com badges
- [ ] .gitignore cobrindo tudo
- [ ] Conventional commits (`feat:`, `fix:`, `refactor:`)

### Mini-Projetos
| Projeto | Stack | Conceito |
|---------|-------|----------|
| Calculadora CLI | Java + Maven | Build tool + testes |
| Validador de CPF | Java + JUnit | Regex + testes |
| Git Logger | Java | Git concepts |

### ✅ Saiu dessa fase sabendo
- Compilar projeto com `mvn clean install`
- Escrever e rodar testes
- Git profissional (branches, PRs, merges)

---

## 🏆 FASE 1 — Java Backend + Banco de Dados (Semana 3-6)

### O que estudar

**SQL:**
- DDL (CREATE, ALTER, DROP)
- DML (INSERT, UPDATE, DELETE, SELECT)
- JOINs (INNER, LEFT, RIGHT, FULL)
- Subqueries, GROUP BY, HAVING
- Indexes, constraints, normalization

**Spring Boot Core:**
- IoC (Inversion of Control)
- DI (Dependency Injection)
- Bean Lifecycle, Scopes
- @Component, @Service, @Repository, @Controller
- application.properties / YAML

**Spring Data JPA:**
- @Entity, @Id, @GeneratedValue
- JpaRepository
- @ManyToOne, @OneToMany, @ManyToMany
- JPQL / Native Queries
- Hibernate basics

### O que fazer no Stay Hard v2.0
```
- Criar schema PostgreSQL (users, habits, daily_logs)
- Migrar CsvUserRepository → JPA UserRepository
- Migrar CsvHabitRepository → JPA HabitRepository
- @Entity User, Habit com relacionamentos
- @Service com @Transactional
- Testes com H2 in-memory
```

### Mini-Projetos
| Projeto | Stack | Conceito |
|---------|-------|----------|
| CRUD Produtos | Spring Boot + H2 | JPA básico |
| API Contatos | Spring Boot + PostgreSQL | Relacionamentos |
| Blog Simples | Spring Boot + Thymeleaf | MVC web |

### ✅ Saiu dessa fase sabendo
- SQL fluente (SELECT com JOIN)
- Spring Boot do zero ao rodar
- JPA mapeando objetos para tabelas

---

## 🏆 FASE 2 — REST API + Autenticação (Semana 7-10)

### O que estudar

**REST API:**
- @RestController, @RequestMapping
- @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
- @PathVariable, @RequestParam, @RequestBody
- HTTP Status (200, 201, 400, 401, 403, 404, 500)
- DTOs (request/response)
- @Valid + Bean Validation

**Exception Handling:**
- @ControllerAdvice + @ExceptionHandler
- Custom exceptions

**Spring Security + JWT:**
- Authentication vs Authorization
- JWT (Header, Payload, Signature)
- JwtTokenProvider, JwtFilter
- SecurityFilterChain
- BCrypt

**Documentation:**
- Swagger / OpenAPI (springdoc-openapi)

### O que fazer no Stay Hard v3.0
```
Endpoints:
  POST   /api/auth/register
  POST   /api/auth/login          → JWT token
  GET    /api/users/me            → perfil
  GET    /api/users/me/stats      → estatísticas
  
  POST   /api/habits              → criar
  GET    /api/habits              → listar
  PUT    /api/habits/{id}/start
  PUT    /api/habits/{id}/complete
  DELETE /api/habits/{id}
  PUT    /api/habits/reset
  
  POST   /api/daily/finish        → encerrar dia

Novos packages:
  dto/request/  dto/response/  security/  exception/  config/
```

### Mini-Projetos
| Projeto | Stack | Conceito |
|---------|-------|----------|
| Auth API JWT | Spring Boot + JWT | Login/Registro |
| Task Manager API | Spring Boot + JPA | CRUD completo |
| Library API | Spring Boot + Swagger | Documentação |

### ✅ Saiu dessa fase sabendo
- Criar API REST profissional
- Implementar login com JWT
- Documentar API com Swagger
- Tratar erros globalmente

---

## 🏆 FASE 3 — JavaScript + TypeScript + React (Semana 11-16)

### O que estudar

**JavaScript (Sem 11-12):**
- ES6+: arrow functions, destructuring, spread/rest
- let/const, template literals
- Promises, async/await, fetch API
- Array methods (map, filter, reduce)
- Modules (import/export)

**TypeScript (Sem 13):**
- Types: string, number, boolean, array, tuple
- Interfaces e Types
- Generics básicos
- Union types, optional properties
- Enums

**React (Sem 14-16):**
- Vite (build tool)
- Componentes funcionais
- Props + TypeScript interfaces
- useState, useEffect, useContext
- React Router DOM v6
- Axios + interceptors (JWT)
- Tailwind CSS
- Custom Hooks

### O que fazer no Stay Hard v4.0
```
stay-hard-frontend/
├── src/
│   ├── pages/      → Login, Register, Dashboard, Habits, Profile
│   ├── components/ → HabitCard, LevelBadge, StreakCounter, Navbar
│   ├── services/   → api.ts (axios + JWT interceptor)
│   ├── hooks/      → useAuth, useHabits
│   ├── context/    → AuthContext.tsx
│   └── types/      → user.types.ts, habit.types.ts
├── package.json
├── tsconfig.json
└── vite.config.ts
```

### Mini-Projetos
| Projeto | Stack | Conceito |
|---------|-------|----------|
| Weather App | React + TS + API | fetch, useState |
| Todo List | React + TS | CRUD frontend |
| Kanban Board | React + TS + DnD | Complex state |
| Chat UI | React + TS + WebSocket | Real-time |

### ✅ Saiu dessa fase sabendo
- TypeScript sem erros
- React com hooks modernos
- Conectar frontend com API Spring Boot
- Autenticação JWT no frontend

---

## 🏆 FASE 4 — Docker + System Design + CI/CD (Semana 17-21)

### 4A. DOCKER

**O que estudar:**
- Imagens, Containers, Volumes, Networks
- Dockerfile (multi-stage builds)
- Docker Compose
- .env files, Health checks

**Stay Hard v5.0 — Dockerizado:**
```yaml
# docker-compose.yml
services:
  postgres:    # banco de dados
  api:         # Spring Boot
  frontend:    # React (Nginx)
  pgadmin:     # admin do banco
```

---

### 4B. SYSTEM DESIGN — HLD

**High Level Design:**
- Functional vs Non-Functional Requirements
- Monolithic vs Microservices
- Event-Driven Architecture
- Scalability (Horizontal vs Vertical)
- Database Replication + Sharding
- SQL vs NoSQL
- CAP Theorem
- Caching (Redis, eviction policies)
- Load Balancing (algorithms)
- API Gateway, Message Queues
- Rate Limiting
- CDN, Proxies, WebSockets

**Low Level Design (LLD):**
- SOLID Principles
- DRY, KISS, YAGNI
- Design Patterns:
  - Creational: Singleton, Factory, Builder
  - Structural: Adapter, Facade, Decorator
  - Behavioral: Strategy, Observer, Command

**Padrões aplicados no Stay Hard:**
- Strategy → LevelService
- Observer → Eventos de conclusão
- Factory → Criação de hábitos
- Repository → Já implementado
- DTO → Separação request/response

---

### 4C. CI/CD PIPELINE

**O que estudar:**
- Continuous Integration / Delivery / Deployment
- GitHub Actions
- Pipeline stages
- Automated testing + deploy

**Pipeline GitHub Actions:**
```yaml
# .github/workflows/ci.yml
stages:
  1. Checkout code
  2. Setup Java 21
  3. mvn clean test        → testes unitários
  4. mvn jacoco:report     → coverage
  5. mvn clean package     → build JAR
  6. Docker build + push   → imagem Docker
  7. Deploy                → produção
```

### Mini-Projetos
| Projeto | Stack | Conceito |
|---------|-------|----------|
| Dockerize API | Docker | Dockerfile |
| Redis Cache | Spring Boot + Redis | Caching |
| GitHub Actions CI | GitHub Actions | CI/CD |
| Rate Limiter | Spring Boot | API Gateway |

### ✅ Saiu dessa fase sabendo
- `docker-compose up` sobe tudo
- GitHub Actions no push
- Desenhar HLD de qualquer sistema
- Aplicar SOLID e Design Patterns

---

## 🏆 FASE 5 — IA + RAG + Microservices + MongoDB (Semana 22-30)

### 5A. MONGODB

**O que estudar:**
- Documents, Collections, CRUD
- Spring Data MongoDB
- @Document, MongoRepository
- Aggregation Pipeline
- Mongo Express

**Stay Hard v6.0:**
- MongoDB para audit logs, analytics, notificações

---

### 5B. MICROSERVIÇOS

**O que estudar:**
- Service Discovery (Eureka)
- API Gateway (Spring Cloud Gateway)
- Inter-service communication
- Circuit Breaker (Resilience4j)
- Distributed Tracing

**Stay Hard v6.0 — Microservices:**
```
eureka-server/          (port 8761)
api-gateway/            (port 8080)
user-service/           (PostgreSQL)
habit-service/          (PostgreSQL)
analytics-service/      (MongoDB)
notification-service/   (MongoDB + WebSocket)
ai-service/             (OpenAI API)
frontend/               (React)
```

---

### 5C. IA + RAG — O DIFERENCIAL

**IA Fundamentals:**
- LLM (Large Language Model)
- Prompt Engineering
- Tokens, context window
- OpenAI API / Gemini API / Ollama

**RAG (Retrieval Augmented Generation):**
- O que é RAG e por que usar
- Vector Databases (pgvector, ChromaDB, Pinecone)
- Embeddings (text → vectors)
- Chunking strategies
- Similarity search
- RAG Pipeline:
  1. Document ingestion
  2. Text chunking
  3. Generate embeddings
  4. Store in vector DB
  5. Query → embed → search similar chunks
  6. Feed chunks + query to LLM
  7. LLM generates answer with context

**Spring AI:**
- ChatClient
- VectorStore
- RAG with Spring AI

**Stay Hard v7.0 — Com IA:**
```
🤖 Coach IA          → Analisa hábitos, sugere melhorias
📊 RAG Analytics     → "Como estão meus hábitos esta semana?"
🎯 Smart Suggestions → Sugere novos hábitos baseado no histórico
📝 Daily Summary     → Resumo motivacional com dados reais
```

### Mini-Projetos IA
| Projeto | Stack | Conceito |
|---------|-------|----------|
| Chat com PDF | Spring AI + pgvector | RAG básico |
| Code Reviewer IA | OpenAI API + Spring | Prompt engineering |
| Document Q&A | RAG + ChromaDB | Embeddings + search |
| Recipe Suggester | Spring AI | LLM + structured output |

### ✅ Saiu dessa fase sabendo
- MongoDB para dados não-relacionais
- Microservices se comunicando
- Integrar IA em aplicações Spring
- Implementar RAG do zero

---

## 🏆 FASE 6 — SaaS + ERPs + Portfolio (Semana 31+)

### SaaS Architecture
- Multi-tenancy (shared DB, schema per tenant, DB per tenant)
- Tenant isolation, subscription management
- Billing (Stripe), RBAC, Admin dashboard

### Projetos SaaS com IA

#### 🏥 MedTrack AI — SaaS Médico
```
Features:
  - Gestão de pacientes, consultas, prontuários
  - 🤖 IA: Triagem automática de sintomas
  - 🤖 IA: Sugestão de diagnóstico (RAG com base médica)
  - 🤖 IA: Resumo automático de prontuário
  - 💳 Cobrança por consulta (Stripe)

RAG:
  - Base de conhecimento médico (artigos, protocolos)
  - Embeddings em pgvector
  - Médico pergunta → IA responde com protocolos + contexto do paciente
```

#### ⚖️ LegalMind AI — SaaS Jurídico
```
Features:
  - Gestão de casos, clientes, prazos
  - 🤖 IA: Análise de contratos (RAG)
  - 🤖 IA: Busca de jurisprudência similar
  - 🤖 IA: Geração de minutas automáticas
  - 🤖 IA: Resumo de processos longos

RAG:
  - Base de jurisprudência (STF, STJ, TJ)
  - Base de legislação (CF, CPC, CLT)
  - Documentos do escritório
  - Advogado pergunta → IA retorna casos similares
```

#### 🔧 BuildFlow AI — SaaS Engenharia
```
Features:
  - Gestão de obras, cronograma Gantt, equipes
  - 🤖 IA: Estimativa de custos com base em projetos passados
  - 🤖 IA: Detecção de atraso em cronograma
  - 🤖 IA: Sugestão de otimização de recursos

RAG:
  - Base de normas técnicas (NBR, ABNT)
  - Histórico de projetos passados
  - IA responde perguntas técnicas com normas
```

#### 📡 TelecomPro — SaaS Telecom
```
Features:
  - Gestão clientes B2B/B2C, planos, faturamento
  - 🤖 IA: Previsão de churn
  - 🤖 IA: Chatbot de suporte (RAG com FAQs)
  - 🤖 IA: Análise de performance de rede
```

### ✅ Saiu dessa fase sabendo
- Construir SaaS multi-tenant
- Integrar IA + RAG em qualquer projeto
- Deploy automatizado
- Projetos reais no portfolio

---

## 📅 CRONOGRAMA SEMANAL

| Dia | Estudo (2h) | Prática (2h) |
|-----|------------|--------------|
| Seg | Teoria (conceito novo) | Anotações + exemplos |
| Ter | Mini-projeto | Mini-projeto |
| Qua | Stay Hard System | Stay Hard System |
| Qui | Mini-projeto | Mini-projeto |
| Sex | Stay Hard System | Stay Hard System |
| Sáb | Revisão + GitHub push | System Design/IA |
| Dom | Descanso | Descanso |

---

## 🎯 ORDEM DE PRIORIDADES

```
1.  Java sólido          → base de tudo
2.  Spring Boot          → backend profissional
3.  SQL + PostgreSQL     → persistência real
4.  REST API + JWT       → comunicação frontend-backend
5.  TypeScript           → segurança no frontend
6.  React                → interface moderna
7.  Docker               → portabilidade
8.  System Design        → pensar como arquiteto
9.  CI/CD                → profissionalismo
10. MongoDB              → dados não-relacionais
11. Microservices        → arquitetura escalável
12. IA + RAG             → DIFERENCIAL no mercado
13. SaaS                 → produto rentável
14. ERPs                 → projetos reais para clientes
```

---

> *"Who's gonna carry the boats?!"* — David Goggins
> **Stay Hard. Never settle. Keep building.**
