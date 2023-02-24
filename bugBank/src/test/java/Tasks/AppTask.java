package Tasks;

import org.openqa.selenium.WebDriver;

import Framework.Utils.FileOperation;
import PageObjects.AppPage;
import Validations.AppValidation;
import Validations.HomeValidation;
import Validations.RegisterValidation;

public class AppTask {

	private WebDriver driver;
	private AppPage appPage;
	private AppValidation appValidation;
	private HomeValidation homeValidation;
	private RegisterValidation registerValidation;

	public AppTask(WebDriver driver) {

		this.driver = driver;
		this.appPage = new AppPage(this.driver);
		appValidation = new AppValidation(this.driver);
		registerValidation = new RegisterValidation(this.driver);
		homeValidation = new HomeValidation(this.driver);
	}
	
	
	public void clicarRegistroButton() {		
		appValidation.validationLoginPage();
		appPage.getRegistrarButton().click();
		registerValidation.validaCarregamentoRegisterPage();
		
	}
	
	public void efetuarLoginConta1() {

		appValidation.validationLoginPage();
		appPage.getEmailInput().sendKeys(FileOperation.getProperties("contas").getProperty("email1"));
		appPage.getPasswordInput().sendKeys(FileOperation.getProperties("contas").getProperty("senha1"));
		appPage.getAcessarButton().click();
		homeValidation.validationHomePage();
	}
	
	public void efetuarLoginConta2() {

		appValidation.validationLoginPage();
		appPage.getEmailInput().clear();
		appPage.getEmailInput().sendKeys(FileOperation.getProperties("contas").getProperty("email2"));
		appPage.getPasswordInput().clear();
		appPage.getPasswordInput().sendKeys(FileOperation.getProperties("contas").getProperty("senha2"));
		appPage.getAcessarButton().click();
		homeValidation.validationHomePage();
	}
}
