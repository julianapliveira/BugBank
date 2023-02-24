package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	// verificar se pega a inicial
	public WebElement getInitialNameText() {

		return driver.findElement(By.className("httAMd"));

	}

	public WebElement getNameText() {

		return driver.findElement(By.id("textName"));

	}

	public WebElement getHomeText() {

		return driver.findElement(By.className("home__Text-sc-1auj767-9 jjmPHj"));

	}

	// verificar se pega o numero da conta
	public WebElement getContaDigitalText() {

		return driver.findElement(By.id("textAccountNumber"));
	}

	public WebElement getSaldoText() {

		return driver.findElement(By.id("jjmPHj"));
	}

	// verificar se pega o valor
	public WebElement getValorSaldoText() {

		return driver.findElement(By.id("textBalance"));

	}

	public WebElement getTransferenciaButton() {

		return driver.findElement(By.className("heVuFC"));

	}

	public WebElement getPagamentosButton() {

		return driver.findElement(By.className("heVuFC"));

	}

	public WebElement getExtratoButton() {

		return driver.findElement(By.id("btn-EXTRATO"));

	}

	public WebElement getSaqueButton() {

		return driver.findElement(By.className("heVuFC"));

	}
	public WebElement getObrigadoMessageText() {

		return driver.findElement(By.className("jjmPHj"));

	}
	public WebElement getHomeContainer() {

		return driver.findElement(By.className("home__ContainerInfos-sc-1auj767-4 hZrCpL"));

	}
	

}