package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PartitionLables_763 {
    public static List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) return Collections.emptyList();
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        int[][] pos = new int[s.length() + 1][2];
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	Integer cur = map.get(ch);
        	if (cur == null) {
        		map.put(ch, len);
        		pos[len][0] = i;
        		pos[len][1] = i;
        		len++;
        	} else {
        		pos[cur][1] = i;
        	}
        }
        
        int start = pos[0][0], end = pos[0][1];
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i < len; i++) {
        	int[] cur = pos[i];
        	if (cur[0] > end) {
        		res.add(end - start + 1);
        		start = cur[0];
        		end = cur[1];
        	}
        	else if (cur[1] > end) {
        		end = cur[1];
        	} 
        }
        res.add(end - start + 1);
        return res;
    }
    
    public static void main(String[] args) {
		System.out.println(partitionLabels("eccbbbbdec"));
	}
}
