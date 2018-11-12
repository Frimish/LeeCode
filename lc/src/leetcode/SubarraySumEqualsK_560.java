package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        dp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	res += dp.getOrDefault(sum - k, 0);
        	dp.put(sum, dp.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
    
    public static void main(String[] args) {
		System.out.println(subarraySum(new int[] {1, -1, 1}, 0));
	}
}
