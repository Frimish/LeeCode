package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private int capacity;
	private int size;
	private Map<Integer, Node> cache = new HashMap<Integer, Node>();
	private Node head, tail;
	
	class Node {
		
		public int val;
		public int key;
		public Node(int key, int val) {
			this.val = val;
			this.key = key;
		}
		public Node pre;
		public Node succ;
		
	}
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    	head = new Node(0, 0);
    	head.pre = null;
    	
    	tail = new Node(0, 0);
    	tail.succ = null;
    	
    	head.succ = tail;
    	tail.pre = head;
    }
    
    public int get(int key) {
    	Node cur = cache.get(key);
    	if (cur != null) {
    		moveToHead(cur);
    		return cur.val;
    	}
    	return -1;
    }

	public void put(int key, int val) {
		Node cur = cache.get(key);
		if (cur == null) {
			cur = new Node(key, val);
			cache.put(key, cur);
			addToHead(cur);
			size ++;
			if (size > capacity) {
				cache.remove(tail.pre.key);
				remove(tail.pre);
				size --;
			}
		} else {
			cur.val = val;
			moveToHead(cur);
		}
    }
    
    private void moveToHead(Node cur) {
		remove(cur);
		addToHead(cur);
	}

	private void remove(Node cur) {
		Node p = cur.pre;
		Node s = cur.succ;
		p.succ = s;
		s.pre = p;
	}
	
	private void addToHead(Node cur) {
		cur.succ = head.succ;
		cur.pre = head;
		head.succ.pre = cur;
		head.succ = cur;
	}
    
}
