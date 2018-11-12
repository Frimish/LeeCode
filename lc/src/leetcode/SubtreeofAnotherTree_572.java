package leetcode;

public class SubtreeofAnotherTree_572 {
	
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	if (s == null) {
    		return t == null ? true : false;
    	}
        return  check(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        
    }
	private boolean check(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		if (s == null || t == null || s.val != t.val) {
			return false;
		}
		return check(s.right, t.right) && check(s.left, t.left);
	}
}
