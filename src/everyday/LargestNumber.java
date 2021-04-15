package everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 179. 最大数
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        List<String> keys = new ArrayList<>();
        for (int num : nums) {
            keys.add(String.valueOf(num));
        }
        keys.sort((a, b) -> (b + a).compareTo(a + b));
        StringBuilder ans = new StringBuilder();
        for (String key : keys) {
            ans.append(key);
        }
        String tmp = ans.toString();
        if (tmp.charAt(0) == '0') {
            return "0";
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new LargestNumber().largestNumber(new int[]{34323, 3432}));
        System.out.println(new LargestNumber().largestNumber(new int[]{8308, 8308, 830}));
    }
}
