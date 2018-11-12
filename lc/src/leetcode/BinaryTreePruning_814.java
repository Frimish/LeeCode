package leetcode;

public class BinaryTreePruning_814 {

	public TreeNode pruneTree(TreeNode root) {
		if (root == null)
			return null;
		dfs(root);
		return root;
	}

	private int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		if (left == 0) {
			root.left = null;
		}
		if (right == 0) {
			root.right = null;
		}
		return left + right + root.val;
	}
}
