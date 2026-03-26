# API Contatos

API REST para gerenciamento de contatos com Spring Boot e PostgreSQL.

## Stack

- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Bean Validation

## Funcionalidades

- CRUD completo de contatos
- Campos: nome, email, telefone
- Validação de email único
- Busca por nome (LIKE)
- Paginação e ordenação

## Como rodar

```bash
# Subir PostgreSQL (Docker)
docker run -d --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres

# Rodar aplicação
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080/api/contatos`.

## Endpoints

| Método | Rota                  | Descrição        |
|--------|-----------------------|------------------|
| GET    | /api/contatos         | Listar contatos  |
| GET    | /api/contatos/{id}    | Buscar por ID    |
| GET    | /api/contatos/busca   | Buscar por nome  |
| POST   | /api/contatos         | Criar contato    |
| PUT    | /api/contatos/{id}    | Atualizar contato|
| DELETE | /api/contatos/{id}    | Deletar contato  |
