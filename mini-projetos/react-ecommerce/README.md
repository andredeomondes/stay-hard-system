# React E-commerce

Catálogo de produtos com carrinho de compras usando Context API para gerenciamento de estado.

## Stack

- React 18
- TypeScript
- Vite
- Context API
- React Router

## Funcionalidades

- Catálogo de produtos com lista e detalhes
- Carrinho de compras (adicionar, remover, alterar quantidade)
- Context API para state global
- Cálculo de total do carrinho
- Páginas: Home, Produto, Carrinho

## Como rodar

```bash
npm install
npm run dev
```

Acesse `http://localhost:5173` no navegador.

## Estrutura

```
react-ecommerce/
├── src/
│   ├── components/
│   │   ├── ProductCard.tsx
│   │   └── CartItem.tsx
│   ├── context/
│   │   └── CartContext.tsx
│   ├── pages/
│   │   ├── Home.tsx
│   │   ├── ProductDetail.tsx
│   │   └── Cart.tsx
│   ├── App.tsx
│   └── main.tsx
└── README.md
```
