package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StatementPage {

	private WebDriver driver;

	public StatementPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getSaldoDisponivel() {

		return driver.findElement(By.id("textBalanceAvailable"));

	}
}