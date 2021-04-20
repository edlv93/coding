package solution;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 *
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 *
 * 优先队列 / 堆
 */
public class MedianFinder {

    Queue<Integer> left, right;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        left  = new PriorityQueue<>();
        right = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (left.size() != right.size()) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if (left.isEmpty()) {
            return 0;
        }
        return left.size() != right.size() ? left.peek() : (left.peek() + right.peek()) / 2.0;
    }
}
