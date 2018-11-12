package leetcode;

public class LowestCommonAncestorofBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == root || q == root)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.left, p, q);
		if (left != null && right != null)
			return root;
		return left == null ? right : left;

	}
}
