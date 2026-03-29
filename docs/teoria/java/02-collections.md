# 📚 COLLECTIONS — Listas, Sets e Maps

## Hierarquia

```
Iterable
    └── Collection
            ├── List (interface)
            │       ├── ArrayList (implementação)
            │       ├── LinkedList (implementação)
            │       └── Vector (implementação)
            │
            ├── Set (interface)
            │       ├── HashSet (implementação)
            │       ├── LinkedHashSet (implementação)
            │       └── TreeSet (implementação - ordenado)
            │
            └── Queue (interface)
                    ├── LinkedList
                    ├── PriorityQueue
                    └── Deque
                            └── ArrayDeque

Map (interface) - NÃO estende Collection!
    ├── HashMap (implementação)
    ├── LinkedHashMap (implementação)
    ├── TreeMap (implementação - ordenado)
    └── Hashtable (implementação - thread-safe)
```

## List — Lista Ordenada (por índice)

### Características:
- ✅ Mantém ordem de inserção
- ✅ Permite duplicatas
- ✅ Acesso por índice (get(0))
- ❌ Busca lenta em listas grandes

### Implementações:

| Implementação | Velocidade Get | Velocidade Add | Quando usar |
|-------------|----------------|----------------|-------------|
| **ArrayList** | ⚡ O(1) | 🐢 O(n) | Acesso aleatório frequente |
| **LinkedList** | 🐢 O(n) | ⚡ O(1) | Inserções frequentes no meio |
| **Vector** | ⚡ O(1) | 🐢 O(n) | Thread-safe (legacy) |

### ArrayList — Uso Comum:

```java
// Criar lista
List<String> nomes = new ArrayList<>();

// Adicionar elementos
nomes.add("André");
nomes.add("Maria");
nomes.add("João");

// Adicionar em posição específica
nomes.add(1, "Pedro"); // ["André", "Pedro", "Maria", "João"]

// Acessar por índice
String primeiro = nomes.get(0); // "André"

// Modificar
nomes.set(0, "André Updated");

// Remover
nomes.remove(0);              // Remove por índice
nomes.remove("Maria");        // Remove por objeto

// Tamanho
int tamanho = nomes.size(); // 3

// Verificar
boolean tem = nomes.contains("André"); // true
boolean vazia = nomes.isEmpty();       // false
```

### Iterar sobre List:

```java
List<String> nomes = List.of("André", "Maria", "João");

// 1. For-each (mais comum)
for (String nome : nomes) {
    System.out.println(nome);
}

// 2. Lambda + forEach
nomes.forEach(nome -> System.out.println(nome));

// 3. Method reference (atalho)
nomes.forEach(System.out::println);

// 4. For tradicional (com índice)
for (int i = 0; i < nomes.size(); i++) {
    System.out.println(i + ": " + nomes.get(i));
}

// 5. Streams
nomes.stream()
     .filter(nome -> nome.startsWith("A"))
     .forEach(System.out::println);
```

## Set — Conjunto (sem duplicatas)

### Características:
- ✅ Não permite duplicatas
- ✅ Busca rápida (HashSet)
- ❌ Não tem índice
- ❌ Não mantém ordem (exceto LinkedHashSet, TreeSet)

### Implementações:

| Implementação | Ordem | Velocidade | Uso |
|---------------|-------|------------|-----|
| **HashSet** | Nenhuma | ⚡⚡⚡ Mais rápido | Busca rápida, ordem não importa |
| **LinkedHashSet** | Inserção | ⚡⚡ Rápido | Precisa da ordem de inserção |
| **TreeSet** | Natural | ⚡ Rápido | Precisa de ordem (Comparable) |

### HashSet — Uso Comum:

```java
// Criar set
Set<String> linguagens = new HashSet<>();

// Adicionar
linguagens.add("Java");
linguagens.add("Python");
linguagens.add("Java"); // Ignorado (duplicado!)

// Tamanho
linguagens.size(); // 2 (não 3!)

// Verificar
linguagens.contains("Java"); // true

// Remover
linguagens.remove("Python");

// Iterar
for (String lang : linguagens) {
    System.out.println(lang);
}
```

### TreeSet — Ordenado:

```java
Set<Integer> numeros = new TreeSet<>();
numeros.add(5);
numeros.add(2);
numeros.add(8);
numeros.add(1);

// Iterar (já ordenado: 1, 2, 5, 8)
numeros.forEach(System.out::println);
```

## Map — Pares Chave-Valor

### Características:
- ✅ Armazena pares (chave, valor)
- ✅ Busca rápida por chave
- ✅ Chaves únicas (não duplica)
- ❌ Não é Collection (não estende Collection)

### Implementações:

| Implementação | Ordem | Velocidade | Uso |
|---------------|-------|------------|-----|
| **HashMap** | Nenhuma | ⚡⚡⚡ Mais rápido | Busca rápida, ordem não importa |
| **LinkedHashMap** | Inserção | ⚡⚡ Rápido | Precisa da ordem de inserção |
| **TreeMap** | Natural | ⚡ Rápido | Precisa de ordem |
| **Hashtable** | Nenhuma | ⚡ Sincronizado | Thread-safe (legacy) |

### HashMap — Uso Comum:

```java
// Criar map
Map<String, Integer> idadePorNome = new HashMap<>();

// Adicionar
idadePorNome.put("André", 25);
idadePorNome.put("Maria", 30);
idadePorNome.put("João", 28);

// Atualizar (sobrescreve valor antigo)
idadePorNome.put("André", 26);

// Buscar por chave
int idade = idadePorNome.get("André"); // 26
int idadeInexistente = idadePorNome.get("Pedro"); // null

// Verificar
boolean existe = idadePorNome.containsKey("André"); // true
boolean temIdade25 = idadePorNome.containsValue(25); // false (agora é 26)

// Remover
idadePorNome.remove("João");

// Tamanho
idadePorNome.size(); // 2
```

### Iterar sobre Map:

```java
Map<String, Integer> mapa = Map.of("André", 25, "Maria", 30, "João", 28);

// 1. Iterar chaves
for (String chave : mapa.keySet()) {
    System.out.println(chave);
}

// 2. Iterar valores
for (Integer valor : mapa.values()) {
    System.out.println(valor);
}

// 3. Iterar chaves e valores
for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
    String chave = entry.getKey();
    Integer valor = entry.getValue();
    System.out.println(chave + " = " + valor);
}

// 4. Lambda (mais moderno)
mapa.forEach((chave, valor) -> System.out.println(chave + " = " + valor));
```

## Coleções Úteis — factory methods

### List.of(), Set.of(), Map.of():

```java
// Lista imutável
List<String> nomes = List.of("André", "Maria", "João");

// Set imutável
Set<String> linguagens = Set.of("Java", "Python", "JavaScript");

// Map imutável
Map<String, Integer> idades = Map.of(
    "André", 25,
    "Maria", 30,
    "João", 28
);

// ⚠️ Não pode modificar! (UnsupportedOperationException)
// nomes.add("Pedro"); // ERRO!
```

## Métodos Comuns a Todas Collections

```java
List<String> lista = new ArrayList<>();

// Adicionar
lista.add("item");           // Adiciona no final
lista.add(0, "item");        // Adiciona na posição

// Remover
lista.remove(0);             // Por índice
lista.remove("item");         // Por objeto
lista.clear();                // Limpa tudo

// Verificar
boolean vazia = lista.isEmpty();    // true/false
boolean tem = lista.contains("x"); // true/false
int tamanho = lista.size();          // número de elementos

// Combinar
lista.addAll(outraLista);    // Adiciona todos
boolean mudou = lista.removeAll(outraLista); // Remove os que estão na outra
boolean temTodos = lista.containsAll(outraLista); // Contém todos?
```

## Collections Utility Class

```java
import java.util.Collections;

// Ordenar
List<Integer> numeros = new ArrayList<>(List.of(3, 1, 2));
Collections.sort(numeros); // [1, 2, 3]

// Inverter
Collections.reverse(numeros); // [3, 2, 1]

// Embaralhar
Collections.shuffle(numeros);

// Mínimo e Máximo
int min = Collections.min(numeros);
int max = Collections.max(numeros);

// Preencher
List<String> lista = new ArrayList<>(10);
Collections.fill(lista, "x"); // ["x", "x", "x", ...]

// Buscar binária (lista deve estar ordenada!)
int pos = Collections.binarySearch(numeros, 2);

// Sincronizar (thread-safe)
List<String> syncList = Collections.synchronizedList(new ArrayList<>());
```

## Arrays Utility Class

```java
import java.util.Arrays;

// Ordenar
int[] nums = {3, 1, 2};
Arrays.sort(nums); // [1, 2, 3]

// Buscar binária
int pos = Arrays.binarySearch(nums, 2);

// Preencher
int[] array = new int[5];
Arrays.fill(array, 10); // [10, 10, 10, 10, 10]

// Converter array para List
String[] nomes = {"André", "Maria"};
List<String> lista = Arrays.asList(nomes);

// toString
System.out.println(Arrays.toString(nums)); // [1, 2, 3]
```

## Quando Usar Cada Um?

| Situação | Use |
|----------|-----|
| Preciso de índice? | `List` |
| Preciso de valores únicos? | `Set` |
| Preciso de chave-valor? | `Map` |
| Busca frequente? | `HashSet`, `HashMap` |
| Ordem de inserção? | `LinkedHashSet`, `LinkedHashMap` |
| Ordem natural? | `TreeSet`, `TreeMap` |
| Inserção/remoção no meio? | `LinkedList` |

## Exercícios Rápidos

```java
// 1. Contar palavras únicas
String texto = "java java python ruby java";
String[] palavras = texto.split(" ");
Set<String> unicas = new HashSet<>(Arrays.asList(palavras));
System.out.println(unicas.size()); // 3

// 2. Contar frequência
Map<String, Integer> freq = new HashMap<>();
for (String p : palavras) {
    freq.put(p, freq.getOrDefault(p, 0) + 1);
}
// {java=3, python=1, ruby=1}

// 3. Remover duplicatas mantendo ordem
List<Integer> comDup = List.of(1, 2, 2, 3, 1, 4);
List<Integer> semDup = new ArrayList<>(new LinkedHashSet<>(comDup));
// [1, 2, 3, 4]
```

## Próximo passo

Aprender **Streams API** para processar Collections de forma funcional.
