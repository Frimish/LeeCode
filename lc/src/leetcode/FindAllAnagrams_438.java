package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams_438 {
	/**
	 * 
	* TODO
	* @Title: findAnagrams 
	* @param s
	* @param p
	* @return   
	* @return List<Integer>  
	* @throws
	 */
	public static List<Integer> findAnagrams(String s, String p) {
		if (s.isEmpty())
			return Collections.emptyList();
		List<Integer> res = new ArrayList<Integer>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : p.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int l = 0, r = 0, need = map.size();
		while (r < s.length()) {
			char c = s.charAt(r);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					need--;
			}
			r++;
			while (need == 0) {
				char tempc = s.charAt(l);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0) {
						need++;
					}
				}
				if (r - l == p.length()) {
					res.add(l);
				}
				l++;
			}
		}

		return res;
	}
	
    public static List<Integer> findAnagrams1(String s, String p) {
//        List<Integer> res = new ArrayList<>();
//        if (s == null || p == null) return res;
//
//        // total number of character in p to be contained in s
//        int countToBeContained = p.length();
//        // calculate the number of each character to be contained in S
//        int[] dict = new int[128];
//        for (char c : p.toCharArray()) dict[c]++;
//        
//        int slow = 0, fast = 0;
//        while (fast < s.length()) {
//            // if the character needs to be contained, include it and minus the counter
//            if (dict[s.charAt(fast++)]-- > 0) countToBeContained--;
//            
//            // all included, move the slow pointer to minimize the window
//            while (countToBeContained == 0) {
//                // current window contains same number of the current character as in p, cannot move forward anymore
//                if (dict[s.charAt(slow++)]++ == 0) {
//                    // if the window size is same as p, an anagram is found
//                    if (fast - slow + 1 == p.length()) res.add(slow - 1);
//                    countToBeContained++;
//                }
//            }
//        }
//        return res;
    	
        if (s == null || p == null) return Collections.emptyList();
        int[] count = new int[128];
        for (char c : p.toCharArray()) {
            count[c]++;
        }
        int counter = p.length(), l = 0, r = 0;
        List<Integer> res = new ArrayList<>();
        while (r < p.length()) {
            if (count[s.charAt(r++)]-- > 0) counter--;
            while (counter == 0) {
                if (count[s.charAt(l++)]++ == 0) {
                	counter ++;
                	if (r - l + 1 == p.length()) res.add(l - 1);
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(findAnagrams1("eabeabe", "ab"));
	}
}
