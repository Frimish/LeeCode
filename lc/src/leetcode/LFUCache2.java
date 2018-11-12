package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache2 {
	private Map<Integer, Integer> vals;
	private Map<Integer, Integer> freqs;
	private Map<Integer, LinkedHashSet<Integer>> lists;
	private int capacity;
	private int min = -1;
	
	LFUCache2(int capacity) {
		this.capacity = capacity;
		vals = new HashMap<>();
		freqs = new HashMap<>();
		lists = new HashMap<>();
		lists.put(1, new LinkedHashSet<Integer>());
	}

	int get(int key) {
		if (!vals.containsKey(key)) {
			return -1;
		}
		int freq = freqs.get(key);
		freqs.put(key, freq + 1); // update the frequecy
		lists.get(freq).remove(key); // remove the old frequency
		if (lists.get(freq).size() == 0 && freq == min) { // if empty min++
			min++;
		}
		freq++;
		if (!lists.containsKey(freq)) { // if the new frequecy is empty then new;
			lists.put(freq, new LinkedHashSet<>());
		}
		lists.get(freq).add(key); // add the new frequency
		return vals.get(key);
	}
	
	void put(int key, int val) {
		if (capacity <= 0) return; // if capacity is less than 0
		if (vals.containsKey(key)) { // if exits, update value and call get method to update frequency;
			vals.put(key, val);
			get(key);
			return;
		}
		if (vals.size() >= capacity) { // if has beyond the capacity remove the min.set.next and remove threee maps
			int evit = lists.get(min).iterator().next();
			lists.get(min).remove(evit);
			vals.remove(evit);
			freqs.remove(evit);
		}
		min = 1; // add a new element;
		freqs.put(key, 1);
		vals.put(key, val);
		lists.get(1).add(key);
	}
}
