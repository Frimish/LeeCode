package leetcode;

import java.util.Arrays;

public class DistinctSubsequences_115 {
    public static int numDistinct(String s, String t) {
        if(s == null && t == null) {
            return 1;
        }
        if(s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        int n = s.length(), m = t.length();
        int[][] dp = new int[2][n + 1];
        Arrays.fill(dp[0], 1);
        int cur = 0;
        for (int i = 1; i <= m; i++) {
        	for (int j = i; j <= n; j++) {
        		cur = 1 - cur;
        		dp[cur][j] = (s.charAt(j - 1) == t.charAt(i - 1) ? dp[1 - cur][j - 1] : 0) + dp[cur][j - 1];
        	}
        }
        
        return dp[cur][n];
    }
    
    public static void main(String[] args) {
		System.out.println(numDistinct("babgbag","bag"));
	}
}
