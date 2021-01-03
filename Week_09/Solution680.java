public class Solution680 {
    // DP
    // 双指针，最多删除一次，即遇到的第一个不匹配直接跳过，并记录状态位
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        boolean canJump = true;
        while (left <= right) {
            if (!canUse(s.charAt(left))) {
                left++;
            } else if (!canUse(s.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else if (canJump) {
                if (Character.toLowerCase(s.charAt(left + 1)) == Character.toLowerCase(s.charAt(right))) {
                    left += 2;
                    right--;
                } else if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right - 1))) {
                    left++;
                    right -= 2;
                } else {
                    return false;
                }
                canJump = false;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean canUse(char letter) {
        return (letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z') || (letter >= '0' && letter <= '9');
    }

    public static void main(String[] args) {
        System.out.println(new Solution680().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
