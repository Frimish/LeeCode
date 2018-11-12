package leetcode;

public class PartitionEqualSubsetSum_416 {
	public boolean canPartition(int[] nums) {

		if (nums.length <= 1)
			return false;
		if (nums.length == 2)
			return nums[0] == nums[1];

		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum % 2 != 0)
			return false;
		sum /= 2;

		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;

		for (int i = 0; i < nums.length; i++) {
			for (int j = sum; j >= nums[i]; j--)
				dp[j] = dp[j] || dp[j - nums[i]];
		}

		return dp[sum];
	}
}
