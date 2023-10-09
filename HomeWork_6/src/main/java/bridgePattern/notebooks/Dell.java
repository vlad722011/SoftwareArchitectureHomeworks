package bridgePattern.notebooks;


import bridgePattern.operationSystems.OS;

public class Dell extends Notebook {
    public Dell(OS operationSystem) {
        super(operationSystem);
    }

    @Override
    String describe() {
        return ("This is notebook DELL with " + operationSystem.OperationSystem());
    }

    @Override
    public String toString() {
        return describe();
    }
}

