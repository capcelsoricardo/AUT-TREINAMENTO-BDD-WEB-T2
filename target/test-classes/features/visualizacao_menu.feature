# language: pt

Funcionalidade: Visualização de Menu

	Contexto: 
		Dado que eu esteja na tela de login
		Quando faço login com o usuário "admin@phptravels.com" e senha "demoadmin"

	@Menu
	Cenário: Itens apresentados no menu Cars
		Dado que eu esteja na tela Home
		Quando acesso o menu Cars
		Então são apresentados os itens "Cars", "Extras" e "Cars Settings" 
		
	@MenuAccounts
	Cenário: Itens apresentados no menu Accounts
		Dado que eu esteja na tela Home
		Quando acesso o menu Accounts
		Então são apresentados os itens "Admins", "Suppliers", "Customers" e "GuestCustomers" 