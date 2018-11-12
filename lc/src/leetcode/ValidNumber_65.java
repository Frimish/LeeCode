package leetcode;

public class ValidNumber_65 {
    public static boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        boolean isSeenNum = false;
        boolean isSeenE = false;
        boolean numAfterE = false;
        boolean isSeenPoint = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                isSeenNum = true;
                numAfterE = true;
            } else if (c == '.') {
                if (isSeenE || isSeenPoint) return false;
                isSeenPoint = true;
            } else if (c == 'e') {
                if (isSeenE || !isSeenNum) return false;
                isSeenE = true;
                numAfterE = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else return false;
        }
        return isSeenNum && numAfterE;
    }
    
    public static void main(String[] args) {
		System.out.println();
	}
}
