package DesignPatterns.Factory;

public class ChessBishop implements ChessFigure {
    private ChessFigure chessBishop;

    public ChessBishop(ChessFigure chessBishop) {
        this.chessBishop = chessBishop;
    }

    public ChessBishop() {
    }

    public ChessFigure getChessBishop() {
        return chessBishop;
    }

    @Override
    public ChessFigure getFigure() {
        return getChessBishop();
    }

    @Override
    public String toString() {
        String result = "";
        String thisFigure = "ChessBishop";
        StringBuilder sb = new StringBuilder();
        result = String.valueOf(sb.append("This chess figure: ").append(thisFigure));
        return result;
    }
}

