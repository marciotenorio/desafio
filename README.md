# Desafio

## Orientações
1. Importar o project no Eclipse como `Existing Maven Project` 
2. Adicionar como servidor o `Tomcat 9` . Caso exista servidor, excluir, adicionar o `Tomcat 9`, `Next` e adicionar o projeto.
3. Acessar pelo navegador o endereço: `localhost:8080/desafioesig/cadastrarevento.xhtml`

Para as operações com o banco de dados funcionarem, é preciso ter o MySQL instalado, editar os atributos da classe ` EventoJDBC` com os dados do seu banco e efetuar os seguintes comandos:
>CREATE DATABASE DESAFIO;
>USE DESAFIO;
>SELECT DATABASE();
>CREATE TABLE eventos(
	nome VARCHAR(50) NOT NULL,
    PRIMARY KEY(nome)
);


## Itens Cobertos

A) Foram utilizados componentes JSF para a UI e um componente server-side bean.
B) Do CRUD foi feito o cadastrar e ler. Apesar do código das outras operações estarem prontos, não consegui pegar o dado do componente Primefaces.
G) Foram utilizados alguns componentes do Primefaces.

No mais utilizei JDBC para conectar e fazer as operações no banco de dados (MySQL no caso)