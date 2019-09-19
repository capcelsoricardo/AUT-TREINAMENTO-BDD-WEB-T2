package curso.treinamento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.utils.Helper;

public class LoginPage {
	
	public LoginPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email")
	private WebElement campoEmail;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement campoPassword;
	
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement botaoLogin;
	
	
	public void preencher_email(String email) { 
		campoEmail.sendKeys(email);
	}
	
	public void preencher_password(String password) {
		campoPassword.sendKeys(password);
	}
	
	public void clicar_botao_login() {
		botaoLogin.click();
	}
	
	public Boolean validar_pagina() { 
		
		Helper.aguardar_elemento(10, botaoLogin);
		return botaoLogin.isDisplayed();
	}


}
