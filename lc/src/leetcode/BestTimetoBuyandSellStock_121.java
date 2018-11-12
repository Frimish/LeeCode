package leetcode;

public class BestTimetoBuyandSellStock_121 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int res = 0;
		int opt = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			res = Math.max(prices[i] - opt, res);
			opt = Math.min(opt, prices[i]);
		}
		return res;
	}
}
