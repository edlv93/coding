package solution;


/**
 * 832. 翻转图像
 */
public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int n = A[i].length;
            for (int j = 0; j < n / 2; j++) {
                int tmp = 1 - A[i][j];
                A[i][j]         = 1 - A[i][n - 1 - j];
                A[i][n - 1 - j] = tmp;

            }
            if (n % 2 != 0) {
                A[i][n / 2] = 1 - A[i][n / 2];
            }
        }
        return A;
    }
}
