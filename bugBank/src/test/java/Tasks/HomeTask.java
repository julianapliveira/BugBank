package Tasks;

import org.openqa.selenium.WebDriver;

import Framework.Utils.FileOperation;
import PageObjects.GenericPage;
import PageObjects.HomePage;
import Validations.AppValidation;
import Validations.HomeValidation;
import Validations.RegisterValidation;
import Validations.TransferValidation;

public class HomeTask {

	private WebDriver driver;
	private HomePage homePage;
	private AppValidation appValidation;
	private HomeValidation homeValidation;
	private GenericPage genericPage;
	private TransferValidation transferValidation;

	public HomeTask(WebDriver driver) {

		this.driver = driver;
		this.homePage = new HomePage(this.driver);
		homeValidation = new HomeValidation(this.driver);
		appValidation = new AppValidation(this.driver);
		genericPage = new GenericPage(this.driver);
		transferValidation = new TransferValidation(this.driver);
	}
	

	public void clicarTransfer() {
		//homeValidation.carregarConta();
		homePage.getTransferenciaButton().click();
		transferValidation.validationTransferPage();
	}

	public void clicarExtrato() {
		//homeValidation.carregarConta();
		homePage.getExtratoButton().click();
		transferValidation.validationTransferPage();
	}
	public void clicarSair() {
		//homeValidation.carregarConta();
		genericPage.getSairButton().click();
		appValidation.validationLoginPage();
	}
}