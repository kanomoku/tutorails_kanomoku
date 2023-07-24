package java8newfeatures;

public class Interface3Impl implements Interface3 {

    @Override
    public void method3() {
    }

    public boolean isNull(String str) {
        System.out.println("Interface3Impl Null Check: " + str);

        return str == null;
    }

    public static void main(String args[]) {
        Interface3Impl obj = new Interface3Impl();
        obj.print("");
        obj.isNull("abc");
        Interface3.isNull("123");
    }
}