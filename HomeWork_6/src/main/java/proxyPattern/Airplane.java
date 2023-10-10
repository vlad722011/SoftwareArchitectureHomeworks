package proxyPattern;

public class Airplane implements IMoveable {

    @Override
    public void move() {

        System.out.println("Этот самолет умеет летать.");
    }
}
