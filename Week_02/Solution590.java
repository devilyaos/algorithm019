import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution590 {
    /**
     * N叉树后序遍历
     *
     * @param root 根节点
     * @return 遍历数组
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> out = new LinkedList<>();

        if (root == null) {
            return out;
        }

        // 后序遍历左右根
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            out.addFirst(node.val);
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
