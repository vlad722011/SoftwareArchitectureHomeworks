package bridgePattern.notebooks;

import bridgePattern.operationSystems.OS;

public class Lenovo extends Notebook {
    public Lenovo (OS operationSystem) {
        super(operationSystem);
    }

    @Override
    String describe() {
        return ("This is notebook LENOVO with " + operationSystem.OperationSystem());
    }

    @Override
    public String toString() {
        return describe();
    }
}

