package leetcode;

public class BalancedBinaryTree_110 {
	private boolean result = true;

	public boolean isBalanced(TreeNode root) {
		findMaxDepth(root);
		return result;
	}

	private int findMaxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int rightDepth = findMaxDepth(root.right);
		int leftDepth = findMaxDepth(root.left);
		if (Math.abs(rightDepth - leftDepth) > 1)  result = false;
		return Math.max(rightDepth, leftDepth) + 1;
	}
}
