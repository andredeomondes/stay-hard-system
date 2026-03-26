# 📚 RABBITMQ — Estudo Completo

## O que é RabbitMQ

RabbitMQ é um **message broker** open-source que usa o protocolo AMQP. Permite comunicação assíncrona entre aplicações via filas de mensagens.

```
Producer → Exchange → Queue → Consumer
```

### RabbitMQ vs Kafka

| Critério | RabbitMQ | Kafka |
|----------|----------|-------|
| Modelo | Message Queue | Event Streaming |
| Ordem | Garantida por fila | Garantida por partição |
| Retenção | Deletada após consumo | Persistida por tempo |
| Velocidade | ~30K msgs/seg | ~1M msgs/seg |
| Uso ideal | Notificações, tasks, RPC | Logs, analytics, event sourcing |

**Use RabbitMQ quando:** roteamento complexo, task queues, notificações, retry
**Use Kafka quando:** alta throughput, event sourcing, analytics tempo real

---

## Conceitos Core

- **Producer:** envia mensagens
- **Consumer:** recebe mensagens
- **Queue:** armazena mensagens
- **Exchange:** roteia mensagens para Queues
- **Binding:** conexão Exchange ↔ Queue
- **Routing Key:** endereço da mensagem

---

## Exchange Types

### Direct
Routing key exata → Queue específica
```
[routing_key: "error"] → Queue "error_logs"
```

### Fanout
Broadcast para TODAS as Queues (ignora routing key)
```
Fanout Exchange → Queue A + Queue B + Queue C
```

### Topic
Wildcards: `*` = uma palavra, `#` = múltiplas
```
"order.*"  → pega "order.created", "order.cancelled"
"order.#"  → pega "order.created.by.user.123"
```

### Headers
Rota por headers da mensagem

---

## Docker + RabbitMQ

```yaml
# docker-compose.yml
rabbitmq:
  image: rabbitmq:3-management
  environment:
    RABBITMQ_DEFAULT_USER: guest
    RABBITMQ_DEFAULT_PASS: guest
  ports:
    - "5672:5672"    # AMQP
    - "15672:15672"  # Management UI
```

Management UI: http://localhost:15672 (guest/guest)

---

## Spring Boot + RabbitMQ

### Dependência
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

### Config
```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

### Queues, Exchanges, Bindings
```java
@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "stay-hard.exchange";
    public static final String HABIT_QUEUE = "habit.completed.queue";
    public static final String NOTIFY_QUEUE = "notification.queue";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue habitQueue() {
        return QueueBuilder.durable(HABIT_QUEUE).build();
    }

    @Bean
    public Queue notificationQueue() {
        return QueueBuilder.durable(NOTIFY_QUEUE).build();
    }

    @Bean
    public Binding habitBinding() {
        return BindingBuilder.bind(habitQueue()).to(exchange()).with("habit.completed");
    }

    @Bean
    public Binding notifyBinding() {
        return BindingBuilder.bind(notificationQueue()).to(exchange()).with("habit.#");
    }
}
```

### Producer
```java
@Service
public class HabitEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishHabitCompleted(Long userId, String habitName) {
        Map<String, Object> message = Map.of(
            "userId", userId,
            "habitName", habitName,
            "timestamp", LocalDateTime.now().toString()
        );
        rabbitTemplate.convertAndSend(
            RabbitMQConfig.EXCHANGE, "habit.completed", message
        );
    }
}
```

### Consumer
```java
@Component
public class NotificationConsumer {

    @RabbitListener(queues = RabbitMQConfig.NOTIFY_QUEUE)
    public void handleHabitCompleted(Map<String, Object> message) {
        Long userId = (Long) message.get("userId");
        String habitName = (String) message.get("habitName");
        // Enviar notificação (email, push, websocket)
    }
}
```

---

## Dead Letter Queue (DLQ)

Fila para mensagens que falharam.

```java
@Bean
public Queue habitQueue() {
    return QueueBuilder.durable(HABIT_QUEUE)
        .deadLetterExchange("dlx.exchange")
        .deadLetterRoutingKey("dlq.habit")
        .build();
}
```

---

## Manual Acknowledgment

```java
@RabbitListener(queues = "my.queue")
public void handleMessage(String message, Channel channel,
                          @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
    try {
        processMessage(message);
        channel.basicAck(tag, false);   // Confirma
    } catch (Exception e) {
        channel.basicNack(tag, false, true);  // Rejeita e recoloca na fila
    }
}
```

---

## Stay Hard — Integração

Cenário: Hábito completado → Notificação via RabbitMQ

```
User completa hábito
       ↓
HabitService → HabitEventPublisher → RabbitMQ
       ↓                    ↓
  habit.completed.queue   notification.queue
       ↓                    ↓
  Analytics Service    Notification Service
  (salva log)          (envia notificação)
```

---

## Outros usos

- **MedTrack AI:** Appointment confirmado → email async
- **LegalMind AI:** Deadline de caso → notificação
- **BuildFlow AI:** Material em falta → alerta
- **TelecomPro:** Novo ticket → roteamento para agente

Padrões: Work Queue, Pub/Sub, RPC
