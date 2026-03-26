# 📚 FASE 0 — Fundação + GitHub

## Maven

### O que é Maven?
Ferramenta de build e gerenciamento de dependências para Java.

### Estrutura Maven
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

### Comandos essenciais
```bash
mvn clean          # limpa target/
mvn compile        # compila
mvn test           # roda testes
mvn package        # gera JAR
mvn clean install  # limpa, compila, testa, gera JAR
```

### pom.xml básico
```xml
<groupId>com.meuprojeto</groupId>
<artifactId>meu-app</artifactId>
<version>1.0.0</version>

<dependencies>
    <!-- Dependências aqui -->
</dependencies>
```

---

## Git Avançado

### Conventional Commits
```
feat: adiciona nova funcionalidade
fix: corrige bug
refactor: melhora código sem mudar comportamento
docs: documentação
test: adiciona testes
chore: configuração, dependências
style: formatação
```

### Branches
```bash
git checkout -b feature/login    # cria branch
git checkout main                # volta para main
git merge feature/login          # merge
git branch -d feature/login      # deleta branch
```

---

## JUnit 5

### Anotações
```java
@Test              // método de teste
@BeforeEach        // roda antes de cada teste
@AfterEach         // roda depois de cada teste
@DisplayName       // nome legível do teste
@ParameterizedTest // teste parametrizado
```

### Assertions
```java
assertEquals(expected, actual);
assertTrue(condition);
assertFalse(condition);
assertNull(object);
assertNotNull(object);
assertThrows(Exception.class, () -> method());
```

### Exemplo
```java
class UserTest {
    @Test
    @DisplayName("Deve criar usuário com nome válido")
    void shouldCreateUser() {
        User user = new User("André");
        assertEquals("André", user.getName());
    }

    @Test
    @DisplayName("Deve lançar exceção para nome nulo")
    void shouldThrowForNullName() {
        assertThrows(IllegalArgumentException.class, () -> new User(null));
    }
}
```

---

## Clean Code

### Naming
```
✅ camelCase para variáveis e métodos: calculateTotal()
✅ PascalCase para classes: UserService
✅ UPPER_SNAKE para constantes: MAX_SIZE
✅ nomes descritivos: daysCompleted (não dc)
```

### SRP (Single Responsibility)
```
✅ Cada classe faz UMA coisa
✅ UserService → lógica de usuário
✅ HabitService → lógica de hábitos
❌ UserManagerAndEmailSenderAndReportGenerator
```

### DRY (Don't Repeat Yourself)
```
✅ Extrair código repetido em métodos
✅ Usar herança ou composição
❌ Copiar e colar código
```
