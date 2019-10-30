package curso.treinamento.steps;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.AddAdminPage;
import curso.treinamento.pages.AdminsManagementPage;
import curso.treinamento.pages.MenuPage;
import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;
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
		
		Helper.create_datatable(dataTable_);
		
		addAdminPage.preencher_first_name(Helper.dataTable.get(0).get("First Name"));
		addAdminPage.preencher_last_name(Helper.dataTable.get(0).get("Last Name"));
		addAdminPage.preencher_email(Helper.dataTable.get(0).get("Email"));
		addAdminPage.preencher_password(Helper.dataTable.get(0).get("Password"));
		addAdminPage.preencher_mobile_number(Helper.dataTable.get(0).get("Mobile Number"));
		addAdminPage.selecionar_country(Helper.dataTable.get(0).get("Country"));
		addAdminPage.preencher_adress1(Helper.dataTable.get(0).get("Address 1"));
		addAdminPage.preencher_adress2(Helper.dataTable.get(0).get("Address 2"));
		addAdminPage.selecionar_status(Helper.dataTable.get(0).get("Status"));
		addAdminPage.selecionar_add(Helper.dataTable.get(0).get("Add"));
		addAdminPage.selecionar_edit(Helper.dataTable.get(0).get("Edit"));
		addAdminPage.selecionar_remove(Helper.dataTable.get(0).get("Remove"));
		addAdminPage.clicar_btn_submit();		
	}

	@Então("administrador cadastrado com sucesso")
	public void administrador_cadastrado_com_sucesso() {
		Assert.assertTrue("Usuário não cadastrado com sucesso.", adminsManagementPage.validar_email_na_tabela(Helper.dataTable.get(0).get("Email")));		
	}
		
	@Quando("incluo um adminstrador com os valores: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void incluo_um_adminstrador_com_os_valores(String firstName, String lastName, String email, String password, String mobileNumber, 
			String country, String address1, String address2, String status, String add, String edit, String remove) {
	    
		adminsManagementPage.clicar_btn_add();		
		
		Assert.assertTrue("Página Add Admin NÃO apresentada.", addAdminPage.validar_pagina());
		
		addAdminPage.preencher_first_name(firstName);
		addAdminPage.preencher_last_name(lastName);
		addAdminPage.preencher_email(email);
		addAdminPage.preencher_password(password);
		addAdminPage.preencher_mobile_number(mobileNumber);
		addAdminPage.selecionar_country(country);
		addAdminPage.preencher_adress1(address1);
		addAdminPage.preencher_adress2(address2);
		addAdminPage.selecionar_status(status);
		addAdminPage.selecionar_add(add);
		addAdminPage.selecionar_edit(edit);
		addAdminPage.selecionar_remove(remove);
		addAdminPage.clicar_btn_submit();
	}

	@Então("administrador {string} cadastrado com sucesso")
	public void administrador_cadastrado_com_sucesso(String email) {
		Assert.assertTrue("Usuário não cadastrado com sucesso.", adminsManagementPage.validar_email_na_tabela(email));
	}
	
	@Quando("altero informações do administrador")
	public void altero_informacoes_do_administrador(DataTable dataTable) {
		
		Helper.create_datatable(dataTable);
		
		Assert.assertTrue("E-mail " + Helper.dataTable.get(0).get("Email Antigo") + " não encontrado para alteração.", adminsManagementPage.validar_email_na_tabela(Helper.dataTable.get(0).get("Email Antigo")));

		adminsManagementPage.clicar_btn_editar(Helper.dataTable.get(0).get("Email Antigo"));
		
		addAdminPage.preencher_first_name(Helper.dataTable.get(0).get("First Name"));
		addAdminPage.preencher_last_name(Helper.dataTable.get(0).get("Last Name"));
		addAdminPage.preencher_email(Helper.dataTable.get(0).get("Email Novo"));
		addAdminPage.preencher_password(Helper.dataTable.get(0).get("Password"));
		addAdminPage.preencher_mobile_number(Helper.dataTable.get(0).get("Mobile Number"));
		addAdminPage.selecionar_country(Helper.dataTable.get(0).get("Country"));
		addAdminPage.preencher_adress1(Helper.dataTable.get(0).get("Address 1"));
		addAdminPage.preencher_adress2(Helper.dataTable.get(0).get("Address 2"));
		addAdminPage.selecionar_status(Helper.dataTable.get(0).get("Status"));
		addAdminPage.selecionar_add(Helper.dataTable.get(0).get("Add"));
		addAdminPage.selecionar_edit(Helper.dataTable.get(0).get("Edit"));
		addAdminPage.selecionar_remove(Helper.dataTable.get(0).get("Remove"));
		addAdminPage.clicar_btn_submit();		
	}

	@Então("informações do administrador alterada com sucesso")
	public void informacoes_do_administrador_alterada_com_sucesso() {
		Assert.assertTrue("Mensagem de alteração não apresentada.", addAdminPage.validar_mensagem_alteracao());
		Assert.assertTrue(" O administrador " + Helper.dataTable.get(0).get("Email Antigo")  + " não foi alterado para " + Helper.dataTable.get(0).get("Email Novo"), adminsManagementPage.validar_email_na_tabela(Helper.dataTable.get(0).get("Email Novo")));					
	}
		
	@Quando("excluo o administrador {string}")
	public void excluo_o_administrador(String email) {
		
		adminsManagementPage.clicar_btn_excluir(email);
		
		System.out.println("Foi apresentado um pop-up com a mensagem: " + Hooks.getDriver().switchTo().alert().getText());
		
		Hooks.getDriver().switchTo().alert().accept();
	}

	@Então("administrador {string} excluido com sucesso")
	public void administrador_excluido_com_sucesso(String email) {		
		Assert.assertFalse("Administrador " + email + " não excluido!", adminsManagementPage.validar_email_na_tabela(email));
	}	
}