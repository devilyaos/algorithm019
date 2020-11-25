import java.util.Arrays;

public class Solution1370 {
    public String sortString(String s) {
        char[] charArr = s.toCharArray();
        int[] tmpArr = new int[26];
        for (char c: charArr) {
            tmpArr[c - 'a'] += 1;
        }
        int total = charArr.length;
        // 实验证明，StringBuilder比直接用char数组初始化string要慢
        StringBuilder sb = new StringBuilder();
        while(total > 0) {
            for (int i = 0; i < 26; i++) {
                if (tmpArr[i] > 0) {
                    sb.append((char) (i + 'a'));
                    tmpArr[i]--;
                    total--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (tmpArr[i] > 0) {
                    sb.append((char) (i + 'a'));
                    tmpArr[i]--;
                    total--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1370().sortString("aaaabbbbcccc"));
    }
}
