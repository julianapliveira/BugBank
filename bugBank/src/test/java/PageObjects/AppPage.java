package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.Browser.Waits;

public class AppPage {

	private WebDriver driver;
	private Waits wait;

	public AppPage(WebDriver driver) {

		this.driver = driver;
		this.wait = new Waits(this.driver);
	}

	public WebElement getTitle() {
		return wait.visibilityOfElement(By.className("cFmqIK"));
	}

	public WebElement getEmailInput() {
		return driver.findElement(By.name("email"));

	}

	public WebElement getPasswordInput() {
		return driver.findElement(By.name("password"));
	}

	public WebElement getAcessarButton() {
		return driver.findElement(By.className("otUnI"));
	}

	public WebElement getRegistrarButton() {

		return driver.findElement(By.className("ihdmxA"));
	}

	public WebElement getRequisitosButton() {

		return driver.findElement(By.className("xzjxU"));
	}

}
