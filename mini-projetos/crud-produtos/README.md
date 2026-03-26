# CRUD Produtos

API REST para gerenciamento de produtos com Spring Boot e banco H2 em memória.

## Stack

- Spring Boot 3
- Spring Data JPA
- H2 Database
- Bean Validation

## Funcionalidades

- Criar, listar, atualizar e deletar produtos
- Campos: nome, preço, quantidade em estoque
- Validação de campos obrigatórios
- Paginação na listagem
- Console H2 em `/h2-console`

## Como rodar

```bash
./mvnw spring-boot:run

# Ou com Gradle
./gradlew bootRun
```

A API estará disponível em `http://localhost:8080/api/produtos`.

## Endpoints

| Método | Rota                   | Descrição         |
|--------|------------------------|-------------------|
| GET    | /api/produtos          | Listar produtos   |
| GET    | /api/produtos/{id}     | Buscar por ID     |
| POST   | /api/produtos          | Criar produto     |
| PUT    | /api/produtos/{id}     | Atualizar produto |
| DELETE | /api/produtos/{id}     | Deletar produto   |
