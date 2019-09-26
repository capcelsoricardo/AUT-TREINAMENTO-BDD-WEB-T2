package curso.treinamento.steps;


import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.HomePage;
import curso.treinamento.pages.LoginPage;
import curso.treinamento.setup.Hooks;


public class LoginSteps {
	
	private LoginPage loginPage = new LoginPage(Hooks.getDriver());
	private HomePage   homePage = new HomePage(Hooks.getDriver());
	

	@Dado("que eu esteja na tela de login")
	public void que_eu_deseje_logar_no_sistema() throws InterruptedException {
		
		loginPage.clicar_remove_frame();
		
		Assert.assertTrue("Página Login não foi apresentada.", loginPage.validar_pagina());
	}

	@Quando("faço login com o usuário {string} e senha {string}")
	public void faco_login_com_o_usuário_e_senha(String user, String pass) {
		
		loginPage.preencher_email(user);
		loginPage.preencher_password(pass);
		loginPage.clicar_botao_login();
	}

	@Então("sou autenticado com sucesso")
	public void sou_autenticado_com_sucesso() throws InterruptedException {
		
		Assert.assertTrue("Login não realizado com sucesso!.", homePage.validar_pagina());
	}

	@Então("é apresentado a mensagem {string}")
	public void é_apresentado_a_mensagem(String mensagem) {				
		Assert.assertTrue("A mensagem '" + mensagem +"' NÃO foi apresentada.",   loginPage.validar_mensagem_email_invalido());				
	}

}
