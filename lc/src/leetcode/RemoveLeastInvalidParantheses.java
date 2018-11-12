package leetcode;

import java.util.Stack;

public class RemoveLeastInvalidParantheses {
	public String removeLeastInvalidParantheses(String st) {
		char left = '(', right = ')';
		st = remove(st, left, right).reverse().toString();
		return remove(st, right, left).reverse().toString();
	}
	
	private StringBuilder remove(String st, char left, char right) {
		int leftCounter = 0;
		StringBuilder sb = new StringBuilder();
		for (char c : st.toCharArray()) {
			if (c == left) {
				leftCounter++;
				sb.append(left);
			} else if (c == right && leftCounter > 0) {
				leftCounter--;
				sb.append(right);
			} else if (c != left && c != right) {
				sb.append(c);
			}
		}
		return sb;
	}
	
	public String removeLeastInvalidParantheses1(String st) {
		char left = '(', right = ')';
		int leftCounter = 0, rightCounter = 0;
		Stack<Character> stack = new Stack<Character>();
		for (char c : st.toCharArray()) {
			if (c == left) {
				stack.push(left);
				leftCounter++;
			} else if (c == right && rightCounter < leftCounter) {
				stack.push(right);
				rightCounter++;
			} else if (c != left && c != right) {
				stack.push(c);
			}
		}
		leftCounter = 0;
		rightCounter = 0;
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			char c = stack.pop();
			if (c == right) {
				sb.append(c);
				rightCounter++;
			} else if (c == left && rightCounter > leftCounter) {
				sb.append(c);
				leftCounter++;
			} else if (c != left && c != right) {
				sb.append(c);
			}
		} 
		return sb.reverse().toString();
	}
	
    public static void main(String[] arg) {
        RemoveLeastInvalidParantheses a = new RemoveLeastInvalidParantheses();
        System.out.println(a.removeLeastInvalidParantheses("((a)))"));
        System.out.println(a.removeLeastInvalidParantheses("(((a))"));
        System.out.println(a.removeLeastInvalidParantheses("())(((a))"));
        System.out.println(a.removeLeastInvalidParantheses("()((a)))"));
        System.out.println(a.removeLeastInvalidParantheses("()"));
    }
}
