package solution;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merge = new ArrayList<>();
        int n = (nums1.length + nums2.length) / 2 + 1;
        boolean flag = (nums1.length + nums2.length) % 2 == 0;
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (setMergeList(nums1, nums2, merge, n, flag, i, j, k)) {
                break;
            }
            if (setMergeList(nums2, nums1, merge, n, flag, j, i, k)) {
                break;
            }
            if (nums1[i] < nums2[j]) {
                if (flag && k == n - 2) {
                    merge.add(nums1[i]);
                }
                if (k == n - 1) {
                    merge.add(nums1[i]);
                }
                i += 1;
            } else {
                if (flag && k == n - 2) {
                    merge.add(nums2[j]);
                }
                if (k == n - 1) {
                    merge.add(nums2[j]);
                }
                j += 1;
            }
        }
        if (flag) {
            return (merge.get(0) + merge.get(1)) / 2.0;
        }
        return (double)merge.get(0);
    }

    public boolean setMergeList(int[] nums1, int[] nums2, List<Integer> merge, int n, boolean flag,
                                int i, int j, int k) {
        if (i == nums1.length && j != nums2.length) {
            if (flag && merge.size() == 0) {
                merge.add(nums2[j + n - k - 2]);
            }
            merge.add(nums2[j + n - k - 1]);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
