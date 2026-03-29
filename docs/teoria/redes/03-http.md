# 📚 HTTP — HyperText Transfer Protocol

## O que é?

**HTTP** é o protocolo que navegadores e servidores web usam para se comunicar. Ele roda sobre TCP.

```
HTTP = HyperText Transfer Protocol
      → Protocolo para transferir texto/hipertexto
      → Base da web
```

## Analogia: Pedido no Restaurante

```
CLIENTE (você)                    SERVIDOR (cozinheiro)
     |                                    |
     | "Quero um hambúrguer, por favor"  |
     | ──────────────────────────────────→|  ← REQUEST
     |                                    |
     |         Preparando...              |
     |                                    |
     | "Aqui está! Bom apetite!"          |
     | ←─────────────────────────────────|  ← RESPONSE
```

## REQUEST — Requisição

### Estrutura:

```
GET /pagina HTTP/1.1              ← Linha de requisição
Host: www.google.com              ← Headers
User-Agent: Mozilla/5.0
Accept: text/html
                                 ← Linha vazia
                                 ← Body (só em POST/PUT)
```

### Partes:

```
┌────────────────────────────────────┐
│ MÉTODO   /caminho   HTTP/VERSÃO   │  ← Request Line
├────────────────────────────────────┤
│ Header1: valor                    │  ← Headers
│ Header2: valor                    │
│ Content-Type: application/json     │
├────────────────────────────────────┤
│                                    │
│ (corpo da requisição)             │  ← Body (opcional)
│                                    │
└────────────────────────────────────┘
```

## RESPONSE — Resposta

### Estrutura:

```
HTTP/1.1 200 OK                    ← Status Line
Content-Type: text/html             ← Headers
Content-Length: 1234
Server: Apache/2.4

                                   ← Linha vazia
<!DOCTYPE html>                    ← Body
<html>
  <head>...</head>
  <body>...</body>
</html>
```

### Partes:

```
┌────────────────────────────────────┐
│ HTTP/VERSÃO   STATUS   DESCRIÇÃO  │  ← Status Line
├────────────────────────────────────┤
│ Content-Type: application/json     │  ← Headers
│ Content-Length: 500               │
│ Cache-Control: max-age=3600       │
├────────────────────────────────────┤
│                                    │
│ {"nome": "André", "idade": 25}   │  ← Body
│                                    │
└────────────────────────────────────┘
```

## Métodos HTTP (VERBOS)

| Método | Uso | Seguro? | Idempotente? |
|--------|-----|--------|--------------|
| **GET** | Ler dados | ✅ Sim | ✅ Sim |
| **POST** | Criar dados | ❌ Não | ❌ Não |
| **PUT** | Substituir dados | ❌ Não | ✅ Sim |
| **PATCH** | Atualizar parcialmente | ❌ Não | ❌ Não |
| **DELETE** | Remover dados | ❌ Não | ✅ Sim |

### O que cada um faz?

```
GET    /usuarios        → Lista todos usuários
GET    /usuarios/1      → Lista usuário 1
POST   /usuarios        → Cria novo usuário
PUT    /usuarios/1      → Substitui usuário 1 inteiro
PATCH  /usuarios/1      → Atualiza só nome do usuário 1
DELETE /usuarios/1      → Remove usuário 1
```

### GET vs POST

```
GET:
- Parâmetros na URL: /busca?q=java&pag=1
- Visível no navegador
- Limite de tamanho (2048 chars)
- Pode ser cacheado

POST:
- Parâmetros no body
- Não aparece na URL
- Sem limite prático
- Não é cacheado
```

## Status Codes (Códigos de Status)

### 1xx — Informacional
| Código | Significado |
|--------|-------------|
| 100 | Continue |
| 101 | Switching Protocols |

### 2xx — Sucesso
| Código | Significado | Quando usar |
|--------|-------------|-------------|
| **200** | OK | GET/DELETE成功 |
| **201** | Created | POST成功 |
| **204** | No Content | DELETE成功 (sem body) |

### 3xx — Redirecionamento
| Código | Significado |
|--------|-------------|
| 301 | Moved Permanently |
| 302 | Found (redirect temporário) |
| 304 | Not Modified (cache) |

### 4xx — Erro do Cliente
| Código | Significado | Quando usar |
|--------|-------------|-------------|
| **400** | Bad Request | Dados inválidos |
| **401** | Unauthorized | Não autenticado |
| **403** | Forbidden | Sem permissão |
| **404** | Not Found | Recurso não existe |
| **409** | Conflict | Conflito (ex: email já existe) |
| **422** | Unprocessable | Validação falhou |
| **429** | Too Many Requests | Rate limit |

### 5xx — Erro do Servidor
| Código | Significado |
|--------|-------------|
| **500** | Internal Server Error | Bug no servidor |
| **502** | Bad Gateway | Proxy error |
| **503** | Service Unavailable | Servidor fora |
| **504** | Gateway Timeout | Timeout |

## Headers (Cabeçalhos)

### Request Headers:
```
Host: www.exemplo.com           ← Obrigatório
User-Agent: Mozilla/5.0          ← Quem está pedindo
Accept: application/json         ← Formato aceito
Authorization: Bearer token123    ← Autenticação
Content-Type: application/json   ← Formato do body
Cookie: session=abc123           ← Cookies
```

### Response Headers:
```
Content-Type: application/json   ← Formato do body
Content-Length: 1234             ← Tamanho
Set-Cookie: session=xyz789       ← Criar cookie
Cache-Control: max-age=3600      ← Cache
Location: /usuarios/5            ← Onde foi criado (201)
```

## curl — Testando HTTP na Prática

### curl é uma ferramenta de linha de comando para fazer requisições HTTP.

```bash
# GET simples
curl https://api.exemplo.com/usuarios

# GET com headers
curl -H "Authorization: Bearer token" https://api.exemplo.com/usuarios

# POST (criar)
curl -X POST https://api.exemplo.com/usuarios \
  -H "Content-Type: application/json" \
  -d '{"nome": "André", "email": "andre@email.com"}'

# PUT (atualizar)
curl -X PUT https://api.exemplo.com/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{"nome": "André Updated"}'

# DELETE
curl -X DELETE https://api.exemplo.com/usuarios/1

# Ver resposta completa
curl -v https://api.exemplo.com/usuarios

# Somente headers
curl -I https://api.exemplo.com/usuarios
```

## Exemplo Completo

### Request:
```bash
curl -X POST https://api.exemplo.com/usuarios \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer abc123" \
  -d '{
    "nome": "André",
    "email": "andre@email.com",
    "idade": 25
  }'
```

### Response:
```http
HTTP/1.1 201 Created
Content-Type: application/json
Location: /usuarios/5
X-Request-Id: abc-123

{
  "id": 5,
  "nome": "André",
  "email": "andre@email.com",
  "idade": 25,
  "criadoEm": "2024-03-29T10:30:00Z"
}
```

## HTTP/1.1 vs HTTP/2 vs HTTP/3

| Versão | Velocidade | Características |
|--------|------------|-----------------|
| HTTP/1.1 | Média | Keep-alive, mais requests |
| HTTP/2 | Rápida | Multiplexing, server push |
| HTTP/3 | Muito rápida | Baseado em UDP, sem handshake |

## HTTPS — HTTP Secure

```
HTTP + TLS/SSL = HTTPS

- Dados são criptografados
- Certificado digital necessário
- Porta 443 (vs 80 do HTTP)
- browsers mostram 🔒 na barra
```

## Próximo passo

Aprender sobre **curl** em detalhes para testar APIs.
