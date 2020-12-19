public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int idx = c - '0' - 1;
                if (row[i][idx] == 1 || col[j][idx] == 1 || box[j / 3 + (i / 3) * 3][idx] == 1) {
                    return false;
                }
                row[i][idx] = 1;
                col[j][idx] = 1;
                box[j / 3 + (i / 3) * 3][idx] = 1;
            }
        }
        return true;
    }
}
