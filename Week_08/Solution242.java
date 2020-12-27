public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] tmpArr = new int[26];
        for (char c: s.toCharArray()) {
            tmpArr[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            tmpArr[c - 'a']--;
            if (tmpArr[c - 'a'] < 0) {
                return false;
            }
        }
        for (int count: tmpArr) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }
}
