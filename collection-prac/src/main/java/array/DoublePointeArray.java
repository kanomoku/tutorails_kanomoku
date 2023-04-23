package array;

import org.testng.annotations.Test;

public class DoublePointeArray {

    @Test
    public void nature() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    @Test
    public void reverse() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * [数组遍历]这个行为被重复执行
     */
    @Test
    public void traverseDeTraverse() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 控制[数组遍历]这个行为被重复执行次数--正序逆序不重要
        for (int i = 0; i < arr.length; i++) {
        // for (int i = arr.length - 1; i >= 0; i--) {

            // 数组正序遍历的行为
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + "  ");
            }

            System.out.print("←分水岭→  ");

            // 数组逆序遍历的行为
            for (int k = arr.length - 1; k >= 0; k--) {
                System.out.print(arr[k] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * [数组元素]被重复执行
     */
    @Test
    public void elementDeTraverse() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        // 数组元素排队轮回的顺序--正序 or 逆序
        for (int i = 0; i < arr.length; i++) {
        // for (int i = arr.length - 1; i >= 0; i--) {

            // 控制[数组元素]被重复执行次数--正序逆序不重要
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i] + "  ");
            }

            System.out.print("←分水岭→  ");

            // 控制[数组元素]被重复执行次数--正序逆序不重要
            for (int k = arr.length - 1; k >= 0; k--) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 动态规划里总结出来的 ☞ `回放的思想`
     */
    @Test
    public void review() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {

            // 从0回放到i
            // for (int j = 0; j <= i; j++) {

            // 从i回退到0
            // for (int j = i; j >= 0; j--) {

            // 从i快进到arr.length-1
            // for (int j = i; j < arr.length; j++) {

            // 从arr.length-1回退到i
            for (int j = arr.length - 1; j >= i; j--) {

                System.out.print(arr[j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 动态规划里总结出来的 ☞ `回放的思想`
     * 格式化
     */
    @Test
    public void reviewFormat() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {

            // 从0回放到i
            String str = "";
            for (int j = 0; j <= i; j++) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 从i回退到0
            str = "";
            for (int j = i; j >= 0; j--) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 从i快进到arr.length-1
            str = "";
            for (int j = i; j < arr.length; j++) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");


            // 从arr.length-1回退到i
            str = "";
            for (int j = arr.length - 1; j >= i; j--) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.println();
        }
    }

    /**
     * 元素遍历其下标的次数 ☞ 回访的拓展 ☞ 还未在算法中遇到
     */
    @Test
    public void indexTime() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {

            // 位置i处元素遍历i次，正序，逆序无所谓
            // for (int j = 0; j <= i; j++) {
            // for (int j = i; j >= 0; j--) {

            // 位置i处元素遍历arr.length-i次，正序，逆序无所谓
            // for (int j = i; j < arr.length; j++) {
            for (int j = arr.length - 1; j >= i; j--) {

                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 元素遍历其下标的次数 ☞ 回访的拓展 ☞ 还未在算法中遇到
     * 格式化
     */
    @Test
    public void indexTimeFormat() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {

            String str = "";
            for (int j = 0; j <= i; j++) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            str = "";
            for (int j = i; j >= 0; j--) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            str = "";
            for (int j = i; j < arr.length; j++) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            str = "";
            for (int j = arr.length - 1; j >= i; j--) {
                 str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.println();
        }
    }

    public static String postFill(String str){
        if (str.length()>=27){
            return str;
        }
        return postFill(str + " ");
    }

    public static String preFill(String str) {
        if (str.length() >= 27) {
            return str;
        }
        return preFill(" " + str);
    }

    /**
     * 数组折叠对应下标相加为length - 1
     */
    @Test
    public void fold() {
        String str1 = "abccba";
        char[] chars = str1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + "  ");
        }
        System.out.println();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        String str2 = "abcba";
        chars = str2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + "  ");
        }
        System.out.println();

        for (int i = 0; i < chars.length; i++) {
            System.out.print(i + "  ");
        }
    }

    /**
     * 基于目标的博弈
     */
    @Test
    public void arrayFold() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {

            // 逐级降低目标
            String str = "";
            for (int j = 0; j <= arr.length - 1 - i; j++) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 从arr.length-1回退到i (相同功能)
            str = "";
            for (int j = arr.length - 1 - i; j >= 0; j--) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 降低成本，观察是否还能达到预期目标
            str = "";
            for (int j = arr.length - 1 - i; j < arr.length; j++) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 资本对品质的反向蚕食
            str = "";
            for (int j = arr.length - 1; j >= arr.length - 1 - i; j--) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.println();
        }
    }

    /**
     * 元素遍历次数与其下标相关
     */
    @Test
    public void arrayFold2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {

            // 元素遍历其[下标的对折位置的下标]的次数，正序逆序无所谓
            String str = "";
            for (int j = 0; j <= arr.length - 1 - i; j++) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 元素遍历其[下标的对折位置的下标]的次数，正序逆序无所谓
            str = "";
            for (int j = arr.length - 1 - i; j >= 0; j--) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 元素遍历其下标的次数，正序逆序无所谓
            str = "";
            for (int j = arr.length - 1 - i; j < arr.length; j++) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 元素遍历其下标的次数，正序逆序无所谓
            str = "";
            for (int j = arr.length - 1; j >= arr.length - 1 - i; j--) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.println();
        }
    }

    /**
     * 回放的思想 ☞ 基于数组折叠思想
     */
    @Test
    public void arrayFold3() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = arr.length - 1; i >= 0; i--) {

            String str = "";
            for (int j = 0; j <= arr.length - 1 - i; j++) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            str = "";
            for (int j = arr.length - 1 - i; j >= 0; j--) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            str = "";
            for (int j = arr.length - 1 - i; j < arr.length; j++) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            str = "";
            for (int j = arr.length - 1; j >= arr.length - 1 - i; j--) {
                str += arr[j] + "  ";
            }
            System.out.print(postFill(str));
            System.out.println();
        }
    }

    /**
     * 元素遍历其[下标的对折位置的下标]的次数（后→前）
     */
    @Test
    public void arrayFold4() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = arr.length - 1; i >= 0; i--) {

            // 元素遍历其[下标的对折位置的下标]的次数，正序逆序无所谓
            String str = "";
            for (int j = 0; j <= arr.length - 1 - i; j++) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 元素遍历其[下标的对折位置的下标]的次数，正序逆序无所谓
            str = "";
            for (int j = arr.length - 1 - i; j >= 0; j--) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 元素遍历其下标的次数，正序逆序无所谓
            str = "";
            for (int j = arr.length - 1 - i; j < arr.length; j++) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.print("←分水岭→  ");

            // 元素遍历其下标的次数，正序逆序无所谓
            str = "";
            for (int j = arr.length - 1; j >= arr.length - 1 - i; j--) {
                str += arr[i] + "  ";
            }
            System.out.print(postFill(str));
            System.out.println();
        }
    }

    /**
     * 数组范围截取
     */
    @Test
    public void arrayBeEaten() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < arr.length; i++) {
            String str = "";
            for (int j = 0; j < arr.length; j++) {
                str += arr[i] + "  ";
            }
            System.out.println(preFill(str.trim()));
        }

        System.out.println();

        for (int i = 1; i < arr.length; i++) {
            String str1 = "";
            for (int j = 1; j < arr.length; j++) {
                str1 += arr[i] + "  ";
            }
            System.out.println(preFill(str1.trim()));
        }

        System.out.println();

        for (int i = arr.length - 1; i < arr.length; i++) {
            String str1 = "";
            for (int j = arr.length - 1; j < arr.length; j++) {
                str1 += arr[i] + "  ";
            }
            System.out.println(preFill(str1.trim()));
        }
    }
}
