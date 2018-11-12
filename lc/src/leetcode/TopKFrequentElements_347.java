package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements_347 {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0)
			return Collections.emptyList();

		HashMap<Integer, Integer> map = new HashMap<>();
			
		for (Integer num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
		
		for (Map.Entry<Integer, Integer> keySet : map.entrySet()) {
			queue.offer(keySet);
		}
		
		List<Integer> res = new ArrayList<Integer>();
		while (k > 0 && !queue.isEmpty()) {
			res.add(queue.poll().getKey());
			k--;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(topKFrequent(new int[] {1,1,2,2,3 }, 4));
	}
}
