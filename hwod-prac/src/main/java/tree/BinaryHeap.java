package tree;

import java.util.Arrays;

public class BinaryHeap {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        System.out.println("原始数据：" + Arrays.toString(arr));


        upAdjust(arr);
        System.out.println("上浮构建二叉堆：" + Arrays.toString(arr));

        int[] arr1 = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        for (int i = (arr1.length - 1) / 2; i >= 0; i--) {
            downAdjust(arr1, i, arr.length);
        }
        System.out.println("下沉构建二叉堆：" + Arrays.toString(arr1));

        int[] arr2 = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(arr2);
        System.out.println("二叉堆排序：" + Arrays.toString(arr2));
    }

    /**
     * 降序排序
     */
    public static void heapSort(int[] arr) {
        // 无序数组构造成二叉堆
        upAdjust(arr);
        System.out.println("上浮构建二叉堆：" + Arrays.toString(arr));

        for (int i = arr.length - 1; i >= 0; i--) {

            // 把小的置换到最下面
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // 把i作为右边界的范围内最小的找出来
            downAdjust(arr, 0, i);
        }
    }

    /**
     * 下浮调整(大的沉下去)
     *
     * @param arr    待调整的堆
     * @param parent 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] arr, int parent, int length) {
        int deseNote = arr[parent]; // 根节点
        int child = 2 * parent + 1;// 求左子节点

        while (child < length) { // 范围内
            if (child + 1 < length && arr[child + 1] < arr[child]) { // 取出两个子节点值最小的那个
                child++;
            }
            if (deseNote <= arr[child]) { // 父节点比他们都小，则不需要挪位置，终止循环
                break;
            }
            arr[parent] = arr[child]; // 子节点小，则子节点位置上移
            parent = child; // 此时子节点视为父节点继续下一步处理
            child = 2 * child + 1; // 算子节点的子节点
        }

        arr[parent] = deseNote;// 嘚瑟不动了，钻进别人剩下的窝里
    }

    /**
     * 上浮调整(小的浮上来)
     */
    public static void upAdjust(int[] arr) {
        int child = arr.length - 1;// 最后一个节点的下标
        int parent = (child - 1) / 2;// 最后一个非叶子节点的下标
        int deseNote = arr[child]; // 往下挪，所以把下面的节点取出来（嘚瑟一圈去，实在不行再回这个位置）

        while (0 < child && deseNote < arr[parent]) { // 说明这个节点还是叶子节点还不是根节点、父节点值>字节点的值
            arr[child] = arr[parent]; // 父节点值挪下来
            child = parent; // 父节点此时开始视为子节点
            parent = (child - 1) / 2; // 算父节点的父节点
        }

        arr[child] = deseNote; // 当前节点>父节点，因为当前节点的值已经赋值给他的子节点了，所有其位置装出去嘚瑟的值
    }
}
