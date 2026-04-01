# 📝 DIA 3 — Anotações

**Data:** __ / __ / 2026

---

## O que aprendi:

### HTTP (HyperText Transfer Protocol)
- Protocolo de comunicação entre cliente e servidor web
- Request/Response = pedido/resposta

### Estrutura de um Request (Cliente → Servidor)
```
GET /api/users HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{"name": "André"}
```

### Estrutura de um Response (Servidor → Cliente)
```
HTTP/1.1 200 OK
Content-Type: application/json

{"users": [{"id": 1, "name": "André"}]}
```

### Métodos HTTP
| Método | Uso |
|--------|-----|
| GET | Buscar dados |
| POST | Criar dados |
| PUT | Atualizar dados |
| DELETE | Deletar dados |

### Status Codes
| Código | Significado |
|--------|-------------|
| 200 | OK |
| 201 | Created |
| 400 | Bad Request |
| 404 | Not Found |
| 500 | Server Error |

---

## Insights:

- HTTP é o "idioma" que navegador e servidor falam
- Request tem: método, path, headers, body
- Response tem: status code, headers, body

---

## Dúvidas:

> (preencher se tiver)

---

## Aplicação no Stay Hard:

HOJE: TCP Server/Client (estudo)
FUTURO: API REST com Spring Boot (vai usar HTTP)

---

## Reflexão:

> (sua reflexão sobre o dia)

---
