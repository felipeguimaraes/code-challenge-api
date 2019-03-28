# Code Challenge Back-end (API)
Este projeto tem como objetivo principal a disponibilização de serviços para PDV (Ponto de Venda). [ZX-Ventures Challenge](https://github.com/ZXVentures/code-challenge)


## Índice

* [Tecnologias Utilizadas](#tecnologias-utilizadas)
* [Pré-requisitos](#pré-requisitos)
* [Documentação](#documentação)
  - [Serviços (API)](#serviços)
  - [Deploy Local](#deploy-local)
  - [Deploy Producao](#deploy-produção)


## Tecnologias utilizadas
1. Java 8
2. Spring Boot 
3. Swagger (documentação e teste de APIs [veja mais...](https://swagger.io/))
4. Maven
5. MongoDB (tecnologia escolhida como Banco de Dados)
6. Git (apenas para download do projeto)

## Pré-requisitos

As tecnologias utilizadas abaixo são cross-platform, ou seja, rodam praticamente em qualquer ambiente (Windows, Linux, MacOS, etc).  

1. Java 8  
  Link com instruções de instalação [Download](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).  

2. MongoDB  
  Link com instruções de instalação [Download](https://docs.mongodb.com/manual/installation/).  
  Após a instalação, abrir o console (de acordo com cada Sistema Operacional) e executar o startup do MongoDB:  

	Linux / MacOS:
	```
	mongod
	```
	
	Windows:
	```
	C:\<DIRETORIO_INSTALACAO_MONGO>\bin>mondod
	```

	Resultado esperado:
	```javascript
	...NETWORK  [initandlisten] waiting for connections on port 27017
	```

	*O MongoDB deve estar rodando para executar o deploy da aplicação, pois ele é pré-requisito para execução dos testes da API.*  
	
	

3. Git  
  Link com instruções de instalação [Download](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).  
	
	Clone do projeto:  
	```
	git clone https://github.com/felipeguimaraes/code-challenge-api.git
	```
	  
	  **Observação:** uma alternativa para não utilizar o Git é realizar o download do projeto ZIP e descompactar para utilização nas próximas etapas [Download ZIP](https://github.com/felipeguimaraes/code-challenge-api/archive/master.zip)



## Documentação


### Serviços

A documentação dos serviços (API) está disponível junto com o projeto via Swagger.  

Esta ferramenta permite que além de documentar, pode ser realizado também testes diretamente via browser de forma simples e intuitiva.  

Como acessar:  

Local -> [http://localhost:8080/swagger-ui.html#/pdv-resource](http://localhost:8080/swagger-ui.html#/pdv-resource)  

Produção -> http://<IP>:8080/swagger-ui.html#/pdv-resource  


Tela inicial do Swagger com os serviços do PDV:  

![Serviços do PDV](files/images/swagger.png)  



Exemplo - Request - Serviço de pesquisa por Longitude e Latitude:  

![Serviços do PDV](files/images/pdv-search-request.png)  


Exemplo - Response - Serviço de pesquisa por Longitude e Latitude:  

![Serviços do PDV](files/images/pdv-search-response.png)  



### Deploy local
O *deploy local* utilizará por padrão o MongoDB que foi instalado também localmente [Pré-requisitos](#pré-requisitos). O profile *dev* será utilizado como padrão.

No entanto, se desejar, é possível alterar a URL do MongoDB apontando para alguma instalação não local (ambiente de dev, qa, cloud, etc). Basta alterar o arquivo `src/main/resources/env/config.dev.properties` e no atributo `spring.data.mongodb.uri` especificar a URL. Exemplo: `spring.data.mongodb.uri=mongodb://127.0.0.1:27017/test?retryWrites=true`  

Após procedimento de clone do Git (ou procedimento via download+descompactação do projeto [Pré-requisitos](#pré-requisitos)), no diretório do projeto, realizar o seguinte comando para compilar:

Linux / MacOS:
```
./mvnw clean package
```

Windows:
```
mvnw.cmd clean package
```

Resultado esperado:
```javascript
[INFO] ---------------------
[INFO] BUILD SUCCESS
[INFO] ---------------------
```

Após a compilação, ainda dentro do diretório do projeto, executar o comando abaixo para startup da aplicação:


Linux / MacOS:
```
java -jar target/api.jar
```

Windows:
```
java -jar target\api.jar
```

Pronto! Serviços do PDV no ar! Podem ser acessados via client de qualquer linguagem de programação, Curl, ou via [Swagger](http://localhost:8080/swagger-ui.html#/pdv-resource).

### Deploy produção

Para o *deploy produção*, recomendamos utilizar o profile *prod*. Assim é possível especificar uma URL diferente do MongoDB. Basta alterar o arquivo `src/main/resources/env/config.prod.properties` e no atributo `spring.data.mongodb.uri` especificar a URL. Exemplo de um MondoGB (SaaS): `spring.data.mongodb.uri=mongodb+srv://code-challenge:code@cluster0-mxtth.mongodb.net/test?retryWrites=true`  

Os procedimentos abaixo (compilação e deploy do pacote) podem ser tanto executados diretamente no servidor de produção, ou apenas compilar localmente e o deploy em produção.   
*Em um ambiente de trabalho real, o ideal é que todos esses procedimentos estejam automatizados utilizando conceitos como CI/CD (integração e entrega contínua).*

Após procedimento de clone do Git (ou procedimento via download+descompactação do projeto [Pré-requisitos](#pré-requisitos)), no diretório do projeto, realizar o seguinte comando para compilar (com o profile *prod*):

Linux / MacOS:
```
./mvnw clean package -Pprod
```

Windows:
```
mvnw.cmd clean package -Pprod
```

Resultado esperado:
```javascript
[INFO] ---------------------
[INFO] BUILD SUCCESS
[INFO] ---------------------
```

Após a compilação, executar o comando abaixo para startup da aplicação:


Linux / MacOS:
```
java -jar target/api.jar
```
ou
```
java -jar api.jar
```

Windows:
```
java -jar target\api.jar
```
ou
```
java -jar api.jar
```

Pronto! Serviços do PDV no ar! Podem ser acessados via client de qualquer linguagem de programação, Curl, ou via Swagger -> http://<IP_OU_DOMINIO>:8080/swagger-ui.html#/pdv-resource  

