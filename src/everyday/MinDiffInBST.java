package everyday;

import common.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 * <p>
 * 二叉搜索树中序遍历得到的值序列是递增有序的
 * 对升序数组求任意两个元素之差的最小值->相邻两个元素之差的最小值
 */
public class MinDiffInBST {
    int pre;
    int ans;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}
