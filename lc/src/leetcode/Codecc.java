package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codecc {
	
	private String spliter = ",";
	private String none = "X";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(none);
			return;
		}
		sb.append(root.val);
		buildString(root.left, sb);
		buildString(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(spliter)));
		return buildTree(nodes);
	}

	private TreeNode buildTree(Queue<String> nodes) {
		String node = nodes.poll();
		if (none.equals(node)) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(node));
		root.left = buildTree(nodes);
		root.right = buildTree(nodes);
		return root;
	}
	
	

}
