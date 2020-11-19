public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 题目设定节点一定能在树中找到
        if (root == null || root == p || root == q) {
            return root;
        }
        // 在左子树找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树找
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右一定在最近公共祖先的左右两侧，即对于最小祖先的上一级来说，一边能找到一边找不到
        // 如果两边都能找到，说明这个节点是最小祖先
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
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
