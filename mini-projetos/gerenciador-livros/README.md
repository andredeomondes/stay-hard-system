# Gerenciador de Livros

API REST para gerenciamento de biblioteca pessoal com busca avançada.

## Stack

- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Bean Validation

## Funcionalidades

- CRUD de livros (título, autor, ISBN, ano de publicação)
- Busca por título ou autor
- Filtro por ano de publicação
- Paginação e ordenação
- Validação de ISBN único

## Como rodar

```bash
docker run -d --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080/api/livros`.

## Endpoints

| Método | Rota                 | Descrição         |
|--------|----------------------|-------------------|
| GET    | /api/livros          | Listar livros     |
| GET    | /api/livros/busca    | Buscar por título |
| GET    | /api/livros/{id}     | Buscar por ID     |
| POST   | /api/livros          | Criar livro       |
| PUT    | /api/livros/{id}     | Atualizar livro   |
| DELETE | /api/livros/{id}     | Deletar livro     |
