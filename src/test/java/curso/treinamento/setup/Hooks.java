package curso.treinamento.setup;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import curso.treinamento.utils.Helper;

public class Hooks {
	
	public static WebDriver driver;
	public static ResourceBundle bundle = ResourceBundle.getBundle("project");
	public static int TIMEOUT_DEFAULT = Integer.parseInt(bundle.getString("env.timeout.default"));
	
	@Before
	public void start_test(Scenario scenario) {
														
		switch (bundle.getString("env.navegador").toUpperCase()) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", Helper.get_path_driver(bundle.getString("env.navegador")));
			break;						
		default:
			Assert.fail("Opção de navegador inválida.");
			break;
		}
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(true);
		
		driver = new ChromeDriver(chromeOptions);
				
		//driver.manage().timeouts().implicitlyWait(TIMEOUT_DEFAULT, TimeUnit.SECONDS);
		
		driver.manage().window().fullscreen();
		
		driver.get(bundle.getString("env.url"));									
	}
	
	@After
	public void tear_down(Scenario scenario) { 
		Helper.screenshot(scenario);
		driver.close();
	}
	
	public static WebDriver getDriver() { 
		return driver;
	}

}
