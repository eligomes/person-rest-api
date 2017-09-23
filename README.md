## Projeto API Rest em Java com Spring Framework(Spring Boot e Spring Data)

### Sobre o projeto ###
   Aplicação Java Rest. Além de código fonte e configurações, segue também a descrição de como o projeto foi desenvolvido e o que foi adotado para implementar.
   Essa aplicação foi desenvolvida seguindo os modelos de arquitetura MVC e REST.

### Tecnologias Utilizadas ###
* **Java versão 8.**
* **Spring Web MVC:** framework web usado como solução MVC para a definição de componentes seguindo o modelo de arquitetura REST
* **Spring Data JPA:** Tecnologia utilizada gerar parte do código relacionado a camada de persistência. Na aplicação foi escrito os contratos de persistência, que realizam a criação dos comandos de manipulação (CRUD), consultas.
* **Spring Boot:** tecnologia utilizada para criar um ambiente de execução. 
* **Maven:** gestão de ciclo de vida, build do projeto e dependências.
* **Swagger:** Utilizado para fazer a documentação da API juntamente com o "javadoc"
* **Tomcat:** embutido disponibilizado pelo Spring Boot.
* **Banco de dados relacional:** MySql.
* **Postman:** Cliente Rest para acessar a API.

### Camadas e pacotes ###
* **com.example:** Pacote com as configurações necessárias para o start da aplicação.
* **com.example.model:** Pacote contendo as entidades persistentes, mapeadas com anotações JPA.
* **com.example.repository:** Pacote contendo as interfaces de persistência.
* **com.example.service:** Pacote contendo os componentes de negócio, que são responsáveis por orquestrar os componentes de acesso a dados, transação com banco de dados e eventuais validações.
* **com.example.controller:** Pacote contendo os componentes Controller e serviços REST.
* **com.example.util:**  Pacote contendo as classes utilitárias configuração da documentação com Swagger e configuração de uma TaskExecutor para salvamento assíncrono de cadastro de pessoas.

### Pré-requisitos - (Instalações e configurações) ###
* JDK - versão 1.8 do Java;
* Maven - para build e dependências.
* Após baixar os fontes, para executar a aplicação é necessário:
* Criar um banco com o nome **"person-data"** em uma instância no MySql, as configurações de conexão podem ser encontradas no arquivo **src/main/resources/application.properties** (**Usuario:** root, **Senha:** root). A configuração está habilitada para criar a tabela **“person”** toda vez que a aplicação for executada.

Para executar a aplicação pela primeira vez execute o comando maven para baixar as dependências e buildar:
* **$ mvn clean package spring-boot:run**

As demais execuções pode ser usado o comando abaixo:
* **$ java -jar target/person-rest-api-0.0.1-SNAPSHOT.jar**

* Para acessar as funcionalidades da api utilizei o Postman:
No diretório **"src/main/resources"** tem um arquivo **person-postman.json"** que pode ser importado no Postman, nele contém todos os endereços listados abaixos prontos para serem executados, basta apenas escolher a opção **"Import"** no canto superior esquerdo da ferramenta e selecionar o arquivo person-postman.json para importação.

* Para a simulação do cadastro de pessoas em lote por falta de conexão, foi adicionado ao cadastro um time de 20 segundos, durante esse intervalo os cadastro podem ser feito normalmente, consulte a lista de pessoas antes e depois desse intervalo para visualizar as pessoas cadastradas. Tal processo é possível utilizando um recurso do spring boot de execução de thread  assíncrona no método de cadastro de pessoas. 

A documentação da API pode ser acessada no endereço baixo com a aplicação rodando:
* http://localhost:8080/swagger-ui.html#/person-controller </br></br>

Listar Pessoas (http://localhost:8080/person) </br>
Cadastrar Pessoas (http://localhost:8080/person/add)</br>
Editar Pessoas (http://localhost:8080/person/edit/{id})</br>
Deletar Pessoas (http://localhost:8080/person/delete/{id})</br>
Pesquisar Pessoa por CPF (http://localhost:8080/person/search/{cpf})

### JSON ###
<b>
{</br>
   "nome": "Fulano",</br>
   "sobrenome": "de Tal",</br>
   "nascimento": "2000-03-11T01:38:18.309Z",</br>
   "endereco": "Rua Liberdade 363",</br>
   "cpf": "88993456720",</br>
   "telefones": {"Trabalho": "11 23456-7654","Casa": "11 67890-0981"}</br>
}</b>
