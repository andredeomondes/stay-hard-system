# Blog Simples

Blog básico com interface web renderizada via Thymeleaf e Spring Boot.

## Stack

- Spring Boot 3
- Spring Data JPA
- H2 Database
- Thymeleaf

## Funcionalidades

- Listar posts na página inicial
- Criar novo post (título, conteúdo, data)
- Visualizar post completo
- Editar e deletar posts
- Interface HTML simples e responsiva

## Como rodar

```bash
./mvnw spring-boot:run
```

Acesse `http://localhost:8080` no navegador.

## Estrutura

```
blog-simples/
├── src/main/java/com/blog/
│   ├── controller/
│   ├── model/
│   ├── repository/
│   └── service/
├── src/main/resources/
│   ├── templates/     (Thymeleaf)
│   └── application.properties
└── README.md
```
