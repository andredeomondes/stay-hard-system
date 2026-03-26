# 📚 DevOps — Logging, Nginx, AWS, SSL

## Logging com SLF4J + Logback

### O que é
Spring Boot já vem com SLF4J + Logback embutido. É o padrão da indústria para logging em Java.

### Log Levels (do mais grave pro menos)
```
ERROR → Erros críticos (exceções, falhas)
WARN  → Avisos (deprecações, configurações ruins)
INFO  → Informações gerais (app started, request recebido)
DEBUG → Informações detalhadas (queries SQL, valores de variáveis)
TRACE → Informações muito detalhadas (raramente usado)
```

### Como usar no Spring Boot
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<UserResponse>> listAll() {
        logger.info("Listando todos os usuários");
        List<UserResponse> users = service.findAll();
        logger.debug("Encontrados {} usuários", users.size());
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest request) {
        logger.info("Criando usuário: {}", request.getEmail());
        try {
            UserResponse user = service.create(request);
            logger.info("Usuário criado com ID: {}", user.getId());
            return ResponseEntity.status(201).body(user);
        } catch (Exception e) {
            logger.error("Erro ao criar usuário: {}", e.getMessage(), e);
            throw e;
        }
    }
}
```

### application.properties (logging config)
```properties
# Nível global
logging.level.root=WARN

# Nível por package
logging.level.com.stayhard=DEBUG
logging.level.org.springframework.web=INFO
logging.level.org.hibernate=WARN

# Output em arquivo
logging.file.name=logs/stay-hard.log
logging.file.max-size=10MB
logging.file.max-history=30

# Formato
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
```

### Structured Logging (JSON)
```xml
<!-- logback-spring.xml -->
<configuration>
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="net.logstash.logback.encoder.LogstashEncoder"/>
    </appender>

    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>logs/stay-hard.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>logs/stay-hard.%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <maxFileSize>10MB</maxFileSize>
            <maxHistory>30</maxHistory>
        </rollingPolicy>
        <encoder class="net.logstash.logback.encoder.LogstashEncoder"/>
    </appender>

    <root level="INFO">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
    </root>
</configuration>
```

### Correlation ID (rastrear requests)
```java
@Component
public class CorrelationIdFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String correlationId = req.getHeader("X-Correlation-ID");
        if (correlationId == null) {
            correlationId = UUID.randomUUID().toString();
        }
        MDC.put("correlationId", correlationId);
        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove("correlationId");
        }
    }
}
```

---

## Nginx como Reverse Proxy

### O que é
Nginx é um servidor web que atua como **reverse proxy**: recebe requests do cliente e encaminha para o backend (Spring Boot).

### Por que usar
- Serve arquivos estáticos (React build) mais rápido que Java
- Load balancing entre múltiplas instâncias do backend
- SSL termination (HTTPS)
- Compressão gzip
- Rate limiting

### Instalação (Docker)
```dockerfile
# Dockerfile para Nginx
FROM nginx:alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY dist/ /usr/share/nginx/html/
```

### nginx.conf básico
```nginx
upstream spring_boot {
    server api:8080;
}

server {
    listen 80;
    server_name localhost;

    # Arquivos estáticos (React build)
    location / {
        root /usr/share/nginx/html;
        try_files $uri $uri/ /index.html;
    }

    # API → Spring Boot
    location /api {
        proxy_pass http://spring_boot;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header X-Correlation-ID $request_id;
    }

    # Swagger UI
    location /swagger {
        proxy_pass http://spring_boot;
    }

    # Actuator (health check)
    location /actuator {
        proxy_pass http://spring_boot;
    }

    # Compressão
    gzip on;
    gzip_types text/plain text/css application/json application/javascript;
}
```

### docker-compose.yml com Nginx
```yaml
services:
  nginx:
    image: nginx:alpine
    ports:
      - "80:80"
      - "443:443"
    volumes:
      - ./nginx.conf:/etc/nginx/conf.d/default.conf
      - ./ssl:/etc/nginx/ssl
    depends_on:
      - api

  api:
    build: ./stay-hard-system
    expose:
      - "8080"
```

---

## AWS Básico

### Conceitos fundamentais
```
AWS = Amazon Web Services (nuvem da Amazon)
Regions = Localizações geográficas (ex: sa-east-1 = São Paulo)
Availability Zones = Data centers dentro de uma região
IAM = Identity and Access Management (usuários e permissões)
```

### IAM (usuários e permissões)
```
1. Criar conta AWS
2. Criar IAM User (não use root)
3. Criar Access Keys (para CLI)
4. Anexar políticas (ex: EC2FullAccess, S3FullAccess)

aws configure
  AWS Access Key ID: AKIA...
  AWS Secret Access Key: ...
  Region: sa-east-1
```

### EC2 (servidores virtuais)
```
EC2 = Elastic Compute Cloud (máquina virtual Linux)

1. Criar instância EC2
   - AMI: Ubuntu 22.04
   - Tipo: t3.micro (free tier)
   - Security Group: abrir portas 22 (SSH), 80 (HTTP), 443 (HTTPS), 8080 (API)
   
2. Conectar via SSH
   ssh -i minha-chave.pem ubuntu@IP_PUBLICO

3. Instalar Java 21
   sudo apt update
   sudo apt install openjdk-21-jdk

4. Copiar JAR para EC2
   scp -i minha-chave.pem target/app.jar ubuntu@IP_PUBLICO:~

5. Rodar Spring Boot
   java -jar app.jar

6. Rodar como serviço (systemd)
   sudo nano /etc/systemd/system/stayhard.service
   
   [Unit]
   Description=Stay Hard System
   After=network.target
   
   [Service]
   User=ubuntu
   ExecStart=/usr/bin/java -jar /home/ubuntu/app.jar
   Restart=always
   
   [Install]
   WantedBy=multi-user.target
   
   sudo systemctl enable stayhard
   sudo systemctl start stayhard
```

### RDS (banco de dados managed)
```
RDS = Relational Database Service (PostgreSQL managed)

1. Criar instância RDS
   - Engine: PostgreSQL 16
   - Tipo: db.t3.micro (free tier)
   - Storage: 20GB
   - VPC: mesma da EC2
   - Security Group: permitir porta 5432 da EC2

2. Conectar do Spring Boot
   spring.datasource.url=jdbc:postgresql://meu-db.xxxxx.sa-east-1.rds.amazonaws.com:5432/stay_hard_db
   spring.datasource.username=admin
   spring.datasource.password=senha_segura
```

### S3 (storage de arquivos)
```
S3 = Simple Storage Service (armazenamento de objetos)

1. Criar bucket S3
   - Nome único globalmente
   - Região: sa-east-1
   - Bloquear acesso público (por padrão)

2. Usar no Spring Boot
   <dependency>
       <groupId>software.amazon.awssdk</groupId>
       <artifactId>s3</artifactId>
   </dependency>

3. Upload de arquivo
   S3Client s3 = S3Client.create();
   s3.putObject(PutObjectRequest.builder()
       .bucket("stay-hard-files")
       .key("uploads/foto.jpg")
       .build(),
       Path.of("foto.jpg"));
```

### ECS (deploy de containers)
```
ECS = Elastic Container Service (Docker na AWS)

1. Criar repositório ECR (container registry)
2. Build + push da imagem Docker
   docker build -t stay-hard .
   docker tag stay-hard:latest ACCOUNT.dkr.ecr.sa-east-1.amazonaws.com/stay-hard:latest
   docker push ACCOUNT.dkr.ecr.sa-east-1.amazonaws.com/stay-hard:latest

3. Criar cluster ECS + task definition + service
4. Ou usar Elastic Beanstalk (mais simples)
```

---

## SSL/HTTPS

### O que é
SSL/TLS criptografa a comunicação entre cliente e servidor. URLs com `https://` são seguras.

### Let's Encrypt (gratuito)
```
Let's Encrypt = Certificado SSL gratuito e automático

Com Certbot:
1. Instalar Certbot
   sudo apt install certbot python3-certbot-nginx

2. Gerar certificado
   sudo certbot --nginx -d meudominio.com

3. Auto-renovação
   sudo certbot renew --dry-run

Certbot configura o Nginx automaticamente!
```

### Nginx com SSL
```nginx
server {
    listen 443 ssl;
    server_name meudominio.com;

    ssl_certificate /etc/letsencrypt/live/meudominio.com/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/meudominio.com/privkey.pem;

    # Redirecionar HTTP → HTTPS
    location / {
        root /usr/share/nginx/html;
        try_files $uri $uri/ /index.html;
    }

    location /api {
        proxy_pass http://spring_boot;
        proxy_set_header Host $host;
        proxy_set_header X-Forwarded-Proto https;
    }
}

# Redirect HTTP to HTTPS
server {
    listen 80;
    server_name meudominio.com;
    return 301 https://$server_name$request_uri;
}
```

### Spring Boot + HTTPS direto (sem Nginx)
```properties
# application.properties
server.port=8443
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-password=senha
server.ssl.keyStoreType=PKCS12
```

---

## Deploy completo — Resumo

```
1. Build da aplicação
   mvn clean package -DskipTests

2. Build Docker images
   docker build -t stay-hard-api ./stay-hard-system
   docker build -t stay-hard-frontend ./stay-hard-frontend

3. Push para ECR (container registry)
   docker push ACCOUNT.dkr.ecr.sa-east-1.amazonaws.com/stay-hard-api

4. Deploy no ECS ou EC2
   - EC2: scp + ssh + java -jar
   - ECS: criar service com task definition

5. Configurar Nginx como reverse proxy
   - Proxy pass para API
   - Serve static files do React

6. Configurar SSL com Let's Encrypt
   certbot --nginx -d meudominio.com

7. Configurar DNS (Route 53 ou outro)
   A record → IP público do EC2/Load Balancer

8. Monitorar
   - Logs: CloudWatch (AWS) ou ELK
   - Health: /actuator/health
   - Metrics: /actuator/metrics
```

### Diagrama de deploy
```
                    ┌──────────┐
                    │  Usuário │
                    └────┬─────┘
                         │ HTTPS
                    ┌────▼─────┐
                    │  Route53 │  (DNS)
                    │ (domínio)│
                    └────┬─────┘
                         │
                    ┌────▼─────┐
                    │  Nginx   │  (SSL + reverse proxy)
                    │ (EC2)    │
                    └────┬─────┘
                         │
              ┌──────────┼──────────┐
              │                     │
         ┌────▼─────┐         ┌────▼─────┐
         │  Spring  │         │  React   │
         │  Boot    │         │ (static) │
         │ (EC2/ECS)│         │          │
         └────┬─────┘         └──────────┘
              │
    ┌─────────┼─────────┐
    │         │         │
┌───▼───┐ ┌──▼───┐ ┌───▼───┐
│Postgres│ │Redis │ │MongoDB│
│ (RDS)  │ │(EC2) │ │(EC2)  │
└────────┘ └──────┘ └───────┘
```
