package leetcode;

public class InvertBinaryTree_226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		TreeNode res = new TreeNode(root.val);
		helper(root, res);
		return res;
	}

	private void helper(TreeNode root1, TreeNode root2) {
		if (root1 == null) return;
		if (root1.left != null) {
			root2.right = new TreeNode(root1.left.val);
			helper(root1.left, root2.right);
		}
		
		if (root1.right != null) {
			root2.left = new TreeNode(root1.right.val);
			helper(root1.right, root2.left);
		}
	}

}
