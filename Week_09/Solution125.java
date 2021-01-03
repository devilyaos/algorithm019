public class Solution125 {
    // 可以用DP
    // 也可以用双指针夹逼
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (!isLetter(s.charAt(left))) {
                left++;
            } else if (!isLetter(s.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isLetter(char letter) {
        return (letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z') || (letter >= '0' && letter <= '9');
    }

    public static void main(String[] args) {
//        System.out.println(new Solution125().isPalindrome("aba"));
//        System.out.println(new Solution125().isPalindrome("abba"));
//        System.out.println(new Solution125().isPalindrome("abbca"));
//        System.out.println(new Solution125().isPalindrome("abb,a"));
        System.out.println(new Solution125().isPalindrome("OP"));
    }
}
