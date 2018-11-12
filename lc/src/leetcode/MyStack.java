package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

	Queue<Integer> queue;

	/** Initialize your data structure here. */
	public MyStack() {
		queue = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		for (int i = 0; i < queue.size() - 1; i++)
			queue.add(queue.remove());
		return queue.remove();
	}

	/** Get the top element. */
	public int top() {
		int t = pop();
		queue.add(t);
		return t;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}
}
