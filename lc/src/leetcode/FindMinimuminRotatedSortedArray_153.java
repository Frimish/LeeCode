package leetcode;

public class FindMinimuminRotatedSortedArray_153 {
	public static int findMin(int[] nums) {
		if (nums.length == 0) return 0;
		int l = 0, r = nums.length - 1, mid = 0;
		while (l < r) {
			mid = l + ((r - l) >> 1);
			if (nums[mid] > nums[r])
				l = mid + 1;
			else
				r = mid;
		}
		return nums[l];
	}
	
	public static void main(String[] args) {
		System.out.println(findMin(new int[] {1,3,3}));
	}
}
