package bytedance;


/**
 * 79. 单词搜索
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();

        //step1: 判断字符出现频率（数量）
        int[] freq1 = new int[255];
        int[] freq2 = new int[255];
        for (char c : words) {
            freq1[c]++;
        }
        for (char[] chars : board) {
            for (char aChar : chars) {
                freq2[aChar]++;
            }
        }
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] > freq2[i]) {
                return false;
            }
        }

        //step2: 回溯判断是否存在（顺序）
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == words[0]) {
                    if (backtrack(board, new boolean[m][n], words, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    boolean backtrack(char[][] board, boolean[][] visited, char[] words, int index, int r, int c) {
        if (index == words.length) {
            return true;
        }
        if (0 > r || r >= board.length || 0 > c || c >= board[0].length) {
            return false;
        }
        if (visited[r][c]) {
            return false;
        }
        if (board[r][c] != words[index]) {
            return false;
        }
        visited[r][c] = true;
        boolean result = false;
        for (int[] select : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            int i = select[0] + r;
            int j = select[1] + c;
            if (backtrack(board, visited, words, index + 1, i, j)) {
                result = true;
                break;
            }
        }
        visited[r][c] = false;
        return result;

    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'E', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        System.out.println(new Exist().exist(board, "ABCCED"));
        System.out.println(new Exist().exist(board, "SEE"));
        System.out.println(new Exist().exist(board, "ABCESEEEFS"));
    }
}
