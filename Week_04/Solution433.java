import java.util.*;

public class Solution433 {
    public int minMutation(String start, String end, String[] bank) {
        // 比较bank中是否有与start仅差一位的数，如果有，则将start变为该值，并继续遍历
        // 否则直接返回
        String tmp = start;
        int count = 0;
        for (int i = 0; i < bank.length;) {
            if (bank[i].isEmpty()) {
                i++;
                continue;
            }
            char[] bankArr = bank[i].toCharArray();
            char[] startArr = tmp.toCharArray();
            if (!checkDiff(bankArr, startArr)) {
                return -1;
            }
            if (!bank[i].isEmpty() && !tmp.equals(bank[i])) {
                tmp = bank[i];
                bank[i] = "";
                count++;
                i = 0;
            } else {
                i++;
            }
        }
        if (!tmp.equals(end)) {
            return -1;
        }
        return count;
    }

    private boolean checkDiff(char[] arr1, char[] arr2) {
        // 考虑到位数相等为8
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (arr1[i] != arr2[i]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution433().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }
}