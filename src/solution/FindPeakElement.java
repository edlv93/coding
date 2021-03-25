package solution;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1 || nums[1] < nums[0]) {
            return 0;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] &&nums[i]>nums[i+1]){
                return i;
            }
        }
        return nums.length - 1;
    }
}
