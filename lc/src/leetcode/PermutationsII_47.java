package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII_47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) return res;
		generate(0, nums, res);
		return res;
	}

	private void generate(int index, int[] nums, List<List<Integer>> res) {
		if (index == nums.length) {
			List<Integer> tmp = new ArrayList<Integer>();
			for (Integer num : nums) {
				tmp.add(num);
			}
			res.add(tmp);
			return;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = index; i < nums.length; i++) {
			if (set.add(nums[i])) {
				swap(nums, i, index);
				generate(index + 1, nums, res);
				swap(nums, i, index);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		if (i == j) return; 
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
}
