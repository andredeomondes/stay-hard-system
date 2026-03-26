# API REST com SQLite + JDBC (sem Spring)

API REST construída com Java puro, sem nenhum framework. Usa `com.sun.net.httpserver.HttpServer` para o servidor HTTP e JDBC + SQLite para o banco de dados.

## Stack

- Java 21
- HttpServer (JDK embutido)
- JDBC
- SQLite
- Gson (JSON)

## Features

- CRUD completo de usuários
- CRUD completo de hábitos
- Endpoints REST (GET, POST, PUT, DELETE)
- JSON request/response
- SQLite como banco de dados
- Zero frameworks

## Como rodar

```bash
mvn clean compile exec:java -Dexec.mainClass="com.api.ApiServer"
```

## Endpoints

```
GET    /api/users          → Listar todos
POST   /api/users          → Criar
GET    /api/users/{id}     → Buscar por ID
PUT    /api/users/{id}     → Atualizar
DELETE /api/users/{id}     → Deletar

GET    /api/habits         → Listar todos
POST   /api/habits         → Criar
GET    /api/habits/{id}    → Buscar por ID
PUT    /api/habits/{id}    → Atualizar
DELETE /api/habits/{id}    → Deletar
```

## Testar

```bash
curl http://localhost:8080/api/users
curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{"name":"André","email":"a@a.com"}'
```
