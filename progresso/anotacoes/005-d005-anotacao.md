# 📝 DIA 5 — Anotações

**Data:** __ / __ / 2026

---

## O que aprendi:

### Server com Loop (múltiplos clientes)
- ServerSocket fica em loop `while(true)` aceitando vários clientes
- Cada cliente conecta, é atendido, e a conexão fecha
- O Server continua ouvindo para o próximo cliente

### Código Server com loop:
```java
while (true) {
    Socket cliente = serverSocket.accept();
    System.out.println("Cliente conectado!");
    
    // atende cliente...
    cliente.close();
}
```

---

## Insights:

- Um Server pode atender vários clientes (um por vez)
- O loop `while(true)` mantém o Server vivo
- `accept()` bloqueia até alguém conectar

---

## Dúvidas:

> (preencher se tiver)

---

## Aplicação no Stay Hard:

Entender sockets é a base para criar APIs REST no futuro.

---

## Reflexão:

> (sua reflexão sobre o dia)

---
