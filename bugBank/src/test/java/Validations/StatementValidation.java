package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.StatementPage;

public class StatementValidation {

	private WebDriver driver;
	private StatementPage statementPage;
	private Waits wait;

	public StatementValidation(WebDriver driver) {

		this.driver = driver;
		statementPage = new StatementPage(this.driver);
		wait = new Waits(this.driver);

	}
	

	public void validaSaldoConta1() {

		try {

			String saldoConta1 = wait.loadElement(statementPage.getSaldoDisponivel()).getAttribute("innerHTML");
			Assertions.assertTrue(saldoConta1.equalsIgnoreCase("R$&nbsp;800,00"));
			Report.log(Status.PASS, "Validou Saldo Conta 1 com sucesso " + saldoConta1, Screenshot.capture(driver));
			System.out.println("Validou Saldo Conta 1 com sucesso " + saldoConta1);
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}

	}

	public void validaSaldoConta2() {

		try {

			String saldoConta = wait.loadElement(statementPage.getSaldoDisponivel()).getAttribute("innerHTML");
			Assertions.assertTrue(saldoConta.equalsIgnoreCase("R$&nbsp;1.200,00"));
			Report.log(Status.PASS, "Validou Saldo Conta 2 com sucesso " + saldoConta, Screenshot.capture(driver));
			System.out.println("Validou Saldo Conta 2 com sucesso " + saldoConta);
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}

	}

}