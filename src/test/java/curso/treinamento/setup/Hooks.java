package curso.treinamento.setup;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	public static ResourceBundle bundle = ResourceBundle.getBundle("project");
	
	@Before
	public void startTest(Scenario scenario) {
		
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/mac/chromedriver");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/windows/chromedriver.exe");
		driver = new ChromeDriver();
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().fullscreen();
		driver.get(bundle.getString("env.url"));
		
		
	}
	
	@After
	public void tearDown(Scenario scenario) { 
		driver.close();
	}
	
	public static WebDriver getDriver() { 
		return driver;
	}

}
