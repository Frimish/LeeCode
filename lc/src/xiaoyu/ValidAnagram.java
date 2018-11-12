package xiaoyu;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	 public boolean isAnagram(String s, String t) {
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        for(int i = 0; i<s.length(); i++) {
	        	if(!map.containsKey(s.charAt(i))) {
	        		map.put(s.charAt(i), 1);
	        	}else {
	        		map.put(s.charAt(i), map.get(s.charAt(i))+1);
	        	}
	        }
	        for(int j = 0; j< t.length(); j++) {
	        	if(map.containsKey(t.charAt(j))){
	        		map.put(s.charAt(j),map.get(s.charAt(j))-1);
	        		
	        	}else {
	        		return false;
	        	}
	        }
			return false;
	    }
}
