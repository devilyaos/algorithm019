public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }
        int[][] tmp = new int[n][m];
        tmp[n - 1][m - 1] = obstacleGrid[n - 1][m - 1] ^ 1;
        for (int a = n - 2; a >= 0; a--) {
            tmp[a][m - 1] = obstacleGrid[a][m - 1] == 1 || tmp[a + 1][m - 1] == 0 ? 0 : 1;
        }
        for (int b = m - 2; b >= 0; b--) {
            tmp[n - 1][b] = obstacleGrid[n - 1][b] == 1 || tmp[n - 1][b +  1] == 0 ? 0 : 1;
        }
        for (int a = n - 2; a >= 0; a--) {
            for (int b = m - 2; b >= 0; b--) {
                tmp[a][b] = obstacleGrid[a][b] == 1 ? 0 : tmp[a + 1][b] + tmp[a][b + 1];
            }
        }
        return tmp[0][0];
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0}, {1,1}, {0,0}};
        System.out.println(new Solution63().uniquePathsWithObstacles(arr));
    }
}
