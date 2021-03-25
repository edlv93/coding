package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 659. 分割数组为连续子序列
 */
public class IsPossible {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        Map<Integer, Integer> end = new HashMap<>();
        for (int x : nums) {
            int xCount = count.getOrDefault(x, 0);
            if (xCount > 0) {
                int preCount = end.getOrDefault(x - 1, 0);
                if (preCount > 0) {
                    count.put(x, xCount - 1);
                    end.put(x - 1, preCount - 1);
                    end.put(x, end.getOrDefault(x, 0) + 1);
                } else {
                    int firstCount = count.getOrDefault(x + 1, 0);
                    int secondCount = count.getOrDefault(x + 2, 0);
                    if (firstCount > 0 && secondCount > 0) {
                        count.put(x, xCount - 1);
                        count.put(x + 1, firstCount - 1);
                        count.put(x + 2, secondCount - 1);
                        end.put(x + 2, end.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
