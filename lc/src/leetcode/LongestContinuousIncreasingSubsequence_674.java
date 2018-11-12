package leetcode;

public class LongestContinuousIncreasingSubsequence_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null | nums.length == 0) return 0;
        int l = 0, r = 1, res = 1;
        while (r < nums.length) {
        	if (nums[r] <= nums[r - 1]) {
        		res = Math.max(res , r - l);
        		l = r;
        	}
        	r++;
        }
        res = Math.max(res , r - l);
        return res;
    }
}
