package leetcode;

public class ScrambleString_87 {
	public static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int length = s1.length();
		int[][][] status = new int[length][length][length + 1];
		dfs(s1, s2, 0, 0, length, status);
		return status[0][0][length] == 1 ? true : false;
	}

	private static void dfs(String s1, String s2, int idx1, int idx2, int length, int[][][] status) {
		if (status[idx1][idx2][length] != 0) {
			return;
		}
		if (length == 1) {
			status[idx1][idx2][1] = s1.charAt(idx1) == s2.charAt(idx2) ? 1 : 2;
			return;
		}

		for (int i = 1; i < length; i++) {
			dfs(s1, s2, idx1 + i, idx2, length - i, status);
			dfs(s1, s2, idx1, idx2 + (length - i), i, status);
			if ((status[idx1 + i][idx2][length - i] == 1) && (status[idx1][idx2 + (length - i)][i] == 1)) {
				status[idx1][idx2][length] = 1;
				return;
			}
			
			dfs(s1, s2, idx1 + i, idx2 + i, length - i, status);
			dfs(s1, s2, idx1, idx2, i, status);
			if ((status[idx1 + i][idx2 + i][length - i] == 1) && (status[idx1][idx2][i] == 1)) {
				status[idx1][idx2][length] = 1;
				return;
			}
		}

		status[idx1][idx2][length] = 2;
		return;
	}

	public static void main(String[] args) {
		String s1 = "mphoebfamrmcscdblwryqykaaqjcnx", s2 = "mphoebfamrmcscdblwryqykaaqjcnx";
		System.out.println(isScramble(s1, s2));
	}
}
