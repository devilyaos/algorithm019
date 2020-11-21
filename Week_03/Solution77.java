import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n < k) {
            return result;
        }
        // 减少资源占用
        Deque<Integer> path = new LinkedList<>();
        dfs(n, k, 1, path, result);
        return result;
    }

    private void dfs(int n, int k, int start, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (Integer i = start; i <= n; i ++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, result);
            path.removeLast();
        }
    }

}
