package leetcode;

public class ValidPalindrome_125 {
	public static boolean isPalindrome(String s) {
		s = s.trim();
		s = s.toUpperCase();
		if (s == null || s.length() == 0)
			return true;
		int l = 0, r = s.length() - 1;
		while (l < r) {
			while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
				l++;
			while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
				r--;
			if ((s.charAt(l) != s.charAt(r)))
				return false;
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(" Asd sa "));
	}
}
