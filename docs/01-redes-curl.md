# 📚 CURL E TESTE DE APIs

## O que é curl?
Ferramenta de linha de comando para fazer requisições HTTP.

## curl Básico

### GET (buscar dados):
```bash
curl https://api.github.com/users
```

### GET com Headers:
```bash
curl -H "Authorization: Bearer TOKEN" \
     https://api.github.com/user
```

### POST (criar dados):
```bash
curl -X POST https://api.example.com/users \
  -H "Content-Type: application/json" \
  -d '{"name": "André", "email": "andre@email.com"}'
```

### PUT (atualizar):
```bash
curl -X PUT https://api.example.com/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "André Omondes"}'
```

### DELETE:
```bash
curl -X DELETE https://api.example.com/users/1
```

## Flags úteis:
| Flag | Uso |
|------|-----|
| `-X` | Método (GET, POST, PUT, DELETE) |
| `-H` | Header |
| `-d` | Data/Body |
| `-v` | Verbose (mostra detalhes) |
| `-i` | Mostra headers da resposta |

## Exemplo completo:
```bash
# Criar hábito
curl -X POST http://localhost:8080/api/habits \
  -H "Content-Type: application/json" \
  -d '{"name": "Treinar", "priority": "HIGH"}'

# Listar hábitos
curl http://localhost:8080/api/habits

# Marcar como completo
curl -X PUT http://localhost:8080/api/habits/1/complete
```

## Testar APIs públicas:
```bash
# GitHub API
curl https://api.github.com/users/andredeomondes

# JSONPlaceholder (API de teste)
curl https://jsonplaceholder.typicode.com/users
curl -X POST https://jsonplaceholder.typicode.com/users \
  -d '{"name": "Test"}'
```

---

## 📝 ANOTAÇÕES PESSOAIS

### O que aprendi hoje:
> 


### Pontos importantes:
> 


### Dúvidas:
> 


### Como aplicar no Stay Hard:
> 

---
