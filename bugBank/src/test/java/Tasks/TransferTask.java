package Tasks;

import org.openqa.selenium.WebDriver;

import Framework.Utils.FileOperation;
import PageObjects.TransferPage;
import Validations.AppValidation;
import Validations.HomeValidation;
import Validations.RegisterValidation;
import Validations.TransferValidation;

public class TransferTask {

	private WebDriver driver;
	private TransferPage transferPage;
	private TransferValidation transferValidation;
	private RegisterValidation registerValidation;
	private AppValidation appValidation;
	private HomeValidation homeValidation;

	public TransferTask(WebDriver driver) {

		this.driver = driver;
		this.transferPage = new TransferPage(this.driver);
		transferValidation = new TransferValidation(this.driver);
		registerValidation = new RegisterValidation(this.driver);
		appValidation = new AppValidation(this.driver);
		this.homeValidation = new HomeValidation(this.driver);
	}
	
	public void efetuarTransferenciaConta1ParaConta2() { 

		//Preenche dados da transferência
		transferPage.getNumeroContaInputTextField().sendKeys(FileOperation.getProperties("contas").getProperty("conta2"));
		transferPage.getDigitoText().sendKeys(FileOperation.getProperties("contas").getProperty("digito2"));
		transferPage.getValorTransfenciaText().sendKeys("200");
		transferPage.getDescricaoText().sendKeys("Transferindo de Conta 1 para Conta 2");
		
		//Clica em botão de transferência
		transferPage.getTransferirAgoraButton().click();
		
		//Valida que foi para modal de sucesso
		transferValidation.validaModalTransferenciaConfirmada();
		
		//clica em em fechar modal
		transferPage.getFecharButtonModalTransferencia().click();
		
		//clica em voltar para poder acessar o extrato
		transferPage.getVoltarButton().click();
				
		//Valida que voltou para página home da conta
		homeValidation.validationHomePage();
	}
}