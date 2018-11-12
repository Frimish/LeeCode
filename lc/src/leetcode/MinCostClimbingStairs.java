package leetcode;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        if (cost.length < 3) return cost[cost.length - 1];
        int[] f = new int[cost.length + 1];
        f[0] = 0;
        f[1] = cost[0];
        for (int i = 2; i <= cost.length; i++) {
            f[i] = Math.min(f[i - 1], f[i - 2]) + cost[i - 1];
        }
        return  Math.min(f[cost.length], f[cost.length - 1]);
    }
    
    public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}
}
