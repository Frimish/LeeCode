package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset_368 {
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums == null || nums.length == 0)
			return Collections.emptyList();
		List<Integer> res = new ArrayList<Integer>();
		int[] dp = new int[nums.length];
		int max = 1;
		Arrays.sort(nums);
		Arrays.fill(dp, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
					max = Math.max(dp[i], max);
				}
			}
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			if (dp[i] == max) {
				if ((res.size() == 0) || (res.get(res.size() - 1) % nums[i] == 0)) {
					res.add(nums[i]);
					max--;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(largestDivisibleSubset(new int[] {2,3,4,9,8}));
	}
}
