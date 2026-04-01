# DIA 36-40 - POO & Exceptions

**Data:** 01/04/2026 ✅

---

## O que aprendi:

### Dia 36: Encapsulamento
```java
private String nome;
public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }
```

### Dia 37: Herança
```java
class Funcionario extends Pessoa { }
```

### Dia 38: Polimorfismo
```java
class Cao extends Animal {
    @Override
    void som() { System.out.println("Au au!"); }
}
```

### Dia 39: Interfaces
```java
interface Pagavel {
    double calcular();
}
class Produto implements Pagavel { }
```

### Dia 40: Exceptions
```java
try { } catch (Exception e) { }
throw new RuntimeException("Erro");
```

---

## Reflexão: