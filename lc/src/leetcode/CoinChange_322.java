package leetcode;

import java.util.Arrays;

public class CoinChange_322 {
	 public static int coinChange(int[] coins, int amount){
		 if (amount <= 0) return 0;
		 int[] dp = new int[amount + 1];
		 Arrays.fill(dp, amount + 1);
		 dp[0] = 0;
		 for (int c : coins) {
			 for (int v = c; v <= amount; v++) {
				 dp[v] = Math.min(dp[v-c] + 1, dp[v]);
			 }
		 }
		 return dp[amount] == amount + 1 ? -1 : dp[amount];
	 }
	 
	 public static void main(String[] args) {
		System.out.println(coinChange(new int[] {2}, 11));
	}
}
