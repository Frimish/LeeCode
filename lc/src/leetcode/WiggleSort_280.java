package leetcode;

import java.util.Arrays;

public class WiggleSort_280 {
    public static void wiggleSort(int[] nums) {
    	if (nums == null || nums.length == 0) return;
    	Arrays.sort(nums);
    	 for(int i = 1; i < nums.length - 1; i+=2)  
             swap(nums, i, i + 1);   
    }

	private static void swap(int[] nums, int left, int right) {
		if (nums[left] == nums[right]) return;
		nums[left] ^= nums[right];
		nums[right] ^= nums[left];
		nums[left] ^= nums[right];
	}
	
	public static void main(String[] args) {
		wiggleSort(new int[] {3,5,2,1,6,4});
	}
}
