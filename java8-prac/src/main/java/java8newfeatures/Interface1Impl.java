package java8newfeatures;

public class Interface1Impl implements Interface1 {

    @Override
    public void method1(String str) {
    }

    public static void main(String[] args) {
        Interface1Impl interface1Impl = new Interface1Impl();
        interface1Impl.log("abc");
    }
}