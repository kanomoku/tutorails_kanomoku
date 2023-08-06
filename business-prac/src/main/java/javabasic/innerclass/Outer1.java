package javabasic.innerclass;

/**
 * 成员内部类
 */
class Outer1 {
    // 类成员位置位置
    private class Inner {
        public void show() {
            System.out.println("密码备份文件");
        }
    }

    //使用getXxx()获取成员内部类，可以增加校验语句（文中省略）
    public Inner getInner() {
        return new Inner();
    }

    private class Inner2 {
        public void show() {
            System.out.println("密码备份文件2");
        }
    }

    public static void main(String[] args) {
        Outer1.Inner2 inner2 = new Outer1().new Inner2();
        inner2.show();

        Outer1.Inner inner = new Outer1().getInner();
        inner.show();
    }
}
