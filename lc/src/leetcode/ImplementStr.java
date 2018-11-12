package leetcode;

public class ImplementStr {
	public static final int A = 1000000007;

	public static int strStr(String haystack, String needle) {
		int n = haystack.length();
		int m = needle.length();
		if (m == 0 || haystack.equals(needle))
			return 0;
		if (m > n) {
			return -1;
		}
		int p = 1;
		for (int i = 0; i < m - 1; i++) {
			p = p * 26 % A;
		}
		int nHash = getHash(haystack.toCharArray(), 0, m);
		int mHash = getHash(needle.toCharArray(), 0, m);
		for (int i = 0; i < n - m + 1; i++) {
			if (nHash == mHash) {
				if (haystack.substring(i, i + m).equals(needle)) {
					return i;
				}
			}
			nHash = (nHash - (haystack.charAt(i) - 'a') * p + A) % A;
			nHash = nHash * 26 + haystack.charAt(i + m) - 'a';
		}
		return -1;
	}

	public static int getHash(char[] c, int start, int end) {
		int hash = 0;
		for (int i = start; i < end; i++) {
			hash = (hash * 26 + c[i] - 'a') % A;
		}
		return hash;
	}
	
	public static void main(String[] args) {
		System.out.println(strStr("mississippi",
				"pi"));
	}
}
