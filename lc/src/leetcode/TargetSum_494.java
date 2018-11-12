package leetcode;

public class TargetSum_494 {
	private int res = 0;
	
    public int findTargetSumWays(int[] nums, int S) {
        dfs(0, nums, S, 0);
        return res;
    }
    
	private void dfs(int idx, int[] nums, int target, int sum) {
		if (idx == nums.length) {
			if (target == sum) {
				res++;
			}
			return;
		}
		dfs(idx + 1, nums, target, sum + nums[idx]);
		dfs(idx + 1, nums, target, sum - nums[idx]);
	}
}
