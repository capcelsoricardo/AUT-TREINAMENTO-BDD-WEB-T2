package curso.treinamento.utils;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import curso.treinamento.setup.Hooks;
import io.cucumber.datatable.DataTable;

public class Helper {
	
	public static List<Map<String, String>> dataTable;
	
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
		
	public static void create_datatable(DataTable dataTable_) { 
		dataTable = dataTable_.asMaps(String.class, String.class);
	}
}