# Library API

API REST completa para gerenciamento de biblioteca com livros, autores e empréstimos.

## Stack

- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- SpringDoc OpenAPI (Swagger)

## Funcionalidades

- CRUD de livros, autores e empréstimos
- Relacionamento: livro -> autor, empréstimo -> livro + usuário
- Busca de livros por título ou autor
- Controle de empréstimos (devolução, atraso)
- Documentação Swagger completa

## Como rodar

```bash
docker run -d --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres
./mvnw spring-boot:run
```

Documentação: `http://localhost:8080/swagger-ui.html`

## Endpoints Principais

| Método | Rota                  | Descrição         |
|--------|-----------------------|-------------------|
| GET    | /api/livros           | Listar livros     |
| POST   | /api/livros           | Criar livro       |
| GET    | /api/autores          | Listar autores    |
| POST   | /api/autores          | Criar autor       |
| POST   | /api/emprestimos      | Criar empréstimo  |
| PUT    | /api/emprestimos/{id} | Devolver livro    |
