import java.util.*;

public class Solution347 {
    /**
     * 找出高频的前n个数
     * 1. 小根堆
     *
     * @param nums 数组
     * @param k    数值
     * @return 结果
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num: nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            heap.offer(new int[] {entry.getKey(), entry.getValue()});
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[0];
        }
        return result;
    }

    /**
     * 找出高频的前n个数
     * 2. 桶排序
     *
     * @param nums 数组
     * @param k    数值
     * @return 结果
     */
    public int[] topKFrequent2(int[] nums, int k) {
        if (k == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num: nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        // 因为频率最大可以等于长度，所以此处要+1
        List<Integer>[] list = new List[nums.length + 1];
        for (int key: map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = list.length - 1; i >= 0 && index < k; i--) {
            if (list[i] == null) {
                continue;
            }
            for (Integer num: list[i]) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution347().topKFrequent2(new int[] {1,1,1,2,2,3}, 2));
    }
}
