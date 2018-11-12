package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder_127 {
	 public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)  {
		if (beginWord.length() != endWord.length() || wordList == null || wordList.size() == 0) {
			return Collections.emptyList();
		}

		Map<String, List<String>> path = new HashMap<String, List<String>>();
		Queue<String> queue = new LinkedList<String>();
		Set<String> set = new HashSet<String>();
		for (String word : wordList) {
			set.add(word);
			path.put(word, new ArrayList<String>());
		}
		Map<String, Integer> mapxy = new HashMap<String, Integer>();
		for (int i = 0; i < wordList.size(); i++) {
			mapxy.put(wordList.get(i), i);
		}
		if (!mapxy.containsKey(beginWord)) {
			mapxy.put(beginWord, wordList.size());
		}
		
		boolean[][] match = new boolean[wordList.size() + 1][wordList.size() + 1];
		for (int i = 0; i < wordList.size(); i++) {
			for (int j = i + 1; j < wordList.size(); j++) {
				match[i][j] = compare(wordList.get(i), wordList.get(j));
				match[j][i] = match[i][j];
			}
			match[i][i] = true;
			match[mapxy.get(beginWord)][i] = compare(beginWord, wordList.get(i));
			match[i][mapxy.get(beginWord)] = match[mapxy.get(beginWord)][i];
		}
		
		queue.offer(beginWord);
		if (set.contains(beginWord))
		set.remove(beginWord);
		path.put(beginWord, Arrays.asList(beginWord));
		boolean find = false;
		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int k = 0; k < size; k++) {
				String cur = queue.poll();

				Iterator<String> it = set.iterator();
				while (it.hasNext()) {
					String word = it.next();
					if (match[mapxy.get(cur)][mapxy.get(word)]) {

						if (!queue.contains(word))
							queue.offer(word);

						List<String> next = path.get(word);
						List<String> pre = path.get(cur);
						for (String s : pre) {
							next.add(s + "->" + word);
						}
						path.put(word, next);
						if (word.equals(endWord)) {
							find = true;
						}
					}
				}
			}

			if (find) {
				List<String> pathList = path.get(endWord);
				List<List<String>> res = new ArrayList<List<String>>();
				for (String s : pathList) {
					List<String> list = Arrays.asList(s.split("->"));
					res.add(list);
				}
				return res;
			}

			size = queue.size();
			for (int k = 0; k < size; k++) {
				String cur = queue.poll();
				if (set.contains(cur))
					set.remove(cur);
				queue.offer(cur);
			}
		}

		return Collections.emptyList();
	}

	private static boolean compare(String cur, String tmp) {
		if (cur.length() != tmp.length())
			return false;
		int count = 0;
		for (int i = 0; i < cur.length(); i++) {
			if (cur.charAt(i) != tmp.charAt(i)) {
				count++;
				if (count > 1)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = new String[] {"hot","dot","dog","lot","log","cog"};
		System.out.println(findLadders(beginWord, endWord, Arrays.asList(wordList)));

	}
}
