package curso.treinamento.utils;

import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import curso.treinamento.setup.Hooks;
import io.cucumber.datatable.DataTable;

public class Helper {
	
	public static List<Map<String, String>> dataTable;
	
	
	public static void aguardar_elemento_presente(By by, int timeout) { 
		WebDriverWait aguardar = new WebDriverWait(Hooks.getDriver(), timeout);
		aguardar.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static void aguardar_elemento_visivel(WebElement elemento, int timeout) { 		
		WebDriverWait aguardar = new WebDriverWait(Hooks.getDriver(), timeout);
		aguardar.until(ExpectedConditions.visibilityOf(elemento));		
	}
	
	public static void aguardar_elemento_clicavel(WebElement elemento, int timeout) {
		WebDriverWait aguardar = new WebDriverWait(Hooks.getDriver(), timeout);
		aguardar.until(ExpectedConditions.elementToBeClickable(elemento));
	}
	
	
	public static boolean elemento_presente(By by, int timeout) { 
		
		try {
		
			aguardar_elemento_presente(by, timeout);
			return true;
			
		} catch (Exception e) {
			return false; 
		}		
	}
	
	public static boolean elemento_existe(WebElement elemento, int timeout) { 		
		try {
			aguardar_elemento_visivel(elemento, timeout);
			
			return true;
			
		} catch (Exception e) {
			return false;
		}		
	}
		
	public static void create_datatable(DataTable dataTable_) { 
		dataTable = dataTable_.asMaps(String.class, String.class);
	}
	
	public static void trocar_aba(int id_aba) { 
		
		List<String> abas = new ArrayList<>(Hooks.getDriver().getWindowHandles());		 
	    Hooks.getDriver().switchTo().window(abas.get(id_aba));			    		 
	}
	
	public static void esperar (int timeout) { 
		try {
			Thread.sleep(timeout);
		} catch (Exception e) {}		
	}
}