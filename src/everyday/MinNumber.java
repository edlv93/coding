package everyday;

public class MinNumber {
    public String minNumber(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int index = getIndex(nums, l, r);
            quickSort(nums, l, index - 1);
            quickSort(nums, index + 1, r);
        }
    }

    private int getIndex(int[] nums, int l, int r) {
        int x = nums[l];
        while (l < r) {
            while (l < r && judge(nums[r], x) >= 0) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && judge(nums[l], x) < 0) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = x;
        return l;
    }

    private int judge(int a, int b) {
        return (a + "" + b).compareTo(b + "" + a);
    }

    public static void main(String[] args) {
        new MinNumber().minNumber(new int[]{1,2,3,1});
    }
}
