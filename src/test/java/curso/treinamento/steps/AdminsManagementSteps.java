package curso.treinamento.steps;

import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.AddAdminPage;
import curso.treinamento.pages.AdminsManagementPage;
import curso.treinamento.pages.MenuPage;
import curso.treinamento.setup.Hooks;
import io.cucumber.datatable.DataTable;


public class AdminsManagementSteps {
	
	MenuPage menuPage = new MenuPage(Hooks.getDriver());
	AdminsManagementPage adminsManagementPage = new AdminsManagementPage(Hooks.getDriver());
	AddAdminPage addAdminPage = new AddAdminPage(Hooks.getDriver());
	
	
	
	@Dado("que eu esteja na tela Admins Management")
	public void que_eu_esteja_na_tela_Admins_Management() {
		menuPage.clicar_submenu("ACCOUNTS", "Admins");

		Assert.assertTrue("Página Admins Management NÃO apresentada.", adminsManagementPage.validar_pagina());
	}

	@Quando("incluo um administrador")
	public void incluo_um_administrador(DataTable dataTable_) {
		adminsManagementPage.clicar_btn_add();
		
		Assert.assertTrue("Página Add Admin NÃO apresentada.", addAdminPage.validar_pagina());
		
		List<Map<String, String>> listDataTable = dataTable_.asMaps(String.class, String.class);
		
		addAdminPage.preencher_first_name(listDataTable.get(0).get("First Name"));
		addAdminPage.preencher_last_name(listDataTable.get(0).get("Last Name"));
		addAdminPage.preencher_email(listDataTable.get(0).get("Email"));
		addAdminPage.preencher_password(listDataTable.get(0).get("Password"));
		addAdminPage.preencher_mobile_number(listDataTable.get(0).get("Mobile Number"));
		addAdminPage.selecionar_country(listDataTable.get(0).get("Country"));
		addAdminPage.preencher_adress1(listDataTable.get(0).get("Address 1"));
		addAdminPage.preencher_adress2(listDataTable.get(0).get("Address 2"));
		addAdminPage.selecionar_status(listDataTable.get(0).get("Status"));
		addAdminPage.selecionar_add(listDataTable.get(0).get("Add"));
		addAdminPage.selecionar_edit(listDataTable.get(0).get("Edit"));
		addAdminPage.selecionar_remove(listDataTable.get(0).get("Remove"));
		addAdminPage.clicar_btn_submit();
		
		
	}

	@Então("administrador cadastrado com sucesso")
	public void administrador_cadastrado_com_sucesso() {
		Assert.assertTrue("Usuário não cadastrado com sucesso.", adminsManagementPage.validar_email_na_tabela("teste@teste2.com.br"));
		
	}

}
