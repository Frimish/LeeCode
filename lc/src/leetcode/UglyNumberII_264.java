package leetcode;

import java.util.TreeSet;

public class UglyNumberII_264 {
	
	/**
	 * 
	* @Title: nthUglyNumber 
	* @Description: TODO
	* @param n
	* @return   
	* @return int  
	* @throws
	 */
    public static int nthUglyNumber(int n) {
        if (n < 1) return 0;
        TreeSet<Long> treeSet = new TreeSet<Long>();
        treeSet.add(1L);
        for (int i = 1; i < n; i++) {
        	long x = treeSet.pollFirst();
        	treeSet.add(x * 2);
        	treeSet.add(x * 3);
        	treeSet.add(x * 5);
        }
        return treeSet.first().intValue();
    }
    
    /**
     * 
    * @Title: nthUglyNumber1 
    * @Description: TODO
    * @param n
    * @return   
    * @return int  
    * @throws
     */
    public static int nthUglyNumber1(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int i = 0, j = 0, k = 0;
        for (int m = 1; dp[n - 1] == 0;) {
            int tempt = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5));
            if (tempt == dp[i] * 2) i++;
            else if (tempt == dp[j] * 3) j++;
            else if (tempt == dp[k] * 5) k++;
            if (dp[m - 1] != tempt) dp[m++] = tempt;
        }
        return dp[n - 1];
    }
    
    public static void main(String[] args) {
		System.out.println(nthUglyNumber1(12));
	}
}
