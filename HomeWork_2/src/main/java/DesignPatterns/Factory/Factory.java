package DesignPatterns.Factory;

public class Factory {
    private ChessFigure figure;

    public Factory(ChessFigure figure, Color color) {
        this.figure = figure;
        if (figure.getClass().equals(Rook.class)) {
            figure = new Rook();
        }
        if (figure.getClass().equals(Qween.class)) {
            figure = new Qween();
        }
    }

    public ChessFigure getCurrentFigure(ChessFigure figure) {
        return figure;
    }
}
