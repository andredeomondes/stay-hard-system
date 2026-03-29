# 📚 MAVEN — Build Tool & Dependency Manager

## O que é?

**Maven** é uma ferramenta para:
1. **Build** — Compilar, testar, empacotar projetos Java
2. **Gerenciar dependências** — Baixar libs automaticamente
3. **Padronizar projetos** — Estrutura de pastas convencionada

## Alternativas

| Ferramenta | Linguagem | Características |
|------------|-----------|----------------|
| **Maven** | Java | XML, mais antigo |
| **Gradle** | Java/Kotlin | Groovy/Kotlin DSL, mais moderno |
| **npm** | JavaScript | Para Node.js |
| **pip** | Python | Para Python |

## Estrutura de Pastas

```
meu-projeto/
├── pom.xml                 ← Configuração do Maven
├── src/
│   ├── main/
│   │   ├── java/          ← Código fonte (.java)
│   │   └── resources/     ← Arquivos de config (.properties, .xml)
│   └── test/
│       └── java/          ← Testes (.java)
├── target/                 ← Compilação e build (gerado)
└── .gitignore
```

## pom.xml — Project Object Model

### Estrutura básica:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
    <!-- Versão do POM (sempre 4.0.0) -->
    <modelVersion>4.0.0</modelVersion>
    
    <!-- Identificação do projeto -->
    <groupId>com.empresa</groupId>       <!-- Domínio invertido -->
    <artifactId>meu-app</artifactId>     <!-- Nome do projeto -->
    <version>1.0.0</version>            <!-- Versão -->
    <packaging>jar</packaging>           <!-- Tipo: jar, war, pom -->
    
    <!-- Propriedades -->
    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <!-- Dependências -->
    <dependencies>
        <!-- Cada dependência é um artefato -->
    </dependencies>
    
    <!-- Build e plugins -->
    <build>
        <plugins>
            <!-- Plugins de build -->
        </plugins>
    </build>
    
</project>
```

## groupId, artifactId, version

```
groupId:artifactId:version
└─┬─┘   └─────┬─────┘  └───┘
  │           │          │
  │     Nome do projeto   │
  │                    Versão
  │
  └─ Domínio invertido (com.empresa)
```

**Exemplo:**
```xml
<groupId>com.stayhard</groupId>
<artifactId>stay-hard-system</artifactId>
<version>1.0.0</version>
```

**Coordinates Maven:**
```
com.stayhard:stay-hard-system:1.0.0
```

## Dependências

### Sintaxe:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
    
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.30</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### Scopes (Escopos):

| Scope | Uso | Bundled in JAR? |
|--------|-----|----------------|
| `compile` | Padrão, em todo lugar | ✅ Sim |
| `test` | Só em src/test | ❌ Não |
| `provided` | Fornecido pelo container | ❌ Não |
| `runtime` | Não para compilar, sim para executar | ✅ Sim |

### Repositórios:

```
Maven Central: https://repo.maven.apache.org/maven2/
              (padrão, automático)
```

## Lifecycle (Ciclo de Vida)

### Principais lifecycle phases:

```
┌─────────────────────────────────────────────┐
│ validate     → Valida projeto               │
├─────────────────────────────────────────────┤
│ compile      → Compila src/main/java       │
├─────────────────────────────────────────────┤
│ test         → Roda testes (src/test/java) │
├─────────────────────────────────────────────┤
│ package      → Gera JAR/WAR                │
├─────────────────────────────────────────────┤
│ install      → Instala no repositório local │
├─────────────────────────────────────────────┤
│ deploy       → Publica em servidor remoto   │
└─────────────────────────────────────────────┘
```

### Comandos:

```bash
# Limpa compilação anterior
mvn clean

# Compila o projeto
mvn compile

# Compila + testa
mvn test

# Limpa + compila + testa + gera JAR
mvn clean test

# Gera JAR
mvn package

# Limpa + compila + testa + gera JAR + instala no repositório local
mvn clean install

# Mostra dependências resolvidas
mvn dependency:tree
```

## Spring Boot Parent (Atalho)

### Em vez de declarar cada dependência:

```xml
<!-- Modo difícil (todas as versões manual) -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>3.2.0</version>
    </dependency>
    <!-- Todas as sub-dependencies manual -->
</dependencies>
```

### Usar Spring Boot Parent (atalho):

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.4.3</version>
</parent>

<dependencies>
    <!-- Versões gerenciadas pelo parent! -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <!-- versão omitida, usa a do parent -->
    </dependency>
</dependencies>
```

## Plugins

### maven-compiler-plugin:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.11.0</version>
    <configuration>
        <source>21</source>
        <target>21</target>
    </configuration>
</plugin>
```

### maven-surefire-plugin (testes):

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.2.0</version>
</plugin>
```

### Spring Boot Maven Plugin:

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

## Estrutura Completa pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project>
    <modelVersion>4.0.0</modelVersion>
    
    <!-- Spring Boot Parent (gerencia versões) -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.3</version>
    </parent>
    
    <!-- Identificação -->
    <groupId>com.stayhard</groupId>
    <artifactId>stay-hard-system</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>
    <name>Stay Hard System</name>
    <description>Sistema de tracking de hábitos</description>
    
    <!-- Propriedades -->
    <properties>
        <java.version>21</java.version>
    </properties>
    
    <!-- Dependências -->
    <dependencies>
        <!-- Spring Boot Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <!-- JUnit para testes -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <!-- Build -->
    <build>
        <plugins>
            <!-- Spring Boot Plugin -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            
            <!-- Test Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

## Maven Wrapper (mvnw)

### O que é?

Wrapper que inclui o Maven junto com o projeto. others podem rodar sem ter Maven instalado.

### Criar:

```bash
mvn wrapper:wrapper
```

### Usar:

```bash
# No Linux/Mac
./mvnw clean install

# No Windows
mvnw.cmd clean install
```

## Repositório Local (.m2)

```
Windows: C:\Users\usuario\.m2\repository
Linux/Mac: ~/.m2/repository

├── com/
│   └── empresa/
│       └── meu-app/
│           └── 1.0.0/
│               └── meu-app-1.0.0.jar
├── junit/
│   └── junit/
│       └── 4.13.2/
│           └── junit-4.13.2.jar
```

## Dica: Gerar projeto rápido

```bash
# Criar projeto Maven archetype padrão
mvn archetype:generate \
    -DgroupId=com.empresa \
    -DartifactId=meu-app \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DinteractiveMode=false
```

## Comandos Essenciais — Resumo

```bash
# Compilar
mvn compile

# Testar
mvn test

# Limpar + compilar + testar
mvn clean test

# Gerar JAR
mvn package

# Limpar + compilar + testar + gerar + instalar
mvn clean install

# Ver árvore de dependências
mvn dependency:tree

# Rodar aplicação (Spring Boot)
mvn spring-boot:run

# Pular testes
mvn clean install -DskipTests
```

## Próximo passo

Criar o primeiro projeto Maven na prática (Calculadora).
