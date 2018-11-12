package leetcode;

public class LowestCommonAncestorofaBinarySearchTree_235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return root;
		return p.val < q.val ? helper(root, p, q) : helper(root, q, p);
	}

	private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		if (p.val <= root.val && root.val <= q.val) 
			return root;
		return (p.val > root.val) ? helper(root.right, p, q) : helper(root.left, p, q);
	}
}
