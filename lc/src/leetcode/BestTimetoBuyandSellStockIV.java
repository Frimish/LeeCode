package leetcode;

public class BestTimetoBuyandSellStockIV {
	public static int maxProfit(int m, int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		if (m >= prices.length / 2) return quickSolve(prices);
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[2][prices.length + 1];
		int cur = 0;
		for (int k = 1; k <= m; k++) {
			max = Integer.MIN_VALUE;
			cur = 1 - cur;
			for (int i = 2; i <= prices.length; i++) {
				max = Math.max(max, dp[1 - cur][i - 2] - prices[i - 2]);
				dp[cur][i] = Math.max(max + prices[i - 1], dp[cur][i - 1]);
			}
		}
		return dp[cur][prices.length];
	}

	private static int quickSolve(int[] prices) {
		int len = prices.length, profit = 0;
		for (int i = 1; i < len; i++)
			// as long as there is a price gap, we gain a profit.
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		return profit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(2, new int[] { 1, 2, 3, 4, 5 }));

	}
}
