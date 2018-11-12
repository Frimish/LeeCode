package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    
    private static Set<String> res = new HashSet<String>();
    
    public static List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            } else if (s.charAt(i) == ')') {
                if (rmL != 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        dfs(s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<>(res);
    }
    
    private static void dfs(String s, int step, int rmL, int rmR, int open, StringBuilder tmp) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        if (step == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                
                res.add(tmp.toString());
            }
            return;
        }
        int len = tmp.length();
        char c = s.charAt(step);
        if (c == '(') {
            dfs(s, step + 1, rmL - 1, rmR, open, tmp);
            dfs(s, step + 1, rmL, rmR, open + 1, tmp.append(c));
        } else if (c == ')') {
            dfs(s, step + 1, rmL, rmR - 1, open, tmp);
            dfs(s, step + 1, rmL, rmR, open - 1, tmp.append(c));
        } else {
            dfs(s, step + 1, rmL, rmR, open, tmp.append(c));
        }
        tmp.setLength(len);
        
    }
    
    public static void main(String[] args) {
		System.out.println(removeInvalidParentheses(")("));
	}
}
