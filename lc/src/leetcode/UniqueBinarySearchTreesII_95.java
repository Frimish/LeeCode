package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII_95 {
	
	@SuppressWarnings("unchecked")
	public List<TreeNode> generateTrees(int n) {
	        return generateTrees(n, 1, n, new List[n + 1][n + 1]);
	 }

	private List<TreeNode> generateTrees(int n, int l, int r, List<TreeNode>[][] dp) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (l > r) return res;
		if (dp[l][r] != null) return dp[l][r];
		for (int mid = l; mid <= r; mid++) {
			List<TreeNode> lefts = generateTrees(n, l, mid-1, dp);
            if (lefts.isEmpty()) lefts.add(null);
            List<TreeNode> rights = generateTrees(n, mid+1, r, dp);
            if (rights.isEmpty()) rights.add(null);
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode tree = new TreeNode(mid);
                    tree.left = left;
                    tree.right = right;
                    res.add(tree);
                }
            }
		}
		dp[l][r] = res;
		return res;
	}
}
