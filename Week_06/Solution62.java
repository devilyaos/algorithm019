import java.util.Arrays;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] tmp = new int[n][m];
        for (int a = 0; a < n; a++) {
            tmp[a][m - 1] = 1;
        }
        for (int b = 0; b < m; b++) {
            tmp[n - 1][b] = 1;
        }
        for (int a = n - 2; a >= 0; a--) {
            for (int b = m - 2; b >= 0; b--) {
                tmp[a][b] = tmp[a][b + 1] + tmp[a + 1][b];
            }
        }
        return tmp[0][0];
    }

    public int uniquePaths3(int m, int n) {
        int[] curr = new int[n];
        Arrays.fill(curr, 1);
        for (int a = 1; a < m; a++) {
            for (int b = 1; b < n; b++) {
                curr[b] += curr[b - 1];
            }
        }
        return curr[n - 1];
    }

    public int uniquePaths2(int m, int n) {
        long ans=1;
        System.out.println("Math.min(m-1,n-1) = " + Math.min(m-1,n-1));
        for(int i=0;i<Math.min(m-1,n-1);i++){
            System.out.println("=========================================");
            System.out.println("i => " + i);
            ans*=m+n-2-i;
            System.out.println("ans*=m+n-2-i => " + ans);
            ans/=i+1;
            System.out.println("ans/=i+1 => " + ans);
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution62().uniquePaths2(7, 3));
    }
}
