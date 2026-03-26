# 📚 FASE 1 — Java Backend + Banco de Dados

## SQL Essencial

### DDL (Data Definition Language)
```sql
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT NOW()
);

ALTER TABLE users ADD COLUMN age INT;
DROP TABLE users;
```

### DML (Data Manipulation Language)
```sql
INSERT INTO users (name, email) VALUES ('André', 'andre@email.com');
UPDATE users SET name = 'André Omondes' WHERE id = 1;
DELETE FROM users WHERE id = 1;
SELECT * FROM users WHERE id = 1;
```

### JOINs
```sql
-- INNER JOIN: só registros que existem em ambas tabelas
SELECT u.name, h.name as habit_name
FROM users u
INNER JOIN habits h ON u.id = h.user_id;

-- LEFT JOIN: todos da esquerda + matches da direita
SELECT u.name, h.name
FROM users u
LEFT JOIN habits h ON u.id = h.user_id;
```

### GROUP BY
```sql
SELECT priority, COUNT(*) as total
FROM habits
GROUP BY priority
HAVING COUNT(*) > 0;
```

---

## Spring Boot Core

### Inversion of Control (IoC)
O Spring cria e gerencia os objetos (Beans) para você.

```java
// SEM Spring (você cria manualmente)
UserRepository repo = new CsvUserRepository();
UserService service = new UserService(repo);

// COM Spring (Spring cria para você)
@Service
public class UserService {
    private final UserRepository repo;
    
    @Autowired  // Spring injeta automaticamente
    public UserService(UserRepository repo) {
        this.repo = repo;
    }
}
```

### Annotations principais
```java
@Component      // Bean genérico
@Service        // Bean de serviço (lógica de negócio)
@Repository     // Bean de repositório (acesso a dados)
@Controller     // Bean de controller (MVC)
@RestController // Controller que retorna JSON (@Controller + @ResponseBody)
@Configuration  // Classe de configuração
@Bean            // Método que cria Bean
@Autowired      // Injeção de dependência
@Value("${property.name}")  // Valor de application.properties
```

### Bean Scopes
```java
@Scope("singleton")  // padrão — uma instância só
@Scope("prototype")  // nova instância a cada request
```

---

## Spring Data JPA

### Entity
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Habit> habits = new ArrayList<>();
    
    // getters, setters, constructors
}
```

### Relacionamentos
```java
// Um usuário tem muitos hábitos
@OneToMany(mappedBy = "user")
private List<Habit> habits;

// Um hábito pertence a um usuário
@ManyToOne
@JoinColumn(name = "user_id")
private User user;
```

### Repository
```java
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Spring cria a query automaticamente pelo nome do método
    Optional<User> findByEmail(String email);
    List<User> findByNameContaining(String name);
    
    // Query customizada
    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findByName(@Param("name") String name);
}
```

### application.properties (PostgreSQL)
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/stay_hard_db
spring.datasource.username=stayhard
spring.datasource.password=stayhard123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
