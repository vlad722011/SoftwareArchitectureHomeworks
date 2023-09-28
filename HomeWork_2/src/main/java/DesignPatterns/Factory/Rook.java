package DesignPatterns.Factory;

public class Rook implements ChessFigure {
    private ChessFigure rook;

    public Rook(ChessFigure rook) {
        this.rook = rook;
    }

    public Rook() {
    }

    public ChessFigure getRook() {
        return rook;
    }

    @Override
    public ChessFigure getFigure() {
        return getRook();
    }

    @Override
    public String toString() {
        String result = "";
        String thisFigure = "Rook";
        StringBuilder sb = new StringBuilder();
        result = String.valueOf(sb.append("This chess figure: ").append(thisFigure));
        return result;
    }
}
