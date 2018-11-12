package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllDuplicatesinanArray_442 {
	public static List<Integer> findDuplicates(int[] nums) {
		// generally, validate the parameters
		if (nums == null || nums.length == 0)
			return Collections.emptyList();
		List<Integer> res = new ArrayList<Integer>();
		int i = 0;
		while (i < nums.length) {
		    // if the number is at the supposed position then move on to next one
			if (nums[i] == i + 1) {
				i++;
				continue;
			}
			// if the number in this position has been marked meaning this number has appeared, then move on
			if (nums[i] == -1) {
				i++;
				continue;
			}
			// if the supposed position has been placed the right number, this number is duplicate 
			if (nums[i] == nums[nums[i] - 1]) {
				res.add(nums[i]);
				// the supposed position should be marked and move on
				nums[nums[i] - 1] = -1;
				i++;
			}
			// if the supposed position has not been placed the right number and neither been marked. 
			// swap the number to the supposed position and deal the new number in this position. do not move on
			else if (nums[nums[i] - 1] != -1) {
				swap(nums, nums[i] - 1, i);
			} else {
			// if the supposed position has been marked also meaning this number has appeared, then move on;
				i++;
			}
		}
		return res;
	}

	private static void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
	
	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] {5,4,6,7,9,3,10,9,5,6}));
	}
}
