package DesignPatterns.Factory;

public class Horse implements ChessFigure {
    private ChessFigure horse;

    public Horse(ChessFigure horse) {
        this.horse = horse;
    }

    public Horse() {
    }

    public ChessFigure getHorse() {
        return horse;
    }

    @Override
    public ChessFigure getFigure() {
        return getHorse();
    }

    @Override
    public String toString() {
        String result = "";
        String thisFigure = "Horse";
        StringBuilder sb = new StringBuilder();
        result = String.valueOf(sb.append("This chess figure: ").append(thisFigure));
        return result;
    }
}

