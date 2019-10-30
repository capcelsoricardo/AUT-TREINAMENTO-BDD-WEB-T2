# language: pt

Funcionalidade: Admins Management

	Contexto: 
		Dado que eu esteja na tela de login
		Quando faço login com o usuário "admin@phptravels.com" e senha "demoadmin"
		Dado que eu esteja na tela Home
		Quando acesso o menu Accounts

	@IncluirAdministrador
	Cenário: Incluir Administrador
		Dado que eu esteja na tela Admins Management
		Quando incluo um administrador
			|First Name			| Last Name| Email 					 	  | Password | Mobile Number | Country | Address 1  | Address 2 | Status  | Add 	 | Edit   | Remove    |
			|	Matheus				| Ferreira | teste@celso1.com.br| 123456   | 11986596778   | Brazil  | Rua Jandira| Casa 2		 | Enabled | Tours |  Cars  | Locations | 
		Então administrador cadastrado com sucesso
		
	@IncluirAdminstradores
		Esquema do Cenário: Inclusão de Administradores
			Dado que eu esteja na tela Admins Management
			Quando incluo um adminstrador com os valores: "<First Name>", "<Last Name>", "<Email>", "<Password>", "<Mobile Number>", "<Country>", "<Address 1>", "<Address 2>", "<Status>", "<Add>", "<Edit>", "<Remove>" 
			Então administrador "<Email>" cadastrado com sucesso
			
			Exemplos: 
					|First Name			| Last Name| Email 					 	   | Password | Mobile Number | Country | Address 1  | Address 2 | Status  | Add 	 | Edit   | Remove    |
				  |	Matheus				| Ferreira | celso@teste2.com.br | 123456   | 11986596778   | Brazil  | Rua Jandira| Casa 2		 | Enabled | Tours |  Cars  | Locations |
	        |	Matheus				| Ferreira | celso2@teste2.com.br| 123456   | 11986596778   | Bolivia | Rua Jandira| Casa 2		 | Enabled | Tours |  Cars  | Locations |
	        |	Matheus				| Ferreira | celso3@teste2.com.br| 123456   | 11986596778   | Bulgaria| Rua Jandira| Casa 2		 | Enabled | Tours |  Cars  | Locations |
	        
	    
	@AlterarAdministrador @Exercicio3
	Cenário: Alterar informações do usuário Admins Management
		Dado que eu esteja na tela Admins Management
		Quando altero informações do administrador
			|First Name			| Last Name| 						Email Antigo 			 |	 Email Novo		| Password | Mobile Number | Country | Address 1  | Address 2 | Status  | Add 	 | Edit   | Remove    |
			|	Celso 				| Ferreira | 		6testadmin@phptravels.com	 | 		inm@inm.com	| 123456   | 11986596778   | Brazil  | Rua Jandira| Casa 2		 | Enabled | Tours |  Cars  | Locations | 
		Então informações do administrador alterada com sucesso     
		
	@ExcluirAdministrador @Exercicio4
	Cenário: Excluir usuário Admins Management
		Dado que eu esteja na tela Admins Management
		Quando excluo o administrador "7testadmin@phptravels.com" 
		Então administrador "7testadmin@phptravels.com" excluido com sucesso