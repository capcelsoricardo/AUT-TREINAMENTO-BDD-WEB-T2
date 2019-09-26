package curso.treinamento.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import curso.treinamento.setup.Hooks;

public class Helper {
	
	
	public static void aguardar_elemento(int timeout, WebElement elemento) { 
		
		WebDriverWait aguardar = new WebDriverWait(Hooks.getDriver(), timeout);
		aguardar.until(ExpectedConditions.visibilityOf(elemento));		
	}
	
	public static boolean elemento_existe(WebElement elemento, int timeout) { 
		
		try {
			aguardar_elemento(timeout, elemento);
			
			return true;
			
		} catch (Exception e) {
			return false;
		}		
	}

}
