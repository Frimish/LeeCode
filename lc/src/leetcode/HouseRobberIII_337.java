package leetcode;

public class HouseRobberIII_337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

	private int[] dfs(TreeNode root) {
		if (root == null) return new int[] {0, 0};
		int[] res = new int[2];
		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		res[0] = Math.max(left[0],  left[1]) + Math.max(right[0], right[1]);
		res[1] = left[0] + right[0] + root.val;
		return res;
	}
    
    
}
