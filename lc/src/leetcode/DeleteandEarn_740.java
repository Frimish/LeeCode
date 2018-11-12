package leetcode;

public class DeleteandEarn_740 {
	public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        for (int x : nums) 
        	max = Math.max(max, x);
        int[] count = new int[max + 1];
        int[][] dp = new int[max + 1][2];
        for (int x : nums) 
        	count[x]++;
        for (int i = 1; i <= max; i++) {
        	dp[i][0] = Math.max(dp[i - 1][0], dp[i- 1][1]);
        	dp[i][1] = dp[i - 1][0] + count[i] * i;
        }
        return  Math.max(dp[max][0], dp[max][1]);
    }
}
