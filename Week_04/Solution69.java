public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        long a = 1;
        long b = x / 2;
        while (a < b) {
            long mid = (a + b + 1) >>> 1;
            if (mid * mid > x) {
                b = mid - 1;
            } else {
                a = mid;
            }
        }
        return (int) a;
    }
}
