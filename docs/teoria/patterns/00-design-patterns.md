# 📚 DESIGN PATTERNS — Os 6 Mais Usados

## O que são?

**Design Patterns** são soluções reutilizáveis para problemas comuns em orientação a objetos.

```
Problema comum → Pattern (solução testada)
```

## Os 6 Patterns Mais Importantes

| # | Pattern | Quando usar | Exemplo no Stay Hard |
|---|---------|------------|---------------------|
| 1 | **Strategy** | Trocar algoritmos em runtime | LevelService |
| 2 | **Repository** | Separar lógica de acesso a dados | UserRepository |
| 3 | **Factory** | Criar objetos complexos | HabitFactory |
| 4 | **Observer** | Notificar múltiplos objetos | Eventos |
| 5 | **Singleton** | Uma única instância global | Logger |
| 6 | **Builder** | Construir objetos com muitos campos | UserBuilder |

---

## 1. STRATEGY — Trocar Comportamento

### Problema:
Você precisa trocar o algoritmo/regra em tempo de execução.

### Solução Strategy:
```java
// Interface para estratégia
interface LevelStrategy {
    String getLevelName(int daysCompleted);
}

// Estratégia concreta 1
class LowLevelStrategy implements LevelStrategy {
    @Override
    public String getLevelName(int daysCompleted) {
        return "Awakening";
    }
}

// Estratégia concreta 2
class MediumLevelStrategy implements LevelStrategy {
    @Override
    public String getLevelName(int daysCompleted) {
        if (daysCompleted >= 15) return "Relentless";
        return "Forged";
    }
}

// Estratégia concreta 3
class HighLevelStrategy implements LevelStrategy {
    @Override
    public String getLevelName(int daysCompleted) {
        if (daysCompleted >= 75) return "Stay Hard";
        return "Unbreakable";
    }
}

// Contexto que usa a estratégia
class LevelService {
    private LevelStrategy strategy;
    
    public LevelService(LevelStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void setStrategy(LevelStrategy strategy) {
        this.strategy = strategy;
    }
    
    public String getLevelName(int days) {
        return strategy.getLevelName(days);
    }
}
```

### Uso:
```java
LevelService service = new LevelService(new LowLevelStrategy());
System.out.println(service.getLevelName(5)); // "Awakening"

// Trocar estratégia em runtime!
service.setStrategy(new HighLevelStrategy());
System.out.println(service.getLevelName(80)); // "Stay Hard"
```

### Quando usar:
- [ ] Precisa trocar algoritmos em runtime
- [ ] Tem múltiplas variações de um comportamento
- [ ] quer evitar muitos `if/else`

---

## 2. REPOSITORY — Separar Acesso a Dados

### Problema:
A lógica de negócio sabe demais sobre como os dados são armazenados.

### Solução Repository:
```java
// Interface do repositório (contrato)
interface UserRepository {
    User findById(Long id);
    User findByEmail(String email);
    List<User> findAll();
    void save(User user);
    void delete(Long id);
}

// Implementação com CSV (arquivo)
class CsvUserRepository implements UserRepository {
    private String filename = "users.csv";
    
    @Override
    public User findByEmail(String email) {
        // Lógica para ler CSV e buscar por email
        return null;
    }
    
    @Override
    public void save(User user) {
        // Lógica para salvar no CSV
    }
}

// Implementação com JDBC (banco)
class JdbcUserRepository implements UserRepository {
    @Override
    public User findByEmail(String email) {
        // Lógica para ler do banco
        return null;
    }
    
    @Override
    public void save(User user) {
        // Lógica para salvar no banco
    }
}

// Serviço que usa o repositório (não sabe como é implementado!)
class UserService {
    private UserRepository repository;
    
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
```

### Uso:
```java
// Trocar CSV por JDBC sem mudar o service!
// Production
UserRepository repo = new JdbcUserRepository();
UserService service = new UserService(repo);

// Testing
UserRepository fakeRepo = new InMemoryUserRepository();
UserService testService = new UserService(fakeRepo);
```

### Quando usar:
- [ ] Precisa trocar fonte de dados (CSV → DB)
- [ ] Quer facilitar testes com repositórios falsos
- [ ] Separação clara entre lógica e persistência

---

## 3. FACTORY — Criar Objetos

### Problema:
Você tem regras complexas para criar um objeto.

### Solução Factory:
```java
// Classe que representa prioridade
enum Priority {
    HIGH, MEDIUM, LOW
}

// Classe Habit
class Habit {
    private String name;
    private Priority priority;
    private Status status;
    
    private Habit(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
        this.status = Status.TODO;
    }
    
    // getters...
}

// Factory para criar Habits
class HabitFactory {
    
    // Método para criar hábito
    public static Habit createHabit(String name, String priorityStr) {
        // Validação
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        
        // Converter string para enum
        Priority priority = parsePriority(priorityStr);
        
        // Criar hábito
        return new Habit(name, priority);
    }
    
    private static Priority parsePriority(String priorityStr) {
        if (priorityStr == null) {
            return Priority.MEDIUM; // Padrão
        }
        
        return switch (priorityStr.toUpperCase()) {
            case "HIGH" -> Priority.HIGH;
            case "LOW" -> Priority.LOW;
            default -> Priority.MEDIUM;
        };
    }
    
    // Factory method para criar hábito do tipo HIGH
    public static Habit createHighPriorityHabit(String name) {
        return new Habit(name, Priority.HIGH);
    }
}
```

### Uso:
```java
// Criar com validação automática
Habit habit = HabitFactory.createHabit("Treinar", "HIGH");

// Criar hábito padrão HIGH
Habit dailyHabit = HabitFactory.createHighPriorityHabit("Diário");
```

### Quando usar:
- [ ] Lógica complexa para criar objeto
- [ ] Validação necessária na criação
- [ ] Quer controlar quais objetos podem ser criados

---

## 4. OBSERVER — Notificar Múltiplos

### Problema:
Quando algo muda, você quer notificar múltiplos "espectadores".

### Solução Observer:
```java
// Interface para observadores
interface Observer {
    void update(String event);
}

// Classe observável
class EventManager {
    private List<Observer> observers = new ArrayList<>();
    
    // Adicionar observador
    public void subscribe(Observer observer) {
        observers.add(observer);
    }
    
    // Remover observador
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }
    
    // Notificar todos
    public void notify(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}

// Observador concreto 1: Logger
class Logger implements Observer {
    @Override
    public void update(String event) {
        System.out.println("[LOG] Evento: " + event);
    }
}

// Observador concreto 2: Notificação
class Notificador implements Observer {
    @Override
    public void update(String event) {
        if (event.contains("HABIT_COMPLETED")) {
            System.out.println("[NOTIFY] Você completou um hábito!");
        }
    }
}

// Observador concreto 3: Analytics
class Analytics implements Observer {
    @Override
    public void update(String event) {
        System.out.println("[ANALYTICS] Registrando: " + event);
    }
}
```

### Uso:
```java
EventManager eventManager = new EventManager();

eventManager.subscribe(new Logger());
eventManager.subscribe(new Notificador());
eventManager.subscribe(new Analytics());

// Quando hábito for completado:
eventManager.notify("HABIT_COMPLETED user=André habit=Treinar");
```

**Saída:**
```
[LOG] Evento: HABIT_COMPLETED user=André habit=Treinar
[NOTIFY] Você completou um hábito!
[ANALYTICS] Registrando: HABIT_COMPLETED user=André habit=Treinar
```

### Quando usar:
- [ ] Precisa notificar múltiplos componentes
- [ ] Eventos como "hábito completado", "dia finalizado"
- [ ] Logging, analytics, notificações

---

## 5. SINGLETON — Uma Única Instância

### Problema:
Você quer garantir que uma classe tenha apenas uma instância.

### Solução Singleton:

```java
// Singleton Eager (cria na carga)
class LoggerEager {
    private static final LoggerEager instance = new LoggerEager();
    
    private LoggerEager() {
        // Construtor privado!
    }
    
    public static LoggerEager getInstance() {
        return instance;
    }
    
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

// Singleton Lazy (cria quando precisa)
class LoggerLazy {
    private static volatile LoggerLazy instance;
    
    private LoggerLazy() {}
    
    public static LoggerLazy getInstance() {
        if (instance == null) {
            synchronized (LoggerLazy.class) {
                if (instance == null) {
                    instance = new LoggerLazy();
                }
            }
        }
        return instance;
    }
    
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
```

### Uso:
```java
// Mesmo em threads diferentes, é a mesma instância!
LoggerLazy logger1 = LoggerLazy.getInstance();
LoggerLazy logger2 = LoggerLazy.getInstance();

System.out.println(logger1 == logger2); // true
```

### Quando usar:
- [ ] Logger (um único log para todo app)
- [ ] Configuration (uma config global)
- [ ] Connection Pool (uma pool de conexões)

### ⚠️ Cuidado:
- Difícil de testar
- Acopla código
- Use com moderação!

---

## 6. BUILDER — Construir Objetos Complexos

### Problema:
Construtor com muitos parâmetros é confuso.

### Solução Builder:

```java
// Classe com muitos campos
class User {
    private String name;
    private String email;
    private int age;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    
    // Construtor privado (só o builder pode criar)
    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
        this.city = builder.city;
        this.state = builder.state;
        this.country = builder.country;
        this.zipCode = builder.zipCode;
    }
    
    // Getters...
    
    // Builder como classe interna
    public static class Builder {
        private String name;
        private String email;
        private int age = 0;
        private String phone;
        private String address;
        private String city;
        private String state;
        private String country;
        private String zipCode;
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        
        // ... outros setters
        
        public User build() {
            // Validação
            if (name == null || email == null) {
                throw new IllegalStateException("name e email são obrigatórios");
            }
            return new User(this);
        }
    }
}
```

### Uso:
```java
// Forma 1: Com Builder (legível!)
User user = new User.Builder()
    .name("André de Omondes")
    .email("andre@email.com")
    .age(25)
    .city("São Paulo")
    .build();

// Forma 2: Telescoping constructor (HORRÍVEL!)
User user = new User("André", "andre@email.com", 25, null, null, "SP", null, null, null);
```

### Quando usar:
- [ ] Classe com mais de 4-5 parâmetros
- [ ] Parâmetros opcionais
- [ ] Validação na construção

---

## Resumo Visual

```
STRATEGY:    ┌─────────┐     ┌──────────────┐
             │ Contexto│────→│  Estratégia  │
             └─────────┘     │  (interface) │
                            └──────┬───────┘
                                   │
              ┌────────────────────┼────────────────────┐
              ▼                    ▼                    ▼
         ┌─────────┐          ┌─────────┐          ┌─────────┐
         │Estratégia│          │Estratégia│          │Estratégia│
         │    A    │          │    B    │          │    C    │
         └─────────┘          └─────────┘          └─────────┘

REPOSITORY:  ┌──────────┐     ┌────────────────┐     ┌─────────┐
             │ Serviço  │────→│  Repositório   │────→│   DB    │
             └──────────┘     │  (interface)    │     └─────────┘
                              └────────────────┘
                                       │
              ┌────────────────────────┼────────────────────────┐
              ▼                        ▼                        ▼
         ┌─────────┐            ┌─────────┐            ┌─────────┐
         │  CSV    │            │  JDBC   │            │   JPA   │
         └─────────┘            └─────────┘            └─────────┘
```

## Próximo passo

Aplicar esses patterns no **Stay Hard System**!
