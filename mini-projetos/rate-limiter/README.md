# Rate Limiter

Implementação de rate limiting com sliding window algorithm usando Spring Boot e Redis.

## Stack

- Spring Boot 3
- Spring Data Redis
- Redis
- Spring Cloud Gateway (conceito)

## Funcionalidades

- Sliding window algorithm para rate limiting
- Controle por IP ou por usuário autenticado
- Resposta com headers de rate limit (X-RateLimit-*)
- HTTP 429 quando limite excedido
- Configuração por endpoint
- Conceito de API Gateway pattern

## Como rodar

```bash
docker run -d --name redis -p 6379:192 redis
./mvnw spring-boot:run
```

## Headers de Resposta

```
X-RateLimit-Limit: 100
X-RateLimit-Remaining: 95
X-RateLimit-Reset: 1700000000
```

## Estrutura

```
rate-limiter/
├── src/main/java/com/ratelimiter/
│   ├── config/
│   ├── filter/
│   ├── service/
│   └── controller/
├── pom.xml
└── README.md
```
