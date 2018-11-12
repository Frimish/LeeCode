package job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tracker {

    public static Integer nextServerNumber(List<Integer> list) {
        if (list.size() == 0) return 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int x : list) {
            set.add(x);
        }
        for (int i = 1; i <= list.size(); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return list.size() + 1;
    }
    private static Map<String, List<Integer>> map = new HashMap<>();
    public static String allocate(String hostType) {
        Integer id = 1;
        List<Integer> list = map.get(hostType);
        if (list != null) {
            id = nextServerNumber(list);
            list.add(id);
            map.put(hostType, list);
        } else {
            list = new ArrayList<>();
            list.add(id);
            map.put(hostType, list);
        }
        return hostType + id;
    }

    public static void deallocate(String hostName) {
    	int pos = 0;
    	hostName = hostName.trim();
        for (; pos <  hostName.length(); pos++) {
        	if (Character.isDigit(hostName.charAt(pos))) {
        		break;
        	}
        }
        String hostType = hostName.substring(0, pos);
        int id = Integer.valueOf(hostName.substring(pos));
        if (!map.containsKey(hostType)) {
        	return;
        } else {
        	 List<Integer> list = map.get(hostType);
        	 int idx = list.indexOf(id);
        	 list.remove(idx);
        	 map.put(hostType, list);
        }
    }
}
