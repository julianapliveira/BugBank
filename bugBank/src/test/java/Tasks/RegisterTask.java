package Tasks;

import org.openqa.selenium.WebDriver;

import Framework.Utils.FileOperation;
import PageObjects.RegisterPage;
import Validations.AppValidation;
import Validations.RegisterValidation;

public class RegisterTask {

	private WebDriver driver;
	private RegisterPage registerPage;
	private RegisterValidation registerValidation;
	private AppValidation appValidation;
	
	public RegisterTask(WebDriver driver) {

		this.driver = driver;
		this.registerPage = new RegisterPage(this.driver);
		this.registerValidation = new RegisterValidation(this.driver);
		this.appValidation = new AppValidation(this.driver);
	}

	public void cadastrarConta1() {

		registerPage.getEmailnput().sendKeys(FileOperation.getProperties("contas").getProperty("email1"));
		registerPage.getNomeInput().sendKeys(FileOperation.getProperties("contas").getProperty("name1"));
		registerPage.getSenhaInput().sendKeys(FileOperation.getProperties("contas").getProperty("senha1"));
		registerPage.getConfirmaSenhaInput().sendKeys(FileOperation.getProperties("contas").getProperty("senha1"));
		registerPage.getComSaldoButton().click();
		registerPage.getCadastrarButton().click();
		registerValidation.validaModalCadastroConfirmado();
		
		//Pega número de conta e dígito com REGEX e substring
		String contaCompleta = registerPage.getTextModalConfirmaCadastro().getAttribute("innerHTML").replaceAll("[\\D]", "");
		int tamanhoConta = contaCompleta.length();
		String numero = contaCompleta.substring(0,tamanhoConta-1);
		String digito = contaCompleta.substring((tamanhoConta-1), tamanhoConta);
		//Salva número e dígita da conta na propertie
		FileOperation.setProperties("contas", "conta1", numero);
		FileOperation.setProperties("contas", "digito1", digito);
		//Fecha modal e volta pra tela de login
		registerPage.getFecharButtonModalConfirmaCadastro().click();
		appValidation.validationLoginPage();
		
	}

	public void cadastrarConta2() {
		//Limpa campo antes de inserir dados da conta 2
		registerPage.getEmailnput().clear();
		registerPage.getEmailnput().sendKeys(FileOperation.getProperties("contas").getProperty("email2"));
		registerPage.getNomeInput().clear();
		registerPage.getNomeInput().sendKeys(FileOperation.getProperties("contas").getProperty("name2"));
		registerPage.getSenhaInput().clear();
		registerPage.getSenhaInput().sendKeys(FileOperation.getProperties("contas").getProperty("senha2"));
		registerPage.getConfirmaSenhaInput().clear();
		registerPage.getConfirmaSenhaInput().sendKeys(FileOperation.getProperties("contas").getProperty("senha2"));
		
		//Não precisa clicar no conta com saldo pois já está ativado da primeira vez
		registerPage.getCadastrarButton().click();
		registerValidation.validaModalCadastroConfirmado();
		
		//Pega número de conta e dígito com REGEX e substring
		String contaCompleta = registerPage.getTextModalConfirmaCadastro().getAttribute("innerHTML").replaceAll("[\\D]", "");
		int tamanhoConta = contaCompleta.length();
		String numero = contaCompleta.substring(0,tamanhoConta-1);
		String digito = contaCompleta.substring((tamanhoConta-1), tamanhoConta);
		
		//Salva número e dígita da conta na propertie
		FileOperation.setProperties("contas", "conta2", numero);
		FileOperation.setProperties("contas", "digito2", digito);
		
		//Fecha modal e volta pra tela de login
		registerPage.getFecharButtonModalConfirmaCadastro().click();
		appValidation.validationLoginPage();

	}
}