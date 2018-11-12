package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal_314 {

	private Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
	private int left = 0, right = 0;

	public List<List<Integer>> verticalOrder(TreeNode root) {
		if (root == null) return Collections.emptyList();
		init(root, 0);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
        for (int i = 0; i < right - left + 1; i++) {
            res.add(new ArrayList<>());
        }
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			res.get(map.get(cur) - left).add(cur.val);
			if (cur.left != null) queue.offer(cur.left);
			if (cur.right != null) queue.offer(cur.right);
		}
		return res;
	}

	private void init(TreeNode root, int col) {
		if (root == null) return;
		map.put(root, col);
		left = Math.min(left, col);
		right = Math.max(right, col);
		init(root.left, col - 1);
		init(root.right, col + 1);
	}
}
