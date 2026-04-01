# 📝 DIA 6 — Anotações

**Data:** __ / __ / 2026

---

## O que aprendi:

### curl
- Ferramenta de linha de comando para fazer requisições HTTP
- Usado para testar APIs

### GET (buscar dados)
```bash
curl https://api.github.com/users/andredeomondes
```

### POST (criar dados)
```powershell
$headers = @{"Content-Type"="application/json"}
$body = '{"title":"Teste","body":"Conteúdo"}'
Invoke-RestMethod -Uri "https://jsonplaceholder.typicode.com/posts" -Method Post -Headers $headers -Body $body
```

### Métodos HTTP
| Método | Uso |
|--------|-----|
| GET | Buscar dados |
| POST | Criar dados |
| PUT | Atualizar |
| DELETE | Deletar |

---

## Insights:

- curl é essencial para testar APIs
- GET é simples (só URL)
- POST precisa do header Content-Type e body

---

## Dúvidas:

> (preencher se tiver)

---

## Aplicação no Stay Hard:

Quando criar APIs REST, vai usar curl para testar os endpoints.

---

## Reflexão:

> (sua reflexão sobre o dia)

---
