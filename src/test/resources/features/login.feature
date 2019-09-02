# language: pt

Funcionalidade: Login

	Cenário: Realizar login com sucesso
		Dado que eu deseje logar no sistema
		Quando faço login com o usuário "admin@phptravels.com" e senha "demoadmin"
		Então sou autenticado com sucesso