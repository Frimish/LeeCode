package leetcode;

public class BinaryTreeLongestConsecutiveSequence {
	private int res = 0;

	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return res;
		dfs(root, 0, root.val - 1);
		return res;
	}
	
	private void dfs(TreeNode root, int len, int preValue) {
		if (root == null) return; 
		len = preValue == root.val - 1 ? len + 1 : 1;
		res = Math.max(res, len);
		dfs(root.left, len, root.val);
		dfs(root.right, len, root.val);
	}
}
