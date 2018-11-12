package leetcode;

public class ReverseLinkedListII_92 {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m >= n) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode startp = newHead;
        ListNode curp = head;
        
        for (int i = 1; i < m; i++) {
        	startp = startp.next;
        	curp = curp.next;
        }
        
        ListNode nextp = curp.next;
        ListNode prep = startp;
        for (int i = m; i <= n; i++) {
        	curp.next = prep;
        	prep = curp;
        	curp = nextp;
        	if (nextp != null)
        		nextp = nextp.next;
        }
        
        startp.next.next = curp;
        startp.next = prep;
        
        return newHead.next;
    }
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		ListNode node = reverseBetween(node1, 2, 3);
		
		print(node);
	}

	private static void print(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
