package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 * 40. 组合总和 II
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < candidates.length; i++) {
            map.put(candidates[i], map.getOrDefault(candidates[i], 0) + 1);
            set.add(candidates[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int key : set) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(key);
            if (judge() != null) {
                res.add(tmp);
            }
        }
        return res;
    }

    private List<Integer> judge() {
        return null;
    }
}
