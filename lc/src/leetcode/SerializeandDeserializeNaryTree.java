package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeNaryTree {
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	String spliter = ",";
	String none = "null";

	// Encodes a tree to a single string.
	public String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		System.out.println(sb.toString());
		return sb.toString();
	}

	private void buildString(Node root, StringBuilder sb) {
		if (root == null) {
			sb.append(none).append(spliter);
			return;
		}
		sb.append(root.val).append(spliter);
		if (root.children != null) {
			sb.append(root.children.size()).append(spliter);
			for (Node child : root.children) {
				buildString(child, sb);
			}
		} else {
			sb.append(0).append(spliter);
		}
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split(spliter)));
		System.out.println(Arrays.asList(data.split(spliter)));
		return buildTree(queue);
	}

	private Node buildTree(Queue<String> queue) {
		String cur = queue.poll();
		if (none.equals(cur)) {
			return null;
		}

		Node root = new Node(Integer.parseInt(cur), new ArrayList<Node>());
		int num = Integer.parseInt(queue.poll());
		for (int i = 0; i < num; i++) {
			root.children.add(buildTree(queue));
		}
		return root;
	}
}
