package DesignPatterns.Factory;

public class ChessPawn implements ChessFigure {
    private ChessFigure chessPawn;

    public ChessPawn(ChessFigure chessPawn) {
        this.chessPawn = chessPawn;
    }

    public ChessPawn() {
    }

    public ChessFigure getChessPawn() {
        return chessPawn;
    }

    @Override
    public ChessFigure getFigure() {
        return getChessPawn();
    }

    @Override
    public String toString() {
        String result = "";
        String thisFigure = "ChessPawn";
        StringBuilder sb = new StringBuilder();
        result = String.valueOf(sb.append("This chess figure: ").append(thisFigure));
        return result;
    }
}

