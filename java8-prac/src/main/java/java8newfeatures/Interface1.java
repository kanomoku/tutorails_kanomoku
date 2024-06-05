package java8newfeatures;

public interface Interface1 {

    void method1(String str);

    default void log(String str) {
        System.out.println("Interface1.log:: " + str);
    }
}