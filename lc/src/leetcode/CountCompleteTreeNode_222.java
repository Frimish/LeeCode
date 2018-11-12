package leetcode;

public class CountCompleteTreeNode_222 {
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int leftH = 0;
		TreeNode left = root;
		while (left != null) {
			leftH++;
			left = left.left;
		}
		int rightH = 0;
		TreeNode right = root;
		while (right != null) {
			rightH++;
			right = right.right;
		}
		if (leftH == rightH)
			return (1 << leftH) - 1;
		return countNodes(root.left) + countNodes(root.right) + 1; 
	}
}