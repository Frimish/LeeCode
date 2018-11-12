package twilio;

import java.util.HashMap;
import java.util.Map;

public class Reformatting {
	
	static Map<String, String> month = new HashMap<String, String>() {{
		put("Jan","01"); put("Feb","02"); put("Mar","03");
		put("Apr","04"); put("May","05"); put("Jun","06");
		put("Jul","07"); put("Aug","08"); put("Sep","09");
		put("Oct","10"); put("Nov","11"); put("Dec","12");
	}};
	public static String[] reformattingDates(String[] dates) {
		if (dates == null || dates.length == 0) return new String[] {};
		String[] res = new String[dates.length];
		for (int i = 0; i < dates.length; i++) {
			String[] s = dates[i].split(" ");
			String y = s[2];
			String m = month.get(s[1]);
			String d = (s[0].length() == 3 ? "0" : "") + s[0].substring(0, s[0].length() - 2);
			res[i] = y + "-" + m + "-" +d;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] res = reformattingDates(new String[] {"1st Mar 1984", "2nd Feb 2013", "04th Apr 1900"});
		for (String date : res) {
			System.out.println(date);
		}
	}
}
