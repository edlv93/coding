package solution;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int n = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > n) {
                n = map.get(s.charAt(i));
            } else {
                max = Math.max(max, i-n);
            }
            map.put(s.charAt(i), i);

        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters s =
                new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstring(" "));
    }
}
