public class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int width = grid[0].length;
        int height = grid.length;
        int count = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[j][i] == '1') {
                    count++;
                    _dealData(grid, width, height, i, j);
                }
            }
        }
        return count;
    }

    private void _dealData(char[][] grid, int width, int height, int x, int y) {
        if (x >= width || y >= height || x < 0 || y < 0 || grid[y][x] == '0') {
            return;
        }
        grid[y][x] = '0';
        _dealData(grid, width, height, x + 1, y);
        _dealData(grid, width, height, x - 1, y);
        _dealData(grid, width, height, x, y +  1);
        _dealData(grid, width, height, x, y -  1);
    }
}
