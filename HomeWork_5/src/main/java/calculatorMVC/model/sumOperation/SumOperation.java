package calculatorMVC.model.sumOperation;

public class SumOperation {
    private double firstArgument;
    private double secondArgument;

    public SumOperation(double firstArgument, double secondArgument) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }
    public double sumOperation(double firstArgument, double secondArgument){
        return firstArgument + secondArgument;
    }
}
