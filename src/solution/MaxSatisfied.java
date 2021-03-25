package solution;

/**
 * 1052. 爱生气的书店老板
 */
public class MaxSatisfied {
//    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
//        int n = customers.length;
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            if (grumpy[i] == 0) {
//                result += customers[i];
//            }
//        }
//        int max = 0;
//        for (int i = 0; i < n - X + 1; i++) {
//            int tmp = 0;
//            for (int j = 0; j < X; j++) {
//                if (grumpy[i + j] == 1) {
//                    tmp += customers[i + j];
//                }
//            }
//            max = Math.max(result + tmp, max);
//        }
//        return max;
//    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += customers[i] * (1 - grumpy[i]);
        }
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < X; i++) {
            tmp += customers[i] * grumpy[i];
        }
        max = tmp;
        for (int i = X; i < n; i++) {
            tmp = tmp + customers[i] * grumpy[i] - customers[i - X] * grumpy[i - X];
            max = Math.max(tmp, max);
        }
        return result + max;
    }
}
