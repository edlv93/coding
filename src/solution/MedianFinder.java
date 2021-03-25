package solution;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MedianFinder {

    private List<Integer> data;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        data = new LinkedList<>();
    }

    public void addNum(int num) {
        if (data.size() == 0) {
            data.add(num);
        } else {
            int i;
            for (i = 0; i < data.size(); i++) {
                if (data.get(i) > num) {
                    break;
                }
            }
            if (i == data.size()) {
                data.add(num);
            } else {
                data.add(data.get(data.size() - 1));
                for (int j = data.size() - 1; j > i; j--) {
                    data.set(j, data.get(j - 1));
                }
                data.set(i, num);
            }
        }
    }

    public double findMedian() {
        if (data.size() % 2 == 0) {
            int i = data.size() / 2;
            return (data.get(i) + data.get(i - 1)) / 2.0;
        } else {
            return data.get(data.size() / 2);
        }
    }
}
