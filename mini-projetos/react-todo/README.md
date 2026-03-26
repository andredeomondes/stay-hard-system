# React Todo App

Aplicação React em TypeScript para gerenciamento de tarefas com persistência local.

## Stack

- React 18
- TypeScript
- Vite
- LocalStorage

## Funcionalidades

- Criar, editar e deletar tarefas
- Marcar tarefa como concluída
- Filtrar por status (todas, pendentes, concluídas)
- Persistência com LocalStorage
- Contador de tarefas

## Como rodar

```bash
npm install
npm run dev
```

Acesse `http://localhost:5173` no navegador.

## Estrutura

```
react-todo/
├── src/
│   ├── components/
│   │   ├── TodoForm.tsx
│   │   ├── TodoList.tsx
│   │   └── TodoItem.tsx
│   ├── hooks/
│   │   └── useLocalStorage.ts
│   ├── types/
│   │   └── Todo.ts
│   ├── App.tsx
│   └── main.tsx
└── README.md
```
