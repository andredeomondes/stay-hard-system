# 📚 STREAMS API — Processamento Funcional de Coleções

## O que é?

**Streams API** é uma forma de processar coleções de dados de maneira:
- ✅ Declarativa (diga O QUE quer, não COMO fazer)
- ✅ Funcional (sem mutações)
- ✅ Paralela (pode usar múltiplas threads)
- ✅ Limpa e concisa

## stream() vs Collection

```
Collection  → Como armazenar dados
Stream      → Como processar dados
```

```java
// Collection: como guardar
List<String> nomes = List.of("André", "Maria", "João");

// Stream: como processar
nomes.stream()
      .filter(nome -> nome.startsWith("A"))
      .map(String::toUpperCase)
      .forEach(System.out::println);
```

## Operações

### 1. Criar Stream

```java
// De Collection
List<String> lista = List.of("a", "b", "c");
Stream<String> stream = lista.stream();

// De Array
String[] array = {"a", "b", "c"};
Arrays.stream(array);

// De valores
Stream<Integer> numeros = Stream.of(1, 2, 3, 4, 5);

// Stream vazia
Stream<String> vazia = Stream.empty();

// Range
IntStream.range(1, 5);        // 1, 2, 3, 4
IntStream.rangeClosed(1, 5);  // 1, 2, 3, 4, 5

// Iterar
Stream.iterate(0, n -> n + 2)  // 0, 2, 4, 6, ...
    .limit(10);

// Gerar
Stream.generate(() -> "x")  // x, x, x, ...
    .limit(5);
```

### 2. Operações Intermediárias (retornam Stream)

| Operação | Descrição | Exemplo |
|----------|-----------|---------|
| `filter` | Filtra elementos | `.filter(n -> n > 0)` |
| `map` | Transforma elementos | `.map(String::toUpperCase)` |
| `flatMap` | Achata listas | `.flatMap(List::stream)` |
| `distinct` | Remove duplicatas | `.distinct()` |
| `sorted` | Ordena | `.sorted()` |
| `limit` | Limita quantidade | `.limit(10)` |
| `skip` | Pula elementos | `.skip(5)` |
| `takeWhile` | Pega enquanto true | `.takeWhile(n -> n < 5)` |
| `dropWhile` | Descarta enquanto true | `.dropWhile(n -> n < 5)` |

### 3. Operações Terminais (retornam algo diferente)

| Operação | Retorno | Descrição |
|----------|---------|-----------|
| `forEach` | void | Itera |
| `collect` | Collection | Coleta em lista/set/map |
| `toList` | List | Coleta em lista (Java 16+) |
| `count` | long | Conta elementos |
| `sum` | int/double | Soma (IntStream) |
| `average` | OptionalDouble | Média |
| `min` | Optional | Menor valor |
| `max` | Optional | Maior valor |
| `anyMatch` | boolean | Algum satisfaz? |
| `allMatch` | boolean | Todos satisfazem? |
| `noneMatch` | boolean | Nenhum satisfaz? |
| `findFirst` | Optional | Primeiro elemento |
| `findAny` | Optional | Algum elemento |
| `reduce` | Optional | Reduz a um valor |

## Exemplos Práticos

### filter — Filtrar

```java
List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Filtrar pares
List<Integer> pares = numeros.stream()
    .filter(n -> n % 2 == 0)
    .toList();
// [2, 4, 6, 8, 10]

// Filtrar maiores que 5
List<Integer> maiores = numeros.stream()
    .filter(n -> n > 5)
    .toList();
// [6, 7, 8, 9, 10]
```

### map — Transformar

```java
List<String> nomes = List.of("André", "Maria", "João");

// Converter para maiúsculas
List<String> maiusculos = nomes.stream()
    .map(String::toUpperCase)
    .toList();
// [ANDRÉ, MARIA, JOÃO]

// Transformar em comprimento
List<Integer> tamanhos = nomes.stream()
    .map(String::length)
    .toList();
// [5, 5, 4]

// Transformar tipo
List<String> numeros = List.of("1", "2", "3");
List<Integer> inteiros = numeros.stream()
    .map(Integer::parseInt)
    .toList();
// [1, 2, 3]
```

### chained — Encadear operações

```java
List<String> nomes = List.of("André", "maria", "JOÃO", "ana");

// Filter + Map + Sort
List<String> resultado = nomes.stream()
    .filter(n -> n.length() > 3)           // Filtrar > 3 chars
    .map(String::toLowerCase)               // Minúsculas
    .sorted()                               // Ordenar
    .toList();
// [ana, andré, joão]
```

### collect — Coletar

```java
List<String> nomes = List.of("André", "Maria", "João");

// Para List
List<String> lista = nomes.stream().toList();

// Para Set (remove duplicatas)
Set<String> set = nomes.stream().collect(Collectors.toSet());

// Para LinkedList
LinkedList<String> linked = nomes.stream()
    .collect(Collectors.toCollection(LinkedList::new));

// Agrupar por tamanho
Map<Integer, List<String>> porTamanho = nomes.stream()
    .collect(Collectors.groupingBy(String::length));
// {4: [João], 5: [André, Maria]}
```

### count, min, max

```java
List<Integer> numeros = List.of(3, 1, 4, 1, 5, 9, 2, 6);

long count = numeros.stream().count(); // 8

Optional<Integer> min = numeros.stream().min(Integer::compareTo);
Optional<Integer> max = numeros.stream().max(Integer::compareTo);
// min: 1, max: 9
```

### anyMatch, allMatch, noneMatch

```java
List<Integer> numeros = List.of(1, 2, 3, 4, 5);

// Algum é maior que 4?
boolean algum = numeros.stream()
    .anyMatch(n -> n > 4); // true

// Todos são positivos?
boolean todos = numeros.stream()
    .allMatch(n -> n > 0); // true

// Nenhum é zero?
boolean nenhum = numeros.stream()
    .noneMatch(n -> n == 0); // true
```

### findFirst, findAny

```java
List<String> nomes = List.of("André", "Maria", "João");

Optional<String> primeiro = nomes.stream()
    .filter(n -> n.length() > 3)
    .findFirst(); // Optional["André"]

Optional<String> qualquer = nomes.stream()
    .filter(n -> n.length() > 3)
    .findAny(); // Pode ser "André" ou "Maria"
```

### reduce — Reduzir a um valor

```java
List<Integer> numeros = List.of(1, 2, 3, 4, 5);

// Somar todos
int soma = numeros.stream()
    .reduce(0, (a, b) -> a + b); // 15

// Produto de todos
int produto = numeros.stream()
    .reduce(1, (a, b) -> a * b); // 120

// Maior valor
Optional<Integer> maior = numeros.stream()
    .reduce(Integer::max); // Optional[5]

// Concatenar strings
String concat = List.of("A", "B", "C").stream()
    .reduce("", (a, b) -> a + b); // "ABC"
```

### sum, average (IntStream)

```java
IntStream.range(1, 6)           // 1, 2, 3, 4, 5
    .sum();                     // 15

IntStream.range(1, 6)
    .average();                 // OptionalDouble[3.0]

IntStream.range(1, 6)
    .summaryStatistics();
// IntSummaryStatistics{count=5, sum=15, min=1, average=3.0, max=5}
```

### flatMap — Achatar listas

```java
List<List<String>> listas = List.of(
    List.of("A", "B"),
    List.of("C", "D"),
    List.of("E")
);

// Sem flatMap (List<List<String>>)
List<List<String>> aninhado = listas.stream()
    .toList();

// Com flatMap (List<String>)
List<String> achatado = listas.stream()
    .flatMap(lista -> lista.stream())
    .toList();
// [A, B, C, D, E]

// Outro exemplo: palavras únicas de frases
List<String> frases = List.of(
    "java é legal",
    "java e python",
    "python é fácil"
);
Set<String> palavrasUnicas = frases.stream()
    .flatMap(frase -> Arrays.stream(frase.split(" ")))
    .collect(Collectors.toSet());
// {java, é, legal, python, e, fácil}
```

### distinct — Remover duplicatas

```java
List<Integer> numeros = List.of(1, 2, 2, 3, 3, 3, 4);
List<Integer> unicos = numeros.stream()
    .distinct()
    .toList();
// [1, 2, 3, 4]
```

### sorted — Ordenar

```java
List<String> nomes = List.of("Pedro", "Ana", "Carlos");

// Orden natural
List<String> ordenado = nomes.stream()
    .sorted()
    .toList();
// [Ana, Carlos, Pedro]

// Ordenar por tamanho
List<String> porTamanho = nomes.stream()
    .sorted(Comparator.comparingInt(String::length))
    .toList();
// [Ana, Pedro, Carlos]

// Ordenar reverso
List<String> reverso = nomes.stream()
    .sorted(Comparator.reverseOrder())
    .toList();
// [Pedro, Carlos, Ana]
```

## parallelStream — Processamento Paralelo

```java
// Sequencial (1 thread)
list.stream()
    .filter(...)
    .map(...)

// Paralelo (múltiplas threads)
list.parallelStream()
    .filter(...)
    .map(...)

// OU
list.stream()
    .parallel()
    .filter(...)
    .map(...)
```

**Quando usar paralelo?**
- Listas grandes (> 10.000 elementos)
- Operações custosas (não trivial)
- ⚠️ Cuidado: ordem pode mudar!

## Exemplo Completo: Pipeline

```java
List<Usuario> usuarios = List.of(
    new Usuario("André", 25, true),
    new Usuario("Maria", 30, false),
    new Usuario("João", 17, true),
    new Usuario("Ana", 22, false)
);

// Pipeline: Filtrar adultos ativos, ordenar por nome, pegar nomes
List<String> nomes = usuarios.stream()
    .filter(u -> u.idade >= 18)          // Filtrar maiores de 18
    .filter(Usuario::isAtivo)              // Filtrar ativos
    .sorted(Comparator.comparing(Usuario::getNome)) // Ordenar
    .map(Usuario::getNome)                 // Pegar só nomes
    .toList();
// [André, João]
```

## Dica: toList() vs collect(toList())

```java
// Java 16+ (mais limpo)
List<String> lista = stream.toList();

// Java 8-15 (verboso)
List<String> lista = stream.collect(Collectors.toList());

// Java 8-15 immutable (se precisar de verdade)
List<String> lista = stream.collect(Collectors.collectingAndThen(
    Collectors.toList(),
    Collections::unmodifiableList
));
```

## Resumo Visual

```
┌─────────────────────────────────────────────────────────────┐
│  stream()                                                   │
│      ↓                                                      │
│  [Operações Intermediárias]                                 │
│      ↓                                                      │
│  filter()  ──→  map()  ──→  sorted()  ──→  distinct()    │
│      ↓                                                      │
│  [Operação Terminal]                                        │
│      ↓                                                      │
│  forEach()  /  collect()  /  reduce()  /  count()         │
└─────────────────────────────────────────────────────────────┘
```

## Próximo passo

Aprender **Lambdas** — a sintaxe que faz Streams funcionarem.
