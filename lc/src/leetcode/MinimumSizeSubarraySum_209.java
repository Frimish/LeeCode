package leetcode;

public class MinimumSizeSubarraySum_209 {
    public static int minSubArrayLen(int s, int[] nums) {
        int sum = 0, l = 0, r = 0, res = Integer.MAX_VALUE;
        while (r < nums.length) {
        	while (sum < s && r < nums.length) {
        		sum += nums[r];
        		r++;
        	}
        	while (sum >= s) {
        		res = Math.min(res, r - l);
        		sum -= nums[l];
        		l++;
        	}
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    public static void main(String[] args) {
		System.out.println(minSubArrayLen(100, new int[] {}));
	}
}
