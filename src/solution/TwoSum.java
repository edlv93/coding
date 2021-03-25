package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{i, result.get(target - nums[i])};
            } else {
                result.put(nums[i], i);
            }
        }
        return null;
    }

    public String toString(int[] sum) {
        return "[" + sum[0] + "," + sum[1] + "]";
    }

    public static void main(String[] args) {
        System.out.println(-2/4);
//        int[] nums = {3,2,4};
//        int target = 6;
//        TwoSum twoSum = new TwoSum();
//
//        System.out.println(twoSum.toString(twoSum.twoSum(nums, target)));
    }
}
