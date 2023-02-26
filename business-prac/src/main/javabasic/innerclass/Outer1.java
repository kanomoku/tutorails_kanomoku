package innerclass;

class Outer1 {
    // 属性的位置
    private class Inner {
        public void show() {
            System.out.println("密码备份文件");
        }
    }

    //使用getXxx()获取成员内部类，可以增加校验语句（文中省略）
    public Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        Outer1.Inner inner = outer1.getInner();
        inner.show();
    }
}
