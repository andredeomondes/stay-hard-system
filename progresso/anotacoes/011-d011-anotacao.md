# 📝 DIA 11 — Anotações

**Data:** __ / __ / 2026

---

## O que aprendi:

### Maven
Ferramenta de build e gerenciamento de dependências do Java.

### Estrutura Maven
```
meu-projeto/
├── pom.xml              ← configuração
├── src/
│   ├── main/java/      ← código fonte
│   └── test/java/      ← testes
└── target/              ← build gerado
```

### Commands
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.estudo.App"
```

### pom.xml básico
```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.estudo</groupId>
    <artifactId>maven-basic</artifactId>
    <version>1.0.0</version>
</project>
```

---

## Reflexão:

> (sua reflexão sobre o dia)
