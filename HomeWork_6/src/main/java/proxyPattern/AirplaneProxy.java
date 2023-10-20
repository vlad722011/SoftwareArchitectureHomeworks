package proxyPattern;

public class AirplaneProxy implements IMoveable {
    // В классе прокси создаем ссылку на оригинальный объект
    IMoveable airplaneProxy = new Airplane();
    @Override
    public void move() {
        System.out.println("Это вызов метода move() у прокси объекта.");
        airplaneProxy .move();
        System.out.println("Однако остальной клиентский код работает быстрее.");
    }
}
