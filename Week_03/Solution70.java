public class Solution70 {
    /**
     * 爬楼梯
     * 动态规划, 且缓存过程值, 考虑到运算过程中实际只需要三个值，所以可以复用三个对象
     *
     * @param n N阶台阶
     * @return 多少种方法
     */
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int a = 1, b = 2, c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
