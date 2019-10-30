# language: pt

@WidgetsManagement
Funcionalidade: Widgets Management

	Contexto: 
		Dado que eu esteja na tela de login
		Quando faço login com o usuário "admin@phptravels.com" e senha "demoadmin"
		Dado que eu esteja na tela Home
		Quando acesso o menu General

	@IncluirWidgets @Exercicio8
	Cenário: Incluir Widgets
		Dado que eu esteja na tela Widgets Management
		Quando incluo um Widgets
			|	Widget Name					| Widget Status| Widget Content 		| 
			|	teste_celso					| Enable			 | Teste de Software	| 
		Então widget cadastrado com sucesso        
	    
	@AlterarWidgets @Exercicio9
	Cenário: Alterar informações do Widgets
		Dado que eu esteja na tela Widgets Management
		Quando altero informações do widgets
			|	Widget Name Antigo	|	Widget Name Novo	  | Widget Status| Widget Content 		  | 
			|	teste_celso					|	teste_celso_alterado| Enable			 | Teste de Software 2	|  
		Então informações do widgets alterada com sucesso     
		
	@ExcluirWidgets @Exercicio10
	Cenário: Excluir Widgets Management
		Dado que eu esteja na tela Widgets Management
		Quando excluo o widgets "Footer hotels booking expedia and other logos" 
		Então widgets "Footer hotels booking expedia and other logos" excluido com sucesso