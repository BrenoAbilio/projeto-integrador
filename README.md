# Alimentação Saudável

API REST desenvolvida em Java e Spring Boot para cadastro de clientes e cálculo da ingestão diária de proteínas.

## Tecnologias

- Java 21
- Spring Boot
- JdbcTemplate
- H2
- React
- Bruno

## Idealização

O sistema funciona como uma ficha nutricional simplificada.

### Dados informados pelo usuário

- Nome
- Peso
- Objetivo: Bulking, Manutenção ou Cutting
- Frequência de musculação: 1 a 7 vezes por semana
- Percentual de gordura (opcional)

### Fluxo

```text
Usuário informa os dados
          ↓
Sistema verifica se o percentual de gordura foi informado
          ↓
       ┌──┴──┐
      SIM    NÃO
       ↓      ↓
  usa massa  usa peso
    magra
       └──┬───┘
          ↓
Aplica o multiplicador de proteína
          ↓
    Proteína diária
```

### Quando o percentual de gordura é informado:
Massa magra = peso × (1 - percentual de gordura / 100)
Proteína diária = massa magra × multiplicador

### Quando o percentual de gordura não é informado:
Proteína diária = peso × multiplicador

### A frequência de musculação é dividida em três níveis:

| Frequência      | Nível |
| --------------- | ----- |
| 1–2x por semana | Baixa |
| 3–4x por semana | Média |
| 5–7x por semana | Alta  |

| Objetivo   |    Baixa |    Média |     Alta |
| ---------- | -------: | -------: | -------: |
| Bulking    | 1,6 g/kg | 1,8 g/kg | 2,0 g/kg |
| Manutenção | 1,6 g/kg | 1,8 g/kg | 2,0 g/kg |
| Cutting    | 1,8 g/kg | 2,0 g/kg | 2,2 g/kg |

### Referências

Os valores foram definidos com base em estudos e revisões sobre ingestão de proteína e treinamento de resistência.

Uma meta-análise de 49 estudos encontrou aproximadamente 1,6 g/kg/dia como ponto a partir do qual ganhos adicionais de massa muscular tendem a ser pequenos, e indicou ~2,2 g/kg/dia como uma estimativa prática para maximizar os resultados.

Para períodos de restrição calórica, estudos sugerem uma maior ingestão de proteína, chegando a aproximadamente 2,3–3,1 g/kg de massa magra, com o objetivo de preservar massa muscular.

As divisões de frequência e os multiplicadores exatos utilizados pelo sistema são regras de negócio do projeto, baseadas nessas faixas encontradas na literatura.


