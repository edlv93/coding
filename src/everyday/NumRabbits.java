package everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. 森林中的兔子
 */
public class NumRabbits {
    public int numRabbits(int[] answers) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            if (answer > 0) {
                int tmp = map.getOrDefault(answer, 0);
                if (tmp != 0) {
                    map.put(answer, tmp - 1);
                } else {
                    map.put(answer, answer);
                }
            }
            sum++;
        }
        for (int i : map.values()) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        new NumRabbits().numRabbits(new int[]{0,0,1,1,1});
    }
}
