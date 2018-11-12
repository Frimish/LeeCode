package leetcode;

public class LongestPalindrome_409 {
	public int longestPalindrome(String s) {
		int[] count = new int[128];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)] ++;
		}
		
		boolean odd = false;
		int res = 0;
		
		for (int i = 0; i < 128; i++) {
			if (count[i] % 2 == 1) {
				odd = true;
			}
			res += count[i] / 2 * 2;
		}
		return odd ? res + 1 : res;
	}
	
	
}
