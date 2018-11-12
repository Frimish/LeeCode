package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * corner case
 * ["TwoSum","add","find"] 
 * [[],[0],[0]]
 */
public class TwoSum {
	private Map<Integer, Integer> map;

	/** Initialize your data structure here. */
	public TwoSum() {
		map = new HashMap<Integer, Integer>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		map.put(number, map.getOrDefault(number, 0) + 1);
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		for (Integer key : map.keySet()) {
			Integer times = map.get(value - key);
			if (times != null && (key * 2 == value && times > 1 || times > 0 && key * 2 != value)) {
				return true;
			}
		}
		return false;
	}
}
