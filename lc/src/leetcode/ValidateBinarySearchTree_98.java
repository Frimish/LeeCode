package leetcode;

public class ValidateBinarySearchTree_98 {

	public boolean isValidBST(TreeNode root) {
		long l = Long.valueOf(Integer.MIN_VALUE) - 1L;
		long r = Long.valueOf(Integer.MAX_VALUE) + 1L;

		return isValidBST(root, l, r);
	}

	private boolean isValidBST(TreeNode root, long l, long r) {
		if (root == null)
			return true;
		return (root.val > l) && (root.val < r) && isValidBST(root.right, root.val, r)
				&& isValidBST(root.left, l, root.val);
	}
}
