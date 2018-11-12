package leetcode;

public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode curA = headA, curB = headB;
		int countA = 0, countB = 0;
		while (curA != curB) {
			if (countA > 1 && countB > 1)
				return null;
			if (curA == null) {
				curA = headB;
				countA++;
			} else {
				curA = curA.next;
			}
			if (curB == null) {
				curB = headA;
				countB++;
			} else {
				curB = curB.next;
			}
		}

		return curA;

	}
}
