package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak_139 {
    public static boolean wordBreak(String s, Set<String> wordDict) {
    	if (s == null || wordDict == null) return false;
    	boolean[] dp = new boolean[s.length() + 1];
    	dp[0] = true;
    	for (int i = 1; i <= s.length(); i++) {
    		for (int j = 0; j < i; j++) {
    			if (dp[j] && wordDict.contains(s.substring(j, i))) {
    				dp[i] = true;
    				break;
    			}
    		}
    	}
    	return dp[s.length()];
    }
    
    public static void main(String[] args) {
		System.out.println(wordBreak("catsandog", new HashSet<>(Arrays.asList("cats","dog","sand","and","cat"))));
	}
}
