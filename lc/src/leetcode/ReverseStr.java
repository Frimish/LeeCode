package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseStr {
	public static String revesrStr(String s) {
		if (s.length() == 0)
			return "";
		List<String> slist = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			int start = i;
			while (i < s.length() && Character.isLetter(s.charAt(i))) {
				i++;
			}
			slist.add(s.substring(start, i));
			if (i == s.length()) break;
			if (s.charAt(i) != ' ') {
				slist.add(s.substring(i, i + 1));
				i++;
			}
			i++;
		}
		int l = 0, r = slist.size() - 1;
		while (l < r) {
			while (l < r && !Character.isLetter(slist.get(l).charAt(0))) {
				l++;
			}
			while (l < r && !Character.isLetter(slist.get(r).charAt(0))) {
				r--;
			}
			Collections.swap(slist, l, r);
			l++;
			r--;
		}
		StringBuilder sb = new StringBuilder();
		for (String st : slist) {
			sb.append(st);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(revesrStr("Hi, nice to see you."));
		
	}
}
