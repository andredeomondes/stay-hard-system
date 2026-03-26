# 📚 FASE 4 — Docker + System Design + CI/CD

## Docker

### Conceitos
```
Imagem    = Template (receita do bolo)
Container = Instância da imagem (bolo pronto)
Volume    = Persistência de dados
Network   = Comunicação entre containers
```

### Dockerfile (Spring Boot)
```dockerfile
# Multi-stage build
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Dockerfile (React + Nginx)
```dockerfile
FROM node:20-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

### nginx.conf (React SPA)
```nginx
server {
    listen 80;
    root /usr/share/nginx/html;
    index index.html;

    location / {
        try_files $uri $uri/ /index.html;
    }

    location /api {
        proxy_pass http://api:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}
```

### docker-compose.yml
```yaml
version: '3.8'
services:
  postgres:
    image: postgres:16
    environment:
      POSTGRES_DB: stay_hard_db
      POSTGRES_USER: stayhard
      POSTGRES_PASSWORD: ${DB_PASSWORD}
    volumes:
      - pgdata:/var/lib/postgresql/data
    ports:
      - "5432:5432"
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U stayhard"]
      interval: 5s
      timeout: 5s
      retries: 5

  api:
    build: ./stay-hard-system
    depends_on:
      postgres:
        condition: service_healthy
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/stay_hard_db
      SPRING_DATASOURCE_USERNAME: stayhard
      SPRING_DATASOURCE_PASSWORD: ${DB_PASSWORD}
      JWT_SECRET: ${JWT_SECRET}
    ports:
      - "8080:8080"

  frontend:
    build: ./stay-hard-frontend
    depends_on:
      - api
    ports:
      - "3000:80"

  pgadmin:
    image: dpage/pgadmin4
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@stayhard.com
      PGADMIN_DEFAULT_PASSWORD: ${PGADMIN_PASSWORD}
    ports:
      - "5050:80"

volumes:
  pgdata:
```

### Comandos Docker
```bash
docker build -t minha-app .         # build imagem
docker run -p 8080:8080 minha-app   # rodar container
docker-compose up -d                # subir tudo (detached)
docker-compose down                 # parar tudo
docker-compose logs -f api          # ver logs
docker ps                           # containers rodando
docker images                       # imagens disponíveis
```

---

## System Design — HLD

### Functional vs Non-Functional Requirements
```
Functional (O QUE o sistema faz):
  - Usuário pode criar hábitos
  - Usuário pode completar hábitos
  - Sistema calcula nível

Non-Functional (COMO o sistema faz):
  - Responder em < 200ms
  - Suportar 10.000 usuários simultâneos
  - 99.9% uptime
  - Dados seguros (encryption)
```

### Monolithic vs Microservices
```
Monolithic:
  ✅ Simples de desenvolver
  ✅ Fácil de fazer deploy
  ❌ Escala tudo junto
  ❌ Um bug derruba tudo

Microservices:
  ✅ Escala independente
  ✅ Deploy independente
  ❌ Complexidade de rede
  ❌ Dificuldade de debugging
```

### CAP Theorem
```
Consistency  → todos nós veem os mesmos dados
Availability → sistema sempre responde
Partition    → sistema funciona mesmo com falha de rede

Escolha 2 dos 3:
  CP → Consistency + Partition (ex: MongoDB, HBase)
  AP → Availability + Partition (ex: Cassandra, DynamoDB)
  CA → Consistency + Availability (ex: PostgreSQL single node)
```

### Scaling
```
Vertical (Scale Up):
  - Mais CPU/RAM no mesmo servidor
  - Limite físico
  - Simples

Horizontal (Scale Out):
  - Mais servidores
  - Sem limite teórico
  - Complexo (load balancer, data consistency)
```

### Caching
```
Cache Hit  → dado encontrado no cache (rápido)
Cache Miss → dado não encontrado (busca no DB)

Eviction Policies:
  LRU  → Least Recently Used (remove o menos usado)
  LFU  → Least Frequently Used (remove o menos frequente)
  FIFO → First In First Out
  TTL  → Time To Live (expira após X tempo)

Redis:
  - In-memory key-value store
  - Super rápido
  - Usado para cache, sessions, rate limiting
```

### Load Balancing
```
Algorithms:
  Round Robin      → distribui em ordem
  Least Connections→ envia para o com menos conexões
  IP Hash          → mesmo IP sempre no mesmo server
  Weighted         → servidores mais fortes recebem mais

Stateless → qualquer servidor pode atender (melhor)
Stateful  → request precisa ir no mesmo server
```

### Database Sharding
```
Horizontal Sharding:
  - Divide tabela em múltiplas tabelas/servidores
  - User ID 1-1000 → Shard 1
  - User ID 1001-2000 → Shard 2

Vertical Sharding:
  - Divide colunas em tabelas diferentes
  - user_profile → DB1
  - user_settings → DB2
```

---

## System Design — LLD (SOLID)

### S — Single Responsibility
```java
// ❌ Uma classe fazendo muita coisa
class UserService {
    void createUser() { /* ... */ }
    void sendEmail() { /* ... */ }
    void generateReport() { /* ... */ }
}

// ✅ Cada classe uma responsabilidade
class UserService {
    void createUser() { /* ... */ }
}
class EmailService {
    void sendEmail() { /* ... */ }
}
class ReportService {
    void generateReport() { /* ... */ }
}
```

### O — Open/Closed
```java
// ✅ Aberto para extensão, fechado para modificação
interface NotificationService {
    void send(String message);
}

class EmailNotification implements NotificationService {
    public void send(String message) { /* envia email */ }
}

class SmsNotification implements NotificationService {
    public void send(String message) { /* envia SMS */ }
}
```

### L — Liskov Substitution
```java
// ✅ Subtipos devem ser substituíveis pelo tipo base
class Bird {
    void fly() { /* ... */ }
}

class Eagle extends Bird { /* pode voar ✅ */ }
// class Penguin extends Bird { /* não pode voar ❌ */ }
```

### I — Interface Segregation
```java
// ❌ Interface gorda
interface Worker {
    void work();
    void eat();
    void sleep();
}

// ✅ Interfaces específicas
interface Workable { void work(); }
interface Eatable { void eat(); }
interface Sleepable { void sleep(); }
```

### D — Dependency Inversion
```java
// ❌ Depende de implementação concreta
class UserService {
    private CsvUserRepository repo = new CsvUserRepository();
}

// ✅ Depende de abstração
class UserService {
    private final UserRepository repo;  // interface
    public UserService(UserRepository repo) {
        this.repo = repo;
    }
}
```

---

## CI/CD Pipeline

### Conceitos
```
CI (Continuous Integration):
  - Merge de código frequente
  - Build + testes automáticos
  - Detecta bugs cedo

CD (Continuous Delivery):
  + Deploy manual aprovado
  + Código sempre pronto para deploy

CD (Continuous Deployment):
  + Deploy automático em produção
  + Sem intervenção humana
```

### GitHub Actions
```yaml
# .github/workflows/ci.yml
name: CI Pipeline

on:
  push:
    branches: [main]
  pull_request:
    branches: [main]

jobs:
  test:
    runs-on: ubuntu-latest
    services:
      postgres:
        image: postgres:16
        env:
          POSTGRES_DB: test_db
          POSTGRES_USER: test
          POSTGRES_PASSWORD: test
        options: >-
          --health-cmd pg_isready
          --health-interval 10s
          --health-timeout 5s
          --health-retries 5
        ports:
          - 5432:5432

    steps:
      - uses: actions/checkout@v4

      - name: Setup Java
        uses: actions/setup-java@v4
        with:
          java-version: '21'
          distribution: 'temurin'
          cache: maven

      - name: Run Tests
        run: mvn clean test

      - name: Generate Coverage
        run: mvn jacoco:report

  build:
    needs: test
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          java-version: '21'
          distribution: 'temurin'
          cache: maven

      - name: Build JAR
        run: mvn clean package -DskipTests

      - name: Upload Artifact
        uses: actions/upload-artifact@v4
        with:
          name: app-jar
          path: target/*.jar

  deploy:
    needs: build
    if: github.ref == 'refs/heads/main'
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4

      - name: Build Docker Image
        run: docker build -t stay-hard:${{ github.sha }} .

      - name: Deploy
        run: echo "Deploy to production"
```

### Pipeline Visual
```
Push → Checkout → Setup Java → Test → Build → Docker → Deploy
                              ↓
                          (se falha → notifica)
```
