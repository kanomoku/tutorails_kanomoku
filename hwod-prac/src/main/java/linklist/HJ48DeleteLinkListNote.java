package linklist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * HJ48 从单向链表中删除指定值的节点
 */
public class HJ48DeleteLinkListNote {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            if (str.equals("")) {
                continue;
            }

            // 6 2 1 2 3 2 5 1 4 5 7 2 2
            // 6 {2 [1 2 3 2 5 1 4 5 7 2]} 2
            String[] split = str.split(" ");

            ListNode head = buildListNode(split);

            // 最后一个参数为2，表示要删掉节点为2的值
            int del_number = Integer.parseInt(split[split.length - 1]);

            StringBuilder sb = new StringBuilder();
            ListNode temp = head;
            while (temp != null) {
                if (temp.val != del_number) // 以跳过的方式模拟删除节点
                    sb.append(temp.val).append(" ");
                temp = temp.next;
            }

            System.out.println(sb.toString()); // 注意要求每个数后面都加空格
        }
        bf.close();
    }

    private static ListNode buildListNode2(String[] split) {
        // 第一个参数6表示输入总共6个节点
        int noteCounts = Integer.parseInt(split[0]); // 总共有多少个节点

        // 第二个参数2表示头节点值为2
        ListNode head = new ListNode(Integer.parseInt(split[1])); // 头结点

        for (int i = 1; i < noteCounts; i++) { // 头结点为2已确定,6组数据所以从第2组开始
            // 剩下的2个一组表示第2个节点值后面插入第1个节点值
            int willInsert = Integer.parseInt(split[2 * i]); // 被插入的值
            int afterWho = Integer.parseInt(split[2 * i + 1]); // 在谁的后面插入值

            ListNode temp = head; // 临时遍历链表
            while (temp.val != afterWho) { // 找到插入的位置
                temp = temp.next;
            }

            ListNode newNode = new ListNode(willInsert);
            newNode.next = temp.next; // 插入位置的节点的后序面节点跟踪上
            temp.next = newNode; // 当前节点挂靠到插入位置的节点上
        }
        return head;
    }

    private static ListNode buildListNode(String[] split) {
        int noteCounts = Integer.parseInt(split[0]); // 总共有多少个节点

        ListNode head = new ListNode(Integer.parseInt(split[1])); // 头结点

        String[] strings = Arrays.copyOfRange(split, 2, split.length); // 余下的成对的节点

        for (int i = 0; i < noteCounts - 1; i++) { // 头结点为2已确定,6组数据还剩5组
            // 剩下的2个一组表示第2个节点值后面插入第1个节点值
            int willInsert = Integer.parseInt(strings[2 * i]); // 被插入的值
            int afterWho = Integer.parseInt(strings[2 * i + 1]); // 在谁的后面插入值

            ListNode temp = head; // 临时遍历链表
            while (temp.val != afterWho) { // 找到插入的位置
                temp = temp.next;
            }

            ListNode newNode = new ListNode(willInsert);
            newNode.next = temp.next; // 插入位置的节点的后序面节点跟踪上
            temp.next = newNode; // 当前节点挂靠到插入位置的节点上
        }
        return head;
    }
}

/**
 * 单向链表
 */
class ListNode {
    ListNode next;
    int val;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}
