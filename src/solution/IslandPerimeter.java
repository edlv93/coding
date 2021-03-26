package solution;

/**
 * 695. 岛屿的最大面积
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2; // 将格子标记为「已遍历过」

        return dfs(grid, r - 1, c)
               + dfs(grid, r + 1, c)
               + dfs(grid, r, c - 1)
               + dfs(grid, r, c + 1);
    }

    public boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
