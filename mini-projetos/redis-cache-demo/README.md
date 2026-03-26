# Redis Cache Demo

Demonstração de cache com Redis em Spring Boot incluindo rate limiting.

## Stack

- Spring Boot 3
- Spring Data Redis
- Redis
- Docker

## Funcionalidades

- Cache de dados com `@Cacheable` e `@CacheEvict`
- TTL configurável para cache
- Rate limiting simples com Redis
- Limpar cache via endpoint
- Listar chaves em cache

## Como rodar

```bash
# Subir Redis
docker run -d --name redis -p 6379:6379 redis

# Rodar aplicação
./mvnw spring-boot:run
```

## Endpoints

| Método | Rota               | Descrição            |
|--------|--------------------|----------------------|
| GET    | /api/dados/{id}    | Buscar (com cache)   |
| DELETE | /api/cache         | Limpar todo cache    |
| GET    | /api/cache/keys    | Listar chaves cache  |

## Configuração

O cache e rate limit são configurados em `application.properties`:

```properties
spring.cache.type=redis
app.rate-limit.requests-per-minute=60
```
