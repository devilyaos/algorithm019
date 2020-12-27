public class Solution190 {
    public int reverseBits1(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            res ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return res;
    }

    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution190().reverseBits2(43261596));
    }
}
