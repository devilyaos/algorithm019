import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution589 {

    /**
     * N叉树前序遍历
     *
     * @param root 根节点
     * @return 遍历数组
     */
    public List<Integer> preorder(Node root) {

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> out = new LinkedList<>();

        if (root == null) {
            return out;
        }
        // 前序根左右
        stack.add(root);
        while (!stack.isEmpty()) {
            // 此处用pullLast是因为用add添加，在队尾操作
            Node node = stack.pollLast();
            out.add(node.val);
            if (node.children.isEmpty()) {
                continue;
            }
            // 考虑到栈是先入先出，所以反向入栈
            Collections.reverse(node.children);
            stack.addAll(node.children);
        }
        return out;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
