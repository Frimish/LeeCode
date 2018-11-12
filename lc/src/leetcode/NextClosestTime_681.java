package leetcode;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime_681 {
	public static String nextClosestTime(String time) {
		Set<Character> set = new HashSet<Character>();
		for (char c : time.toCharArray()) {
			set.add(c);
		}
		set.remove(':');
		int second = ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 + (time.charAt(3) - '0') * 10
				+ (time.charAt(4) - '0');
		for (int hh = 0; hh < 48; hh++) {
			for (int mm = 0; mm < 60; mm++) {
				int tmp = hh * 60 + mm;
				if (tmp > second && tmp - second <= 24 * 60) {
					if (set.contains((char) (hh % 24 / 10 + '0')) && set.contains((char) (hh % 24 % 10 + '0'))
							&& set.contains((char) (mm / 10 + '0')) && set.contains((char) (mm % 10 + '0'))) {
							return (hh % 24 < 10 ? "0" : "") + hh % 24 + ":" +  (mm < 10 ? "0" : "") + mm;
					}
				}
			}
		}
		return "";
		
	}
	public static void main(String[] args) {
		System.out.println(nextClosestTime("11:11"));
	}
}
