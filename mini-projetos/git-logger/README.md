# Git Logger

Ferramenta CLI que exibe o histórico de commits de um repositório Git de forma customizada.

## Stack

- Java 17+
- ProcessBuilder (java.lang)

## Funcionalidades

- Executa `git log` via ProcessBuilder
- Exibe hash, autor, data e mensagem do commit
- Output colorido no terminal (ANSI codes)
- Filtro por autor ou período
- Formatação em tabela

## Como rodar

```bash
javac -d out src/*.java
java -cp out GitLogger

# Com opções
java -cp out GitLogger --author "João" --since "2025-01-01"
```

## Estrutura

```
git-logger/
├── src/
│   ├── GitLogger.java
│   ├── GitCommand.java
│   └── ColorFormatter.java
└── README.md
```
