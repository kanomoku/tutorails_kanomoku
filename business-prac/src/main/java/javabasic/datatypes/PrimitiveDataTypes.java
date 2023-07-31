package datatypes;

public class PrimitiveDataTypes {
    public static void main(String[] args) {
        Integer d1 = 100;
        Integer d2 = 100;
        System.out.println(d1 == d2); // true

        Integer d3 = 127;
        Integer d4 = 127;
        System.out.println(d3 == d4); // true

        Integer d5 = -128;
        Integer d6 = -128;
        System.out.println(d5 == d6); // true

        Integer d7 = 128;
        Integer d8 = 128;
        System.out.println(d7 == d8); // false

        Integer d9 = -129;
        Integer d10 = -129;
        System.out.println(d9 == d10); // false


        Integer b = 127;
        Integer c = new Integer(127);
        System.out.println(c == b); // false

        Integer e = new Integer(127);
        Integer f = new Integer(127);
        System.out.println(e == f); // false
        System.out.println(e.equals(f)); // false
    }
}
