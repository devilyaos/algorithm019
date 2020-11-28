// 此处实现了DFS的实现，BFS实现其实大体的思路一致，只是将向下遍历，改为将每一个节点的周围一圈为E的节点放入队列
// 此处没有对节点变化进行更进一步的封装，仅表达实现方式
public class Solution529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        char clickVal = board[click[0]][click[1]];
        // 处理已点击的方块
        if (clickOnTapped(clickVal)) {
            return board;
        }
        // 处理踩雷
        if (clickVal == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        // 处理其他未点击方块、
        _tap(board, board[0].length, board.length,click[0], click[1]);
        return board;
    }

    private void _tap(char[][] board, int width, int height, int x, int y) {
        if (!isPointValid(x, y, width, height)) {
            return;
        }
        if (clickOnTapped(board[x][y])) {
            return;
        }
        // 先判断周围一圈是否有地雷
        char count = '0';
        count += checkMineNum(board, width, height, x + 1, y);
        count += checkMineNum(board, width, height, x + 1, y + 1);
        count += checkMineNum(board, width, height, x, y + 1);
        count += checkMineNum(board, width, height, x - 1, y + 1);
        count += checkMineNum(board, width, height, x - 1, y);
        count += checkMineNum(board, width, height, x - 1, y - 1);
        count += checkMineNum(board, width, height, x, y - 1);
        count += checkMineNum(board, width, height, x + 1, y - 1);
        if (count > '0') {
            board[x][y] = count;
            return;
        }
        board[x][y] = 'B';
        // 向周围扩散
        _tap(board,width, height, x + 1, y);
        _tap(board,width, height, x + 1, y + 1);
        _tap(board,width, height, x, y + 1);
        _tap(board,width, height, x - 1, y + 1);
        _tap(board,width, height, x - 1, y);
        _tap(board,width, height, x - 1, y - 1);
        _tap(board,width, height, x, y - 1);
        _tap(board,width, height, x + 1, y - 1);
    }

    private boolean isPointValid(int x, int y, int width, int height) {
        return x < height && y < width && x >= 0 && y >= 0;
    }

    private int checkMineNum(char[][] board, int width, int height, int x, int y) {
        return isPointValid(x, y, width, height) && board[x][y] == 'M' ? 1 : 0;
    }

    private boolean clickOnTapped(char clickVal) {
        if (clickVal == 'X') {
            return true;
        }
        if (clickVal == 'B') {
            return true;
        }
        if (clickVal >= '1' && clickVal <= '8') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = new int[]{3,0};
        System.out.println(new Solution529().updateBoard(arr, click));
        System.out.println(1);
    }
}
