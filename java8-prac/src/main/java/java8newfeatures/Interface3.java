package java8newfeatures;

public interface Interface3 {
    void method3();
    default void print(String str) {
        if (!isNull(str))
            System.out.println("Interface3 Print: " + str);
    }

    static boolean isNull(String str) {
        System.out.println("Interface Null Check: " + str);
        return str == null;
    }
}