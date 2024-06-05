package java8newfeatures;

public interface Interface3 {
    void method3();

    default void defaultPrint(String str) {
        if (!staticIsNull(str))
            System.out.println("default-Interface3.print: " + str);
    }

    static boolean staticIsNull(String str) {
        System.out.println("static-Interface3.isNull: " + str);
        return str == null;
    }
}