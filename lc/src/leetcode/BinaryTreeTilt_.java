package leetcode;

public class BinaryTreeTilt_ {
	private int res = 0;

	public int findTilt(TreeNode root) {
		if (root == null)
			return res;
		dfs(root);
		return res;
	}

	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		int tilt = Math.abs(left - right);
		res += tilt;
		return left + right + root.val;
	}
}
