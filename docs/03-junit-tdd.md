# 📚 JUNIT + TDD

## O que é JUnit?
Framework de testes unitários para Java.

## O que é TDD?
Test-Driven Development — escrever testes ANTES do código.

```
1. Escrever teste (vermelha)
2. Implementar código (verde)
3. Refatorar
```

## Estrutura de Teste:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void testSoma() {
        int resultado = 2 + 3;
        assertEquals(5, resultado);
    }
}
```

## Assertions comuns:
```java
assertEquals(esperado, atual);
assertTrue(condicao);
assertFalse(condicao);
assertNull(objeto);
assertNotNull(objeto);
assertThrows(Exception.class, () -> metodo());
```

## Antes e Depois:
```java
class DatabaseTest {
    
    @BeforeEach
    void setUp() {
        // Roda antes de cada teste
        conexao = new Conexao();
    }
    
    @AfterEach
    void tearDown() {
        // Roda depois de cada teste
        conexao.fechar();
    }
}
```

## Testar exceções:
```java
@Test
void testDivisaoPorZero() {
    assertThrows(ArithmeticException.class, () -> {
        calculadora.dividir(10, 0);
    });
}
```

## Testar collections:
```java
@Test
void testListaNaoVazia() {
    List<String> nomes = List.of("André", "Maria");
    assertFalse(nomes.isEmpty());
    assertEquals(2, nomes.size());
}
```

## Mockito (mocks):
```java
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Test
    void testBuscarUsuario() {
        when(repository.findById(1)).thenReturn(new User("André"));
        
        UserService service = new UserService(repository);
        User user = service.buscar(1);
        
        assertEquals("André", user.getNome());
    }
}
```

## Rodar testes:
```bash
mvn test
```

---

## 📝 ANOTAÇÕES PESSOAIS

### O que aprendi hoje:
> 


### Pontos importantes:
> 


### Dúvidas:
> 


### Como aplicar no Stay Hard:
> 

---
