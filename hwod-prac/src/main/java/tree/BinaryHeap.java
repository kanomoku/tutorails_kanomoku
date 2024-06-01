package tree;

import java.util.Arrays;

public class BinaryHeap {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 9, 5, 7, 8, 6, 10, 0};
        System.out.println("原始数据：" + Arrays.toString(arr));
        for (int i = arr.length - 1; i >= 0; i--) {
            smallUp1(arr, i);
        }
        System.out.println("上浮构建最小二叉堆：" + Arrays.toString(arr));

        int[] arr2 = {1, 3, 2, 9, 5, 7, 8, 6, 10, 0};
        for (int i = arr2.length - 1; i >= 0; i--) {
            smallUp2(arr2, i);
        }
        System.out.println("上浮构建最小二叉堆：" + Arrays.toString(arr2));

        int[] arr11 = {1, 3, 2, 9, 5, 7, 8, 6, 10, 0};
        for (int i = (arr11.length - 1) / 2; i >= 0; i--) {
            bigDown1(arr11, i, arr11.length);
        }
        System.out.println("下沉构建最小二叉堆：" + Arrays.toString(arr11));

        int[] arr22 = {1, 3, 2, 9, 5, 7, 8, 6, 10, 0};
        for (int i = (arr22.length - 1) / 2; i >= 0; i--) {
            bigDown2(arr22, i, arr22.length);
        }
        System.out.println("下沉构建最小二叉堆：" + Arrays.toString(arr22));

        System.out.println("===============================================");

        int[] arr222 = {1, 3, 2, 9, 5, 7, 8, 6, 10, 0};
        heapSort1(arr222);
        System.out.println("二叉堆排序：" + Arrays.toString(arr222));

        int[] arr2222 = {1, 3, 2, 9, 5, 7, 8, 6, 10, 0};
        heapSort1(arr2222);
        System.out.println("二叉堆排序：" + Arrays.toString(arr2222));
    }

    /**
     * 降序排序
     */
    public static void heapSort1(int[] arr) {
        // 无序数组构造成二叉堆
        System.out.println("原始数据：" + Arrays.toString(arr));
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            bigDown1(arr, i, arr.length);
        }
        System.out.println("下沉构建最小二叉堆：" + Arrays.toString(arr));

        for (int i = arr.length - 1; i > 0; i--) { // i=0会出错，会把值清零
            arr[0] = arr[0] ^ arr[i];
            arr[i] = arr[0] ^ arr[i];
            arr[0] = arr[0] ^ arr[i];
            bigDown2(arr, 0, i); // 把i作为右边界
        }
    }

    /**
     * 降序排序
     */
    public static void heapSort2(int[] arr) {
        // 无序数组构造成二叉堆
        System.out.println("原始数据：" + Arrays.toString(arr));
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            bigDown1(arr, i, arr.length);
        }
        System.out.println("下沉构建最小二叉堆：" + Arrays.toString(arr));

        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            bigDown2(arr, 0, i);
        }
    }

    /**
     * 下浮调整(大的下沉)
     *
     * @param arr    待调整的堆
     * @param parent 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void bigDown1(int[] arr, int parent, int length) {
        int child = 2 * parent + 1;
        while (child < length) { // 范围内
            if (child + 1 < length && arr[child + 1] < arr[child]) { // 取出两个子节点值最小的那个
                child++;
            }
            if (arr[parent] <= arr[child]) {       // 父节点比他们都小，则符合预期终止循环
                break;
            }
            arr[child] = arr[child] ^ arr[parent];
            arr[parent] = arr[child] ^ arr[parent];
            arr[child] = arr[child] ^ arr[parent];
            parent = child;                         // 此时子节点视为父节点继续下一步处理
            child = 2 * child + 1;
        }
    }

    /**
     * 下浮调整(大的下沉)
     *
     * @param arr    待调整的堆
     * @param parent 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void bigDown2(int[] arr, int parent, int length) {
        int baseVal = arr[parent];
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && arr[child + 1] < arr[child]) {
                child++;
            }
            if (baseVal <= arr[child]) {
                break;
            }
            arr[parent] = arr[child]; // 子节点小，则子节点位置上移
            parent = child;
            child = 2 * child + 1;
        }
        arr[parent] = baseVal;        // baseVal下沉不动了，所以落在当前子节点位置
    }

    /**
     * 上浮调整(小的上浮)
     */
    public static void smallUp1(int[] arr, int child) {
        int parent = (child - 1) / 2;

        while (0 < child && arr[child] < arr[parent]) { // 0 < child说明这个节点还是叶子
            arr[child] = arr[child] ^ arr[parent];
            arr[parent] = arr[child] ^ arr[parent];
            arr[child] = arr[child] ^ arr[parent];
            child = parent;                             // 父节点此时开始视为子节点
            parent = (child - 1) / 2;                   // 算父节点的父节点
        }
    }

    /**
     * 上浮调整(小的上浮)
     */
    public static void smallUp2(int[] arr, int child) {
        int parent = (child - 1) / 2;
        int baseVal = arr[child];                       // 把处理的数据取出来
        while (0 < child && baseVal < arr[parent]) {
            arr[child] = arr[parent];                   // 父节点值挪下来，父节点为baseVal备选位置
            child = parent;
            parent = (child - 1) / 2;
        }

        arr[child] = baseVal;                           // baseVal上浮不动了，所以落在当前子节点位置
    }
}
