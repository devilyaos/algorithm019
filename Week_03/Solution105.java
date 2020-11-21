import java.util.HashMap;
import java.util.Map;

public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> nodeIndexMap = new HashMap<>();
        // 缓存中序遍历的节点，方便寻找根节点
        for (int i = 0, len = inorder.length; i < len; i++) {
            nodeIndexMap.put(inorder[i], i);
        }
        return buildTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, nodeIndexMap);
    }

    /**
     * 根据前序遍历，根据中序辅助构建
     * @param preorder 前序遍历
     * @param prestart 前序开头
     * @param preend 前序结尾
     * @param inorder 中序遍历
     * @param instart 中序开头
     * @param inend 中序结尾
     * @param nodeIndexMap 中序节点缓存
     * @return 数
     */
    private TreeNode buildTreeNode(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map<Integer, Integer> nodeIndexMap) {
        if (prestart == preend) {
            return null;
        }
        // 通过先序遍历找根节点，然后通过中序遍历确定左右子树
        TreeNode root = new TreeNode(preorder[prestart]);
        int inNodeIndex = nodeIndexMap.get(preorder[prestart]);
        // 即inNodeIndex左边为相对于根的左子树，右边为相对于根的右子树
        int leftTreeNum = inNodeIndex - instart;
        TreeNode leftNode = buildTreeNode(preorder, prestart + 1, prestart + leftTreeNum, inorder, instart, inNodeIndex, nodeIndexMap);
        TreeNode rightNode = buildTreeNode(preorder, prestart + leftTreeNum, preend, inorder, inNodeIndex + 1, inend, nodeIndexMap);
        root.left = leftNode;
        root.right = rightNode;
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
