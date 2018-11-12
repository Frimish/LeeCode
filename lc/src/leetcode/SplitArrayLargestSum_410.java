package leetcode;

public class SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int m) {
    	int len = nums.length;
    	if (len == 0) return 0;
    	int[][] dp = new int[len + 1][m + 1];
    	int[] sum = new int[len + 1];
    	sum[0] = 0;
    	for (int i = 0; i < len; i++) {
    		sum[i + 1] = sum[i] + nums[i];
    	}
    	for (int i = 1; i <= len; i++) {
    		dp[i][1] = sum[i];
    	}
    	for (int i = 2; i <= m; i++) {
    		for (int j = 1; j <= len; j++) {
    			for (int k = j - 1; k > 0; k--) {
    				int tmp = sum[j] - sum[k];
    				if (tmp > dp[i][j]) break;
    				dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], tmp));
    			}
    		}
    	}
    	
    	return dp[m][len];
    }
}
