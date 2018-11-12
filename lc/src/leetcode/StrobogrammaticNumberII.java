package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
    private final static Map<Character, Character> MAP = new HashMap<Character, Character>() {{
        put('0', '0');
        put('1', '1');
        put('6', '9');
        put('8', '8');
        put('9', '6');
    }};
   
    private static char[] CH = new char[]{'0', '1', '6', '8', '9'};
    
    public static List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }
    
    private static List<String> dfs(int n, int m) {
        if (m == 0) return Arrays.asList("");
        if (m == 1) return Arrays.asList("0", "1", "8");
        List<String> tmp = dfs(n, m - 2);
        List<String> res = new ArrayList<String>();
        for (String list : tmp) {
            for (int i = 0; i < CH.length; i++) {
                if (i == 0 && n == m) continue;
                res.add(CH[i] + list + MAP.get(CH[i]));
            }
        }
        return res;
    }
   
    
    public static void main(String[] args) {
		System.out.println(findStrobogrammatic(3));
	}
}
