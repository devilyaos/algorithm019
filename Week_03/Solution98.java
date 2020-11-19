public class Solution98 {
    /**
     * 验证二叉搜索树
     * 可以递归判断每个节点的左右儿子是否满足条件
     * @param root 根节点
     * @return 是否为二叉搜索树
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val < pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(1);
        System.out.println(new Solution98().isValidBST(root));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
