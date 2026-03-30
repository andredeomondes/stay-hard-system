# 📚 SaaS + ERPs com IA — Estudo Completo

## Multi-Tenancy

### Estratégias

| Estratégia | Descrição | Pros | Cons |
|------------|-----------|------|------|
| Shared DB + tenant_id | Todos usam mesma tabela, coluna tenant_id | Simples, barato | Isolamento fraco |
| Schema per tenant | Cada tenant = schema diferente | Bom isolamento | Mais complexo |
| DB per tenant | Cada tenant = banco diferente | Isolamento total | Caro, difícil manter |

### Tenant Resolution
```java
// Via JWT claim
String tenantId = jwtTokenProvider.getTenantId(token);

// Via header
String tenantId = request.getHeader("X-Tenant-ID");

// Via subdomain
// tenant1.app.com → tenant1
// tenant2.app.com → tenant2
```

### Implementação (filtro de tenant)
```java
@Component
public class TenantFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest req = (HttpServletRequest) request;
        String tenantId = req.getHeader("X-Tenant-ID");
        TenantContext.setCurrentTenant(tenantId);
        try {
            chain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}
```

---

## RBAC (Role-Based Access Control)

```java
public enum Role {
    ADMIN,      // Acesso total
    MANAGER,    // Gerencia equipes + dados
    USER        // Acesso próprio
}

// No Security
@PreAuthorize("hasRole('ADMIN')")
public void deleteUser(Long id) { /* ... */ }

@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
public List<User> getAllUsers() { /* ... */ }
```

---

## 🏥 MedTrack AI — SaaS Médico

### Features
- Gestão de pacientes (CRUD)
- Agendamento de consultas (calendário)
- Prontuário eletrônico
- Prescrições
- 🤖 IA: Triagem de sintomas
- 🤖 IA: Sugestão de diagnóstico (RAG)
- 🤖 IA: Resumo de prontuário
- 💳 Cobrança por consulta (Stripe)

### Schema DB
```sql
patients (id, tenant_id, name, cpf, birth_date, created_at)
doctors (id, tenant_id, name, crm, specialty)
appointments (id, tenant_id, patient_id, doctor_id, date, status)
prescriptions (id, appointment_id, medication, dosage, instructions)
medical_records (id, patient_id, doctor_id, notes, diagnosis)
knowledge_base (id, content, embedding)  -- pgvector para RAG
```

### RAG Pipeline
```
1. Ingestão: artigos médicos, protocolos, guidelines
2. Chunking: dividir em pedaços de 500 tokens
3. Embedding: gerar vetores com OpenAI ada-002
4. Storage: pgvector no PostgreSQL
5. Query: médico pergunta → busca similares → LLM responde
```

---

## ⚖️ LegalMind AI — SaaS Jurídico

### Features
- Gestão de casos/processos
- Gestão de clientes
- Controle de prazos (calendário)
- Gestão de documentos
- 🤖 IA: Análise de contratos (RAG)
- 🤖 IA: Busca de jurisprudência similar
- 🤖 IA: Geração de minutas automáticas
- 🤖 IA: Resumo de processos longos

### Schema DB
```sql
clients (id, tenant_id, name, cpf_cnpj, type)
cases (id, tenant_id, client_id, title, status, court)
deadlines (id, case_id, description, due_date, status)
documents (id, case_id, type, file_url, content_text)
jurisprudencia (id, content, court, date, embedding)  -- pgvector
legislacao (id, content, law_number, article, embedding)
```

### RAG Pipeline
```
Base de conhecimento:
  - Jurisprudência (STF, STJ, TJ)
  - Legislação (CF, CPC, CLT, etc)
  - Documentos do escritório

Advogado: "Tem jurisprudência sobre dano moral em atraso de voo?"
IA: Busca jurisprudência similar + retorna casos + sugere argumentação
```

---

## 🔧 BuildFlow AI — SaaS Engenharia

### Features
- Gestão de projetos de obra
- Cronograma Gantt
- Controle de materiais/estoque
- Gestão de equipes
- 🤖 IA: Estimativa de custos (baseado em projetos passados)
- 🤖 IA: Detecção de atraso em cronograma
- 🤖 IA: Sugestão de otimização de recursos
- 📊 Dashboard financeiro

### Schema DB
```sql
projects (id, tenant_id, name, budget, start_date, end_date, status)
teams (id, project_id, name, specialty)
materials (id, project_id, name, quantity, unit_price, supplier)
milestones (id, project_id, name, due_date, completed_date)
normas_tecnicas (id, content, nbr_code, embedding)  -- pgvector
historico_projetos (id, project_data, cost_result, embedding)
```

---

## 📡 TelecomPro — SaaS Telecom

### Features
- Gestão de clientes B2B/B2C
- Gestão de planos e serviços
- Faturamento automático
- Ticket de suporte
- 🤖 IA: Previsão de churn (cliente cancelar)
- 🤖 IA: Chatbot de suporte (RAG com FAQs)
- 🤖 IA: Análise de performance de rede

### Schema DB
```sql
customers (id, tenant_id, name, type, status)
plans (id, tenant_id, name, price, features)
subscriptions (id, customer_id, plan_id, start_date, status)
tickets (id, customer_id, subject, status, priority)
invoices (id, subscription_id, amount, due_date, paid)
faqs (id, content, category, embedding)  -- pgvector
```

---

## Padrões comuns a todos ERPs

| Padrão | Descrição |
|--------|-----------|
| Audit Log | MongoDB registra quem fez o quê (user_id, action, timestamp) |
| File Upload | S3/MinIO para documentos, imagens |
| Export | PDF, Excel para relatórios |
| Dashboard | Recharts/Chart.js no frontend |
| RBAC | Admin, Manager, User |
| Billing | Stripe subscriptions |
| Notifications | WebSocket + Email + RabbitMQ |
| Multi-tenant | tenant_id em todas tabelas |

---

## 📝 ANOTAÇÕES PESSOAIS

### O que aprendi:
> 


### Pontos importantes:
> 


### Dúvidas:
> 

---
