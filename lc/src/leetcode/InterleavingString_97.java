package leetcode;

public class InterleavingString_97 {
	public static boolean isInterleave(String s1, String s2, String p) {
		if (s1.length() + s2.length() != p.length())
			return false;

		int n = s1.length(), m = s2.length();
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		for (int i = 1; i <= n; i++) {
			if (s1.charAt(i - 1) == p.charAt(i - 1)) {
				dp[i][0] = dp[i - 1][0];
			}
		}

		for (int j = 1; j <= m; j++) {
			if (s2.charAt(j - 1) == p.charAt(j - 1)) {
				dp[0][j] = dp[0][j - 1];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = (dp[i - 1][j] && (p.charAt(i + j - 1) == s1.charAt(i - 1)))
						|| (dp[i][j - 1] && (p.charAt(i + j - 1) == s2.charAt(j - 1)));
			}
		}
		
		return dp[n][m];

	}
	
	public static void main(String[] args) {
		String s1 = "";
		String s2 = "b";
		String p = "b";
		System.out.println(isInterleave(s1, s2, p));
	}
}
