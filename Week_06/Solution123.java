public class Solution123 {
    public int maxProfitDP(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[][][] dp = new int[prices.length][2][3];
        //因为最小值再减去1就是最大值Integer.MIN_VALUE-1=Integer.MAX_VALUE
        int MIN_VALUE = Integer.MIN_VALUE / 2;
        //初始化
        //第一天休息
        dp[0][0][0] = 0;
        //不可能
        dp[0][0][1] = dp[0][1][1] = MIN_VALUE;
        //不可能
        dp[0][0][2] = dp[0][1][2] = MIN_VALUE;
        //买股票
        dp[0][1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            dp[i][1][2] = MIN_VALUE;
        }
        return Math.max(0, Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));
    }
}
