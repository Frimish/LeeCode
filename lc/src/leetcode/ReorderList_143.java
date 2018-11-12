package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList_143 {
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<ListNode>();
        ListNode cur = head;
        while (cur != null) {
        	deque.offerLast(cur);
        	cur = cur.next;
        }
       
        cur = deque.pollFirst();
        ListNode next = null;
        boolean pollHead = false;
        while (!deque.isEmpty()) {
        	if (pollHead) {
        		next = deque.pollFirst();
        	} else {
        		next = deque.pollLast();
        	}
        	cur.next = next;
        	cur = next;
        	pollHead = !pollHead;
        }
        if (cur != null) {
            cur.next = null;
        }
    }
}
