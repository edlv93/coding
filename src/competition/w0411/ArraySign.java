package competition.w0411;

public class ArraySign {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                sign *= -1;
            }
        }
        return sign;
    }

    public static void main(String[] args) {
        System.out.println(new ArraySign().arraySign(new int[]{-1,1,-1,1,-1}));
    }
}
