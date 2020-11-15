public class SolutionJz49 {
    /**
     * 丑数
     * 1. 暴力穷举，顺序遍历正整数，直到出现n个丑数
     * 2. 暴力穷举丑数，直到n个丑数
     * 3. 题解目标可以看做某较小丑数 * 某系数
     *
     * @param n 位数
     * @return 第n个丑数
     */
    public int nthUglyNumber(int n) {
        if (n > 1690) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        int[] result = new int[n];
        result[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int dp2 = result[a] * 2, dp3 = result[b] * 3, dp5 = result[c] * 5;
            result[i] = Math.min(Math.min(dp2, dp3), dp5);
            if (result[i] == dp2) {
                a++;
            }
            if (result[i] == dp3) {
                b++;
            }
            if (result[i] == dp5) {
                c++;
            }
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new SolutionJz49().nthUglyNumber(10));
    }
}
