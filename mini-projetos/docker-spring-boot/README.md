# Docker Spring Boot

Configuração Docker com multi-stage build para Spring Boot e Docker Compose.

## Stack

- Docker (multi-stage build)
- Docker Compose
- Spring Boot 3
- PostgreSQL

## Funcionalidades

- Dockerfile com build multi-stage (compilação + runtime)
- Docker Compose orquestrando app + PostgreSQL
- Health checks configurados
- Variáveis de ambiente externalizadas
- Volume persistente para banco de dados
- Rede Docker interna

## Como rodar

```bash
# Build e subir tudo
docker-compose up --build

# Em background
docker-compose up -d --build

# Parar
docker-compose down
```

A API estará disponível em `http://localhost:8080/api`.

## Estrutura

```
docker-spring-boot/
├── src/
├── Dockerfile
├── docker-compose.yml
├── .dockerignore
└── README.md
```
