package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate_217 {
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> numbers = new HashSet<>();
		
		
		for (int n : nums) {
			if (!numbers.add(n))
				return true;

		}
		return false;
	}
	
	public static void main(String[] args) {
//		System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
		Map<Integer,Integer>m = new HashMap<Integer,Integer>();
		System.out.println(m.put(1, 1));
		System.out.println(m.put(1, 2));
	}
}
