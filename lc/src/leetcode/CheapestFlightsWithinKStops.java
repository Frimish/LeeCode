package leetcode;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3F3F3F3F;
        int[] cost = new int[n];
        Arrays.fill(cost, INF);
        cost[src] = 0;
        int ans = cost[dst];
        for(int i = k; i >= 0; i--){
        	int[] cur = new int[n];
            Arrays.fill(cur, INF);
            for(int[] flight : flights){
                cur[flight[1]] = Math.min(cur[flight[1]], cost[flight[0]] + flight[2]);
            }
            cost = cur;
            ans = Math.min(ans, cost[dst]);
        }
        return ans == INF ? -1 : ans;
    }
    public static void main(String[] args) {
		System.out.println(findCheapestPrice(3,
				new int[][] {{0,1,100},{1,2,100},{0,2,500}
			},0, 2, 1));
		int INF = 0x3F3F3F3F;
		System.out.println(INF);
		System.out.println(INF * 2);
		System.out.println(Integer.MAX_VALUE);
	}
}
