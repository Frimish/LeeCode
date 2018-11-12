package leetcode;

public class PalindromicSubstrings_647 {
	public static int countSubstrings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int[][] dp = new int[s.length()][s.length()];
		int res = 0, j = 0;
		for (int l = 0; l < s.length(); l++) {
			for (int i = 0; i < s.length() - l; i++) {
				j = i + l;
				if (l < 2) {
					dp[i][j] = s.charAt(i) == s.charAt(j) ? l + 1 : 1;
				} else {
					
					dp[i][j] = Math.max(s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 2 :  dp[i + 1][j - 1], Math.max(dp[i + 1][j], dp[i][j - 1]));
				}
				res = Math.max(res, dp[i][j]);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(countSubstrings("abcabc"));
	}
}
