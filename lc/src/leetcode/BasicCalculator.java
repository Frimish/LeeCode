package leetcode;

import java.util.Stack;

public class BasicCalculator {
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		char[] c = s.toCharArray();
		char sign = '+';
		int num = 0;
		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i])) {
				num = num * 10 + c[i] - '0';
			} 
			if (!Character.isDigit(c[i]) && c[i] != ' ' || i == c.length - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = c[i];
				num = 0;
			}
		}
		num = 0;
		while (!stack.isEmpty()) {
			num += stack.pop();
		}
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(calculate("3+2*2"));
	}
}

