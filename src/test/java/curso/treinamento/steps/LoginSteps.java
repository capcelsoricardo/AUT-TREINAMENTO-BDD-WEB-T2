package curso.treinamento.steps;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LoginSteps {
	

//	public WebDriver driver;
//	
//	@Dado("que eu deseje logar no sistema")
//	public void que_eu_deseje_logar_no_sistema() {
//		
//		System.setProperty("webdriver.chrome.driver", "src/test/resources/mac/chromedriver");
//		driver = new ChromeDriver();
//		
//		driver.get("https://www.phptravels.net/admin");		
//		
//	}
//
//	@Quando("faço login com o usuário {string} e senha {string}")
//	public void faço_login_com_o_usuário_e_senha(String user, String pass) {
//		
//		driver.findElement(By.name("email")).sendKeys(user);
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);		
//		driver.findElement(By.xpath("//span[text()='Login']")).click();
//		
//		
//	}
//
//	@Então("sou autenticado com sucesso")
//	public void sou_autenticado_com_sucesso() throws InterruptedException {
//		
//		Thread.sleep(5000);
//		Assert.assertTrue(driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/logout']")).isDisplayed());
//	}
//	
//	@Dado("que eu esteja na tela de login")
//	public void que_eu_esteja_na_tela_de_login() {
//		
//		System.setProperty("webdriver.chrome.driver", "src/test/resources/mac/chromedriver");
//		driver = new ChromeDriver();
//		
//		driver.get("https://www.phptravels.net/admin");
//
//	}
//
//	@Então("é apresentado a mensagem {string}")
//	public void é_apresentado_a_mensagem(String mensagem) {
//		
//		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger loading wow fadeIn animated animated']//p")).getText());
//		
//		
//		Assert.assertEquals(mensagem, driver.findElement(By.xpath("//div[@class='alert alert-danger loading wow fadeIn animated animated']//p")).getText());
//		
//		
//		//Assert.assertTrue("Mensagem 'The Email field must contain a valid email address.' não apresentada.",
//		//		driver.findElement(By.xpath("//p[text()='"+ mensagem +"']")).isDisplayed());
//		
//	}

}
