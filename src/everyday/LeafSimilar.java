package everyday;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        dfs(root1, leaf1);
        List<Integer> leaf2 = new ArrayList<>();
        dfs(root2, leaf2);
        if (leaf1.size() != leaf2.size()) {
            return false;
        }
        for (int i = 0; i < leaf1.size(); i++) {
            if (leaf1.get(i).intValue() != leaf2.get(i).intValue()) {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> leaf) {
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
        }
        if (null != root.left) {
            dfs(root.left, leaf);
        }
        if (null != root.right) {
            dfs(root.right, leaf);
        }
    }
}
