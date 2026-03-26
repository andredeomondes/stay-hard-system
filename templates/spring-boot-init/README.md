# Spring Boot Init Template

Template básico para iniciar projetos Spring Boot rapidamente.

## Como usar

1. Copie esta pasta para seu novo projeto
2. Renomeie o groupId/artifactId no pom.xml
3. Renomeie o package em src/main/java
4. `mvn spring-boot:run`

## Stack

- Java 21
- Spring Boot 3.4
- Spring Web
- Spring Data JPA
- PostgreSQL (prod) + H2 (test)
- Lombok
- Validation

## Estrutura

```
src/
├── main/
│   ├── java/com/template/
│   │   ├── Application.java
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── domain/
│   │   │   ├── entity/
│   │   │   └── enums/
│   │   ├── dto/
│   │   │   ├── request/
│   │   │   └── response/
│   │   ├── exception/
│   │   └── config/
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/template/
```
