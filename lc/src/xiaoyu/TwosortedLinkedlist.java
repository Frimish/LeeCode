package xiaoyu;

public class TwosortedLinkedlist {
	public static ListNode sort(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (head1 != null && head2 != null) {
			if (head1.value <= head2.value) {
				cur = head1;
				cur = cur.next;
				head1 = head1.next;
			} else {
				cur = head2;
				cur = cur.next;
				head2 = head2.next;
			}
		}
		if (head1 == null) {
			cur = head2;
		}
		if (head2 == null) {
			cur = head1;
		}
		return dummy.next;
	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(7);
		ListNode n4 = new ListNode(9);
		head1.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode head2 = new ListNode(3);
		ListNode m1 = new ListNode(5);
		ListNode m2 = new ListNode(6);
		ListNode m3 = new ListNode(8);
		head2.next = m1;
		m1.next = m2;
		m2.next = m3;
		ListNode newhead = sort(head1, head2);
		print(newhead);

	}
}