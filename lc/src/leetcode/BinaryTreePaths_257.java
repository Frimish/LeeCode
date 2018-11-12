package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> path = new ArrayList<List<Integer>>();
        List<String> res = new ArrayList<String>();
        helper(root, new ArrayList<Integer>(), path);
        for (List<Integer> list : path) {
        	if (!list.isEmpty()) {
        		StringBuilder sub = new StringBuilder(String.valueOf(list.get(0)));
            	for (int i = 1; i < list.size(); i++) {
            		sub.append("->" + list.get(i));
            	}
            	res.add(sub.toString());
        	} else {
        		res.add("");
        	}
        }
        return res;
    }

	private void helper(TreeNode root, ArrayList<Integer> tmp, List<List<Integer>> path) {
		if (root == null) return;
		if (root.right == null && root.left == null) {
			tmp.add(root.val);
			path.add(new ArrayList<Integer>(tmp));
			tmp.remove(tmp.size() - 1);
			return;
		}
		tmp.add(root.val);
		helper(root.left, tmp, path);
		helper(root.right, tmp, path);
		tmp.remove(tmp.size() - 1);
	}
    
}
