# Code Challenge Back-end (API)
Este projeto tem como objetivo principal a disponibilização de serviços para PDV (Ponto de Venda). [ZX-Ventures Challenge](https://github.com/ZXVentures/code-challenge)


## Índice

* [Tecnologias Utilizadas](#tecnologias-utilizadas)
* [Pré-requisitos](#pré-requisitos)
* [Documentação](#documentação)
  - [Serviços (API)](#serviços)
  - [Deploy Local](#deploy-local)
  - [Deploy Producao](#deploy-producao)


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

3. Git  
  Link com instruções de instalação [Download](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).  
	
	Clone do projeto:  
	```
	git clone https://github.com/felipeguimaraes/code-challenge-api.git
	```
	  
	  **Observação:** uma alternativa para não utilizar o Git é realizar o download do projeto ZIP e descompactar para utilização nas próximas etapas [Download ZIP](https://github.com/felipeguimaraes/code-challenge-api/archive/master.zip)



## Documentação

### - Serviços

A documentação dos serviços (API) está disponível junto com o projeto via Swagger.  

Esta ferramenta permite que além de documentar, pode ser realizado também testes diretamente via browser de forma simples e intuitiva.  

Como acessar:  

Local -> [http://localhost:8080/swagger-ui.html#/pdv-resource](http://localhost:8080/swagger-ui.html#/pdv-resource)  

Produção -> http://<IP_OU_DOMINIO>:8080/swagger-ui.html#/pdv-resource  


Tela inicial do Swagger com os serviços do PDV:  

![Serviços do PDV](files/images/swagger.png)  



Exemplo - Request - Serviço de pesquisa por Longitude e Latitude:  

![Serviços do PDV](files/images/pdv-search-request.png)  


Exemplo - Response - Serviço de pesquisa por Longitude e Latitude:  

![Serviços do PDV](files/images/pdv-search-response.png)  



### - Deploy locall
asdfasdf


### - Deploy produção
asdfasdf
