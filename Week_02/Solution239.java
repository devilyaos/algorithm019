import java.util.ArrayDeque;
import java.util.Deque;

public class Solution239 {
    /**
     * 滑动窗口最大值
     * 动态规划，构造左右数组，数组分为N段，防止左右的最大值影响左右数组结果
     * 构造左右数组，顺着窗口方向比较左右数组中的最大值，即为滑动窗口最大值
     *
     * @param nums 原始数组
     * @param k    元素数量
     * @return 结果
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        // left数组为max(left[i-1], nums[i])
        int[] left = new int[n];
        left[0] = nums[0];
        // right数组为max(right[j], nums[j+1])
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        int newSize = n - k + 1;
        int[] output = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }
        return output;
    }

    /**
     * 滑动窗口最大值
     * 双向队列
     *
     * @param a 数组
     * @param k 个数
     * @return 结果
     */
    public int[] maxSlidingWindow2(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution239().maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
