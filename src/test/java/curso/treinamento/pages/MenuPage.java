package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class MenuPage {
	
	public MenuPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='#Cars']")
	private WebElement menuCars;
	
	
	public void clicar_menu_cars() { 
		menuCars.click();
	}
	
	public boolean validar_submenu_cars(String subMenu) { 
		
		return Helper.elemento_existe(Hooks.getDriver().findElement(By.xpath("//a[@href='#Cars']/following::a[text()='"+subMenu+"']")), 10);  
			
	}
}
