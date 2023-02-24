package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.StatementPage;
import Validations.StatementValidation;

public class StatementTask {

	private WebDriver driver;
	private StatementPage statementPage;
	private StatementValidation statementValidation;

	public StatementTask(WebDriver driver) {

		this.driver = driver;
		statementPage = new StatementPage(this.driver);
		statementValidation = new StatementValidation(this.driver);

	}

	public void validarExtratoConta1() {
		
		statementValidation.validaSaldoConta1();
	}
	
	public void validarExtratoConta2() {
		
		statementValidation.validaSaldoConta2();
	}

}