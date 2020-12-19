import java.util.HashMap;
import java.util.Map;

public class Solution389 {
    public char findTheDifference(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int total1 = 0;
        int total2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            total1 += arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            total2 += arr2[i];
        }
        return (char) (total2 - total1);
    }
}
