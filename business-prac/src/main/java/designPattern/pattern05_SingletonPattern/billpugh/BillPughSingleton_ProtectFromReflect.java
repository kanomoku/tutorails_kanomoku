package designPattern.pattern05_SingletonPattern.billpugh;

public class BillPughSingleton_ProtectFromReflect {
    private BillPughSingleton_ProtectFromReflect() {
        if (BillPughSingleton_ProtectFromReflect.getInstance() != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    private static class SingletonHelper {
        private static final BillPughSingleton_ProtectFromReflect INSTANCE = new BillPughSingleton_ProtectFromReflect();
    }

    public static BillPughSingleton_ProtectFromReflect getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
