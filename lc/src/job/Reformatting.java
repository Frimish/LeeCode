package job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reformatting {
	
	static Map<String, String> month = new HashMap<String, String>() {{
		put("Jan","01"); put("Feb","02"); put("Mar","03");
		put("Apr","04"); put("May","05"); put("Jun","06");
		put("Jul","07"); put("Aug","08"); put("Sep","09");
		put("Oct","10"); put("Nov","11"); put("Dec","12");
	}};
    static List<String> reformatDate(List<String> dates) {
        if (dates == null || dates.size() == 0) return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        for (String date : dates) {
            String[] s = date.split(" ");
            String y = s[2];
            String m = month.get(s[1]);
            String d = (s[0].length() == 3 ? "0" : "") + s[0].substring(0, s[0].length() -2);
            res.add(y + "-" + "-" + d);
        }
        return res;
    }
	
	public static void main(String[] args) {
	}
}
