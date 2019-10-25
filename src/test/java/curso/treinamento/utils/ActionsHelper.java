package curso.treinamento.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import curso.treinamento.setup.Hooks;

public class ActionsHelper {
			
	public static void clicar_elemento(WebElement elemento) { 
		Actions actions = new Actions(Hooks.getDriver());
		actions.click(elemento).build().perform();;
	}
	
	public static void mover_ate_elemento(WebElement elemento) { 
		Actions actions = new Actions(Hooks.getDriver());
		actions.moveToElement(elemento).build().perform();
	}
}
