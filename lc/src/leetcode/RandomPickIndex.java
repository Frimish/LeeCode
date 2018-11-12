package leetcode;

import java.util.Arrays;
import java.util.Random;

public class RandomPickIndex {

	private int[] A;

	public RandomPickIndex(int[] nums) {
		Arrays.sort(nums);
		A = nums;
	}

	public int pick(int target) {
		int idx = Arrays.binarySearch(A, target);
		int l = idx, r = idx;
		
		while (l >= 0 && A[l] == target) {
			l--;
		}
		l++;
		
		while (r < A.length && A[r] == target) {
			r++;
		}
		r--;
		
		Random rand = new Random();
		return rand.nextInt(r - l + 1) + l;
	}
}
