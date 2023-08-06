package javabasic.innerclass;

/**
 * 用匿名内部类实现回调功能
 */
interface IBusiness {
    void execute();
}

public class Service {
    public void test(IBusiness iBusiness) {
        iBusiness.execute();
    }

    public static void main(String[] args) {
        Service service = new Service();
        // 这里我们使用匿名内部类的方式将接口对象作为参数传递到test方法中去了
        service.test(new IBusiness() {
            public void execute() {
                System.out.println("接口实现类1的execute");
            }
        });

        service.test(new IBusiness() {
            @Override
            public void execute() {
                System.out.println("接口实现类2的execute");
            }
        });

        service.test(() -> {
            System.out.println("接口实现类3的execute");
        });
    }
}
