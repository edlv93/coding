package solution;


/**
 * 867. 转置矩阵
 */
public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res[][] = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Transpose transpose = new Transpose();
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        transpose.transpose(a);
    }
}
