
# GeBiblio - Gestão de Biblioteca!

Projeto de um sistema de Gestão de Biblioteca.
O projeto é dividido em duas partes:
- API de cadastros, consultas, alterações e exclusões de registros;
- Front-end

## Sobre a API

A API foi desenvolvida com Java e Spring Frameworkm, utilizando Spring Boot para facilitar a configuração e inicialização da aplicação.
A documentação completa com os endpoints, parâmetros e métodos (GET, POST, DELETE) pode ser consultada no seguinte endereço [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) com a aplicação rodando.

## Sobre o front-end

A parte de front-end será desenvolvida em Angular, utilizando a versão 14.

## Como rodar
- Instalar [PostgreSQL](https://www.postgresql.org/download/) ou um banco de dados de sua preferência;
- Criar uma `database`, por padrão o nome já configurado na aplicação é `gebiblio`:
    - `CREATE DATABASE gebiblio;`
- Clonar o projeto:
  `git clone https://github.com/WilliamAB/gebiblio.git`
- Configurar o arquivo `application.resources` dentro de `src/main/resources`:
    - URL de acesso ao banco (conforme banco instalado e nome do schema criado): `spring.datasource.url=jdbc:postgresql://localhost:5432/gebiblio`;
    - Usuário do banco de dados: `spring.datasource.username=postgres`
    - Senha do usuário do banco: `spring.datasource.password=senha`
- Executar a aplicação a partir do seguinte comando dentro do diretório clonado:
  `mvnw spring-boot:run`

## Como testar

- Acesse [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) para consultar a documentação da API e poder realizar os testes de requisições.
