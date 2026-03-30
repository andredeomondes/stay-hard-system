# 📚 JDBC + TRANSACTIONS

## O que é JDBC?
Java Database Connectivity — API padrão do Java para conectar com bancos.

## Fluxo JDBC:
```
1. Carregar driver
2. Criar conexão
3. Criar statement
4. Executar query
5. Processar resultado
6. Fechar recursos
```

## Exemplo completo:
```java
import java.sql.*;

public class UserRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/stayhard";
    private static final String USER = "postgres";
    private static final String PASS = "123";

    // CREATE
    public void save(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // READ
    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email")
                );
            }
            return null;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // READ ALL
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    // UPDATE
    public void update(User user) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

## Transactions

### O que são?
Conjunto de operações que devem acontecer juntas ou não acontecer.

### ACID:
- **A**tomicity — tudo ou nada
- **C**onsistency — dados válidos
- **I**solation — operações isoladas
- **D**urability — persistido após commit

### Exemplo de transação:
```java
Connection conn = DriverManager.getConnection(URL, USER, PASS);
conn.setAutoCommit(false);  // Iniciar transação

try {
    // Debitar da conta A
    PreparedStatement debito = conn.prepareStatement(
        "UPDATE accounts SET balance = balance - ? WHERE id = ?"
    );
    debito.setDouble(1, 100.0);
    debito.setInt(2, 1);
    debito.executeUpdate();

    // Creditar na conta B
    PreparedStatement credito = conn.prepareStatement(
        "UPDATE accounts SET balance = balance + ? WHERE id = ?"
    );
    credito.setDouble(1, 100.0);
    credito.setInt(2, 2);
    credito.executeUpdate();

    conn.commit();  // Confirma transação
} catch (SQLException e) {
    conn.rollback();  // Desfaz tudo
    throw e;
} finally {
    conn.setAutoCommit(true);
    conn.close();
}
```

## PreparedStatement (SEGURANÇA!)
```java
// ❌ NUNCA use concatenação (SQL Injection!)
String sql = "SELECT * FROM users WHERE name = '" + input + "'";

// ✅ SEMPRE use PreparedStatement
PreparedStatement stmt = conn.prepareStatement(
    "SELECT * FROM users WHERE name = ?"
);
stmt.setString(1, input);
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
