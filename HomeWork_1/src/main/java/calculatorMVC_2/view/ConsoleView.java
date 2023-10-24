package calculatorMVC.view;

import calculatorMVC.db.input.GetDataFromConsole;
import calculatorMVC.db.input.IInput;
import calculatorMVC.db.output.IOutput;
import calculatorMVC.db.output.OutputResultToConsole;
import calculatorMVC.model.CalculatorController;


public class ConsoleView implements IView {
    CalculatorController calculatorController;
    IInput inputString;
    IOutput outputString;

    public ConsoleView() {
        inputString = new GetDataFromConsole();
        outputString = new OutputResultToConsole();
        calculatorController = new CalculatorController();
    }

    @Override
    public String runCalculator() {
        String input = inputString.getDataFromConsole();
        return getResultString(input);
    }

    public String getResultString(String input) {
        String[] parts = input.split(" ");
        String firstArgument = parts[0];
        double firstArg = Double.parseDouble(firstArgument);
        String secondArguments = parts[2];
        double secondArg = Double.parseDouble(secondArguments);
        String operation = parts[1];
        String resultOperation = "";
        switch (operation) {
            case "+": {
                double result = calculatorController.SumOperation(firstArg, secondArg);
                resultOperation = String.format("%.2f", result);
                break;
            }
            case "-": {
                double result = calculatorController.SubOperation(firstArg, secondArg);
                resultOperation = String.format("%.2f", result);
                break;
            }
            case "*": {
                double result = calculatorController.MultiplyOperation(firstArg, secondArg);
                resultOperation = String.format("%.2f", result);
                break;
            }
            case "/": {
                double result = calculatorController.DivOperation(firstArg, secondArg);
                resultOperation = String.format("%.2f", result);
                break;
            }
            default:
                break;
        }
        return resultOperation;
    }
}

