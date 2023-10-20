package bridgePattern.notebooks;

import bridgePattern.operationSystems.OS;

public class Apple extends Notebook {
    public Apple (OS operationSystem) {
        super(operationSystem);
    }

    @Override
    String describe() {
        return ("This is notebook APPLE with " + operationSystem.OperationSystem());
    }

    @Override
    public String toString() {
        return describe();
    }
}
