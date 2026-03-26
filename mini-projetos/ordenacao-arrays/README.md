# Ordenação de Arrays

Implementação dos principais algoritmos de ordenação em Java com medição de desempenho.

## Stack

- Java 17+
- System.nanoTime()

## Funcionalidades

- Bubble Sort
- Selection Sort
- Insertion Sort
- Medição de tempo de execução de cada algoritmo
- Comparação de performance com arrays de diferentes tamanhos
- Exibição do array antes e depois da ordenação

## Como rodar

```bash
javac -d out src/*.java
java -cp out Main

# Com tamanho customizado
java -cp out Main --size 10000
```

## Estrutura

```
ordenacao-arrays/
├── src/
│   ├── BubbleSort.java
│   ├── SelectionSort.java
│   ├── InsertionSort.java
│   ├── SortingBenchmark.java
│   └── Main.java
└── README.md
```
