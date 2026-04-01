# 📝 DIA 1 — Anotações

**Data:** 31/03/2026 ✅

---

## O que aprendi:

### Modelo Cliente-Servidor
- Cliente faz requisição → Servidor responde
- Exemplo: Navegador (cliente) → Google (servidor) → Página

### TCP/IP
- TCP = Transmission Control Protocol (confiável, ordenado)
- IP = Internet Protocol (endereçamento)
- Portas comuns: 80 (HTTP), 443 (HTTPS), 8080 (HTTP alternativo), 3306 (MySQL), 5432 (PostgreSQL)

### Socket em Java
- ServerSocket = cria servidor que escuta numa porta
- Socket = conexão do cliente com o servidor

---

## Insights:

- Porta é como "número do apartamento" — IP é o CEP do prédio
- Quando crio ServerSocket(8080), o SO reserva essa porta
- Client e Server "conversam" através de um Socket de comunicação

---

## Dúvidas:


---

## Aplicação no Stay Hard:

HOJE: Terminal (Cliente) ←→ Arquivos CSV (Servidor de arquivo)
FUTURO: React (Client) ←→ Spring Boot (Server) ←→ PostgreSQL (BD)

O que aprendi hoje é a BASE para entender como APIs REST funcionam.

---

## Código do dia:

### Server.java
```java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            int porta = 8080;
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

### Client.java
```java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
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

### Como rodar:
```bash
# Terminal 1 (Server)
javac Server.java
java Server

# Terminal 2 (Client)
javac Client.java
java Client
```

---

## Reflexão:

> (sua reflexão sobre o dia)

---
