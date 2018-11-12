package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords_692 {
	public static List<String> topKFrequent(String[] words, int k) {
		if (words == null || words.length == 0 || k == 0)
			return Collections.emptyList();
		List<String> res = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> min = new PriorityQueue<String>((x,
				y) -> map.get(x) ==  map.get(y) ? y.compareTo(x) : map.get(x) - map.get(y));
		
		for (String word : map.keySet()) {
			min.offer(word);
			if (min.size() > k) {
				min.poll();
			}
		}
		
		while (!min.isEmpty()) {
			res.add(min.poll());
		}
		Collections.reverse(res);
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(topKFrequent(new String[] {"a","aa","aaa"}, 1));
	}
}
