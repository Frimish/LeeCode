package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {
	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() < 4) {
			return res;
		}
		List<List<String>> subs = new ArrayList<List<String>>();
		dfs(s, new ArrayList<String>(), subs);
		for (List<String> sub : subs) {
			StringBuilder sb = new StringBuilder();
			for (String each : sub) {
				sb.append(each).append(".");
			}
			res.add(sb.substring(0, sb.length() - 1).toString());
		}

		return res;

	}

	private static void dfs(String s, List<String> tmp, List<List<String>> subs) {
		if (s.length() / (4 - tmp.size()) > 3)
			return;

		if (tmp.size() == 3) {
			if (vaildate(s)) {
				tmp.add(s);
				subs.add(new ArrayList<String>(tmp));
				tmp.remove(tmp.size() - 1);
			}
			return;
		}

		for (int i = 0; i < s.length() - (3 - tmp.size()); i++) {
			if (vaildate(s.substring(0, i + 1))) {
				tmp.add(s.substring(0, i + 1));
				dfs(s.substring(i + 1), tmp, subs);
				tmp.remove(tmp.size() - 1);
			} else {
				break;
			}
		}
	}

	private static boolean vaildate(String s) {
        if (s.charAt(0) == '0' && s.length() > 1) 
            return false;
		return Integer.valueOf(s) <= 255;
	}

	public static void main(String[] args) {
		String ip = "010010";
		System.out.println(restoreIpAddresses(ip));
	}
}
