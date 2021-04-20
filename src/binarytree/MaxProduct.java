package binarytree;

import common.TreeNode;

/**
 * 1339. 分裂二叉树的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/
 */
public class MaxProduct {
    long ans;
    int  sum;
    int  MOD = (int) 1e9 + 7;

    public int maxProduct(TreeNode root) {
        ans = Long.MIN_VALUE;
        sum = sumTree(root);
        nodeStack(root);
        return (int) (ans % MOD);
    }

    private long nodeStack(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long split = root.val + nodeStack(root.left) + nodeStack(root.right);
        ans = Math.max(ans, (sum - split) * split);
        return split;
    }

    private int sumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumTree(root.left) + sumTree(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new MaxProduct().MOD);
    }
}
