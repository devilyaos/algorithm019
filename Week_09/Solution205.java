import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    public boolean isIsomorphic2(String s, String t) {
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        int len = s.length();
        char a;
        char b;
        for (int i = 0; i < len; i++) {
            if (arr1[s.charAt(i)] != arr2[t.charAt(i)]) {
                return false;
            }
            arr1[s.charAt(i)] += 1;
            arr2[t.charAt(i)] += 1;
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        Map<String, Character> map = new HashMap<>();
        int len = s.length();
        String tmpKeyS;
        String tmpKeyT;
        for (int i = 0 ; i < len; i++) {
            tmpKeyS = "s" + s.charAt(i);
            tmpKeyT = "t" + t.charAt(i);
            if (!map.containsKey(tmpKeyS)) {
                map.put(tmpKeyS, t.charAt(i));
            } else if (map.get(tmpKeyS) != t.charAt(i)) {
                return false;
            }
            if (!map.containsKey(tmpKeyT)) {
                map.put(tmpKeyT, s.charAt(i));
            } else if (map.get(tmpKeyT) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
