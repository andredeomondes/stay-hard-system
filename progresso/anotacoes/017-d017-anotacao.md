# 📝 DIA 17 — Anotações

**Data:** __/__/2026

---

## O que aprendi:

### Streams API

```java
// filter - filtrar
list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

// map - transformar
list.stream().map(n -> n * 2).collect(Collectors.toList());

// forEach - iterar
list.forEach(n -> System.out.println(n));

// reduce - reduzir a um valor
list.stream().reduce(0, (a, b) -> a + b);
```

---

## Reflexão: