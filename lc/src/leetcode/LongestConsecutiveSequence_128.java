package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {
	public static int longestConsecutive(int[] nums) {
		int res = 0;
		if (nums == null || nums.length == 0)
			return res;
		Set<Integer> set = new HashSet<Integer>();
		for (Integer num : nums) {
			set.add(num);
		}
		int len = 0, cur = 0;
		for (Integer num : nums) {
			cur = num;
			len = 1;
			if (!set.contains(cur - 1)) {
				while (set.contains(cur + 1)) {
					cur++;
					len++;
				}
			}
			res = Math.max(res, len);
		}

		return res;
	}

	public static int longestConsecutive1(int[] nums) {
		int res = 0;
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		int start = 0, end = 0, dup = 0;
		while (end < nums.length) {
			dup = 0;
			while ((end < nums.length - 1) && (nums[end] + 1 == nums[end + 1] || nums[end] == nums[end + 1])) {
				dup = dup + (nums[end] == nums[end + 1] ? 1 : 0);
				end++;
			}
				
			res = Math.max(end - start + 1 - dup, res);
			start = end + 1;
			end = start;
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive1(new int[] {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));
	}
}
