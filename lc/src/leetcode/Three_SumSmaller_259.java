package leetcode;

import java.util.Arrays;

public class Three_SumSmaller_259 {
    public static int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                while (j < k && nums[i] + nums[j] + nums[k] >= target) 
                    k--;
                res += k - j;
                j++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
		System.out.println(threeSumSmaller(new int[] {3,-2,-2}, -1));
	}
}
