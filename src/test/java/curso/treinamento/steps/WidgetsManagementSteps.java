package curso.treinamento.steps;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import curso.treinamento.pages.MenuPage;
import curso.treinamento.pages.WidgetsManagementPage;
import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;
import io.cucumber.datatable.DataTable;


public class WidgetsManagementSteps {
	
	MenuPage menuPage = new MenuPage(Hooks.getDriver());
	WidgetsManagementPage widgetsManagementPage = new WidgetsManagementPage(Hooks.getDriver());	
	Helper helper = new Helper();
		
	
	@Dado("que eu esteja na tela Widgets Management")
	public void que_eu_esteja_na_tela_Widgets_Management() {
		menuPage.clicar_submenu("menu-ui", "Widgets");
		Assert.assertTrue("Página Widgets Management NÃO apresentada.", widgetsManagementPage.validar_pagina());
	}

	@Quando("incluo um Widgets")
	public void incluo_um_Widgets(DataTable dataTable) {
		widgetsManagementPage.clicar_btn_add();
					
		Helper.create_datatable(dataTable);
		
		widgetsManagementPage.preencher_widget_name(Helper.dataTable.get(0).get("Widget Name"));
		widgetsManagementPage.selecionar_widget_status(Helper.dataTable.get(0).get("Widget Status"));
		widgetsManagementPage.preencher_widget_content(Helper.dataTable.get(0).get("Widget Content"));		
		Hooks.getDriver().switchTo().defaultContent();
		widgetsManagementPage.clicar_btn_add();	    
	}

	@Então("widget cadastrado com sucesso")
	public void widget_cadastrado_com_sucesso() {
		Assert.assertTrue("Widget não cadastrado com sucesso.", widgetsManagementPage.validar_nome_widget_na_tabela(Helper.dataTable.get(0).get("Widget Name")));
	}

	@Quando("altero informações do widgets")
	public void altero_informações_do_widgets(DataTable dataTable) {
		
		Helper.create_datatable(dataTable);
		
		Assert.assertTrue("Widget Name " + Helper.dataTable.get(0).get("Widget Name Antigo") + " não encontrado para alteração.", widgetsManagementPage.validar_nome_widget_na_tabela(Helper.dataTable.get(0).get("Widget Name Antigo")));

		widgetsManagementPage.clicar_btn_editar(Helper.dataTable.get(0).get("Widget Name Antigo"));
		
		widgetsManagementPage.preencher_widget_name(Helper.dataTable.get(0).get("Widget Name Novo"));
		widgetsManagementPage.selecionar_widget_status(Helper.dataTable.get(0).get("Widget Status"));
		widgetsManagementPage.preencher_widget_content(Helper.dataTable.get(0).get("Widget Content"));		
		Hooks.getDriver().switchTo().defaultContent();
		widgetsManagementPage.clicar_btn_update();	    
	    
	}

	@Então("informações do widgets alterada com sucesso")
	public void informacoes_do_widgets_alterada_com_sucesso() {
		Assert.assertTrue("Widget Name " + Helper.dataTable.get(0).get("Widget Name Novo") + " não encontrado para alteração.", widgetsManagementPage.validar_nome_widget_na_tabela(Helper.dataTable.get(0).get("Widget Name Novo")));
	}

	@Quando("excluo o widgets {string}")
	public void excluo_o_widgets(String nome) {
		widgetsManagementPage.clicar_btn_excluir(nome);
		
		System.out.println("Foi apresentado um pop-up com a mensagem: " + Hooks.getDriver().switchTo().alert().getText());
		
		Hooks.getDriver().switchTo().alert().accept();	    
	}

	@Então("widgets {string} excluido com sucesso")
	public void widgets_excluido_com_sucesso(String nome) {
		Assert.assertFalse("Administrador " + nome + " não excluido!", widgetsManagementPage.validar_nome_widget_na_tabela(nome));
	}
}
