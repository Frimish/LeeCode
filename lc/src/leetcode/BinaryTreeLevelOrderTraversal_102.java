package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        q.offer(root);
        while (!q.isEmpty()) {
        	int size = q.size();
        	List<Integer> tmp = new ArrayList<Integer>();
        	for (int i = 0; i < size; i++) {
        		TreeNode treeNode = q.poll();
        		tmp.add(treeNode.val);
        		if (treeNode.left != null) {
        			q.offer(treeNode.left);
        		} 
        		if (treeNode.right != null) {
        			q.offer(treeNode.right);
        		}
        	}
        	
        	res.addFirst(tmp);
        }
        
        return res;
    }
}
