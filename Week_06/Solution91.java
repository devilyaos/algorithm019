public class Solution91 {
    public int numDecodings(String s) {
        if ("0".equals(s)) {
            return 0;
        }
        int prev = 1, curr = 1;
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i++) {
            int temp = curr;
            if (array[i] == '0') {
                if (array[i - 1] == '1' || array[i - 1] == '2') {
                    curr = prev;
                } else {
                    return 0;
                }
            } else if (array[i - 1] == '1' || (array[i - 1] == '2' && array[i] >= '1' && array[i] <= '6')) {
                curr += prev;
            }
            prev = temp;
        }
        return curr;
    }
}
