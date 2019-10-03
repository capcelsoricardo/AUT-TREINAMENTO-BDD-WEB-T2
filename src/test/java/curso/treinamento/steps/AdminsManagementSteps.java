package curso.treinamento.steps;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.AdminsManagementPage;
import curso.treinamento.pages.MenuPage;
import curso.treinamento.setup.Hooks;


public class AdminsManagementSteps {
	
	MenuPage menuPage = new MenuPage(Hooks.getDriver());
	AdminsManagementPage adminsManagementPage = new AdminsManagementPage(Hooks.getDriver());
	
	
	
	@Dado("que eu esteja na tela Admins Management")
	public void que_eu_esteja_na_tela_Admins_Management() {
		menuPage.clicar_submenu("ACCOUNTS", "Admins");

		Assert.assertTrue("Página Admins Management NÃO apresentada.", adminsManagementPage.validar_pagina());
	}

	@Quando("incluo um administrador")
	public void incluo_um_administrador(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		


	}

	@Então("administrador cadastrado com sucesso")
	public void administrador_cadastrado_com_sucesso() {

	}

}
