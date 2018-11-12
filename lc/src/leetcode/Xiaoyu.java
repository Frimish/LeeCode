package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Xiaoyu {
	public static boolean isIsomorphic(String s1, String s2) {
		Map<Character, Character> m = new HashMap<>();
		Map<Character, Character> m2 = new HashMap<>();
		if (s1 == null || s2 == null) {
			return true;
		}
		if (s1.length() != s2.length()) {
			return false;
		}

		for (Integer i = 0; i < s1.length(); i++) {
			if (m.containsKey(s1.charAt(i))) {
				if ((m.get(s1.charAt(i))) != s2.charAt(i)) {
					return false;
				}
			} else {
				if (m2.containsKey(s2.charAt(i))) {
					if ((m2.get(s2.charAt(i))) != s1.charAt(i)) {
						return false;
					}
				}
				;
				m.put(s1.charAt(i), s2.charAt(i));
				m2.put(s2.charAt(i), s1.charAt(i));
			}
		}
		return true;
	}

	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();

		while (n != 1) {
			if (!set.add(n)) {
				return false;
			}
			int a = 0;
			while (n > 0) {
				a += (int) Math.pow(n % 10, 2);
				n = n / 10;
			}
			n = a;

		}

		return true;

	}
	 public ListNode removeElements(ListNode head, int val) {
		 ListNode dummy = new ListNode(0);
		 dummy.next = head;
		 ListNode cur = dummy;
		 while(cur.next!=null) {
			 if(cur.next.val == val) {
				 cur.next = cur.next.next;
			 }else {
				 cur = cur.next;
			 }
			 
		 }
		 
		return dummy.next;
		 
	 }
	 
	 public int binarySearch(int[] nums, int target) {
		 int l = 0, r = nums.length - 1, mid = 0;
		 while (l < r) {
			 mid = (l + r) >> 1;//mid = (l + r) / 2;
		 	 if (nums[mid] == target) return mid;
		 	 if (nums[mid] < target) l = mid + 1;
		 	 else r = mid;
			 
		 }
		 return -1;
	 }

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
}
