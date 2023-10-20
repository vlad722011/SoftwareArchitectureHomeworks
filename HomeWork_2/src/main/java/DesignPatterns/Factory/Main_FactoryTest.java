/*
Паттерн проектирования: Factory (Фабрика)

Описание:
Данный паттерн используется, когда у нас есть суперкласс
(в нашем примере это класс "ФАБРИКА" (Class - "Factory"))
с несколькими подклассами (соответственно в нашем примере это классы конкретных шахматных фигур:
ладья, ферзь, король, конь, слон и пешка).
На основе входных данных возвращается один из подклассов. В момент создания суперкласс не знает
объект какого типа он должен создать. Объекты создаются в зависимости от входящих данных.

 */

package DesignPatterns.Factory;

public class Main_FactoryTest {
    public static void main(String[] args) {
        Color color1 = Color.WHITE;
        ChessFigure figure1 = new Rook();

        Color color2 = Color.BLACK;
        ChessFigure figure2 = new Horse();

        Factory factory1 = new Factory(figure1, color1);
        ChessFigure currentFigure1 = factory1.getCurrentFigure(figure1);
        System.out.println("First chess figure:");
        System.out.println(currentFigure1.toString() + " " + color1);

        System.out.println();

        Factory factory2 = new Factory(figure2, color2);
        ChessFigure currentFigure2 = factory2.getCurrentFigure(figure2);
        System.out.println("Second chess figure:");
        System.out.println(currentFigure2.toString() + " " + color2);
    }
}

