# Task Manager API

API REST para gerenciamento de tarefas com autenticação JWT e documentação Swagger.

## Stack

- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Spring Security + JWT
- SpringDoc OpenAPI (Swagger)

## Funcionalidades

- CRUD de tarefas
- Campos: título, descrição, status, prioridade
- Filtro por status e prioridade
- Autenticação JWT
- Documentação Swagger em `/swagger-ui.html`

## Como rodar

```bash
docker run -d --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres
./mvnw spring-boot:run
```

Documentação: `http://localhost:8080/swagger-ui.html`

## Endpoints

| Método | Rota               | Descrição         |
|--------|--------------------|-------------------|
| POST   | /api/auth/register | Registrar         |
| POST   | /api/auth/login    | Login             |
| GET    | /api/tasks         | Listar tarefas    |
| POST   | /api/tasks         | Criar tarefa      |
| PUT    | /api/tasks/{id}    | Atualizar tarefa  |
| DELETE | /api/tasks/{id}    | Deletar tarefa    |
