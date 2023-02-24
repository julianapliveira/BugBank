package TestCases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import Framework.TestBase;
import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Tasks.AppTask;
import Tasks.HomeTask;
import Tasks.RegisterTask;
import Tasks.StatementTask;
import Tasks.TransferTask;

public class RealizarTransferenciaComSucessoTest extends TestBase {

	private WebDriver driver = this.getDriverManager();

	AppTask appTask = new AppTask(driver);
	RegisterTask registerTask = new RegisterTask(driver);
	HomeTask homeTask = new HomeTask(driver);
	StatementTask statementTask = new StatementTask(driver);
	TransferTask transferTask = new TransferTask(driver);

	@Test
	public void realizarTransferencia() throws InterruptedException {

		try {
			Report.createTest("Realizar Transferência com Sucesso da Conta 1 para Conta 2", ReportType.GROUP);
			Report.createStep("Realizar Cadastro de Conta 1");
			appTask.clicarRegistroButton();
			registerTask.cadastrarConta1();
			Report.createStep("Realizar Cadastro de Conta 2");
			appTask.clicarRegistroButton();
			registerTask.cadastrarConta2();
			Report.createStep("Realizar Login de Conta 1");
			appTask.efetuarLoginConta1();
			Report.createStep("Realizar Transferência de Conta 1 para Conta 2");
			homeTask.clicarTransfer();
			transferTask.efetuarTransferenciaConta1ParaConta2();
			Report.createStep("Validar Saldo Conta 1");
			homeTask.clicarExtrato();
			statementTask.validarExtratoConta1();
			homeTask.clicarSair();
			Report.createStep("Realizar Login de Conta 2");
			appTask.efetuarLoginConta2();
			Report.createStep("Validar Saldo Conta 2");
			homeTask.clicarExtrato();
			statementTask.validarExtratoConta2();
			homeTask.clicarSair();
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}
	}
}