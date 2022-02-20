import org.testng.annotations.Test;

public class ArrayTwoDimensional {

    @Test public void Test_Array_Search() {
        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%5d", a[i][j]);
                if (j == a[i].length - 1) {
                    System.out.println();
                } else {
                    System.out.print(",");
                }
            }
        }
    }
}
