package leetcode;

public class SymmetricTree_101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return validate(root.left, root.right);

	}

	private boolean validate(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		return validate(left.right, right.left) && validate(left.left, right.right);
	}
}
