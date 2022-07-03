package array;

import org.testng.annotations.Test;

public class DoublePointeArray {

    @Test public void test1() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test2() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                System.out.print(arr[j] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test3() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test4() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test5() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[j] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test6() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print(arr[j] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test7() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print(arr[j] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test8() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                System.out.print(arr[j] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test9() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test10() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test11() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test12() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test13() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= arr.length - 1 - i; j++) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test14() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1 - i; j >= 0; j--) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test15() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    @Test public void test16() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }
}
