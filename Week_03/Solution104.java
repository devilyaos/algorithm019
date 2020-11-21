import java.util.Deque;
import java.util.LinkedList;

public class Solution104 {
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        TreeNode tmpNode;
        int height = 0;
        while(!queue.isEmpty()) {
            height++;
            for (int i = 0, len = queue.size(); i < len; i++) {
                tmpNode = queue.poll();
                if (tmpNode.left != null) {
                    queue.addFirst(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.addFirst(tmpNode.right);
                }
            }
        }
        return height;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
