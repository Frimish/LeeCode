package leetcode;

public class MaximumDepthOfBinaryTree_104 {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return findMinDepth(root);

	}

	private int findMinDepth(TreeNode root) {
		if (root.left == null && root.right == null)
			return 1;
		if (root.left == null)
			return findMinDepth(root.right);
		if (root.right == null)
			return findMinDepth(root.left);
		return Math.max(findMinDepth(root.right), findMinDepth(root.left)) + 1;
	}
}
