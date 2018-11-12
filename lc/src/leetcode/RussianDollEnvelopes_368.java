package leetcode;
import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes_368 {
	public static int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0)
			return 0;
		Arrays.sort(envelopes, (x, y) -> x[0] - y[0] == 0 ? y[1] - x[1] : x[0] - y[0]);
		int[] dp = new int[envelopes.length + 1];
		int len = 0, idx = 0;
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < envelopes.length; i++) {
			idx = Arrays.binarySearch(dp, envelopes[i][1]);
			idx = idx < 0 ? -idx - 1 : idx;
			dp[idx] = envelopes[i][1];
			len = Math.max(len, idx);
		}
		return len;
	}
	
	public static int maxEnvelopes1(int[][] envelopes) {
	    if(envelopes == null || envelopes.length == 0 
	       || envelopes[0] == null || envelopes[0].length != 2)
	        return 0;
	    Arrays.sort(envelopes, new Comparator<int[]>(){
	        public int compare(int[] arr1, int[] arr2){
	            if(arr1[0] == arr2[0])
	                return arr2[1] - arr1[1];
	            else
	                return arr1[0] - arr2[0];
	       } 
	    });
	    int dp[] = new int[envelopes.length];
	    int len = 0;
	    for(int[] envelope : envelopes){
	        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
	        if(index < 0)
	            index = -(index + 1);
	        dp[index] = envelope[1];
	        if(index == len)
	            len++;
	    }
	    return len;
	}
	public static void main(String[] args) {
		System.out.println(maxEnvelopes(new int[][]{{4,7},{6,7},{2,3},{1,1}}));
	}
}
