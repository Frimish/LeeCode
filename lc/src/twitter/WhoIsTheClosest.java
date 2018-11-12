package twitter;

import java.util.HashMap;
import java.util.Map;

public class WhoIsTheClosest {
	private static int[] closet(String s, int count, int[] queries) {
		Map<Character, Integer> map = new HashMap<>();
		int len = s.length();
		int[] left = new int[len], right = new int[len], res = new int[count];
		for (int i = 0; i < len; i++) {
			Integer pos = map.put(s.charAt(i), i);
			left[i] = pos == null ? Integer.MAX_VALUE : pos;
		}
		map.clear();
		for (int i = len - 1; i >= 0; i--) {
			Integer pos = map.put(s.charAt(i), i);
			right[i] = pos == null ? Integer.MAX_VALUE : pos;
		}
		for (int i = 0; i < count; i++) {
			res[i] = Math.min(left[queries[i]], right[queries[i]]);
			res[i] = res[i] == Integer.MAX_VALUE ? -1 : res[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] res = closet("hackerrank", 4, new int[] {4, 1, 6, 8});
		for (int x : res) {
			System.out.println(x);
		}
		
	}
}
