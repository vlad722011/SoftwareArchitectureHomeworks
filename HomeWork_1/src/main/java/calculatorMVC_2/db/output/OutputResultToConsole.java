package calculatorMVC.db.output;

import calculatorMVC.model.CalculatorController;
import calculatorMVC.view.ConsoleView;
public class OutputResultToConsole implements IOutput{
    CalculatorController calculatorController = new CalculatorController();
    @Override
    public void saveData() {
        // add metod
    }

    @Override
    public String outputResultToConsole(String inputString) {
        calculatorController = new CalculatorController();
        ConsoleView consoleView = new ConsoleView();
        String resultOperation = consoleView.getResultString(inputString);
        return resultOperation;
    }
}
