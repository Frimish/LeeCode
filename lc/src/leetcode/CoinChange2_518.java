package leetcode;

/*
 * f[0] = 1
 * f[j] = f[j - coin[j]] + f[j]  coin[j] <= j <= amount
 * coin [1, 2] aoumt = 4
 * f[1] = 1 f[2] = 1 f[3] = 1 f[4] = 1
 * f[2] = f[2] + f[0] = 2 f[3] = f[1] + f[3] = 2 f[4] = f[2] + f[4] = 3
 */


public class CoinChange2_518 {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i= 0; i < coins.length; i++) {
        	for (int j = coins[i]; j <= amount; j++) 
        		dp[j] = dp[j - coins[i]] + dp[j];
        }
        return dp[amount];
    }
    
    public static void main(String[] args) {
		System.out.println(change(0, new int[] {}));
	}
}
