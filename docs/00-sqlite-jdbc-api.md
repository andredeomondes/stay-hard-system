# 📚 SQLite + JDBC + API sem Spring

## SQLite

### O que é SQLite
Banco de dados leve, serverless, embarcado. Um único arquivo `.db` contém tudo.

### Quando usar
- Projetos pequenos/médios
- Desenvolvimento/testes
- Apps desktop/mobile
- Quando não precisa de PostgreSQL/MySQL

### Instalação
```xml
<!-- pom.xml -->
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.46.0.0</version>
</dependency>
```

### Conexão
```java
// Conectar (cria o arquivo se não existir)
Connection conn = DriverManager.getConnection("jdbc:sqlite:stay_hard.db");
```

### SQL básico (mesmo que PostgreSQL)
```sql
CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (name, email) VALUES ('André', 'andre@email.com');
SELECT * FROM users WHERE id = 1;
UPDATE users SET name = 'André Omondes' WHERE id = 1;
DELETE FROM users WHERE id = 1;
```

---

## JDBC

### O que é JDBC
Java Database Connectivity — API padrão do Java para conectar com bancos de dados.

### Conceitos
```
DriverManager  → gerencia conexões
Connection     → representa uma conexão com o banco
Statement      → executa SQL estático
PreparedStatement → executa SQL com parâmetros (SEGURANÇA!)
ResultSet      → resultado de uma query
```

### Fluxo básico
```java
// 1. Conectar
Connection conn = DriverManager.getConnection("jdbc:sqlite:stay_hard.db");

// 2. Criar statement
PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
stmt.setInt(1, userId);

// 3. Executar query
ResultSet rs = stmt.executeQuery();

// 4. Processar resultado
while (rs.next()) {
    String name = rs.getString("name");
    String email = rs.getString("email");
    System.out.println(name + " - " + email);
}

// 5. Fechar recursos
rs.close();
stmt.close();
conn.close();
```

### PreparedStatement (OBRIGATÓRIO para segurança)
```java
// ❌ NUNCA faça isso (SQL Injection!)
String sql = "SELECT * FROM users WHERE name = '" + userInput + "'";

// ✅ SEMPRE use PreparedStatement
PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE name = ?");
stmt.setString(1, userInput);
ResultSet rs = stmt.executeQuery();
```

### CRUD completo com JDBC
```java
public class UserRepository {

    private final String url = "jdbc:sqlite:stay_hard.db";

    // CREATE
    public void save(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
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
        try (Connection conn = DriverManager.getConnection(url);
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
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
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
        try (Connection conn = DriverManager.getConnection(url);
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
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

### Transações
```java
Connection conn = DriverManager.getConnection(url);
conn.setAutoCommit(false);  // Iniciar transação

try {
    PreparedStatement stmt1 = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
    stmt1.setDouble(1, 100.0);
    stmt1.setInt(2, 1);
    stmt1.executeUpdate();

    PreparedStatement stmt2 = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
    stmt2.setDouble(1, 100.0);
    stmt2.setInt(2, 2);
    stmt2.executeUpdate();

    conn.commit();  // Confirma
} catch (SQLException e) {
    conn.rollback();  // Desfaz em caso de erro
    throw e;
} finally {
    conn.setAutoCommit(true);
    conn.close();
}
```

---

## API sem Spring (HttpServer do JDK)

### O que é
Java tem um `com.sun.net.httpserver.HttpServer` embutido que permite criar APIs REST sem nenhum framework.

### Servidor básico
```java
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.net.InetSocketAddress;

public class ApiServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Registrar endpoints
        server.createContext("/api/users", new UserHandler());
        server.createContext("/api/habits", new HabitHandler());

        server.setExecutor(null);  // usa executor padrão
        server.start();
        System.out.println("Servidor rodando na porta 8080");
    }
}
```

### Handler (GET)
```java
public class UserHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();

        if ("GET".equals(method)) {
            // Buscar todos os usuários
            List<User> users = userRepository.findAll();
            String json = new Gson().toJson(users);

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, json.getBytes().length);
            exchange.getResponseBody().write(json.getBytes());
            exchange.close();
        }
    }
}
```

### Handler (POST)
```java
if ("POST".equals(method)) {
    // Ler body da requisição
    String body = new String(exchange.getRequestBody().readAllBytes());
    CreateUserRequest request = new Gson().fromJson(body, CreateUserRequest.class);

    // Criar usuário
    User user = new User(request.getName(), request.getEmail());
    userRepository.save(user);

    // Retornar resposta
    String json = new Gson().toJson(user);
    exchange.getResponseHeaders().set("Content-Type", "application/json");
    exchange.sendResponseHeaders(201, json.getBytes().length);
    exchange.getResponseBody().write(json.getBytes());
    exchange.close();
}
```

### Handler (DELETE)
```java
if ("DELETE".equals(method)) {
    // Extrair ID da URL: /api/users/123
    String path = exchange.getRequestURI().getPath();
    int id = Integer.parseInt(path.split("/")[3]);

    userRepository.delete(id);

    exchange.sendResponseHeaders(204, -1);  // No Content
    exchange.close();
}
```

### Roteamento por path
```java
public class UserHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String method = exchange.getRequestMethod();

        // /api/users       → GET todos, POST criar
        // /api/users/123   → GET um, PUT atualizar, DELETE deletar

        String[] parts = path.split("/");
        boolean hasId = parts.length > 3;

        if (!hasId && "GET".equals(method)) {
            handleGetAll(exchange);
        } else if (!hasId && "POST".equals(method)) {
            handleCreate(exchange);
        } else if (hasId && "GET".equals(method)) {
            handleGetById(exchange, Integer.parseInt(parts[3]));
        } else if (hasId && "PUT".equals(method)) {
            handleUpdate(exchange, Integer.parseInt(parts[3]));
        } else if (hasId && "DELETE".equals(method)) {
            handleDelete(exchange, Integer.parseInt(parts[3]));
        } else {
            sendResponse(exchange, 405, "{\"error\":\"Method not allowed\"}");
        }
    }
}
```

### Utilitário de resposta
```java
private void sendResponse(HttpExchange exchange, int statusCode, String body) throws IOException {
    exchange.getResponseHeaders().set("Content-Type", "application/json");
    exchange.sendResponseHeaders(statusCode, body.getBytes().length);
    exchange.getResponseBody().write(body.getBytes());
    exchange.close();
}
```

---

## Dependências necessárias

```xml
<!-- SQLite -->
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.46.0.0</version>
</dependency>

<!-- Gson (para JSON) -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
</dependency>
```

---

## Arquitetura do projeto

```
mini-projetos/api-sqlite-jdbc/
├── pom.xml
├── src/main/java/com/api/
│   ├── ApiServer.java           (main + HttpServer)
│   ├── database/
│   │   └── DatabaseConnection.java  (conexão SQLite)
│   ├── model/
│   │   ├── User.java
│   │   └── Habit.java
│   ├── repository/
│   │   ├── UserRepository.java  (JDBC CRUD)
│   │   └── HabitRepository.java (JDBC CRUD)
│   ├── handler/
│   │   ├── UserHandler.java     (HttpHandler)
│   │   └── HabitHandler.java    (HttpHandler)
│   └── util/
│       └── JsonResponse.java    (utilitário JSON)
└── schema.sql
```

---

## Testar com curl

```bash
# GET todos
curl http://localhost:8080/api/users

# POST criar
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"André","email":"andre@email.com"}'

# GET por ID
curl http://localhost:8080/api/users/1

# PUT atualizar
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"André Omondes","email":"andre@email.com"}'

# DELETE
curl -X DELETE http://localhost:8080/api/users/1
```
