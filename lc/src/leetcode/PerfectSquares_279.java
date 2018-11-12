package leetcode;

import java.util.Arrays;

public class PerfectSquares_279 {
	public static int numSquares(int n) {
		if (n < 1)
			return 0;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, n);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println(numSquares(13));
	}
}
