package leetcode;

import java.util.Stack;

public class MinStack {
		Stack<Integer> stack = null;
		Stack<Integer> min = null;
	    public MinStack() {
	    	stack = new Stack<Integer>();
	    	min = new Stack<Integer>();
	    }
	    
	    public void push(int x) {
	        stack.push(x);
	        min.push(min.isEmpty() ? x : Math.min(x, min.peek()));
	        
	    }
	    
	    public void pop() {
	        stack.pop();
	        min.pop();
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int getMin() {
	        return min.peek();
	    }
}
