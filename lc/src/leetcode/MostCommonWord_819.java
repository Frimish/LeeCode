package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord_819 {
	public String mostCommonWord(String paragraph, String[] banned) {
		if (paragraph == null || paragraph.length() == 0)
			return "";
		String[] st = paragraph.toLowerCase().split("[^[!?',;.]]+");
		Set<String> set = new HashSet<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < banned.length; i++) {
			set.add(banned[i]);
		}
		int max = 0; 
		String most = "";
		for (String s : st) {
			if (!set.contains(s)) {
				map.put(s, map.getOrDefault(s, 0) + 1);
				if (map.get(s) > max) {
					max = map.get(s);
					most = s;
				}
			}
		}
		return most;
	}
}
