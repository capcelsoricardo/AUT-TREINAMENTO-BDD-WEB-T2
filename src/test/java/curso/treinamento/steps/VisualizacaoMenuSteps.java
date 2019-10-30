package curso.treinamento.steps;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.HomePage;
import curso.treinamento.pages.MenuPage;
import curso.treinamento.setup.Hooks;


public class VisualizacaoMenuSteps {
	
	HomePage homePage = new HomePage(Hooks.getDriver());
	MenuPage menuPage = new MenuPage(Hooks.getDriver());
	
	@Dado("que eu esteja na tela Home")
	public void que_eu_esteja_na_tela_Home() {
	    Assert.assertTrue("Página Home NÃO foi apresentada.", homePage.validar_pagina());
	}
	
	@Quando("acesso o menu General")
	public void acesso_o_menu_General() {
		menuPage.clicar_menu_general();		
	}

	@Quando("acesso o menu Cars")
	public void acesso_o_menu_Cars() {		
		menuPage.clicar_menu_cars();	    
	}

	@Então("são apresentados os itens do menu Cars {string}, {string} e {string}")
	public void sao_apresentados_os_itens(String subMenuCars, String subMenuExtras, String subMenuSettings) {
		
		Assert.assertTrue("Submenu "+ subMenuCars + " NÃO apresentado.", menuPage.validar_submenu_cars(subMenuCars));
		Assert.assertTrue("Submenu "+ subMenuExtras + " NÃO apresentado.", menuPage.validar_submenu_cars(subMenuExtras));
		Assert.assertTrue("Submenu "+ subMenuSettings + " NÃO apresentado.", menuPage.validar_submenu_cars(subMenuSettings));
	}
	
	@Quando("acesso o menu Accounts")
	public void acesso_o_menu_Accounts() {		
		menuPage.clicar_menu_accounts();	 		
	}

	@Então("são apresentados os itens do menu Accounts {string}, {string}, {string} e {string}")
	public void sao_apresentados_os_itens(String subMenuAdmins, String subMenuSuppliers, String subMenuCustomers, String subMenuGuestCustomers) {
		
		Assert.assertTrue("Submenu "+ subMenuAdmins + " NÃO apresentado.", menuPage.validar_submenu_accounts(subMenuAdmins));
		Assert.assertTrue("Submenu "+ subMenuSuppliers + " NÃO apresentado.", menuPage.validar_submenu_accounts(subMenuSuppliers));
		Assert.assertTrue("Submenu "+ subMenuCustomers + " NÃO apresentado.", menuPage.validar_submenu_accounts(subMenuCustomers));
		Assert.assertTrue("Submenu "+ subMenuGuestCustomers + " NÃO apresentado.", menuPage.validar_submenu_accounts(subMenuGuestCustomers));
	} 	
	
	@Quando("acesso o menu Tours")
	public void acesso_o_menu_Tours() {		
		menuPage.clicar_menu_tours();
	}

	@Então("são apresentados os itens do menu Tours {string}, {string}, {string}, {string} e {string}")
	public void sao_apresentados_os_itens(String subMenuTours, String subMenuAddNew, String subMenuExtras, String subMenuReviews, String subMenuSettings) {
		
		Assert.assertTrue("Submenu "+ subMenuTours + " NÃO apresentado.", menuPage.validar_submenu_tours(subMenuTours));
		Assert.assertTrue("Submenu "+ subMenuAddNew + " NÃO apresentado.", menuPage.validar_submenu_tours(subMenuAddNew));
		Assert.assertTrue("Submenu "+ subMenuExtras + " NÃO apresentado.", menuPage.validar_submenu_tours(subMenuExtras));
		Assert.assertTrue("Submenu "+ subMenuReviews + " NÃO apresentado.", menuPage.validar_submenu_tours(subMenuReviews));
		Assert.assertTrue("Submenu "+ subMenuSettings + " NÃO apresentado.", menuPage.validar_submenu_tours(subMenuSettings));
	}	
	
	@Quando("acesso o menu Travelhope Hotels")
	public void acesso_o_menu_travelhope_hotels() {
		menuPage.clicar_menu_travelhope_hotels();	    
	}

	@Então("são apresentados os itens do menu Travelhope Hotels {string} e {string}")
	public void são_apresentados_os_itens_do_menu_travelhope_hotels(String subMenuBookings, String subMenuSettings) {
		
		Assert.assertTrue("Submenu "+ subMenuBookings + " NÃO apresentado.", menuPage.validar_submenu_travelhope_hotels(subMenuBookings));
		Assert.assertTrue("Submenu "+ subMenuSettings + " NÃO apresentado.", menuPage.validar_submenu_travelhope_hotels(subMenuSettings));
		
	}
}
