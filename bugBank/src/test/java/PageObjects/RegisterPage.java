package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.Browser.Waits;

public class RegisterPage {

	private WebDriver driver;
	private Waits wait;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		this.wait = new Waits(this.driver);
	}

	public WebElement getEmailnput() {

		return driver.findElement(By.xpath("//div[@class='card__register']/form/div/input[@name='email']"));				
	}
	public WebElement getNomeInput() {

		return driver.findElement(By.xpath("//div[@class='card__register']/form/div/input[@name='name']"));

	}

	public WebElement getSenhaInput() {
		
		return driver.findElement(By.xpath("//div[@class='card__register']/form/div[@class='login__password']/div/input[@name='password']"));

	}

	public WebElement getConfirmaSenhaInput() {

		return driver.findElement(By.xpath(
				"//div[@class='card__register']/form/div[@class='login__password']/div/input[@name='passwordConfirmation']"));

	}

	public WebElement getComSaldoButton() {
		return driver.findElement(By.id("toggleAddBalance"));
	}
		
	// Botão para teste de carregamento da página
	public WebElement getCadastrarButton() {
		return driver.findElement(By.className("CMabB"));
	}
	
	public WebElement getVoltarLoginButton() {
		return driver.findElement(By.id("btnBackButton"));
	}
	
	public WebElement getTextModalConfirmaCadastro()
	{
		return driver.findElement(By.id("modalText"));
	}
	
	public WebElement getFecharButtonModalConfirmaCadastro()
	{
		return driver.findElement(By.id("btnCloseModal"));
	}
	

}
