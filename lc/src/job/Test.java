package job;

public class Test {
	
    public static boolean backspaceCompare(String s, String t) {
        String s1 = process(s, 0);
        String t2 = process(t, 0);
        return s.equals(t);
    }
    
    private static String process(String str, int start) {
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (i <= 1) {
                    return process(str.substring(i + 1), 0);
                } else {
                    return process(str.substring(0, i - 1) + str.substring(i + 1), i - 2);
                }
            }
        }
        return str;
    }
	public static void main(String[] args) {
		
	}
}
