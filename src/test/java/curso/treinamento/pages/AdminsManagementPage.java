package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class AdminsManagementPage {
	
	public AdminsManagementPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement btnAdd;
	
	@FindBy(xpath = "//div[text()='Admins Management']")
	private WebElement tituloPagina;
	
	
	public boolean validar_email_na_tabela(String email) { 
				
		try {								
			return Helper.elemento_existe(Hooks.getDriver().findElement(By.xpath("//td//a[text()='" + email + "']")), Hooks.TIMEOUT_DEFAULT);
		} catch (Exception e) {
			return false;
		}
									
	}
		
	public boolean validar_pagina() { 
		
		return Helper.elemento_existe(tituloPagina, Hooks.TIMEOUT_DEFAULT);		
	}
	
	public void clicar_btn_add() { 
		btnAdd.click();
	}

	public void clicar_btn_editar(String email) { 		
		Hooks.getDriver().findElement(By.xpath("(//a[text()='"+ email +"']//following::i[@class='fa fa-edit'])[1]")).click();
	}
	
	
	public void clicar_btn_excluir(String email) { 		
		Hooks.getDriver().findElement(By.xpath("(//a[text()='"+ email +"']//following::i[@class='fa fa-times'])[1]")).click();				
	}
}