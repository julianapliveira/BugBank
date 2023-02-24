package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.AppPage;
import PageObjects.HomePage;

public class HomeValidation {

	private WebDriver driver;
	private HomePage homePage;
	private Waits wait;

	public HomeValidation(WebDriver driver) {

		this.driver = driver;
		homePage = new HomePage(this.driver);
		wait = new Waits(this.driver);

	}

	public void validationHomePage() {

		try {

			wait.visibilityOfElement(By.id("textAccountNumber"));
			String contaText = homePage.getContaDigitalText().getAttribute("innerHTML");
			Assertions.assertTrue(homePage.getContaDigitalText().isDisplayed());
			Report.log(Status.PASS, "Acessou a HomePage com Sucesso." + contaText, Screenshot.capture(driver));
			System.out.println("Acessou a HomePage com Sucesso.");
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}
	
}