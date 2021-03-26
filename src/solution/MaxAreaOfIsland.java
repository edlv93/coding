package solution;

/**
 * 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, dfs(grid, r, c));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2; // 将格子标记为「已遍历过」

        return 1
               + dfs(grid, r - 1, c)
               + dfs(grid, r + 1, c)
               + dfs(grid, r, c - 1)
               + dfs(grid, r, c + 1);
    }

    public boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
