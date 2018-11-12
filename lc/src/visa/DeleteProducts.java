package visa;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DeleteProducts {
	public static int deleteProducts(List<Integer> ids, int m) {
	    // Write your code here
		Map<Integer, Integer> map = new HashMap<>();
		for (int id : ids) {
			map.put(id, map.getOrDefault(id, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x, y) -> x.getValue() - y.getValue());
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			queue.offer(entry);
		}
		int res = queue.size();
		while (m > 0 && !queue.isEmpty()) {
			int cur = queue.poll().getValue();
			res = m >= cur ? res - 1 : res; 
			m = m - Math.min(m, cur);
		}
		return res;
	}
}
