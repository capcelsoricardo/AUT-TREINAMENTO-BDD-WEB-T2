package curso.treinamento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.utils.Helper;

public class AdminsManagementPage {
	
	public AdminsManagementPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Admins Management']")
	private WebElement tituloPagina;
		
	public Boolean validar_pagina() { 
		
		return Helper.elemento_existe(tituloPagina, 10);		
	}

}