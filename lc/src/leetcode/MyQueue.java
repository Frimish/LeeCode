package leetcode;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> input = null;
	Stack<Integer> output = null;

	public MyQueue() {
		input = new Stack<Integer>();
		output = new Stack<Integer>();
	}

	public void push(int x) {
		input.push(x);
	}

	public int pop() {
		peek();
		return output.pop();
	}

	public int peek() {
		if (output.empty())
			while (!input.empty())
				output.push(input.pop());
		return output.peek();
	}

	public boolean empty() {
		return input.empty() && output.empty();
	}
}
