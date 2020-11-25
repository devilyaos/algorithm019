public class Solution122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int begin = -1;
        for(int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                begin = i;
                break;
            }
        }
        if (begin < 0) {
            return 0;
        }
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }
}
