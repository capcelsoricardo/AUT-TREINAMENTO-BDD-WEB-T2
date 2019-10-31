package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class WidgetsManagementPage {

	public WidgetsManagementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement btnAdd;
	
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement btnUpdate;

	@FindBy(xpath = "//div[text()='Widgets Management']")
	private WebElement tituloPagina;
	
	@FindBy(name = "title")
	private WebElement cmpWidgetName;
	
	@FindBy(name = "status")
	private WebElement comboBoxStatus;
	
	@FindBy(xpath = "/html/body/p")
	private WebElement cmpWidgetContent;
	
	public boolean validar_pagina() {
		return Helper.elemento_existe(tituloPagina, 10);
	}

	public boolean validar_nome_widget_na_tabela(String nome) {

		try {
			return Helper.elemento_existe(Hooks.getDriver().findElement(By.xpath("//td[text()='"+ nome +"']")), Hooks.TIMEOUT_DEFAULT);
		} catch (Exception e) {
			return false;
		}
	}

	public void clicar_btn_add() {		
		btnAdd.click();
	}

	public void clicar_btn_update() {		
		btnUpdate.click();
	}
	
	public void clicar_btn_editar(String nome) {
		Hooks.getDriver().findElement(By.xpath("(//td[text()='" + nome + "']//following::i[@class='fa fa-edit'])[1]")).click();
	}

	public void clicar_btn_excluir(String nome) {
		Hooks.getDriver().findElement(By.xpath("(//td[text()='" + nome + "']//following::i[@class='fa fa-times'])[1]")).click();
	}
	
	public void preencher_widget_name(String name) { 
		cmpWidgetName.clear();
		cmpWidgetName.sendKeys(name);
	}
	
	public void selecionar_widget_status(String status) { 		
		new Select(comboBoxStatus).selectByVisibleText(status); 				
	}

	public void preencher_widget_content(String text)  { 
		
		for (int i = 0; i < 10; i++) {
			try {
				Hooks.getDriver().switchTo().frame(Hooks.getDriver().findElement(By.xpath("//iframe[contains(@title,'Rich')]")));
				break;
			} catch (Exception e) {
				Helper.esperar(1000);
			}			
		}
		
		cmpWidgetContent.clear();
		cmpWidgetContent.sendKeys(text);
										
	}
	
}