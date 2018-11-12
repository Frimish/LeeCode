package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		List<List<Integer>> res = new ArrayList<>();
		boolean isLeft = false;
		if (root == null)
			return res;
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> tmp = new ArrayList<Integer>();

			for (int i = 0; i < size; i++) {
				TreeNode treeNode = q.poll();
				if (isLeft) {
					tmp.add(treeNode.val);
				} else {
					stack.push(treeNode);
				}

				if (treeNode.right != null) {
					q.offer(treeNode.right);
				}
				if (treeNode.left != null) {
					q.offer(treeNode.left);
				}

			}
			
			while (!stack.isEmpty()) {
				tmp.add(stack.pop().val);
			}
			
			isLeft = !isLeft;
			res.add(tmp);
		}

		return res;
	}
}
