package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public static List<List<String>> groupStrings(String[] strings) {
        if (strings.length == 0) 
            return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s :strings) {
            if (s.length() == 0) {
                map.put("", Arrays.asList(""));
                continue;
            }
            int offset = 'a' - s.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append((char)((c - 'a' + offset + 26) % 26 + 'a'));
            }
            String weaver = sb.toString();
            List<String> list = map.getOrDefault(weaver, new ArrayList<String>());
            list.add(s);
            map.put(weaver, list);
        }
        return new ArrayList(map.values());
    }
    
    public static void main(String[] args) {
		System.out.println(groupStrings(new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
	}
}
