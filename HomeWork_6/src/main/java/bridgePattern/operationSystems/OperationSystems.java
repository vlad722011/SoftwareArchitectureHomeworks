package bridgePattern.operationSystems;

public class OperationSystems {
    public static class WindowsOS implements OS {
        @Override
        public String OperationSystem() {
            return "Windows Operation System";
        }
    }

    public static class UbuntuOS  implements OS{
        @Override
        public String OperationSystem() {
            return "Ubuntu Operation System";
        }
    }

    public static class MacOS implements OS{
        @Override
        public String OperationSystem() {
            return "Mac Operation System";
        }
    }
}
