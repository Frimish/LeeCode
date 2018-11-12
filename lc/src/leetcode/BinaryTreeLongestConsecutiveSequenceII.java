package leetcode;

public class BinaryTreeLongestConsecutiveSequenceII {
	private int res = 0;
	public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

	private int[] dfs(TreeNode root) {
		if (root == null) return new int[] {0, 0};
		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		int[] rot = new int[]{1, 1};
		if (root.left != null) {
			if (root.val == root.left.val + 1) {
				rot[0] = left[0] + 1;
			}
			if (root.val == root.left.val - 1) {
				rot[1] = left[1] + 1;
			}
		} 
		
		if (root.right != null) {
			if (root.val == root.right.val + 1) {
				rot[0] = Math.max(rot[0], right[0] + 1);
			}
			
			if (root.val == root.right.val - 1) {
				rot[1] = Math.max(rot[1], right[1] + 1);
			}
		}
		
		res = Math.max(res, rot[0] + rot[1] - 1);
		return rot;
	}
}
