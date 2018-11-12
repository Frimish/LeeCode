package leetcode;
/*
 * corner case :"ac" "a"
 *             :"" "a"
 */
public class OneEditDistance_161 {
	public static boolean isOneEditDistance(String s, String t) {
		if (s.equals(t)) {
			return false;
		}
		if (Math.abs(s.length() - t.length()) > 1) {
			return false;
		}
		if (s.length() < t.length()) return isOneEditDistance(t, s);
		if ("".equals(t)) return true;
		boolean isEdited = false;
		for (int i= 0, j = 0; i < s.length(); i++, j++) {
			if (j < t.length() && s.charAt(i) != t.charAt(j)) {
					if (isEdited) return false;
					isEdited = true;
					if (s.length() == t.length()) continue;
					else j--;
			} 
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ca", "ac"));
	}
}
