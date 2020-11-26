import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int a = 0, b = 0;
        while(a < g.length && b < s.length) {
            if (g[a] <= s[b++]) {
                a++;
            }
        }
        return a;
    }
}
