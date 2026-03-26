# 🏋️ Stay Hard System

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![React](https://img.shields.io/badge/React-TypeScript-61DAFB?style=for-the-badge&logo=react&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)

> *"Who's gonna carry the boats?!"* — David Goggins

Sistema gamificado de tracking de hábitos que evolui de CLI para SaaS completo com IA. **Projeto de estudo Full-Stack Java + React + IA/RAG — 209 dias, 10 fases.**

---

## 📂 Estrutura do Repositório

```
stay-hard-system/
│
├── stay-hard-system-v1.0/       ← Projeto v1.0 (CLI Java puro, CSV)
│   └── src/                     ← Código fonte original
│
├── src/                         ← Projeto v2.0+ (Maven + Spring Boot)
│   ├── main/java/com/stayhard/  ← Código fonte (entities, services, controllers)
│   ├── main/resources/          ← application.properties
│   └── test/java/               ← Testes JUnit
│
├── docs/                        ← Anotações de estudo (11 arquivos)
│   ├── 00-sqlite-jdbc-api.md    ← SQLite + JDBC + API sem Spring
│   ├── 01-fase0-fundacao.md     ← Maven, Git, JUnit
│   ├── 02-fase1-java-backend.md ← Spring Boot, PostgreSQL, JPA
│   ├── 03-fase2-rest-api.md     ← REST, JWT, Swagger
│   ├── 04-fase3-react-typescript.md ← JS, TypeScript, React
│   ├── 05-fase4-docker-systemdesign.md ← Docker, System Design, CI/CD
│   ├── 06-fase5-ia-rag.md       ← IA, RAG, Spring AI, Kafka, RabbitMQ
│   ├── 07-redis.md              ← Redis completo
│   ├── 08-saas-erp-ia.md        ← SaaS, ERPs com IA
│   ├── 09-rabbitmq.md           ← RabbitMQ completo
│   └── 10-devops.md             ← Logging, Nginx, AWS, SSL
│
├── progresso/                   ← Acompanhamento de progresso
│   ├── daily-tasks.md           ← 209 dias de tarefas (COMECE AQUI)
│   ├── daily-log.md             ← Marcar dias completados
│   └── checklist.md             ← 224 itens gamificados com XP
│
├── mini-projetos/               ← 22+ projetos práticos
│   ├── calculadora-cli/         ← Fase 0: Java puro
│   ├── validador-cpf/           ← Fase 0: Java + JUnit
│   ├── api-sqlite-jdbc/         ← Fase 1: Java + SQLite + JDBC
│   ├── todo-list-web/           ← Fase 2: HTML + CSS + JS
│   ├── calculadora-web/         ← Fase 2: HTML + CSS + JS
│   ├── weather-app/             ← Fase 2: HTML + CSS + JS + API
│   ├── portfolio-page/          ← Fase 2: HTML + CSS
│   ├── crud-produtos/           ← Fase 3: Spring Boot + H2
│   ├── api-contatos/            ← Fase 3: Spring Boot + PostgreSQL
│   ├── redis-cache-demo/        ← Fase 3: Spring Boot + Redis
│   ├── rate-limiter/            ← Fase 5: Spring Boot + Redis
│   ├── auth-api-jwt/            ← Fase 4: Spring Boot + JWT
│   ├── docker-spring-boot/      ← Fase 5: Docker
│   ├── github-actions-ci/       ← Fase 5: GitHub Actions
│   ├── react-weather/           ← Fase 8: React + TS
│   ├── react-todo/              ← Fase 8: React + TS
│   ├── react-kanban/            ← Fase 8: React + TS
│   ├── react-chat/              ← Fase 8: React + TS
│   └── react-ecommerce/         ← Fase 8: React + TS
│
├── templates/                   ← Templates reutilizáveis
│   ├── spring-boot-init/        ← Template Spring Boot (pom.xml + config)
│   └── react-ts-init/           ← Template React + TypeScript (package.json + config)
│
├── pom.xml                      ← Maven (dependências do projeto principal)
├── .gitignore                   ← Arquivos ignorados pelo Git
├── ROADMAP.md                   ← Roadmap completo detalhado
└── README.md                    ← Este arquivo
```

---

## 🚀 Como Começar

### 1. Clone o repositório
```bash
git clone https://github.com/andredeomondes/stay-hard-system.git
cd stay-hard-system
```

### 2. Abra o guia diário
```
progresso/daily-tasks.md    ← Comece pelo Dia 1 aqui
```

### 3. Marque seu progresso
```
progresso/daily-log.md      ← Marque cada dia completado
progresso/checklist.md      ← Marque cada item aprendido
```

---

## 📚 Plano de Estudo — 209 Dias / 10 Fases

| Fase | Dias | Conteúdo | Doc |
|------|------|----------|-----|
| 0 | 1-10 | Fundação: Maven, Git, JUnit, mini-projetos CLI | [docs/01](docs/01-fase0-fundacao.md) |
| 1 | 11-20 | SQLite, JDBC, API REST sem Spring | [docs/00](docs/00-sqlite-jdbc-api.md) |
| 2 | 21-40 | HTML, CSS, JavaScript (front-end básico) | [docs/04](docs/04-fase3-react-typescript.md) |
| 3 | 41-60 | Spring Boot, PostgreSQL, JPA, Redis | [docs/02](docs/02-fase1-java-backend.md) |
| 4 | 61-80 | REST API, JWT Auth, Swagger | [docs/03](docs/03-fase2-rest-api.md) |
| 5 | 81-105 | Docker, Redis, Nginx, Logging, SysDesign, CI/CD | [docs/05](docs/05-fase4-docker-systemdesign.md) |
| 6 | 106-133 | MongoDB, Microservices, Kafka, RabbitMQ | [docs/06](docs/06-fase5-ia-rag.md) |
| 7 | 134-153 | IA, RAG, Spring AI, mini-projetos IA | [docs/06](docs/06-fase5-ia-rag.md) |
| 8 | 154-178 | TypeScript, React, Tailwind CSS | [docs/04](docs/04-fase3-react-typescript.md) |
| 9 | 179-209 | SaaS, ERPs com IA, AWS, SSL, Deploy, Portfolio | [docs/08](docs/08-saas-erp-ia.md) |

### Referências extras
| Tópico | Doc |
|--------|-----|
| Redis | [docs/07-redis.md](docs/07-redis.md) |
| RabbitMQ | [docs/09-rabbitmq.md](docs/09-rabbitmq.md) |
| DevOps (Logging, Nginx, AWS, SSL) | [docs/10-devops.md](docs/10-devops.md) |
| SaaS + ERPs com IA | [docs/08-saas-erp-ia.md](docs/08-saas-erp-ia.md) |

---

## 🚀 Como Rodar

### v1.0 — CLI (Java puro, sem dependências)
```bash
cd stay-hard-system-v1.0/src
javac StayHardApp.java
java StayHardApp
```

### v2.0+ — Spring Boot (Maven)
```bash
mvn clean install
mvn spring-boot:run
# Acesse: http://localhost:8080
```

### Docker (v5.0+)
```bash
docker-compose up -d
# API: http://localhost:8080
# Frontend: http://localhost:3000
# Swagger: http://localhost:8080/swagger-ui.html
```

---

## 📈 Evolução do Projeto

| Versão | Fase | O que tem |
|--------|------|-----------|
| v1.0 | 0 | CLI + CSV + Update/Delete de hábitos |
| v1.5 | 1 | SQLite + JDBC + API REST sem Spring |
| v2.0 | 3 | Spring Boot + PostgreSQL + JPA |
| v3.0 | 4 | REST API + JWT Auth + Swagger |
| v4.0 | 8 | React + TypeScript Frontend |
| v5.0 | 5 | Docker + Redis + CI/CD |
| v6.0 | 6 | Microservices + MongoDB + Kafka + RabbitMQ |
| v7.0 | 7 | IA/RAG + Spring AI |
| v8.0 | 9 | SaaS Multi-Tenant + ERPs com IA |

---

## 🎯 Mini-Projetos (22+)

### Fase 0 — Java Puro
| Projeto | Stack |
|---------|-------|
| [Calculadora CLI](mini-projetos/calculadora-cli/) | Java |
| [Validador CPF](mini-projetos/validador-cpf/) | Java + JUnit |
| [Git Logger](mini-projetos/git-logger/) | Java |
| [Gerador de Senhas](mini-projetos/gerador-senhas/) | Java |
| [Ordenação de Arrays](mini-projetos/ordenacao-arrays/) | Java |

### Fase 1 — SQLite + JDBC
| Projeto | Stack |
|---------|-------|
| [API SQLite JDBC](mini-projetos/api-sqlite-jdbc/) | Java + SQLite + JDBC |

### Fase 2 — Front-end Básico
| Projeto | Stack |
|---------|-------|
| [Todo List Web](mini-projetos/todo-list-web/) | HTML + CSS + JS |
| [Calculadora Web](mini-projetos/calculadora-web/) | HTML + CSS + JS |
| [Weather App](mini-projetos/weather-app/) | HTML + CSS + JS + API |
| [Portfolio Page](mini-projetos/portfolio-page/) | HTML + CSS |

### Fase 3-4 — Spring Boot
| Projeto | Stack |
|---------|-------|
| [CRUD Produtos](mini-projetos/crud-produtos/) | Spring Boot + H2 |
| [API Contatos](mini-projetos/api-contatos/) | Spring Boot + PostgreSQL |
| [Auth API JWT](mini-projetos/auth-api-jwt/) | Spring Boot + JWT |
| [Task Manager](mini-projetos/task-manager-api/) | Spring Boot |

### Fase 5 — DevOps
| Projeto | Stack |
|---------|-------|
| [Docker Spring Boot](mini-projetos/docker-spring-boot/) | Docker |
| [Redis Cache Demo](mini-projetos/redis-cache-demo/) | Spring Boot + Redis |
| [Rate Limiter](mini-projetos/rate-limiter/) | Spring Boot + Redis |
| [GitHub Actions CI](mini-projetos/github-actions-ci/) | GitHub Actions |

### Fase 8 — React
| Projeto | Stack |
|---------|-------|
| [React Weather](mini-projetos/react-weather/) | React + TS |
| [React Todo](mini-projetos/react-todo/) | React + TS |
| [React Kanban](mini-projetos/react-kanban/) | React + TS |
| [React Chat](mini-projetos/react-chat/) | React + TS |
| [React E-commerce](mini-projetos/react-ecommerce/) | React + TS |

---

## 🎮 Game Mechanics (Stay Hard System)

| Level | Days | Title |
|-------|------|-------|
| 1 | 0-6 | 🌱 Awakening |
| 2 | 7-14 | 🔥 Forged |
| 3 | 15-29 | ⚡ Relentless |
| 4 | 30-74 | 🛡️ Unbreakable |
| 5 | 75+ | 👑 Stay Hard |

---

## 👤 Autor

**André de Omondes**
- GitHub: [@andredeomondes](https://github.com/andredeomondes)
- LinkedIn: [in/andredeomondes](https://www.linkedin.com/in/andredeomondes/)

---

## 📄 License

MIT
