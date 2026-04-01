# 📝 DIA 8 — Anotações

**Data:** __ / __ / 2026

---

## O que aprendi:

### PUT (atualizar dados)
```powershell
Invoke-RestMethod -Uri "https://jsonplaceholder.typicode.com/posts/1" -Method Put -ContentType "application/json" -Body (@{title="Atualizado"} | ConvertTo-Json)
```

### DELETE (deletar dados)
```powershell
Invoke-RestMethod -Uri "https://jsonplaceholder.typicode.com/posts/1" -Method Delete
```

---

## Dúvidas:

> (preencher se tiver)

---

## Reflexão:

> (sua reflexão sobre o dia)

---
