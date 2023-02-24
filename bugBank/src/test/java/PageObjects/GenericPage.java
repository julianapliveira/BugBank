package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericPage {

	private WebDriver driver;

	public GenericPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getTextTitle() {

		return driver.findElement(By.className("cFmqIK"));

	}

	public WebElement getImage() {

		return driver.findElement(
				By.xpath("//img[@src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fbugbank.ede6fc83.png&w=384&q=75']"));

	}
	public WebElement getSairButton() {

		return driver.findElement(By.id("btnExit"));

	}

}