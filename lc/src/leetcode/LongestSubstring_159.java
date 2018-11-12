package leetcode;

public class LongestSubstring_159 {
    public static int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] count = new int[128];
        int counts = 0;
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
        	if (counts <= k) {
        		if (count[s.charAt(right)] == 0) 
        			counts++;
        		count[s.charAt(right++)]++;
        	}
        	if (counts <= k) res = Math.max(res, right - left);
        	while (counts > k) {
        		count[s.charAt(left)]--;
        		if (count[s.charAt(left)] == 0) 
        			counts--;
        		left++;
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb", 3));
	}
}
