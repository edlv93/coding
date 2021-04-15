package competition.w0411;

import java.util.Arrays;

/**
 * 1825. 求出 MK 平均值
 */
public class MKAverage {
    int   m;
    int   k;
    int   l;
    int[] nums;
    int   n;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.l = m - 2 * k;
        nums   = new int[m];
        n      = 0;
    }

    public void addElement(int num) {
        if (n < m) {
            nums[n++] = num;
        } else {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }
            nums[n - 1] = num;
        }
    }

    public int calculateMKAverage() {
        if (n < m) {
            return -1;
        } else {
            int[] sorted = Arrays.copyOf(nums, n);
            quickSort(sorted, 0 ,n-1);
            int sum = 0;
            for (int i = k; i < n - k; i++) {
                sum += sorted[i];
            }
            return sum / this.l;
        }
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int index = getIndex(nums, l, r);
            quickSort(nums, l, index - 1);
            quickSort(nums, index + 1, r);
        }
    }

    static int getIndex(int[] nums, int l, int r) {
        int x = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= x) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] < x) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = x;
        return l;
    }

    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);        // 当前元素为 [17612]
        obj.addElement(1);        // 当前元素为 [17612,74607]
        System.out.println(obj.calculateMKAverage());
        // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        obj.addElement(10);       // 当前元素为 [8272,17612,74607]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [17612,33433,74607]
        // 删除最小以及最大的 1 个元素后，容器为 [33433]
        // [33433] 的平均值等于 33433/1 = 33433 ，故返回 33433
        obj.addElement(5);        // 当前元素为 [15456,17612,33433,74607]
        obj.addElement(5);
        obj.addElement(5); // 当前元素为 [15456,17612,33433,64938,74607]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [33433,64938,74607]
        // 删除最小以及最大的 1 个元素后，容器为 [5]
        // [5] 的平均值等于 5/1 = 5 ，故返回
    }
}
