package solution;

import java.util.TreeMap;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 *
 * 滑块思想，左右指针移动
 * TreeMap，有序哈希表，基于红黑树实现
 *
 */
public class LongestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0, res = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
