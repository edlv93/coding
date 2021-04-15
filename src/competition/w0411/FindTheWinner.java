package competition.w0411;

public class FindTheWinner {
    public int findTheWinner(int n, int k) {
        if (k == 1) {
            return 0;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int cur = -1;
        int last = n;
        while (last > 1) {
            for (int i = 0; i < k; i++) {
                cur++;
                if (cur == n) {
                    cur = 0;
                }
                while (nums[cur] == -1) {
                    cur++;
                    if (cur == n) {
                        cur = 0;
                    }
                }
            }
            nums[cur] = -1;
            last--;
        }
        for (int num : nums) {
            if (num != -1) {
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheWinner().findTheWinner(5, 3));
    }
}
