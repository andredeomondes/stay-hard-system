# Auth API JWT

API REST com autenticação JWT usando Spring Security.

## Stack

- Spring Boot 3
- Spring Security
- JWT (jjwt)
- PostgreSQL

## Funcionalidades

- Registro de novos usuários
- Login com geração de token JWT
- Endpoints públicos e protegidos
- Refresh token
- Validação de token em cada requisição

## Como rodar

```bash
docker run -d --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres
./mvnw spring-boot:run
```

## Endpoints

| Método | Rota              | Auth   | Descrição          |
|--------|-------------------|--------|--------------------|
| POST   | /api/auth/register | Público | Registrar usuário |
| POST   | /api/auth/login    | Público | Login e get token |
| GET    | /api/auth/me       | JWT     | Dados do usuário  |
| GET    | /api/protected     | JWT     | Endpoint protegido|

## Uso

```bash
# Registrar
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"joao","password":"123456"}'
```
