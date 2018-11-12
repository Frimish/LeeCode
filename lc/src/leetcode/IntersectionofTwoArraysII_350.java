package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArraysII_350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int[] tmp = new int[Math.max(nums1.length, nums2.length)];
		int p1 = 0, p2 = 0, len = 0;
		Set<Integer> set = new HashSet<Integer>();
		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] == nums2[p2]) {
				if (!set.contains(nums1[p1])) {
					tmp[len] = nums1[p1];
					len++;
					set.add(nums1[p1]);
				}
				p1++; 
				p2++;
			} else if (nums1[p1] > nums2[p2]) {
				p2++;
			} else {
				p1++;
			}
		}
		return Arrays.copyOf(tmp, len);
	}
}
