package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static int ascii_deletion_distance(String str1, String str2) {
		int[] count = new int[128];
		for (char ch : str1.toCharArray()) {
			count[ch]++;
		}

		for (char ch : str2.toCharArray()) {
			count[ch]--;
		}
		int res = 0;
		for (int i = 0; i < 128; i++) {
			res += Math.abs(count[i]) * i;
		}
		return res;

	}

	public static int bracket_match(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		int res = 0;
		int[] dp = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == ')') {
					if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(')
						dp[i] = (i - dp[i - 1] - 2 < 0 ? 0 : dp[i - dp[i - 1] - 2]) + dp[i - 1] + 2;
				} else {
					dp[i] = (i < 2 ? 0 : dp[i - 2]) + 2;
				}
				res = Math.max(res, dp[i]);
			}
		}
		return res;
	}

	public static int four_letter_words(String sentence) {
		String[] four = sentence.split(" ");
		int res = 0;
		for (String st : four) {
			if (st.length() == 4) {
				res++;
			}
		}
		return res;
	}

	public static int almost_palindromes(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int[][] dp = new int[s.length()][s.length()];
		int res = 0, j = 0;
		for (int l = 0; l < s.length(); l++) {
			for (int i = 0; i < s.length() - l; i++) {
				j = i + l;
				if (l < 2) {
					dp[i][j] = s.charAt(i) == s.charAt(j) ? l + 1 : 1;
				} else {

					dp[i][j] = Math.max(s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 2 : dp[i + 1][j - 1],
							Math.max(dp[i + 1][j], dp[i][j - 1]));
				}
				res = Math.max(res, dp[i][j]);
			}
		}
		return s.length() - res;
	}
	
	public static void traverse(TreeNode root) {
		//base case
		if (root == null) return;
		//list.add(root.val);
		System.out.println(root.val);
		traverse(root.left);
		traverse(root.right);
	}

	public static void main(String[] args) {
	
		String str = "ab+b-c*c2c";
		String[] s = str.split("[0-9+-/*]");
		Codeccc c = new Codeccc();
		List<String> strs = new ArrayList<>();
		strs.add("123");
		strs.add("456");
		String res = c.encode(strs);
		System.out.println(res);
		System.out.println(c.decode(res));
	}
}
