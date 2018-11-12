package leetcode;

public class BestTimetoBuyandSellStockIII_123 {
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int m = 2;
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[m + 1][prices.length + 1];
		for (int k = 1; k <= m; k++) {
			max = Integer.MIN_VALUE;
			for (int i = 2; i <= prices.length; i++) {
				max = Math.max(max, dp[k - 1][i - 2] - prices[i - 2]);
				dp[k][i] = Math.max(max + prices[i - 1], dp[k][i - 1]);
			}
		}
		return dp[m][prices.length];
	}
	
	public static int maxProfit1(int[] prices) {
	    if (prices.length == 0) return 0;
	    int m = 2;
	    int[][] dp = new int[m + 1][prices.length + 1];
	    for (int k = 1; k <= m; k++) {
	        for (int i = 2; i <= prices.length; i++) {
	            for (int j = 0; j < i - 1; j++) {
	                dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] - prices[j] + prices[i - 1]);
	            }
	            dp[k][i] = Math.max(dp[k][i], dp[k][i - 1]);
	        }
	    }
	    return dp[m][prices.length];
	}


	public static void main(String[] args) {
		System.out.println(maxProfit1(new int[] {1,2,3,4,5}));
		
		
	}
}
