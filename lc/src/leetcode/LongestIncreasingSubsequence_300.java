package leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
	public static int lengthOfLIS(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int n = A.length, res = 1, len = 0, idx;
		int[] dp = new int[n + 1];
		int[] d = new int[n + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[0] = A[0];
		dp[0] = len + 1;
		for (int i = 1; i < n; i++) {
			idx = Arrays.binarySearch(d, A[i]);
			idx = idx < 0 ? -idx - 1 : idx;
			d[idx] = A[i];
			dp[i] = idx + 1;
			res = Math.max(res, dp[i]);
		}
		return res;
	}

    public static int lengthOfLIS1(int[] nums) {
        if (nums.length < 2) return nums.length;
        int max = 1, idx = 0;
        int[] f = new int[nums.length];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int x : nums) {
            idx = Arrays.binarySearch(f, x);
            idx = idx < 0 ? -idx - 1 : idx;
            f[idx] = x;
            max = Math.max(max, idx + 1);
        }
        return max;
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLIS1(new int[] {1,2,2,1}));
	}
}
