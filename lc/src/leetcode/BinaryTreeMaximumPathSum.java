package leetcode;

public class BinaryTreeMaximumPathSum {
	private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxSubPathSum(root);
        return res;
    }

	private int maxSubPathSum(TreeNode root) {
		if (root == null) return 0;
		int left = Math.max(maxSubPathSum(root.left), 0);
		int right = Math.max(maxSubPathSum(root.right), 0);
		int val = left + right + root.val;
		res = Math.max(res, val);
		return Math.max(left, right) + root.val;
	}
}
