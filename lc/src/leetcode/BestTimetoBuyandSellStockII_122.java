package leetcode;

public class BestTimetoBuyandSellStockII_122 {
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < prices.length - 1;) {
			int buy = i;
			int sell = i;
			while ((sell < prices.length - 1) && (prices[sell + 1] > prices[sell]))
				sell++;
			res += Math.max(0, prices[sell] - prices[buy]);
			i = sell + 1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] prices = new int[] {1,6,5,4,2,7};
		System.out.println(maxProfit(prices));
	}
}
