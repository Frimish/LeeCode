package leetcode;

import java.util.Arrays;

public class ShortestDistanceCharacter_821 {
	public int[] shortestToChar(String s, char c) {
		if (s == null || s.length() == 0)
			return new int[] {};
		int left = -s.length(), right = 2 * s.length();
		int[] res = new int[s.length()];
		Arrays.fill(res, s.length());
		for (int i = 0; i < s.length(); i++) {
			int j = s.length() - i - 1;
			if (s.charAt(i) == c) 
				left = i;
			if (s.charAt(j) == c) 
				right = j;
			res[i] = Math.min(res[i], i - left);
			res[j] = Math.min(res[j], right - j);
		}
		return res;
	}
}
