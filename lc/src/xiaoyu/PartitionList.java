package xiaoyu;

public class PartitionList {
	public static ListNode partition(ListNode head, int target) {
		ListNode dummy1 = new ListNode(0);
		ListNode cur1 = dummy1;
		ListNode dummy2 = new ListNode(0);
		ListNode cur2 = dummy2;
		ListNode cur = head;
		while (cur != null) {
			if (cur.value <= target) {
				cur1.next = cur;
				cur1 = cur1.next;
			} else {
				cur2.next = cur;
				cur2 = cur2.next;
			}
			cur = cur.next;
		}
		cur1.next = dummy2.next;
		cur2.next = null;
		return dummy1.next;
	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode n1 = new ListNode(8);
		ListNode n2 = new ListNode(6);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(2);
		head1.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		int target = 5;
		ListNode newhead = partition(head1, 5);
		print(newhead);
	}

}