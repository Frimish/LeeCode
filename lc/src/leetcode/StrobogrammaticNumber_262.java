package leetcode;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber_262 {
	public boolean isStrobogrammatic(String num) {
		Map<Character, Character> map = new HashMap<>();
		map.put('8', '8');
		map.put('9', '6');
		map.put('6', '9');
		map.put('1', '1');
		map.put('0', '0');
		int l = 0, r = num.length() - 1;
		while (l <= r) {
			if (map.containsKey(num.charAt(l)) && map.get(num.charAt(l)) == num.charAt(r)) {
				l++;
				r--;
			} else {
				return false;
			}
		}
		return true;
	}
}
