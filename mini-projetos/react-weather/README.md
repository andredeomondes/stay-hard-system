# React Weather App

Aplicação React em TypeScript para consulta de clima usando API pública.

## Stack

- React 18
- TypeScript
- Vite
- API pública de clima (OpenWeatherMap)

## Funcionalidades

- Buscar clima por nome da cidade
- Exibir temperatura, umidade e descrição
- Loading state durante requisição
- Tratamento de erros (cidade não encontrada)
- Hooks: useState, useEffect

## Como rodar

```bash
npm install
npm run dev
```

Acesse `http://localhost:5173` no navegador.

## Estrutura

```
react-weather/
├── src/
│   ├── components/
│   │   ├── SearchBar.tsx
│   │   └── WeatherCard.tsx
│   ├── services/
│   │   └── weatherApi.ts
│   ├── App.tsx
│   └── main.tsx
├── package.json
└── README.md
```
