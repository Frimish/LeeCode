package leetcode;

public class ReverseWordsinaString_151 {
    public static String reverseWords(String s) {
        if (s == null) return s;
		s = s.trim();
		if (s.isEmpty()) return s;
		StringBuilder sb = new StringBuilder(s);
		
		sb.reverse();
		String[] subs = sb.toString().split(" ");
		StringBuilder res = new StringBuilder();
		for (String sub : subs) {
			sub = sub.trim(); 
			if (sub.isEmpty()) continue;
			StringBuilder subSb = new StringBuilder(sub);
			res.append(subSb.reverse()).append(" ");
		}
		return res.deleteCharAt(res.length() - 1).toString();
    }
    public static void main(String[] args) {
		System.out.println(reverseWords("   a  bc cc   b   "));
	}
}
