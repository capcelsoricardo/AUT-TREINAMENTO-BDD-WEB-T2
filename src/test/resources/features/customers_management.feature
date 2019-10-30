# language: pt

@CustomersManagement
Funcionalidade: Customers Management

	Contexto: 
		Dado que eu esteja na tela de login
		Quando faço login com o usuário "admin@phptravels.com" e senha "demoadmin"
		Dado que eu esteja na tela Home
		Quando acesso o menu Accounts

	@IncluirCustomer @Exercicio5
	Cenário: Incluir Customer
		Dado que eu esteja na tela Customers Management
		Quando incluo um customer
			|First Name			| Last Name| Email 					 	  | Password | Mobile Number | Country | Address 1  | Address 2  | Status  | 
			|	Matheus				| Ferreira | teste@celsuu.com.br| 123456   | 11986596778   | Brazil  | Rua Jandira| Casa 2		 | Enabled | 
		Então customer cadastrado com sucesso        
	    
	@AlterarCustomer @Exercicio6
	Cenário: Alterar informações do usuário Customer Management
		Dado que eu esteja na tela Customers Management
		Quando altero informações do customer
			|First Name			| Last Name| 						Email Antigo 			 |	 Email Novo		| Password | Mobile Number | Country | Address 1  | Address 2  | Status  |
			|	Celso 				| Ferreira | 		teste@celsoo.com.br 			 | 		inm@inm.com	| 123456   | 11986596778   | Brazil  | Rua Jandira| Casa 2		 | Enabled | 
		Então informações do customer alterada com sucesso     
		
	@ExcluirCustomer @Exercicio7
	Cenário: Excluir usuário Customer Management
		Dado que eu esteja na tela Customers Management
		Quando excluo o customer "applebeauty@gmail.com" 
		Então customer "applebeauty@gmail.com" excluido com sucesso