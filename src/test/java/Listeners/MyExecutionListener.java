package Listeners;
import Utilities.CMDRunner;
import org.testng.IExecutionListener;
public class MyExecutionListener implements IExecutionListener {
    private final String deleteJsonCommand = "cmd /c cd allure-results && del /q *.json";
    private final String generateAllureReportCommand = "cmd /c allure generate allure-results --clean -o allure-report";
    @Override
    public void onExecutionStart() {
        System.out.println("MyExecutionListener onExecutionStart");
        CMDRunner.executeCommand(deleteJsonCommand);

    }

    @Override
    public void onExecutionFinish() {
        System.out.println("MyExecutionListener onExecutionFinish");
        CMDRunner.executeCommand(generateAllureReportCommand);
    }
}
