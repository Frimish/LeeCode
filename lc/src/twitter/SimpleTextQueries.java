package twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleTextQueries {

	private static Map<String, List<Integer>> map = new HashMap<>();

	public static List<List<Integer>> simpleText(int n, String[] sentence, int q, String[] queries) {
		List<List<Integer>> res = new ArrayList<>();
		for (String query : queries) {
			List<Integer> merge = new ArrayList<>();
			query = query.trim();
			if (!query.isEmpty()) {
				String[] words = query.split(" ");
				List<Integer> idxs = map.get(words[0]);
				Set<Integer> set = new HashSet<>();
				merge.addAll(find(sentence, words[0]));
				for (int i = 1; i < words.length; i++) {
					if (merge.isEmpty())
						break;
					idxs = find(sentence, words[i]);
					for (int idx : idxs) {
						if (merge.contains(idx))
							set.add(idx);
					}
					merge.clear();
					merge.addAll(set);
					set.clear();
				}
				if (merge.isEmpty()) {
					merge.add(-1);
					res.add(merge);
				} else {
					Collections.sort(merge);
					res.add(merge);
				}
			} else {
				merge.add(-1);
				res.add(merge);
			}

		}
		return res;
	}

	private static List<Integer> find(String[] sentence, String word) {
		if (map.containsKey(word))
			return map.get(word);
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < sentence.length; i++) {
			if (sentence[i].contains(word)) {
				res.add(i);
			}
		}
		map.put(word, res);
		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> res = simpleText(3,
				new String[] { "it go will way", " east go do art", "what to will east" }, 3,
				new String[] { "it go art", "   ", "will" });
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}
