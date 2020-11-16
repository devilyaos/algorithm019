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

    /**
     * 爬楼梯，用斐波拉契数列通项公式求解
     *
     * @param n 台阶数
     * @return 结果
     */
    public int climbStairs2(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2, n + 1);
        return (int) (fib_n / sqrt_5);
    }
}
