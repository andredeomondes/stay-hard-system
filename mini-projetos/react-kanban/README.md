# React Kanban Board

Board Kanban com drag and drop básico em React e TypeScript.

## Stack

- React 18
- TypeScript
- Vite
- HTML5 Drag and Drop API

## Funcionalidades

- Colunas: To Do, In Progress, Done
- Criar cards em cada coluna
- Arrastar e soltar cards entre colunas
- Editar e deletar cards
- Persistência com LocalStorage

## Como rodar

```bash
npm install
npm run dev
```

Acesse `http://localhost:5173` no navegador.

## Estrutura

```
react-kanban/
├── src/
│   ├── components/
│   │   ├── Board.tsx
│   │   ├── Column.tsx
│   │   └── Card.tsx
│   ├── hooks/
│   │   └── useDragAndDrop.ts
│   ├── types/
│   │   └── Kanban.ts
│   ├── App.tsx
│   └── main.tsx
└── README.md
```
