package proxyPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------");
        // Создаем оосновной объект, с которым взаимодействует клиентский код.
        IMoveable airplane = new Airplane();
        // Вызвываем метод move() у основного объекта
        System.out.println("Это результат вызова метода move() у основного объекта.");
        airplane.move();
        System.out.println("-------------------------------------------------------");
        IMoveable airplaneProxy = new AirplaneProxy();
        // Вызвываем метод move() у прокси объекта
        airplaneProxy.move();
        System.out.println("-------------------------------------------------------");
    }
}
