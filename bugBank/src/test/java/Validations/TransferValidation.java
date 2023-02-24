package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.TransferPage;

public class TransferValidation {

	private WebDriver driver;
	private TransferPage transferPage;
	
	private Waits wait;

	public TransferValidation(WebDriver driver) {

		this.driver = driver;
		transferPage = new TransferPage(this.driver);
		wait = new Waits(this.driver);

	}

	public void validationTransferPage() {

		try {
			wait.visibilityOfElement(By.id("btnBack"));
			Assertions.assertTrue(transferPage.getVoltarButton().isDisplayed());
			Report.log(Status.PASS, "Acessou a Pagina de Transferencia com Sucesso.", Screenshot.capture(driver));
			System.out.println("Acessou a Pagina de Transferencia com Sucesso.");
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}
	
	public void validaModalTransferenciaConfirmada() {

		try {
			String message = wait.loadElement(transferPage.getTextModalConfirmaTransferencia()).getAttribute("innerHTML");
			Assertions.assertTrue(message != "");
			Report.log(Status.PASS, "Modal Confirmação de Transferência carregado com sucesso: " + message);
			System.out.println("Modal Confirmação de Transferência carregado com sucesso: " + message);

		} catch (Exception e) {
			Report.log(Status.FAIL, "Modal Confirmação de Transferência não carregado " + e.getMessage(),
					Screenshot.captureBase64(driver));
		}

	}

}