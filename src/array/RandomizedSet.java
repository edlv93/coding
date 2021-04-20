package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * 380. 常数时间插入、删除和获取随机元素
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 *
 * 1、java中插入时间复杂度为o(1)的hashMap和ArrayList
 * 2、随机返回一个数时需要用到下标，hashMap不满足
 * 3、ArrayList满足插入和随机访问时o(1)
 * 4、删除满足o(1)的方案：
 *  ①将待删除的元素和最后一个元素交换
 *  ②删除最后一个元素
 * 5、因为需要知道待删除元素的位置，增加一个hashMap来存储元素在数组里的索引
 *
 */
public class RandomizedSet {

    List<Integer>         nums;
    Map<Integer, Integer> position;
    Random                rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nums     = new ArrayList<>();
        position = new HashMap<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified
     * element.
     */
    public boolean insert(int val) {
        if (position.containsKey(val)) {
            return false;
        }
        int n = nums.size();
        position.put(val, n);
        nums.add(n, val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!position.containsKey(val)) {
            return false;
        }
        int lastIndex = nums.size() - 1;
        int last = nums.get(lastIndex);
        int index = position.get(val);
        nums.set(index, last);
        position.put(last, index);
        nums.remove(lastIndex);
        position.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
