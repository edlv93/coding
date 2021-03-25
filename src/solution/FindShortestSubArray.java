package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 */
public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        int d = 0;
        int n = nums.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        for (int[] value : map.values()) {
            if (value[0] > d) {
                d = value[0];
                n = value[2] - value[1] + 1;
            } else if (value[0] == d) {
                n = Math.min(n, value[2] - value[1] + 1);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        FindShortestSubArray findShortestSubArray = new FindShortestSubArray();
        System.out.println(findShortestSubArray.findShortestSubArray(nums));
    }
}
