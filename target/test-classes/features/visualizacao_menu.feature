# language: pt

@Menu
Funcionalidade: Visualização de Menu

	Contexto: 
		Dado que eu esteja na tela de login
		Quando faço login com o usuário "admin@phptravels.com" e senha "demoadmin"

	@MenuCars
	Cenário: Validar itens apresentados no menu Cars
		Dado que eu esteja na tela Home
		Quando acesso o menu Cars
		Então são apresentados os itens do menu Cars "Cars", "Extras" e "Cars Settings" 
		
	@MenuAccounts
	Cenário: Validar itens apresentados no menu Accounts
		Dado que eu esteja na tela Home
		Quando acesso o menu Accounts
		Então são apresentados os itens do menu Accounts "Admins", "Suppliers", "Customers" e "GuestCustomers" 
		
	@MenuTours @Exercicio2
	Cenário: Validar itens apresentados no menu Tours
		Dado que eu esteja na tela Home
		Quando acesso o menu Tours
		Então são apresentados os itens do menu Tours "Tours", "Add New", "Extras", "Reviews" e "Settings"
				
	@MenuTravelhopeHotels @Exercicio1
	Cenário: Validar itens apresentados no menu Travelhope Hotels
		Dado que eu esteja na tela Home
		Quando acesso o menu Travelhope Hotels
		Então são apresentados os itens do menu Travelhope Hotels "Bookings" e "Settings"