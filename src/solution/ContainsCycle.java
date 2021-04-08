package solution;

/**
 * 1559. 二维网格图中探测环
 */
public class ContainsCycle {
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (visited[r][c]) {
                    continue;
                }
                boolean res = dfs(grid, r, c, grid[r][c], visited, 0);
//                System.out.println(1);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, int r, int c, char key, boolean[][] visited, int flag) {
        if (!inArea(grid, r, c)) {
            return false;
        }
        // 如果这个格子不是相同的值，直接返回
        if (grid[r][c] != key) {
            return false;
        }
        if (visited[r][c]) {
            return true;
        }
        visited[r][c] = true; // 将格子标记为「已遍历过」
        if (flag == 0) {
            return dfs(grid, r - 1, c, key, visited, 1)
                   || dfs(grid, r + 1, c, key, visited, 3)
                   || dfs(grid, r, c - 1, key, visited, 4)
                   || dfs(grid, r, c + 1, key, visited, 2);
        } else if (flag == 1) {
            return dfs(grid, r - 1, c, key, visited, 1)
                   || dfs(grid, r, c - 1, key, visited, 4)
                   || dfs(grid, r, c + 1, key, visited, 2);
        } else if (flag == 2) {
            return dfs(grid, r - 1, c, key, visited, 1)
                   || dfs(grid, r + 1, c, key, visited, 3)
                   || dfs(grid, r, c + 1, key, visited, 2);
        } else if (flag == 3) {
            return dfs(grid, r + 1, c, key, visited, 3)
                   || dfs(grid, r, c - 1, key, visited, 4)
                   || dfs(grid, r, c + 1, key, visited, 2);
        } else {
            return dfs(grid, r - 1, c, key, visited, 1)
                   || dfs(grid, r + 1, c, key, visited, 3)
                   || dfs(grid, r, c - 1, key, visited, 4);
        }

    }

    public boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }

    public static void main(String[] args) {
        new ContainsCycle().containsCycle(
                new char[][]{{'b', 'a', 'c'},
                             {'c', 'a', 'c'},
                             {'d', 'd', 'c'},
                             {'b', 'c', 'c'}});
    }
}
