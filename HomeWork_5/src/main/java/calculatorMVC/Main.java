package calculatorMVC;

import calculatorMVC.db.input.GetDataFromConsole;
import calculatorMVC.db.output.OutputResultToConsole;
import calculatorMVC.view.IView;
import calculatorMVC.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        // Первый вариант запуска калькулятора
        System.out.println("Первый вариант запуска калькулятора:");
        IView view = new ConsoleView();
        String resultOperation = view.runCalculator();
        System.out.println("Результат: " + resultOperation);


        // Второй вариант запуска калькулятора
        System.out.println("Второй вариант запуска калькулятора:");
        GetDataFromConsole getDataFromConsole = new GetDataFromConsole();
        String input = getDataFromConsole.getDataFromConsole();
        System.out.print("Результат: " + input);
        OutputResultToConsole outputResultToConsole = new OutputResultToConsole();
        String result = outputResultToConsole.outputResultToConsole(input);
        System.out.println(" " + result);
    }

}
