# GitHub Actions CI

Pipeline de CI com GitHub Actions: Teste, Build e Deploy automatizados.

## Stack

- GitHub Actions
- Java 17
- Maven
- JaCoCo (coverage)

## Funcionalidades

- Workflow em 3 stages: Test → Build → Deploy
- Execução de testes unitários automaticamente
- Relatório de cobertura com JaCoCo
- Build do artefato JAR
- Deploy simulado (extensível para produção)
- Cache de dependências Maven

## Como usar

1. Copie a pasta `.github/workflows/` para seu repositório
2. Faça push para a branch `main`
3. Acesse a aba Actions no GitHub para ver o pipeline

## Workflow

```
┌───────┐     ┌───────┐     ┌────────┐
│ Test  │────▶│ Build │────▶│ Deploy │
└───────┘     └───────┘     └────────┘
  JUnit         Maven        Artefato
  JaCoCo         JAR         (mock)
```

## Estrutura

```
github-actions-ci/
├── .github/
│   └── workflows/
│       └── ci.yml
├── src/
├── pom.xml
└── README.md
```
