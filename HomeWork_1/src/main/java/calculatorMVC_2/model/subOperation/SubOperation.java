package calculatorMVC.model.subOperation;

public class SubOperation {
    private double firstArgument;
    private double secondArgument;

    public SubOperation(double firstArgument, double secondArgument) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }
    public double subOperation(double firstArgument, double secondArgument){
        return firstArgument - secondArgument;
    }
}
