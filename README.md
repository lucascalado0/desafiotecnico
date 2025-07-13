<h1>Desafio técnico - NTT DATA</h1>
<hr>
<p>
  O desafio tem como objetivo focar no desenvolvimento de um sistema simples de catálogo de produtos e simulação de pedidos. O sistema deve ser composto por dois microsserviços independentes, implementados utilizando Spring Boot e Spring Cloud. A comunicação entre os microsserviços será realizada via requisições HTTP, com o uso de um API Gateway e Service Discovery.
</p>
<h3>Dependências utilizadas</h3>
<ul>
  <li>H2 Database</li>
  <li>Lombok</li>
  <li>JPA</li>
  <li>Spring Cloud Eureka</li>
  <li>Spring Cloud Gateway</li>
</ul>
<hr>

<h3>Requisitos do desafio</h3>

<h3>Arquitetura Proposta</h3>
A arquitetura da aplicação é composta pelos seguintes componentes:
<ul>
  <li>Browser: Cliente que consome a API.</li>
  <li>API Gateway: Ponto de entrada único para todas as requisições, responsável pelo roteamento para os microsserviços apropriados.</li>
  <li>Service Discovery (Eureka): Permite que os microsserviços se registrem e descubram uns aos outros dinamicamente.</li>
  <li>Microsserviço 1 (Produtos): Gerencia o cadastro, listagem e consulta de produtos.</li>
  <li>Microsserviço 2 (Pedidos): Simula a criação de pedidos a partir dos produtos disponíveis.</li>
  <li>H2 Database: Banco de dados em memória utilizado pelo microsserviço de produtos para persistência.</li>
</ul>

<h2>Contexto do negócio</h3>

<h3>Microsserviço 1(Catálogo de Produtos)</h3>
<ul>
  <li>Realizar chamadas ao Microsserviço 1 para buscar os produtos disponíveis.</li>
  <li>A persistência dos dados deve ser feita em um banco de dados H2.</li>
</ul>

<h3>Microsserviço 2(Simulador de Pedidos)</h3>
<ul>
  <li>Realizar chamadas ao Microsserviço 1 para buscar os produtos disponíveis</li>
  <li>Simular a criação de um pedido com base em uma lista de produtos</li>
  <li>Não necessita de persistência de dados</li>
</ul>

<h2>Requisitos técnicos</h2>
<ul>
    <li>O sistema deve conter dois microsserviços independentes.</li>
    <li>Utilizar Spring Boot em todos os serviços.</li>
    <li>Usar Spring Cloud Eureka como Service Discovery.</li>
    <li>Utilizar Spring Cloud Gateway como API Gateway.</li>
    <li>Implementar APIs REST com boas práticas.</li>
    <li>
        Garantir que:
        <ul>
            <li>O Microsserviço 1 seja acessível pela rota /produtos.</li>
            <li>O Microsserviço 2 seja acessível pela rota /pedidos.</li>
            <li>Todos os endpoints devem ser acessados exclusivamente via Gateway.</li>
        </ul>
    </li>
</ul>

<h3>Portas</h3>
<ul>
  <li>Microsserviço 1 - Produtos: 8100-8199</li>
  <li>Microsserviço 2 - Pedidos: 8200-8299</li>
  <li>API Gateway: 8700-8799</li>
</ul>

<h2>Tabela de Endpoints da API</h2>

<p>A tabela a seguir detalha os endpoints disponíveis nos microsserviços de <strong>Produtos</strong> e <strong>Pedidos</strong>.</p>

<table>
  <thead>
    <tr>
      <th>Microsserviço</th>
      <th>Método HTTP</th>
      <th>URI Final (via Gateway)</th>
      <th>Descrição</th>
      <th>Corpo da Requisição (Body)</th>
      <th>Parâmetros de URL</th>
      <th>Resposta de Sucesso</th>
      <th>Resposta de Falha / Vazio</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Produtos</strong></td>
      <td><code>POST</code></td>
      <td><code>/produtos</code></td>
      <td>Cadastra um novo produto no sistema.</td>
      <td><code>ProdutoDTO</code></td>
      <td>-</td>
      <td><code>200 OK</code> com o <code>ProdutoDTO</code> criado.</td>
      <td><code>400 Bad Request</code> (em caso de dados inválidos)</td>
    </tr>
    <tr>
      <td><strong>Produtos</strong></td>
      <td><code>GET</code></td>
      <td><code>/produtos/listar</code></td>
      <td>Retorna a lista de todos os produtos cadastrados.</td>
      <td>-</td>
      <td>-</td>
      <td><code>200 OK</code> com uma <code>List&lt;ProdutoDTO&gt;</code>.</td>
      <td><code>204 No Content</code> (se não houver produtos)</td>
    </tr>
    <tr>
      <td><strong>Produtos</strong></td>
      <td><code>GET</code></td>
      <td><code>/produtos/consultar/{id}</code></td>
      <td>Consulta um produto específico pelo seu ID.</td>
      <td>-</td>
      <td><code>id</code> (na URL)</td>
      <td><code>200 OK</code> com o <code>ProdutoDTO</code> encontrado.</td>
      <td><code>404 Not Found</code> (se o produto não existir)</td>
    </tr>
    <tr>
      <td><strong>Pedidos</strong></td>
      <td><code>POST</code></td>
      <td><code>/pedidos</code></td>
      <td>Simula a criação de um pedido com base nos produtos.</td>
      <td><code>PedidoRequest</code></td>









