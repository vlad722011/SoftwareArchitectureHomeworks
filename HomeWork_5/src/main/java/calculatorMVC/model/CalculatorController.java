package calculatorMVC.model;

import calculatorMVC.model.diviisionOperation.DivOperation;
import calculatorMVC.model.multiplyOperation.MultiplyOperation;
import calculatorMVC.model.subOperation.SubOperation;
import calculatorMVC.model.sumOperation.SumOperation;

public class CalculatorController {
    public double SumOperation(double a, double b){
        SumOperation  sumOperation = new SumOperation(a, b);
        return sumOperation.sumOperation(a, b);
    }
    public double SubOperation(double a, double b){
        SubOperation subOperation = new SubOperation(a, b);
        return subOperation.subOperation(a, b);
    }
    public double DivOperation(double a, double b){
        DivOperation divOperation =new DivOperation(a, b);
        return divOperation.divisionOperation(a, b);
    }
    public double MultiplyOperation (double a, double b){
        MultiplyOperation multiplyOperation = new MultiplyOperation(a, b);
        return multiplyOperation.multiplyOperation(a, b);
    }
}
