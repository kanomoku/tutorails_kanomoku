package array;

/**
 * JZ4 二维数组中的查找
 */
public class JZ4FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rows = array.length, columns = array[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
