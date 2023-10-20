package bridgePattern.notebooks;


import bridgePattern.operationSystems.OS;

public abstract class Notebook {
    protected OS operationSystem;

    public Notebook(OS operationSystem) {
        this.operationSystem = operationSystem;
    }

    abstract String describe();
}
