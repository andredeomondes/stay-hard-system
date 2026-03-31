# 📝 DIA 7 — Anotações

**Data:** __ / __ / 2026

---

## O que aprendi:

### Headers HTTP
- Informações adicionais que cliente e servidor trocam
- Exemplos: Authorization, Content-Type, Accept

```powershell
# Enviando headers
Invoke-RestMethod -Uri "https://api.github.com/user" -Headers @{"Authorization"="Bearer token"}
```

### Query Parameters
- Parâmetros na URL depois do `?`
- Exemplo: ?userId=1&page=2

```powershell
# Com query params
Invoke-RestMethod -Uri "https://jsonplaceholder.typicode.com/posts?userId=1"
```

---

## Insights:

- Headers são como "rótulos" da requisição
- Query params são para filtrar/buscar dados
- É como usar o Postman, mas via linha de comando

---

## Dúvidas:

> (preencher se tiver)

---

## Aplicação no Stay Hard:

Essential para testar APIs REST no futuro.

---

## Reflexão:

> (sua reflexão sobre o dia)

---