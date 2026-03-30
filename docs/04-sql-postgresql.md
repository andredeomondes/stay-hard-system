# 📚 SQL + POSTGRESQL

## O que é SQL?
Linguagem para manipular bancos de dados relacionais.

## PostgreSQL
Banco de dados relacional open-source robusto.

### Instalação Docker:
```bash
docker run --name postgres -e POSTGRES_PASSWORD=123 -p 5432:5432 -d postgres
```

### Conectar:
```bash
psql -h localhost -U postgres
# senha: 123
```

## DDL (Data Definition Language)

### Criar tabela:
```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    age INT,
    created_at TIMESTAMP DEFAULT NOW()
);
```

### Alterar tabela:
```sql
ALTER TABLE users ADD COLUMN ativo BOOLEAN DEFAULT true;
ALTER TABLE users DROP COLUMN age;
ALTER TABLE users RENAME TO usuarios;
```

### Deletar tabela:
```sql
DROP TABLE users;
```

## DML (Data Manipulation Language)

### INSERT:
```sql
INSERT INTO users (name, email) VALUES ('André', 'andre@email.com');
INSERT INTO users (name, email) VALUES 
    ('Maria', 'maria@email.com'),
    ('João', 'joao@email.com');
```

### SELECT:
```sql
SELECT * FROM users;
SELECT name, email FROM users;
SELECT * FROM users WHERE id = 1;
SELECT * FROM users WHERE age > 18 AND ativo = true;
SELECT * FROM users ORDER BY name ASC;
SELECT * FROM users LIMIT 10;
```

### UPDATE:
```sql
UPDATE users SET name = 'André Omondes' WHERE id = 1;
UPDATE users SET ativo = false WHERE email LIKE '%test%';
```

### DELETE:
```sql
DELETE FROM users WHERE id = 1;
DELETE FROM users WHERE ativo = false;
```

## JOINs

### INNER JOIN:
```sql
SELECT u.name, h.name as habit
FROM users u
INNER JOIN habits h ON u.id = h.user_id;
```

### LEFT JOIN:
```sql
SELECT u.name, h.name
FROM users u
LEFT JOIN habits h ON u.id = h.user_id;
-- Mostra todos users, mesmo sem hábito
```

### RIGHT JOIN:
```sql
SELECT u.name, h.name
FROM users u
RIGHT JOIN habits h ON u.id = h.user_id;
-- Mostra todos habits, mesmo sem user
```

## Agregações

### COUNT, SUM, AVG, MIN, MAX:
```sql
SELECT COUNT(*) FROM users;
SELECT AVG(age) FROM users;
SELECT MAX(age) FROM users;
```

### GROUP BY:
```sql
SELECT status, COUNT(*) 
FROM habits 
GROUP BY status;
```

### HAVING:
```sql
SELECT user_id, COUNT(*) as total
FROM habits
GROUP BY user_id
HAVING COUNT(*) > 5;
```

## Subqueries:
```sql
SELECT * FROM users 
WHERE id IN (
    SELECT user_id FROM habits WHERE status = 'COMPLETED'
);
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
