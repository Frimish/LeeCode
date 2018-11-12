package leetcode;

public class FindPeakElement_162 {
	public int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;
		int l = 0, r = nums.length, mid = 0;
		while (l < r) {
			mid = l + ((r - l) >> 1);
			if (nums[mid] < nums[mid + 1])
				l = mid + 1;
			else
				r = mid;
		}
		return l;
	}
}
