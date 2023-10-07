package calculatorMVC.model.diviisionOperation;

public class DivOperation {
    private double firstArgument;
    private double secondArgument;

    public DivOperation(double firstArgument, double secondArgument) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }
    public double divisionOperation(double firstArgument, double secondArgument){
        return firstArgument / secondArgument;
    }
}
