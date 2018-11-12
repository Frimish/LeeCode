package leetcode;

public class MergeTwoBinaryTrees_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode t = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        t.left = mergeTrees(t1.left, t2.left);
        t.right = mergeTrees(t1.right, t2.right);
        return t;
    }
}
