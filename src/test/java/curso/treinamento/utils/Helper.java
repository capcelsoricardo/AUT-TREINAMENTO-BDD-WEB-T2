package curso.treinamento.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import curso.treinamento.setup.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;

public class Helper {
	
	public static List<Map<String, String>> dataTable;
		
	public static void aguardar_elemento_presente(By by, int timeout) { 
		
		Wait aguardar = new FluentWait<>(Hooks.getDriver()).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
		
		aguardar.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static void aguardar_elemento_visivel(WebElement elemento, int timeout) { 		
		Wait aguardar = new FluentWait<>(Hooks.getDriver()).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
		
		aguardar.until(ExpectedConditions.visibilityOf(elemento));		
	}
	
	public static void aguardar_elemento_clicavel(WebElement elemento, int timeout) {
		Wait aguardar = new FluentWait<>(Hooks.getDriver()).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
		
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
	
	public static void screenshot(Scenario scenario) {		

		String nomeEvidencia = scenario.getName().replace(" ", "_")+ "_" + scenario.getStatus().toString() + ".jpg";

		File file = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);

		try {						
			FileUtils.copyFile(file, new File("target" + File.separator + "screenshots" + File.separator +  nomeEvidencia));
		} catch (IOException e) {
			Assert.fail("Erro na geração da evidência: " + nomeEvidencia );
		}
	}
	

	
	public static String get_path_driver(String navegador) {
		
		switch (navegador.toUpperCase()) {
		
			case "CHROME":
				
				if(System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
					return  "src"+ File.separator + "test" + File.separator + "resources" + 	File.separator +  "drivers" + File.separator + "chromedriver.exe";
				else
					return "src"+ File.separator + "test" + File.separator + "resources" + 	File.separator +  "drivers" + File.separator + "chromedriver";
			
			case "IE":
				break;												
		}		
		
		Assert.fail("Opção de navegador inválida.");
		
		return "";
	}
}