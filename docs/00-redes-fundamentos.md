# 📚 FUNDAMENTOS DE REDE

## Cliente-Servidor

### O que é?
Modelo onde o **CLIENTE** faz requisições e o **SERVIDOR** responde.

### Exemplo do dia-a-dia:
```
Você (Cliente) → Abre navegador → Digita google.com
Servidor do Google → Devolve a página
```

### Analogia com Restaurante:
```
Cliente = Você (faz pedido)
Garçom = Request (leva pedido)
Cozinha = Servidor (prepara comida)
Você = Response (recebe comida)
```

---

## TCP/IP

### O que é TCP/IP?
Conjunto de protocolos que permite comunicação na internet.

```
TCP  = Transmission Control Protocol (confiável, Ordered)
IP   = Internet Protocol (endereçamento)
```

### Portas comuns:
| Porta | Serviço |
|-------|---------|
| 80 | HTTP |
| 443 | HTTPS |
| 8080 | HTTP alternativo |
| 3306 | MySQL |
| 5432 | PostgreSQL |

---

## HTTP

### O que é HTTP?
Protocolo de comunicação entre cliente e servidor web.

### Request (Cliente → Servidor):
```
GET /api/users HTTP/1.1
Host: localhost:8080
Content-Type: application/json
```

### Response (Servidor → Cliente):
```
HTTP/1.1 200 OK
Content-Type: application/json

{"users": []}
```

### Métodos HTTP:
| Método | Uso |
|--------|-----|
| GET | Buscar dados |
| POST | Criar dados |
| PUT | Atualizar dados |
| DELETE | Deletar dados |

### Status Codes:
| Código | Significado |
|--------|-------------|
| 200 | OK |
| 201 | Created |
| 400 | Bad Request |
| 404 | Not Found |
| 500 | Server Error |

---

## DNS

### O que é DNS?
Sistema que traduz nomes de domínio em endereços IP.

```
google.com → 142.250.217.78
```

### Fluxo:
```
1. Você digita "google.com"
2. Seu computador pergunta ao DNS
3. DNS retorna o IP
4. Seu computador conecta ao IP
```

---

## Socket em Java

### TCP Server:
```java
ServerSocket server = new ServerSocket(8080);
Socket client = server.accept();

BufferedReader in = new BufferedReader(
    new InputStreamReader(client.getInputStream())
);
PrintWriter out = new PrintWriter(
    client.getOutputStream(), true
);

String msg = in.readLine();
out.println("Olá cliente!");
```

### TCP Client:
```java
Socket socket = new Socket("localhost", 8080);

PrintWriter out = new PrintWriter(
    socket.getOutputStream(), true
);
BufferedReader in = new BufferedReader(
    new InputStreamReader(socket.getInputStream())
);

out.println("Olá servidor!");
String response = in.readLine();
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
