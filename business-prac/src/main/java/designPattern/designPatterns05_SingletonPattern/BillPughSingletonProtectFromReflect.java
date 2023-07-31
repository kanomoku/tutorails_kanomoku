package designPattern.designPatterns05_SingletonPattern;

public class BillPughSingletonProtectFromReflect {
    private BillPughSingletonProtectFromReflect() {
        if (BillPughSingletonProtectFromReflect.getInstance() != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    private static class SingletonHelper {
        private static final BillPughSingletonProtectFromReflect INSTANCE = new BillPughSingletonProtectFromReflect();
    }

    public static BillPughSingletonProtectFromReflect getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
