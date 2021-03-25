package solution;

public class IsMonotonic {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        for (int i = 0; i < A.length - 2; i += 2) {
            if (((A[i] >= A[i + 1]) && (A[i + 1] < A[i + 2])) || ((A[i] <= A[i + 1]) && (A[i + 1]
                                                                                          > A[i
                                                                                               + 2]))) {
                return false;
            }
        }
        return true;
    }
}
