public class Solution387 {
    public int firstUniqChar(String s) {
        int[] letterCountArr = new int[26];
        char[] letterArr = s.toCharArray();
        for (char c: letterArr) {
            letterCountArr[c - 'a']++;
        }
        for (int i = 0; i < letterArr.length; i++) {
            if (letterCountArr[letterArr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
