# 🏋️ Stay Hard System

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![React](https://img.shields.io/badge/React-TypeScript-61DAFB?style=for-the-badge&logo=react&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

> *"Who's gonna carry the boats?!"* — David Goggins

Sistema gamificado de tracking de hábitos que evolui de CLI para SaaS completo com IA. Projeto de estudo Full-Stack Java + React + IA/RAG.

---

## 📂 Estrutura do Projeto

```
stay-hard-system/
├── stay-hard-system-v1.0/       ← CLI original (Java puro)
├── src/                         ← v2.0+ (Maven + Spring Boot)
├── docs/                        ← Anotações de estudo por fase
├── progresso/                   ← Checklist gamificado + daily tasks
├── mini-projetos/               ← 22 projetos práticos
├── templates/                   ← Templates reutilizáveis
├── ROADMAP.md                   ← Roadmap completo
└── README.md                    ← Este arquivo
```

---

## 📚 Estudo (150 dias)

| Fase | Dias | Conteúdo | Docs |
|------|------|----------|------|
| 0 | 1-10 | Maven, Git, JUnit, mini-projetos CLI | [docs/01-fase0-fundacao.md](docs/01-fase0-fundacao.md) |
| 1 | 11-30 | PostgreSQL, Spring Boot, JPA | [docs/02-fase1-java-backend.md](docs/02-fase1-java-backend.md) |
| 2 | 31-48 | REST API, JWT, Swagger | [docs/03-fase2-rest-api.md](docs/03-fase2-rest-api.md) |
| 3 | 49-72 | JS, TypeScript, React | [docs/04-fase3-react-typescript.md](docs/04-fase3-react-typescript.md) |
| 4 | 73-92 | Docker, Redis, System Design, CI/CD | [docs/05-fase4-docker-systemdesign.md](docs/05-fase4-docker-systemdesign.md) |
| 5 | 93-120 | MongoDB, Microservices, Kafka, RabbitMQ, IA, RAG | [docs/06-fase5-ia-rag.md](docs/06-fase5-ia-rag.md) |
| 6 | 121-150 | SaaS, ERPs com IA, Portfolio | [docs/08-saas-erp-ia.md](docs/08-saas-erp-ia.md) |

### Materiais extras
- [Redis](docs/07-redis.md)
- [RabbitMQ](docs/09-rabbitmq.md)
- [Roadmap completo](ROADMAP.md)
- [Checklist gamificado](progresso/checklist.md)
- [Daily tasks (150 dias)](progresso/daily-tasks.md)
- [Daily log](progresso/daily-log.md)

---

## 🚀 Como Rodar

### v1.0 (CLI)
```bash
cd stay-hard-system-v1.0/src
javac StayHardApp.java
java StayHardApp
```

### v2.0+ (Spring Boot)
```bash
mvn spring-boot:run
```

### Docker (v5.0+)
```bash
docker-compose up -d
```

---

## 📈 Evolução do Projeto

| Versão | O que tem |
|--------|-----------|
| v1.0 | CLI + CSV + Update/Delete de hábitos |
| v2.0 | Spring Boot + PostgreSQL + JPA |
| v3.0 | REST API + JWT Auth + Swagger |
| v4.0 | React + TypeScript Frontend |
| v5.0 | Docker + Redis + CI/CD |
| v6.0 | Microservices + MongoDB |
| v7.0 | Kafka + RabbitMQ + IA/RAG |
| v8.0 | SaaS Multi-Tenant + ERPs com IA |

---

## 🎯 Mini-Projetos

| Projeto | Stack |
|---------|-------|
| [Calculadora CLI](mini-projetos/calculadora-cli/) | Java |
| [Validador CPF](mini-projetos/validador-cpf/) | Java + JUnit |
| [CRUD Produtos](mini-projetos/crud-produtos/) | Spring Boot |
| [Auth API JWT](mini-projetos/auth-api-jwt/) | Spring Boot + JWT |
| [React Weather](mini-projetos/react-weather/) | React + TS |
| [React Kanban](mini-projetos/react-kanban/) | React + TS |
| [Docker Spring Boot](mini-projetos/docker-spring-boot/) | Docker |
| [Redis Cache](mini-projetos/redis-cache-demo/) | Spring Boot + Redis |
| [Rate Limiter](mini-projetos/rate-limiter/) | Spring Boot + Redis |
| [E mais...](mini-projetos/) | 22 projetos no total |

---

## 👤 Autor

**André de Omondes**
- GitHub: [@andredeomondes](https://github.com/andredeomondes)
- LinkedIn: [in/andredeomondes](https://www.linkedin.com/in/andredeomondes/)

---

## 📄 License

MIT
