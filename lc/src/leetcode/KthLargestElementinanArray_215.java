package leetcode;

import java.util.Arrays;

public class KthLargestElementinanArray_215 {
    public static int findKthLargest(int[] nums, int k) {
    	if (k > nums.length) return 0;
        return helper(0, nums.length - 1, nums, nums.length - k);
    }
    
    
	private static int helper(int l, int r, int[] nums, int k) {
		int mid = quickSort(l, r, nums);
		if (mid == k) {
			return nums[k];
		} else if (k < mid) {
			return helper(l, mid - 1, nums, k);
		} else {
			return helper(mid + 1, r, nums, k);
		}
		
	}


	private static int quickSort(int l, int r, int[] nums) {
		int pivot = nums[l];
		while (l < r) {
			while (l < r && nums[r] >= pivot) r--;
			nums[l] = nums[r];
			while (l < r && nums[l] <= pivot) l++;
			nums[r] = nums[l];
		}
		nums[l] = pivot;
		return l;
	}
	
	 public static int findKthLargest1(int[] nums, int k) {
	    	if (k > nums.length) return 0;
	        Arrays.sort(nums);
	        return nums[nums.length - k];
	    }
	
	public static void main(String[] args) {
		
		System.out.println(findKthLargest1(new int[] {3,2,3,1,2,4,5,5,6}, 1));
	}
}
