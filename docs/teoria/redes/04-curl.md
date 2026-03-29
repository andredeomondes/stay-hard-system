# 📚 CURL — Linha de Comando para HTTP

## O que é?

**curl** é uma ferramenta de linha de comando para fazer requisições HTTP (e outros protocolos). Vem instalada na maioria dos sistemas.

## Uso Básico

```bash
# GET simples
curl https://api.exemplo.com

# Ver resposta completa (verbose)
curl -v https://api.exemplo.com

# Salvar resposta em arquivo
curl -o resposta.json https://api.exemplo.com/dados
```

## Opções Principais

### -X ou --request: Método HTTP

```bash
curl -X GET https://api.exemplo.com/usuarios
curl -X POST https://api.exemplo.com/usuarios
curl -X PUT https://api.exemplo.com/usuarios/1
curl -X DELETE https://api.exemplo.com/usuarios/1
curl -X PATCH https://api.exemplo.com/usuarios/1
```

### -H ou --header: Headers

```bash
# Header único
curl -H "Content-Type: application/json" https://api.exemplo.com

# Múltiplos headers
curl -H "Content-Type: application/json" \
     -H "Authorization: Bearer token123" \
     -H "Accept: application/json" \
     https://api.exemplo.com
```

### -d ou --data: Body da requisição

```bash
# JSON
curl -d '{"nome": "André", "email": "andre@email.com"}' \
     -H "Content-Type: application/json" \
     https://api.exemplo.com/usuarios

# Form data
curl -d "nome=André&email=andre@email.com" \
     https://api.exemplo.com/usuarios

# Ler de arquivo
curl -d @dados.json \
     -H "Content-Type: application/json" \
     https://api.exemplo.com
```

## Exemplos Práticos Completos

### GET — Buscar dados

```bash
# GET simples
curl https://jsonplaceholder.typicode.com/users

# GET com query params
curl "https://api.exemplo.com/usuarios?nome=André&ativo=true"

# GET com header de autenticação
curl -H "Authorization: Bearer meu-token" \
     https://api.exemplo.com/dados-privados

# GET com accept
curl -H "Accept: application/xml" \
     https://api.exemplo.com/usuarios
```

### POST — Criar dados

```bash
curl -X POST https://jsonplaceholder.typicode.com/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "André de Omondes",
    "username": "andredeomondes",
    "email": "andre@email.com"
  }'
```

**Resposta esperada:**
```json
{
  "name": "André de Omondes",
  "username": "andredeomondes",
  "email": "andre@email.com",
  "id": 11
}
```

### PUT — Substituir dados

```bash
curl -X PUT https://jsonplaceholder.typicode.com/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "name": "Nome Atualizado",
    "username": "novoUsername",
    "email": "novo@email.com"
  }'
```

### PATCH — Atualizar parcialmente

```bash
curl -X PATCH https://jsonplaceholder.typicode.com/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "email": "novo-email@atualizado.com"
  }'
```

### DELETE — Remover dados

```bash
curl -X DELETE https://jsonplaceholder.typicode.com/users/1
```

## Opções Úteis

### -v ou --verbose: Ver detalhes

```bash
curl -v https://api.exemplo.com
```

**Saída:**
```
> GET / HTTP/1.1
> Host: api.exemplo.com
> User-Agent: curl/7.68.0
> Accept: */*
>
< HTTP/1.1 200 OK
< Content-Type: application/json
<
{"dados": "..."}
```

### -i ou --include: Headers da resposta

```bash
curl -i https://api.exemplo.com
```

### -I ou --head: Somente headers

```bash
curl -I https://api.exemplo.com
```

### -w ou --write-out: Info adicional

```bash
curl -w "\nTempo: %{time_total}s\n" https://api.exemplo.com
```

### -o ou --output: Salvar em arquivo

```bash
curl -o arquivo.json https://api.exemplo.com/dados
```

### --max-time: Timeout

```bash
curl --max-time 10 https://api.exemplo.com  # 10 segundos
```

### -L ou --location: Seguir redirects

```bash
curl -L https://bit.ly/abc123
```

## Autenticação

### Basic Auth

```bash
curl -u usuario:senha https://api.exemplo.com/perfil
```

### Bearer Token (JWT)

```bash
curl -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIs..." \
     https://api.exemplo.com/dados-privados
```

### API Key

```bash
curl -H "X-API-Key: sua-api-key-aqui" \
     https://api.exemplo.com/dados
```

## Exercícios Práticos

### 1. Listar usuários (GET)

```bash
curl https://jsonplaceholder.typicode.com/users
```

### 2. Buscar usuário específico (GET com ID)

```bash
curl https://jsonplaceholder.typicode.com/users/1
```

### 3. Criar usuário (POST)

```bash
curl -X POST https://jsonplaceholder.typicode.com/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "André Developer",
    "username": "ad新闻dev",
    "email": "andre.dev@email.com"
  }'
```

### 4. Filtrar com query params

```bash
curl "https://jsonplaceholder.typicode.com/posts?userId=1"
```

### 5. Verbos HTTP (testar todos)

```bash
# OPTIONS - Quais métodos o servidor aceita
curl -X OPTIONS -i https://api.exemplo.com

# HEAD - Sem body
curl -I https://api.exemplo.com
```

## Dicas Pro

### 1. Formatar JSON no terminal

```bash
# Instalar jq (processador de JSON)
# Linux: sudo apt install jq
# Mac: brew install jq

curl https://api.exemplo.com/dados | jq
```

### 2. Salvar cookie e reuse

```bash
# Salvar cookie
curl -c cookies.txt -d "user=admin&pass=123" https://api.exemplo.com/login

# Usar cookie salvo
curl -b cookies.txt https://api.exemplo.com/perfil
```

### 3. Enviar arquivo

```bash
curl -X POST -F "arquivo=@documento.pdf" \
     https://api.exemplo.com/upload
```

### 4. JSON completo com tudo

```bash
curl -v -X POST \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer token123" \
  -d '{"nome": "André"}' \
  https://api.exemplo.com/usuarios 2>&1 | grep -v "^*"
```

## API Pública para Praticar

| API | URL | Uso |
|-----|-----|-----|
| JSONPlaceholder | https://jsonplaceholder.typicode.com | GET, POST, PUT, DELETE |
| Dog API | https://dog.ceo/api/breeds/list/all | GET simples |
| Random User | https://randomuser.me/api/ | GET com params |
| Quotes | https://dummyjson.com/quotes | GET lista |

## Checklist de Uso

```bash
# 1. Escolher método
-X GET|POST|PUT|DELETE

# 2. Adicionar URL
https://api.exemplo.com/recurso

# 3. Headers necessários?
-H "Content-Type: application/json"
-H "Authorization: Bearer token"

# 4. Body (se POST/PUT)?
-d '{"campo": "valor"}'

# 5. Ver resultado?
-v (verbose) ou -i (include headers)
```

## Próximo passo

Agora você sabe HTTP e curl. Vamos criar um **mini-projeto: API Testing** para praticar!
