package solution;

import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 */
public class BSTIterator {
    private TreeNode        cur;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur   = root;
        stack = new Stack<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }

    public boolean hasNext() {
        return cur != null || !stack.empty();
    }

}
