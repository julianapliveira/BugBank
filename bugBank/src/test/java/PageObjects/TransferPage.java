package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferPage {

	private WebDriver driver;

	public TransferPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getTextTransferPage() {

		return driver.findElement(By.xpath("//p[@class='transfer__TextInformation-sc-1yjpf2r-7 eUFZOb']"));

	}

	public WebElement getNumeroContaInputTextField() {

		return driver.findElement(By.name("accountNumber"));

	}

	public WebElement getDigitoText() {

		return driver.findElement(By.name("digit"));

	}

	public WebElement getValorTransfenciaText() {

		return driver.findElement(By.name("transferValue"));

	}

	public WebElement getDescricaoText() {

		return driver.findElement(By.name("description"));

	}

	public WebElement getTransferirAgoraButton() {

		return driver.findElement(By.className("CMabB"));

	}

	public WebElement getVoltarButton() {

		return driver.findElement(By.id("btnBack"));

	}

	public WebElement getTextModalConfirmaTransferencia()
	{
		return driver.findElement(By.id("modalText"));
	}
	
	public WebElement getFecharButtonModalTransferencia()
	{
		return driver.findElement(By.id("btnCloseModal"));
	}
	
}