package bridgePattern;

import bridgePattern.notebooks.Dell;
import bridgePattern.notebooks.Apple;
import bridgePattern.notebooks.Lenovo;
import bridgePattern.operationSystems.OperationSystems;

public class Main {
    public static void main(String[] args) {
        Dell notebookDellWithMacOS = new Dell(new OperationSystems.MacOS());
        System.out.println(notebookDellWithMacOS);

        Apple notebookDellWithUbuntuOS = new Apple(new OperationSystems.UbuntuOS());
        System.out.println(notebookDellWithUbuntuOS);

        Lenovo notebookLenovoWithWindowsOS = new Lenovo(new OperationSystems.WindowsOS());
        System.out.println(notebookLenovoWithWindowsOS);

    }
}
