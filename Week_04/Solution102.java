import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while(!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0, len = queue.size(); i < len; i++) {
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                if (tmpNode.left != null) {
                    queue.addFirst(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.addFirst(tmpNode.right);
                }
            }
            result.add(tmpList);
        }
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        _dfs(result, root, 0);
        return result;
    }

    private void _dfs(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        _dfs(result, root.left, level + 1);
        _dfs(result, root.right, level + 1);
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
