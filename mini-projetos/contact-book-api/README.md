# Contact Book API

API REST para agenda de contatos com organização em grupos e autenticação JWT.

## Stack

- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Spring Security + JWT

## Funcionalidades

- CRUD de contatos (nome, email, telefone)
- Organização em grupos (família, trabalho, amigos)
- Autenticação JWT por usuário
- Busca por nome ou grupo
- Paginação e ordenação

## Como rodar

```bash
docker run -d --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres
./mvnw spring-boot:run
```

## Endpoints

| Método | Rota                       | Descrição         |
|--------|----------------------------|--------------------|
| POST   | /api/auth/register         | Registrar          |
| POST   | /api/auth/login            | Login              |
| GET    | /api/contatos              | Listar contatos    |
| POST   | /api/contatos              | Criar contato      |
| PUT    | /api/contatos/{id}         | Atualizar contato  |
| DELETE | /api/contatos/{id}         | Deletar contato    |
| GET    | /api/grupos                | Listar grupos      |
| POST   | /api/grupos                | Criar grupo        |
