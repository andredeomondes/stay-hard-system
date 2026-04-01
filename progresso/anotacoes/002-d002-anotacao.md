# 📝 DIA 2 — Anotações

**Data:** __ / __ / 2026

---

## O que aprendi:

### TCP/IP
- TCP = Transmission Control Protocol (confiável, ordenado)
- IP = Internet Protocol (endereçamento)
- Portas = "número do apartamento" no computador

### Portas mais comuns
| Porta | Uso |
|-------|-----|
| 80 | HTTP |
| 443 | HTTPS |
| 8080 | HTTP alternativo (desenvolvimento) |
| 3306 | MySQL |
| 5432 | PostgreSQL |

### Three-way Handshake (conexão TCP)
1. Cliente → SYN (quer conectar)
2. Servidor → SYN-ACK (ta livre)
3. Cliente → ACK (confirmado)
4. Conexão estabelecida!

### Controle de fluxo
- TCP usa "sliding window" para não encher o buffer do receptor
- ACK confirma recebimento

### Controle de erro
- Checksum verifica integridade
- Se erro, reenvia o pacote

---

## Insights:

- Porta é como "número do apartamento" — IP é o CEP do prédio
- Quando crio ServerSocket(9090), o SO reserva essa porta
- TCP garante: conexão confiável, dados na ordem, sem erros

---

## Dúvidas:

> (preencher se tiver)

---

## Aplicação no Stay Hard:

O que aprendi hoje é a BASE para entender como APIs REST funcionam no futuro.

---

## Código do dia:

### Server.java (porta 9090)
```java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            int porta = 9090;
            ServerSocket serverSocket = new ServerSocket(porta);
            System.out.println("Servidor ouvindo na porta " + porta + "...");
            
            Socket cliente = serverSocket.accept();
            System.out.println("Cliente conectado!");
            
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(cliente.getInputStream())
            );
            
            PrintWriter saida = new PrintWriter(
                cliente.getOutputStream(), true
            );
            
            String mensagem = entrada.readLine();
            System.out.println("Recebi: " + mensagem);
            
            saida.println("Eco: " + mensagem);
            
            cliente.close();
            serverSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Client.java (porta 9090)
```java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9090);
            System.out.println("Conectado!");
            
            PrintWriter saida = new PrintWriter(
                socket.getOutputStream(), true
            );
            
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            
            saida.println("Olá servidor!");
            String resposta = entrada.readLine();
            System.out.println("Servidor disse: " + resposta);
            
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## Reflexão:

> (sua reflexão sobre o dia)

---
