package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.AppPage;

public class AppValidation {

	private WebDriver driver;
	private AppPage appPage;
	private Waits wait;

	public AppValidation(WebDriver driver) {

		this.driver = driver;
		appPage = new AppPage(this.driver);
		wait = new Waits(this.driver);

	}

	public void validationLoginPage() {

		try {
			
			wait.loadElement(appPage.getTitle());
			Assertions.assertTrue(appPage.getTitle().isDisplayed());
			Report.log(Status.PASS, "Acessou a Pagina de Login com Sucesso.", Screenshot.capture(driver));
			System.out.println("Acessou a pagina de Login com sucesso.");
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}

}
