# modulo03
projeto individual do módulo Programação Orientada a Objetos II

#### professor:
* Jackson Braga

#### aluno:
* Marcos Torres

----

## Funcionamento
A aplicação simula uma loja virtual simples.

Inicialmente uma listagem com os produtos (previamente cadastrados) disponíveis na loja é mostrada ao usuário:
![2023-01-22 (7)](https://user-images.githubusercontent.com/17331645/213940765-ccb10278-9f45-42b3-9926-691b9286e919.png)

<br>

O sistema recebe o comando de adicionar um produto ao carrinho, um item por vez. Depois que um item é adicionado, a listagem dos produtos aparece novamente para que o usuário adicione outro produto ao carrinho:
![2023-01-22 (8)](https://user-images.githubusercontent.com/17331645/213940909-9e6a508e-f2a0-4b7c-9f14-0c5d43008ba6.png)

<br>

Em vez de adicionar um produto ao carrinho, o usuário pode acessar o carrinho. O carrinho mostra os produtos adicionados, com seus preços unitários e a quantidade de cada um, além do valor total atual da compra:
![2023-01-22 (10)](https://user-images.githubusercontent.com/17331645/213941125-e026d16f-d0dc-4e5d-a557-2e0238dbdac1.png)

<br>

Depois de acessar o carrinho, o usuário pode decidir ou por finalizar a compra, ou por retornar para adicionar mais produtos ao carrinho:
<br>
![2023-01-22 (11)](https://user-images.githubusercontent.com/17331645/213941287-a86c6de2-a45f-407f-a109-4822cc61ad51.png)

<br>

Caso o usuário, depois de acessar o carrinho, decida finalizar a compra, as opções de pagamento são mostradas:
![2023-01-22 (14)](https://user-images.githubusercontent.com/17331645/213941379-17c6b93f-d10f-488b-8fbd-8b3f995cf787.png)

<br>

Caso o usuário escolha uma opção de pagamento que não ofereça a opção de parcelamento, o sistema entende que o pagamento foi feito. Assim a compra é finalizada, o carrinho é esvaziado, e o usuário retorna ao início, podendo realizar uma nova compra:
![2023-01-22 (15)](https://user-images.githubusercontent.com/17331645/213941744-272404e7-373c-4569-83fb-6c997f83e443.png)

<br>

Caso o usuário escolha uma forma de pagamento que dê suporte a parcelamento, ele é requisitado a escolher o número de parcelas:
<br>
![2023-01-22 (16)](https://user-images.githubusercontent.com/17331645/213941969-224558fb-22ea-4629-8fb3-5f4042fb30a4.png)

<br>

Após escolher um número válido de parcelas, o sistema entende que o pagamento foi feito, assim o carrinho é esvaziado e a compra é finalizada. Em seguida o usuário volta ao início, podendo fazer uma nova compra:
![2023-01-22 (17)](https://user-images.githubusercontent.com/17331645/213942123-268c421e-3f7c-4bda-b441-76dd9aab2ea6.png)

----

## Modelagem

A modelagem escolhida para essa aplicação foi a seguinte:

* Existe uma classe OnlineStore, que representa a loja virtual em si. Um objeto de OnlineStore possui um objeto de Client, e uma coleção de objetos de Product 
* Existe uma classe Client, que representa a pessoa que utiliza aquela instância da loja virtual. Um objeto de Client possui um objeto de ShoppingCart.
* Existe uma classe ShoppingCart, que representa um carrinho de compras virtual, isto é, um local virtual onde produtos são guardados até a finalização da compra. Um objeto de ShoppingCart possui uma coleção de objetos de Product.
* Existe uma classe Product, que representa algum produto possuído pela loja virtual, ou armazenado no carrinho de compras.
* Existe ainda um enum PaymentOptions, que agrupa todas as diferentes formas de pagamento (PayPal, boleto, etc).
* Existe ainda uma classe específica para a interação com o usuário: a classe OnlineStoreView. Toda a entrada/saída de dados se dá por essa classe, desacoplando o sistema (back-end) do front-end.
