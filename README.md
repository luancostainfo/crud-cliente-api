# CRUD de Clientes - Backend

Projeto criado para vaga de desenvolvedor fullstack da GS3.

Backend desenvolvido com Java, Spring Boot, Flyway, Lombok e MySQL.

[**Veja também o repositório com o front-end.**](https://github.com/luancostainfo/crud-cliente-web)

## Como executar o projeto

Edite o arquivo application-development.properties em src/main/resources/application-development.properties com as
informações necessárias correspondentes às configurações da sua máquina (usuário/senha do banco de dados), por padrão o
usuário é root e senha também é root. O projeto foi construído com a IDE InteliJ. Para executá-lo:

1. Entre na raiz do projeto utilizando um terminal
2. Gere o jar com o comando **mvn clean package**
3. Execute a aplicação com o comando **java -jar target/crud-cliente-api-0.0.1-SNAPSHOT.jar**

## Funcionalidades do software

- Listar todos os clientes
- Buscar cliente por id
- Cadastrar cliente
- Alterar cliente
- Excluir cliente
- Login de usuários e controle de permissões

## URLS

Observação: Para executar as requisições no Postman é necessário primeiro gerar um token JWT. Esse token então deve ser
enviado junto com as requisições feitas nas URLs. A aplicação front-end resolve todos esses detalhes sem necessidade de
intervenção do usuário.

- Screenshots com os passos usados no Postman:

![image](https://user-images.githubusercontent.com/73789803/129376583-82427cee-38a2-4afa-a851-fdb2f4337cb9.png)

![image](https://user-images.githubusercontent.com/73789803/129376745-634b90c3-a1eb-466c-b8d7-5439047a9cc2.png)

![image](https://user-images.githubusercontent.com/73789803/129376839-b89dc464-313a-4c11-9924-d44f283c70f5.png)

| URL                                   | Método | Descrição               |
|---------------------------------------|--------|-------------------------|
| `http://localhost:8080/oauth/token`   | POST   | Solicita Access Token   |
| `http://localhost:8080/oauth/token`   | POST   | Solicita Refresh Token  |
| `http://localhost:8080/tokens/revoke` | DELETE | Revoga o token atual    |
| `http://localhost:8080/clientes`      | GET    | Lista todos os clientes |
| `http://localhost:8080/clientes/{id}` | GET    | Retorna um cliente      |
| `http://localhost:8080/clientes`      | POST   | Cadastra um cliente     |
| `http://localhost:8080/clientes/{id}` | PUT    | Altera um cliente       |
| `http://localhost:8080/clientes/{id}` | DELETE | Exclui um cliente       |

Na raiz do projeto existe um arquivo de coleção chamado **crud_de_clientes.postman_collection.json** do postman que pode ser importado.

Para importar o arquivo vá em file -> import -> aba file -> upload file -> escolher arquivo citado acima.