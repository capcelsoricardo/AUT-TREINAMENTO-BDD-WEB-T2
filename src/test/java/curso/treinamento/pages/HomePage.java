package curso.treinamento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class HomePage {
	
	public HomePage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//strong[contains(text(),'Logout')]")
	private WebElement linkLogout;
		
	public Boolean validar_pagina() { 
		
		Helper.aguardar_elemento_visivel(linkLogout, Hooks.TIMEOUT_DEFAULT);
		return linkLogout.isDisplayed();		
	}

}