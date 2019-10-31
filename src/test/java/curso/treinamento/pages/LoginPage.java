package curso.treinamento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.setup.Hooks;
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
	
	@FindBy(xpath = "//span[text()='Remove Frame']")
	private WebElement linkRemoveFrame;
	
	@FindBy(xpath = "//p[text()='The Email field must contain a valid email address.']")
	private WebElement msgEmailInvalido;
	
	public boolean validar_mensagem_email_invalido() {
		
		return Helper.elemento_existe(msgEmailInvalido, Hooks.TIMEOUT_DEFAULT);	
	}
	
	
	public void clicar_remove_frame() { 		
		if(Helper.elemento_existe(linkRemoveFrame, 1))
			linkRemoveFrame.click();
	}
	
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
		
		Helper.aguardar_elemento_visivel(botaoLogin, Hooks.TIMEOUT_DEFAULT);
		return botaoLogin.isDisplayed();
	}

}
