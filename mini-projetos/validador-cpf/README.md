# Validador de CPF

Validação de CPF brasileiro usando o algoritmo oficial dos dígitos verificadores.

## Stack

- Java 17+
- JUnit 5

## Funcionalidades

- Validação dos 11 dígitos do CPF
- Algoritmo dos dígitos verificadores (módulo 11)
- Formatação com máscara (XXX.XXX.XXX-XX)
- Rejeita CPFs com todos dígitos iguais
- Testes unitários cobrindo cenários válidos e inválidos

## Como rodar

```bash
javac -d out src/*.java
java -cp out Main 123.456.789-09

# Rodar testes
./mvnw test
```

## Estrutura

```
validador-cpf/
├── src/
│   ├── CpfValidator.java
│   └── Main.java
├── src/test/
│   └── CpfValidatorTest.java
└── README.md
```
