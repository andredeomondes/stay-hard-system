# 📚 TCP/IP — Transmission Control Protocol / Internet Protocol

## O que é?

**TCP/IP** é o conjunto de protocolos que permite comunicação na internet.

```
TCP = Transmission Control Protocol
     → Garante que dados CHEGUEM na ordem correta

IP  = Internet Protocol
     → Endereçamento e roteamento de pacotes
```

## Analogia: Carta vs Telefonema

| | Carta (IP) | Telefonema (TCP) |
|--|------------|-----------------|
| **Entrega** | Pode se perder | Garantida |
| **Ordem** | Pode chegar fora de ordem | Sempre na ordem |
| **Velocidade** | Rápido | Um pouco mais lento |
| **Confirmação** | Sem confirmação | "Alô?" → "Alô!" |

## TCP — Transmission Control Protocol

### Características:
- ✅ **Orientado a conexão** (precisa "conectar" primeiro)
- ✅ **Confiável** (se perder pacote, reenvia)
- ✅ **Ordenado** (chega na ordem correta)
- ✅ **Full-duplex** (pode enviar e receber ao mesmo tempo)

### "3-Way Handshake" (Conexão)

```
CLIENTE                          SERVIDOR
   |                                |
   | ──── SYN (seq=x) ───────────→ |  "Quero conectar!"
   |                                |
   | ←── SYN-ACK (seq=y, ack=x+1) ─|  "OK, vamos!"
   |                                |
   | ──── ACK (ack=y+1) ──────────→ |  "Confirmado!"
   |                                |
   |         CONEXÃO ESTABELECIDA    |
   |                                |
```

### Exemplo em Java:

```java
// CLIENTE TCP
Socket socket = new Socket("localhost", 8080);
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
BufferedReader in = new BufferedReader(
    new InputStreamReader(socket.getInputStream())
);

// Envia mensagem
out.println("Olá servidor!");

// Recebe resposta
String resposta = in.readLine();
System.out.println("Servidor disse: " + resposta);

socket.close();
```

```java
// SERVIDOR TCP
ServerSocket serverSocket = new ServerSocket(8080);
System.out.println("Servidor esperando na porta 8080...");

Socket clientSocket = serverSocket.accept();
System.out.println("Cliente conectado!");

BufferedReader in = new BufferedReader(
    new InputStreamReader(clientSocket.getInputStream())
);
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

String mensagem = in.readLine();
System.out.println("Cliente disse: " + mensagem);

out.println("Olá cliente!");
clientSocket.close();
serverSocket.close();
```

## IP — Internet Protocol

### Endereço IPv4:
```
192.168.1.100
│    │    │    │
│    │    │    └── Host (máquina)
│    │    └─────── Sub-rede
│    └──────────── Rede
└───────────────── Classe
```

### Endereços Especiais:

| Endereço | Significado |
|----------|-------------|
| `127.0.0.1` | Localhost (esta máquina) |
| `localhost` | Mesmo que 127.0.0.1 |
| `0.0.0.0` | Todas as interfaces |
| `192.168.x.x` | Rede local (privado) |
| `10.x.x.x` | Rede local (privado) |

### Portas:

```
192.168.1.100:8080
│    │    │    │  │
│    │    │    │  └── Porta (app específico)
│    │    │    └──── Host
│    │    └────────── Sub-rede
│    └──────────────── Rede
└────────────────────── IP
```

## UDP — User Datagram Protocol

### Características:
- ❌ **Sem conexão** (envia direto)
- ❌ **Não confiável** (pode perder pacotes)
- ❌ **Não ordenação** (pode chegar fora de ordem)
- ✅ **Mais rápido** (sem confirmação)

### Quando usar UDP?

| Situação | Protocolo | Por quê? |
|----------|----------|----------|
| Web | TCP | Precisa garantir entrega |
| Email | TCP | Precisa garantir entrega |
| Videochamada | UDP | Rapidez > precisão |
| Gaming online | UDP | Rapidez > precisão |
| DNS | UDP | Rápido, retries resolvem |

## Portas Comuns para记住

```
HTTP      → 80
HTTPS     → 443
SSH       → 22
FTP       → 21
MySQL     → 3306
PostgreSQL → 5432
MongoDB   → 27017
Redis     → 6379
Tomcat    → 8080
```

## TCP vs UDP

| Característica | TCP | UDP |
|----------------|-----|-----|
| Conexão | Precisa conectar | Direto |
| Confiabilidade | ✅ Garante | ❌ Não |
| Ordenação | ✅ Sim | ❌ Não |
| Velocidade | Média | Rápida |
| Uso de banda | Mais | Menos |
| Header size | 20 bytes | 8 bytes |

## Camadas do TCP/IP

```
┌──────────────────────────┐
│ 4. Aplicação (HTTP/FTP)  │  ← Seus apps
├──────────────────────────┤
│ 3. Transporte (TCP/UDP)  │  ← Portas
├──────────────────────────┤
│ 2. Internet (IP)        │  ← Endereços
├──────────────────────────┤
│ 1. Enlace (Ethernet)     │  ← Fisíco
└──────────────────────────┘
```

## Exercício Prático

```java
// Servidor TCP simples
public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Ouvindo na porta 8080...");
        
        while (true) {
            Socket cliente = server.accept();
            System.out.println("Novo cliente: " + cliente.getInetAddress());
            
            // Trata cliente em nova thread (exemplo)
            new Thread(() -> trataCliente(cliente)).start();
        }
    }
}
```

## Próximo passo

Aprender sobre **HTTP** — o protocolo que cliente-servidor web usam para se comunicar.
