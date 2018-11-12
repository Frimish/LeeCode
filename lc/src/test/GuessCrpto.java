package test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GuessCrpto {
	private static String s = "ZTMN PXTNE CFA PEQEF KECNP CJT TMN ZCWSENP ONTMJSW ZTNWS TF WSVP XTFWVFEFW,"
			+ " C FEB FCWVTF, XTFXEVQEA VF GVOENWK,"
			+ " CFA AEAVXCWEA WT WSE RNTRTPVWVTF WSCW CGG LEF CNE XNECWEA EYMCG.";

	private static void dfs(int step, Map<Character, Character> map) {
		if (step == 26) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				sb.append(map.get(s.charAt(i)));
			}
			System.out.println(sb.toString());
			return;
		}
		for (int i = 0; i < 26; i++) {
			if (!map.containsKey((char)(step + 'A'))) {
				map.put((char)(step + 'A'), (char)(i + 'A'));
				dfs(step + 1, map);
				map.remove((char)(step + 'A'));
			}
		}
	}

	public static void main(String[] args) {
		
		dfs(0, new HashMap<Character, Character>());
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == ' ' || c == ',' || c == '.') continue;
			map.put(c, map.getOrDefault(c, 0) + 1);
			count++;
		}
		PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<Map.Entry<Character, Integer>>((x, y) -> y.getValue() - x.getValue());	
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			queue.offer(entry);
		}
		while (!queue.isEmpty()) {
			Map.Entry<Character, Integer> entry = queue.poll();
			System.out.println(entry.getKey() + ":" + entry.getValue() * 1.0 / count);
		}
	}

}
