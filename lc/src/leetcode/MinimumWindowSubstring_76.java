package leetcode;

public class MinimumWindowSubstring_76 {
    public static String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
			return "";
		int[] count = new int[128];
		char[] tch = t.toCharArray();
        char[] c = s.toCharArray();
		for (char ch : tch) {
			count[ch]++;
		}
		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
		while (end < c.length) {
			if (count[c[end++]]-- > 0) counter--;
            while (counter == 1) {
                if (end - start < minLen && end - start >= t.length()) {
                    minLen = end - start;
                    minStart = start;
                }
                if (count[c[start++]]++ == 0) counter++;
            }
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
	
	public static void main(String[] args) {
		String S = "acedbg", T = "xcbe";
		System.out.println(minWindow(S, T));
	}
}
