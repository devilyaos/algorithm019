import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (int i = 0, len = queue.size(); i < len; i++) {
                TreeNode tmppNode = queue.poll();
                max = Math.max(max, tmppNode.val);
                if (tmppNode.left != null) {
                    queue.offer(tmppNode.left);
                }
                if (tmppNode.right != null) {
                    queue.offer(tmppNode.right);
                }
            }
            result.add(max);
        }
        return result;
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
