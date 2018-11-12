package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII_140 {
	private static Map<String, List<String>> cache = new HashMap<String, List<String>>();

	public static List<String> wordBreak(String s, List<String> wordDict) {
		if (s == null || wordDict == null)
			return Collections.emptyList();
		return helper(s, wordDict, cache);
	}

	private static List<String> helper(String s, List<String> wordDict, Map<String, List<String>> cache) {
		if (cache.containsKey(s))
			return cache.get(s);
		List<String> res = new ArrayList<String>();
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				if (s.equals(word)) {
					res.add(word);
				} else {
					List<String> tmp = helper(s.substring(word.length()), wordDict, cache);
					for (String each : tmp) {
						res.add(word + " " + each);
					}
				}
			}
		}
		cache.put(s, res);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(wordBreak("gggg", Arrays.asList("g", "gg")));
	}
}
