package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolish_Notation_150 {
	
	private Set<String> operators = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));
	
	interface Operate {
		int operate(int x, int y);
	}
	
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(Integer.valueOf(token));
			} else {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(generate(token).operate(x, y));
			}
		}
		return stack.pop();
		
	}
	private Operate generate(String token) {
		Operate op = null;
		switch (token) {
		case "+":
			op = (x, y) -> x + y;
			break;
		case "-":
			op = (x, y) -> x - y;
			break;
		case "*":
			op = (x, y) -> x * y;
			break;
		case "/":
			op = (x, y) -> x / y;
			break;
		}
		return op;
	}
	
	public static void main(String[] args) {
		
	}
}
