import java.util.*;

public class Solution429 {
    /**
     * N叉树的层序遍历
     * 利用队列，在左边添加，在右边消费，右边每消费一个节点，便将其的children-node添加到左边，考虑到读取的顺序，按children的顺序添加即可
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        queue.add(root);
        result.add(Collections.singletonList(root.val));
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            // 每次清空当前queue中内容，及该层全部内容
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);
            }
            result.add(list);
        }
        return result;
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
