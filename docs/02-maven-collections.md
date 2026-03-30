# 📚 MAVEN + COLLECTIONS

## Maven

### O que é?
Ferramenta de build e gerenciamento de dependências para Java.

### Por que usar?
- Baixa dependências automaticamente
- Compila o projeto
- Roda testes
- Gera JAR/WAR

### Estrutura Maven:
```
meu-projeto/
├── pom.xml                    ← configuração do projeto
├── src/
│   ├── main/
│   │   ├── java/              ← código fonte
│   │   └── resources/         ← configurações
│   └── test/
│       └── java/              ← testes
└── target/                    ← build output (gerado)
```

### Comandos essenciais:
```bash
mvn clean          # limpa target/
mvn compile        # compila
mvn test           # roda testes
mvn package        # gera JAR
mvn clean install  # limpa, compila, testa, gera JAR
mvn dependency:tree # mostra dependências
```

### pom.xml básico:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.meuprojeto</groupId>
    <artifactId>meu-app</artifactId>
    <version>1.0.0</version>
    
    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.2</version>
        </dependency>
    </dependencies>
</project>
```

---

## Collections (Java)

### Hierarquia:
```
Iterable
    └── Collection
            ├── List (ArrayList, LinkedList)
            ├── Set (HashSet, TreeSet)
            └── Queue (PriorityQueue, Deque)
Map (HashMap, TreeMap)
```

### List:
```java
List<String> nomes = new ArrayList<>();
nomes.add("André");
nomes.add("Maria");
nomes.get(0);        // "André"
nomes.size();        // 2
nomes.contains("Ana"); // false
```

### Set (não permite duplicatas):
```java
Set<String> unique = new HashSet<>();
unique.add("A");
unique.add("B");
unique.add("A");  // ignora (já existe)
unique.size();    // 2
```

### Map (chave-valor):
```java
Map<String, Integer> idade = new HashMap<>();
idade.put("André", 25);
idade.put("Maria", 30);
idade.get("André");    // 25
idade.containsKey("João"); // false
```

### Streams API:
```java
// Filtrar
list.stream()
    .filter(x -> x > 10)
    .collect(Collectors.toList());

// Mapear
list.stream()
    .map(x -> x * 2)
    .collect(Collectors.toList());

// Reduzir
list.stream()
    .reduce(0, (a, b) -> a + b);
```

### forEach:
```java
list.forEach(item -> System.out.println(item));
// ou
list.forEach(System.out::println);
```

---

## 📝 ANOTAÇÕES PESSOAIS

### O que aprendi hoje:
> 


### Pontos importantes:
> 


### Dúvidas:
> 


### Como aplicar no Stay Hard:
> 

---
