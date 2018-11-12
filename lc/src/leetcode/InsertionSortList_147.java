package leetcode;

public class InsertionSortList_147 {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while (cur.next != null) {
        	ListNode tmp = cur.next.next;
        	ListNode idx = dummy;
        	while (cur.val > idx.next.val) {
        		idx = idx.next;
        	}
        	if (idx != cur) {
        		cur.next = idx.next;
        		idx.next = cur;
        	}
        	cur = tmp;
        }
        return dummy.next;
    }
    
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(8);
		ListNode node6 = new ListNode(0);
		ListNode node7 = new ListNode(7);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		ListNode node = insertionSortList(node1);
		
		print(node);
	}

	private static void print(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
