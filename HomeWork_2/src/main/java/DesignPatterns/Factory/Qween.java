package DesignPatterns.Factory;

public class Qween implements ChessFigure{
    private ChessFigure qween;

    public Qween(ChessFigure qween) {
        this.qween = qween;
    }

    public Qween() {
    }

    public ChessFigure getQween() {
        return qween;
    }

    @Override
    public ChessFigure getFigure() {
        return getQween();
    }

    @Override
    public String toString() {
        String result = "";
        String thisFigure = "Qween";
        StringBuilder sb = new StringBuilder();
        result = String.valueOf(sb.append("This chess figure: ").append(thisFigure));
        return result;
    }
}
