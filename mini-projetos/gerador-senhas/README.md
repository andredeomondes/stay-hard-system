# Gerador de Senhas

Gerador de senhas aleatórias e seguras em Java, com opções de configuração.

## Stack

- Java 17+
- SecureRandom (java.security)
- Clipboard API (java.awt)

## Funcionalidades

- Configurar tamanho da senha
- Incluir/excluir maiúsculas, minúsculas, números e símbolos
- Gerar múltiplas senhas de uma vez
- Copiar senha gerada para o clipboard
- Indicador de força da senha

## Como rodar

```bash
javac -d out src/*.java
java -cp out Main --size 16 --uppercase --numbers --symbols
```

## Estrutura

```
gerador-senhas/
├── src/
│   ├── PasswordGenerator.java
│   ├── PasswordConfig.java
│   └── Main.java
└── README.md
```
