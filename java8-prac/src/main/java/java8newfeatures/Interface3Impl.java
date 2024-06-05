package java8newfeatures;

public class Interface3Impl implements Interface3 {

    @Override public void method3() {
    }

    public boolean objIsNull(String str) {
        System.out.println("Interface3Impl.isNull: " + str);
        System.out.println("Interface3Impl.isNull: " + str);
        return str == null;
    }

    @Override public void defaultPrint(String str) {
        Interface3.super.defaultPrint(str);
    }

    public static void main(String args[]) {
        Interface3Impl obj = new Interface3Impl();
        obj.defaultPrint("");
        obj.objIsNull("abc");
        Interface3.staticIsNull("123");
    }
}