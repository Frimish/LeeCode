package leetcode;

public class MaximalSquare_221 {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int n = matrix.length - 1, m = matrix[0].length - 1, ans = 0;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = n - 1; i >=0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				dp[i][j] = (matrix[i][j] - '0') * (Math.min(Math.min(dp[i][j+1], dp[i + 1][j]), dp[i+1][j+1]) + 1);
				ans = Math.max(ans, dp[i][j]);
			}
		}
		return ans*ans;
	}
}
