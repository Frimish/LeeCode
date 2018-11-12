package leetcode;

import java.util.Arrays;

public class MaximumGap_164 {
	public static int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;
		long max = Arrays.stream(nums).max().getAsInt();
		int[] bucket = new int[nums.length];
		int Radix = 16;
		long e = 1;
		while (max / e > 0) {
			int[] count = new int[Radix];
			for (int num : nums) {
				count[(num / (int)e) % Radix]++;
			}
			for (int i = 1; i < Radix; i++) {
				count[i] += count[i - 1];
			}

			for (int i = nums.length - 1; i >= 0; i--) {
				bucket[--count[(nums[i] / (int)e) % Radix]] = nums[i];
			}
			int[] temp = bucket;
			bucket = nums;
			nums = temp;
			e *= Radix;
		}
		int res = 0;
		for (int i = 1; i < nums.length; i++) {
			res = Math.max(res, nums[i] - nums[i - 1]);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(maximumGap(new int[] {1,3,6,9}));
	}
}
