package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTtoGreaterTree_538 {
	private static List<Integer> list = new ArrayList<>();
	private static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
    	list.add(0);
        dfs(root);
        sum = list.get(list.size() - 1);
        return create(root, list);
    }

	private static TreeNode create(TreeNode root, List<Integer> list) {
		
		if (root == null) return null;
		TreeNode t = new TreeNode(0);
		t.left = create(root.left, list);
		t.val = sum - list.remove(0);
		t.right = create(root.right, list);
		return t;
	}

	private static void dfs(TreeNode root) {
		if (root == null) return;
		dfs(root.left);
		list.add(list.get(list.size() - 1) + root.val);
		dfs(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode t5 = new TreeNode(5);
		TreeNode t2 = new TreeNode(2);
		TreeNode t13 = new TreeNode(13);
		t5.left = t2;
		t5.right = t13;
		convertBST(t5);
	}
	
	
}
