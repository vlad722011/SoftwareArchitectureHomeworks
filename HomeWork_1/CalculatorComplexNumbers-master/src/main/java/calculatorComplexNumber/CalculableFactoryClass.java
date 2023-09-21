package calculatorComplexNumber;

public class CalculableFactoryClass implements CalculableFactoryInterface{

    @Override
    public Calculable createArg(ComplexNumber number) {
        return (Calculable) new ComputingModuleClass(number);
    }
}
