package leetcode;

public class PaintHouseII_265 {
	//f[i][j] = min(f[i- 1][k]) + cost[i - 1][j] {k != j} O(N*K*K)
    //f[i][j] = min(cost[i - 1][j] + min1 / min2) {if j = minj, choose min2; else choose min1} O(N*K)
    public static int minCostII(int[][] costs) {
       
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        if (k == 1 && n != 1) return Integer.MAX_VALUE;
        int min1 = 0, min2 = 0, minj = -1, m1 = min1, m2 = min2, mj = minj;
        int[] f = new int[k];
        for (int i = 0; i < n; i++) {
            m1 = min1; m2 = min2; mj = minj;
            min1 = Integer.MAX_VALUE;  min2 = Integer.MAX_VALUE; minj = -1;
            for (int j = 0; j < k; j++) {
                    f[j] = (mj == j ? m2 : m1) + costs[i][j]; 
                    if (f[j] < min1) {
                        min1 = f[j];
                        minj = j;
                    } 
                }
            for (int j = 0; j < k; j++) {
                    if (f[j] < min2 && j != minj) {
                        min2 = f[j];
                    } 
            
            }
        }
        return min1;
    }
    
    public static void main(String[] args) {
		System.out.println(minCostII(new int[][] {}));
	}
}
