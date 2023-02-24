package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;

import PageObjects.RegisterPage;

public class RegisterValidation {

	private WebDriver driver;
	private RegisterPage registerPage;
	private Waits wait;

	public RegisterValidation(WebDriver driver) {

		this.driver = driver;
		registerPage = new RegisterPage(this.driver);
		wait = new Waits(this.driver);

	}

	public void validaCarregamentoRegisterPage() {

		try {

			wait.loadElement(registerPage.getCadastrarButton());
			Assertions.assertTrue(registerPage.getCadastrarButton().isDisplayed());
			Report.log(Status.PASS, "Acessou a Pagina de Registro com Sucesso", Screenshot.captureBase64(driver));
			System.out.println("Acessou a Pagina de Registro com Sucesso");

		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));

		}
	}

	public void validaModalCadastroConfirmado() {

		try {
			String message = wait.loadElement(registerPage.getTextModalConfirmaCadastro()).getAttribute("innerHTML");
			;
			Assertions.assertTrue(message != "");
			Report.log(Status.PASS, "Modal Confirmação de Cadastro carregado com sucesso: " + message);
			System.out.println("Modal Confirmação de Cadastro carregado com sucesso: " + message);

		} catch (Exception e) {
			Report.log(Status.FAIL, "Modal Confirmação de Cadastro não carregado " + e.getMessage(),
					Screenshot.captureBase64(driver));
		}

	}

}
