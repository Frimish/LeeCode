package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray_697 {
	public static int findShortestSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>(), firstMap = new HashMap<Integer, Integer>(),
				lastMap = new HashMap<Integer, Integer>();
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (countMap.get(nums[i]) == null) 
				firstMap.put(nums[i], i);
			lastMap.put(nums[i], i);
			countMap.put(nums[i], countMap.getOrDefault((nums[i]), 0) + 1);
		}
		
		int max = Collections.max(countMap.values());
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() == max) {
				res = Math.min(res, lastMap.get(entry.getKey()) - firstMap.get(entry.getKey()) + 1);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(findShortestSubArray(new int[] { 1, 2, 2, 3, 1 }));
	}
}
