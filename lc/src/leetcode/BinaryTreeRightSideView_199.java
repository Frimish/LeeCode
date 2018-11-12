package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
	
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        q.offer(root);
        while (!q.isEmpty()) {
        	int size = q.size();
        	int val = 0;
        	for (int i = 0; i < size; i++) {
        		TreeNode treeNode = q.poll();
        		val = treeNode.val;
        		if (treeNode.left != null) {
        			q.offer(treeNode.left);
        		} 
        		if (treeNode.right != null) {
        			q.offer(treeNode.right);
        		}
        	}
        res.add(val);
        }
        
        return res;
    }

}
