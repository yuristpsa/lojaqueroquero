# CRUD REST com Quarkus

Projeto desenvolvido com Quarkus que implementa a seguintes funcionalidades:

- Cadastrar, alterar, buscar por matrcula e listar vendedores
- Cadastrar, alterar e listar produtos
- Cadastrar venda, uma venda é definida por um vendedor e um ou mais itens
  - Listar vendedores ordenados por maior número de vendas
  - Listar vendedores ordenados por maior valor total vendido
  - Listar itens ordenados por maior quantidade de vendas

## Executando a aplicação em modo de desenvolvimento

1. Na interface de linha de comando, navegue até o diretório docker e execute o comando para iniciar docker-compose. Na primeira vez que for executado, será feito o build da imagem do postgresql contendo o script de inicialização responsável pela criação do usuário do banco e concessão de acesso.

```shell script
docker-compose up -d
```

2. Ainda na interface de linha de comando, navegue até o diretório raiz da aplicação e execute o comando abaixo para inicializar a aplicação em modo de desenvolvimento.

```shell script
mvn install quarkus:dev
```

## Exemplos de Chamadas

Nesta seção são expostas as instruções para realização de cada uma das possíveis chamadas:

### CRUD Vendedor

#### Cadastrar novo vendedor

`POST /salesman`

```json
{
	 "name": "Yuri Stapassoli de Sá",
	 "registration": "yuristpsa"
}
```
#### Atualizar vendedor existente

`POST /salesman/{id}`

```json
{
	 "name": "Yuri Stapassoli",
}
```

