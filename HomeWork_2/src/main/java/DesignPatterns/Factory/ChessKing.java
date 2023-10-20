package DesignPatterns.Factory;

public class ChessKing implements ChessFigure {
    private ChessFigure chessKing;

    public ChessKing(ChessFigure chessKing) {
        this.chessKing = chessKing;
    }

    public ChessKing() {
    }

    public ChessFigure getChessKing() {
        return chessKing;
    }

    @Override
    public ChessFigure getFigure() {
        return getChessKing();
    }

    @Override
    public String toString() {
        String result = "";
        String thisFigure = "ChessKing";
        StringBuilder sb = new StringBuilder();
        result = String.valueOf(sb.append("This chess figure: ").append(thisFigure));
        return result;
    }
}

