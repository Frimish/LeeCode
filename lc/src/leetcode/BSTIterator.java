package leetcode;

import java.util.Stack;

public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        addLeftBranch(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode tmp = stack.pop();
        if (tmp.right != null) 
        	addLeftBranch(tmp.right);
        return tmp.val;
    }
    
    private void addLeftBranch(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
			
	}
}
