# Desafio Injeção de Dependência

### Formação Desenvolvedor Moderno
### Módulo: Back end
### Capítulo: Componentes e injeção de dependência

## DESAFIO: Componentes e injeção de dependência
<p>Este projeto é um desafio de programação do curso Java Spring Profissional, do DevSuperior.
Trata-se de uma aplicação Spring Boot que demonstra o uso de injeção de dependência para calcular o valor total de pedidos, 
incluindo descontos e custos de envio. </p>

<p>A regra para cálculo do frete é a seguinte:</p>
<table border="1" cellpadding="5" cellspacing="0">
    <thead>
        <tr>
            <th>Valor básico do pedido (sem desconto)</th>
            <th>Frete</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Abaixo de R$ 100.00</td>
            <td>R$ 20.00</td>
        </tr>
        <tr>
            <td>De R$ 100.00 até R$ 200.00 exclusive</td>
            <td>R$ 12.00</td>
        </tr>
        <tr>
            <td>R$ 200.00 ou mais</td>
            <td>Grátis</td>
        </tr>
    </tbody>
</table>

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `src/main/java/com/api/desafio_injecao_dependencia`
  - `DesafioInjecaoDependenciaApplication.java`: Classe principal que inicia a aplicação Spring Boot e executa alguns cenários de teste.
  - `entities`
    - `Order.java`: Classe que representa um pedido, contendo código, valor básico e desconto.
  - `services`
    - `OrderService.java`: Interface que define o contrato para o serviço de pedidos.
    - `ShippingService.java`: Interface que define o contrato para o serviço de envio.
  - `services/impl`
    - `OrderServiceImpl.java`: Implementação do serviço de pedidos, que calcula o valor total do pedido.
    - `ShippingServiceImpl.java`: Implementação do serviço de envio, que calcula o custo de envio.

### Executando a Aplicação
Para executar a aplicação, utilize o Maven para compilar e rodar o projeto:
```bash
mvn spring-boot:run
```
<p>
A aplicação irá iniciar e executar alguns cenários de teste, exibindo os resultados no console.  
</p>
