package tree;

import java.util.*;

/**
 * leetcode 剑指 Offer 32 - I. 从上到下打印二叉树
 * leetcode 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * leetcode 102. 二叉树的层序遍历
 * leetcode 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class PrintABinaryTreeFromTopToBottom {

    /**
     * leetcode 剑指 Offer 32 - I. 从上到下打印二叉树
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * [3,9,20,15,7]
     */
    public int[] levelOrder1(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        Integer[] integers = result.toArray(new Integer[0]);
        return Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
    }

    /**
     * leetcode 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * leetcode 102. 二叉树的层序遍历
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // 临界值返回
        if (root == null) {
            return result;
        }

        // BFS走迷宫那个思路
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelValueList = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                levelValueList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelValueList);
        }

        return result;
    }

    /**
     * leetcode 剑指 Offer 32 - III. 从上到下打印二叉树 III
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isOrderLeftToRight = true;

        while (!queue.isEmpty()) {
            Deque<Integer> levelValueQueue = new LinkedList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curNode = queue.poll();

                if (isOrderLeftToRight) {
                    levelValueQueue.offerLast(curNode.val);
                } else {
                    levelValueQueue.offerFirst(curNode.val);
                }

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            result.add(new LinkedList<>(levelValueQueue));

            // 取相反的操作
            isOrderLeftToRight = !isOrderLeftToRight;
        }

        return result;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}