package leetcode;

public class PathSumIII_437 {
	
	private int res = 0;
	private int target = 0;

	public int pathSum(TreeNode root, int sum) {
		target = sum;
		traverse(root);
		return res;
	}

	private void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root, 0);
		traverse(root.left);
		traverse(root.right);
	}

	private void helper(TreeNode root, int sum) {
		if (root == null) return;
		if (sum + root.val== target) res++;
		helper(root.left, sum + root.val);
		helper(root.right, sum + root.val);
	}

}
