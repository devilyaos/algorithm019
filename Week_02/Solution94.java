import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    /**
     * 二叉树的中序遍历
     * 中序为左中右
     * 1.套用递归公式
     *
     * @param root 根节点
     * @return 中序遍历数组
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new LinkedList<>(inorderTraversal1(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal1(root.right));
        return list;
    }

    /**
     * 二叉树的中序遍历
     * 中序为左中右
     * 1.用栈进行循环
     *
     * @param root 根节点
     * @return 中序遍历数组
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        // 保留一个指针
        TreeNode curr = root;
        List<Integer> list = new ArrayList<>();
        // 当指针一直有值或栈不为空的时候，都进行处理
        while (curr != null || !stack.isEmpty()) {
            // 不停将左节点压入栈，因为从左边开始
            while(curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            // 不停取栈顶，即为不停从左节点开始向中节点即右节点遍历
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
