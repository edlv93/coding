package solution;

import java.util.HashMap;
import java.util.Map;

public class NumArray {
    Map<Integer, Integer> sum = new HashMap<>();

    public NumArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            sum.put(i, sum.getOrDefault(i - 1, 0) + nums[i]);
        }
    }

    public int sumRange(int i, int j) {
        return sum.get(j) - sum.get(i);
    }
}
