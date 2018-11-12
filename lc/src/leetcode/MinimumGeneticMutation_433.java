package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation_433 {
	public static int minMutation(String start, String end, String[] bank) {
		if (start.length() != end.length() || bank == null || bank.length == 0) {
			return -1;
		}
		
		char[] mutation = new char[] { 'A', 'C', 'G', 'T' };
		Set<String> set = new HashSet<String>();
		for (String s : bank) {
			set.add(s);
		}
		
		Queue<String> queue = new LinkedList<String>();
		
		queue.offer(start);
		int res = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				String cur = queue.poll();
				if (cur.equals(end)) {
					return res;
				}
				for (int i = 0; i < cur.length(); i++) {
					for (int j = 0; j < 4; j++) {
						if (cur.charAt(i) != mutation[j]) {
							String tmp = cur.substring(0, i) + mutation[j] + cur.substring(i + 1);
							if (set.contains(tmp)) {
								queue.offer(tmp);
								set.remove(tmp);
							}
						}
					}
				}
			}
			res ++;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(minMutation("AAAAACCC", "AACCCCCC", new String[] {"AACACCCA", "AAACCCCC", "AACCCCCC"}));
	}
	
	
}
