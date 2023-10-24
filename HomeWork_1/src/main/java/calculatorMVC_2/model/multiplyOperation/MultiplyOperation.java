package calculatorMVC.model.multiplyOperation;

public class MultiplyOperation {
    private double firstArgument;
    private double secondArgument;

    public MultiplyOperation(double firstArgument, double secondArgument) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }
    public double multiplyOperation(double firstArgument, double secondArgument){
        return firstArgument * secondArgument;
    }
}
