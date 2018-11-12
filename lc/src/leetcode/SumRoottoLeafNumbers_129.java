package leetcode;

public class SumRoottoLeafNumbers_129 {
	private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return sum;
    }

	private void dfs(TreeNode root, int tmp) {
		if (root.left == null && root.right == null) {
			sum += tmp * 10 + root.val;
			return;
		}
		if (root.left != null) dfs(root.left, tmp * 10 + root.val);
		if (root.right != null) dfs(root.right, tmp * 10 + root.val);
	}
    
    
}
