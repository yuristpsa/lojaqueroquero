# CRUD REST com Quarkus

Projeto desenvolvido com Quarkus que implementa a seguintes funcionalidades:

- Cadastrar, alterar, buscar por matrícula e listar vendedores
- Cadastrar, alterar e listar produtos
- Cadastrar venda, uma venda é definida por um vendedor e um ou mais itens
  - Listar vendedores ordenados por maior número de vendas
  - Listar vendedores ordenados por maior valor total vendido
  - Listar itens ordenados por maior quantidade de vendas

## Executando a aplicação em modo de desenvolvimento

1. Na interface de linha de comando, navegue até o diretório /src/main/docker e execute o comando para iniciar docker-compose. Na primeira vez que for executado, será feito o build da imagem do postgresql contendo o script de inicialização responsável pela criação do usuário do banco e concessão de acesso.

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

`POST /salesmans`

```json
{
	 "name": "Yuri Stapassoli de Sá",
	 "registration": "yuristpsa"
}
```
#### Atualizar vendedor existente

`PUT /salesmans/{id}`

```json
{
	 "name": "Yuri Stapassoli"
}
```

#### Excluir vendedor

`DEL /salesmans/{id}`

#### Buscar por matrícula

`GET /salesmans/{matricula}`

#### Listar todos

`GET /salesmans`

### CRUD Produto

#### Cadastrar novo produto

`POST /products`

```json
{
	"name": "Aspirador de Pó Robô",
	"price": "1000"
}
```
#### Atualizar produto existente

`PUT /products/{id}`

```json
{
	"price": 900
}
```

#### Excluir produto

`DEL /products/{id}`

#### Listar todos

`GET /products`

### Cadastro e relatórios de vendas

#### Cadastrar nova venda

`POST /sales`

```json
{
	"salesman": {
		"id": 1
	},
	"saleItems": [
		{
			"product": {
				"id": 1
			},
			"amount": 5
		}	
	]
}
```
#### Lista de produtos ordenado pelos mais vendidos

`GET /sales/reports/best-selling-items`

#### Lista dos vendedores por maior número de vendas

`GET /sales/reports/best-sellers-by-sales-quantity`

#### Lista dos vendedores por valor vendido

`GET /sales/reports/best-sellers-by-value-sold`

