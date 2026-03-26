# React Chat

Interface de chat em React com introdução a WebSocket.

## Stack

- React 18
- TypeScript
- Vite
- WebSocket (API nativa)

## Funcionalidades

- Interface de chat com lista de mensagens
- Envio de mensagens em tempo real
- Simulação de WebSocket (server mock)
- Identificação de usuário
- Timestamp nas mensagens
- Auto-scroll para última mensagem

## Como rodar

```bash
# Terminal 1 - Servidor WebSocket mock
node server.js

# Terminal 2 - Frontend
npm install
npm run dev
```

Acesse `http://localhost:5173` no navegador.

## Estrutura

```
react-chat/
├── src/
│   ├── components/
│   │   ├── ChatWindow.tsx
│   │   ├── MessageList.tsx
│   │   └── MessageInput.tsx
│   ├── hooks/
│   │   └── useWebSocket.ts
│   ├── App.tsx
│   └── main.tsx
├── server.js
└── README.md
```
