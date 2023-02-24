package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.GenericPage;

public class GenericValidation {

	private WebDriver driver;
	private GenericPage genericPage;
	private Waits wait;

	public GenericValidation(WebDriver driver) {

		this.driver = driver;
		genericPage = new GenericPage(this.driver);
		wait = new Waits(this.driver);

	}

	public void validationTituloGenerico() {

		try {

			wait.loadElement(genericPage.getTextTitle());
			Assertions.assertTrue(genericPage.getTextTitle().isDisplayed());
			Report.log(Status.PASS, "Carregou o texto generico com sucesso.", Screenshot.capture(driver));
			System.out.println("Carregou o texto generico com sucesso.");

		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}
	
	public void validationImagem() {

		try {

			wait.loadElement(genericPage.getImage());
			Assertions.assertTrue(genericPage.getImage().isDisplayed());
			Report.log(Status.PASS, "Carregou a imagem generica com sucesso.", Screenshot.capture(driver));
			System.out.println("Carregou a imagem generica com sucesso.");

		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}	
	
	
}