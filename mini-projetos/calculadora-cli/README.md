# Calculadora CLI

Calculadora de linha de comando desenvolvida em Java, operando via terminal com interação do usuário.

## Stack

- Java 17+
- Scanner (java.util)

## Funcionalidades

- Operações: soma, subtração, multiplicação e divisão
- Input do usuário via `Scanner`
- Loop contínuo até o usuário sair
- Tratamento de erros (divisão por zero, input inválido)
- Formatação de resultados decimais

## Como rodar

```bash
javac -d out src/Main.java
java -cp out Main
```

## Estrutura

```
calculadora-cli/
├── src/
│   └── Main.java
└── README.md
```
