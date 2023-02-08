package tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTree {
    public static void main(String[] args) {

        System.out.println("前序遍历：");
        List<Character> res = new ArrayList<>();
        preOrderRecursion(createBinTree(), res);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(",")));
        List<Character> characters = preOrder(createBinTree());
        System.out.println(characters.stream().map(String::valueOf).collect(Collectors.joining(",")));


        System.out.println("中序遍历:");
        List<Character> res2 = new ArrayList<>();
        inOrderRecursion(createBinTree(), res2);
        System.out.println(res2.stream().map(String::valueOf).collect(Collectors.joining(",")));
        List<Character> characters2 = inOrder(createBinTree());
        System.out.println(characters2.stream().map(String::valueOf).collect(Collectors.joining(",")));


        System.out.println("后序遍历:");
        List<Character> res3 = new ArrayList<>();
        postOrderRecursion(createBinTree(), res3);
        System.out.println(res3.stream().map(String::valueOf).collect(Collectors.joining(",")));
        List<Character> characters3 = postOrder(createBinTree());
        System.out.println(characters3.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    /**
     * 创建一棵二叉树
     *
     * @return 根节点
     */
    public static BinTreeNode<Character> createBinTree() {
        BinTreeNode<Character> RR2 = new BinTreeNode<>('F', null, null);
        BinTreeNode<Character> LR2 = new BinTreeNode<>('E', null, null);
        BinTreeNode<Character> LL2 = new BinTreeNode<>('D', null, null);
        BinTreeNode<Character> L1 = new BinTreeNode<>('B', LL2, LR2);
        BinTreeNode<Character> R1 = new BinTreeNode<>('C', null, RR2);
        BinTreeNode<Character> node = new BinTreeNode<>('A', L1, R1);
        return node;
    }

    /**
     * 前序递归法
     */
    public static void preOrderRecursion(BinTreeNode<Character> root, List<Character> res) {
        if (root == null) {
            return;
        }
        res.add(root.data);
        preOrderRecursion(root.lchild, res);
        preOrderRecursion(root.rchild, res);
    }

    /**
     * 中序递归法
     */
    public static void inOrderRecursion(BinTreeNode<Character> root, List<Character> res) {
        if (root == null) {
            return;
        }
        inOrderRecursion(root.lchild, res);
        res.add(root.data);
        inOrderRecursion(root.rchild, res);
    }

    /**
     * 后序递归法
     */
    public static void postOrderRecursion(BinTreeNode<Character> root, List<Character> res) {
        if (root == null) {
            return;
        }
        postOrderRecursion(root.lchild, res);
        postOrderRecursion(root.rchild, res);
        res.add(root.data);
    }

    /**
     * 前序遍历：迭代法
     */
    public static List<Character> preOrder(BinTreeNode<Character> root) {

        // 结果收集容器
        List<Character> res = new ArrayList<>();

        // Stack
        Deque<BinTreeNode<Character>> stack = new LinkedList<>();

        // root != null是针对有值处理的场景、!stack.isEmpty()是针对root = null时的场景
        while (root != null || !stack.isEmpty()) {
            while (root != null) { // 子节点有值就先入Stack
                res.add(root.data); // 前序遍历故遇到根节点就收集值
                stack.push(root);
                root = root.lchild; // 再看子节点的左子节点是否有值
            }

            root = stack.pop(); // 左弹根→右弹根父
            root = root.rchild; // 弹出父节点后取出其右子节点
        }

        return res;
    }


    /**
     * 中序迭代法
     */
    public static List<Character> inOrder(BinTreeNode<Character> root) {
        List<Character> res = new ArrayList<>();

        Deque<BinTreeNode<Character>> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.lchild;
            }

            root = stack.pop();
            res.add(root.data); // 左弹根→此时左子节点处理完毕弹出根节点，中序遍历故收集根节点值
            root = root.rchild;
        }

        return res;
    }


    /**
     * 后序迭代法
     */
    public static List<Character> postOrder(BinTreeNode<Character> root) {
        List<Character> res = new ArrayList<>();

        Deque<BinTreeNode<Character>> stack = new LinkedList<>();

        BinTreeNode<Character> previous = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.lchild;
            }

            root = stack.pop(); // 左弹根→右弹根→再弹根父

            if (root.rchild == null || root.rchild == previous) {
                res.add(root.data); // 上面的while包含了左右两种子节点情况、故这里单独处理右节点
                previous = root;
                root = null; // 赋值为null是为了触发右弹根父
            } else {
                stack.push(root); // 右子节点有值且没走过,pop出来的根节点二次入栈
                root = root.rchild;
            }
        }

        return res;
    }

}

class BinTreeNode<Character> {
    char data;
    BinTreeNode<Character> lchild;//树的左子树
    BinTreeNode<Character> rchild;//树的右子树

    BinTreeNode(char data, BinTreeNode<Character> lchild, BinTreeNode<Character> rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }
}