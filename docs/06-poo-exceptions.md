# 📚 POO + EXCEPTIONS

## Pillares da POO

### 1. Encapsulamento
Proteger dados, expor apenas o necessário.

```java
public class User {
    private String name;
    private String email;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

### 2. Herança
Reutilizar código entre classes.

```java
public class Funcionario extends Pessoa {
    private double salario;
}

public class Gerente extends Funcionario {
    private int equipe;
}
```

### 3. Polimorfismo
Mesma ação, comportamentos diferentes.

```java
// Sobrescrita
class Animal {
    void som() { }
}

class Cao extends Animal {
    @Override
    void som() { System.out.println("Au au!"); }
}

class Gato extends Animal {
    @Override
    void som() { System.out.println("Miau!"); }
}

// Uso
Animal a1 = new Cao();
Animal a2 = new Gato();
a1.som(); // Au au!
a2.som(); // Miau!
```

### 4. Abstração
Esconder complexidade, mostrar apenas essência.

```java
// Interface
interface Pagavel {
    double calcularValor();
}

// Classe abstrata
abstract class Forma {
    abstract double area();
}
```

## Interfaces vs Classes Abstratas

| Interface | Classe Abstrata |
|-----------|-----------------|
| 100% abstrata | pode ter concreto |
| múltiplas | uma só |
| contratos | contratos + esqueleto |

```java
// Interface
interface Database {
    void connect();
    void disconnect();
    List<Map<String, Object>> query(String sql);
}

// Implementação
class PostgreSQL implements Database {
    public void connect() { /* ... */ }
    public void disconnect() { /* ... */ }
    public List<Map<String, Object>> query(String sql) { /* ... */ }
}
```

## Exceptions

### Tipos:
```
Throwable
├── Error (system errors - não tratar)
└── Exception
    ├── RuntimeException (unchecked)
    └── IOException (checked)
```

### Try-Catch:
```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Erro: " + e.getMessage());
} finally {
    System.out.println("Sempre executa");
}
```

### Throw vs Throws:
```java
// throw = lançar exceção
throw new IllegalArgumentException("Valor inválido");

// throws = declarar que pode lançar
public void salvar() throws IOException {
    // código que pode lançar IOException
}
```

### Exception personalizada:
```java
public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(int id) {
        super("Usuário com ID " + id + " não encontrado");
    }
}

// Uso
if (user == null) {
    throw new UsuarioNaoEncontradoException(id);
}
```

### Boa prática:
```java
// ❌ Catch genérico
catch (Exception e) {
    e.printStackTrace();
}

// ✅ Catch específico
catch (SQLException e) {
    throw new DatabaseException("Erro ao salvar usuário", e);
}
```

## Classes Utilitárias

### Records (Java 16+):
```java
// Imutável,自动 getters, equals, hashCode, toString
public record UserDTO(String name, String email, int age) {}

// Uso
UserDTO user = new UserDTO("André", "andre@email.com", 25);
user.name();    // getter
```

### Enum:
```java
public enum Prioridade {
    LOW(1),
    MEDIUM(2),
    HIGH(3);
    
    private final int nivel;
    
    Prioridade(int nivel) {
        this.nivel = nivel;
    }
    
    public int getNivel() { return nivel; }
}

// Uso
Prioridade p = Prioridade.HIGH;
p.getNivel(); // 3
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
