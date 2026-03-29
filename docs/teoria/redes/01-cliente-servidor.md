# 📚 CLIENTE-SERVIDOR

## Definição

**Modelo Cliente-Servidor** é um padrão de arquitetura onde:
- **Cliente**: Faz requisições, aguarda respostas
- **Servidor**: Espera requisições, processa e responde

## Analogia do Dia-a-Dia

```
🍔 CLIENTE                    🍳 SERVIDOR
   |                              |
   |  "Quero um hambúrguer!"     |
   | ───────────────────────────→ |
   |                              |
   |           Preparando...      |
   |                              |
   |  "Aqui está!" ←──────────────|
```

- **Restaurante**: Cliente pede, cozinha prepara
- **Banco**: Cliente solicita saque, banco processa
- **Netflix**: Você (cliente) pede vídeo, servidor transmite

## No Mundo da Programação

```
🌐 NAVEGADOR (Cliente)          🖥️ SERVIDOR WEB
   Chrome/Firefox                  Apache/Nginx/Express
       |                               |
       | GET /pagina HTTP/1.1         |
       | ──────────────────────────→  |
       |                               |
       |       HTML + CSS + JS        |
       | ←──────────────────────────  |
```

## Tipos de Cliente

| Tipo | Exemplo | Descrição |
|------|---------|-----------|
| **Thin Client** | Navegador | Lógica toda no servidor |
| **Fat Client** | App Desktop | Lógica local + servidor |
| **API Client** | Postman/curl | Apenas dados (JSON) |

## Tipos de Servidor

| Tipo | Exemplo | Função |
|------|---------|--------|
| **Web Server** | Apache, Nginx | Serve HTML, CSS, JS |
| **API Server** | Spring, Express | Serve dados (JSON) |
| **Database Server** | PostgreSQL, MySQL | Armazena dados |
| **File Server** | FTP, S3 | Armazena arquivos |
| **Game Server** | - | Sincroniza jogadores |

## Comunicação

### Síncrona (mais comum)
```
Cliente → Requisição → Servidor → Processa → Resposta → Cliente
         (aguarda)                                 (aguarda)
```

### Assíncrona (moderna)
```
Cliente → Requisição → Servidor
    ↓                      ↓
 Continua              Processa em background
    ↓                      ↓
 Callback ←────────── Resposta futura
```

## Portas Comuns

| Porta | Protocolo | Uso |
|-------|-----------|-----|
| 80 | HTTP | Web padrão |
| 443 | HTTPS | Web seguro |
| 3000 | Custom | Dev servers |
| 8080 | Custom | Tomcat, proxies |
| 5432 | PostgreSQL | Banco dados |
| 3306 | MySQL | Banco dados |
| 27017 | MongoDB | NoSQL |
| 6379 | Redis | Cache |

## Protocolos

```
┌─────────────────────────────────────┐
│           APLICAÇÃO                  │
│   HTTP, FTP, SMTP, SSH, DNS         │
├─────────────────────────────────────┤
│           TRANSPORTE                │
│          TCP, UDP                   │
├─────────────────────────────────────┤
│             REDE                    │
│            IP (IPv4/IPv6)           │
└─────────────────────────────────────┘
```

## Quando usar?

| Cenário | Cliente | Servidor |
|---------|---------|----------|
| Website | Navegador | Web Server |
| API REST | Frontend/App | API Server |
| Banco de dados | App | Database Server |
| Email | Cliente Email | SMTP Server |

## Próximo passo

Aprender sobre **TCP/IP** — como os dados trafegam entre cliente e servidor.
