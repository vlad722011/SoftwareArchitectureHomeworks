package calculatorMVC.db.input;

import java.util.Scanner;

public class GetDataFromConsole implements IInput{
    @Override
    public void getData() {
        // add metod
    }
    @Override
    public String getDataFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return getString(scanner);
    }

    private static String getString(Scanner scanner) {
        System.out.print("Введите первый аргумент: ");
        String firstArg = scanner.nextLine();
        System.out.print("Введите второй аргумент: ");
        String secondArg = scanner.nextLine();
        System.out.print("Какое математическое действие с аргументами выполнить? ");
        String mathOperation = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        String inputString = String.valueOf(sb
                .append(firstArg)
                .append(" ")
                .append(mathOperation)
                .append(" ")
                .append(secondArg)
                .append(" ")
                .append("="));
        return inputString;
    }
}
