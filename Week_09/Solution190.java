public class Solution190 {
    public int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return result;
    }

    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }
}
