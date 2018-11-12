package leetcode;

import java.util.Stack;

public class BasicCalculator_224 {
	public static int calculate1(String s) {
		Stack<String> nums = new Stack<String>();
		Stack<Character> operator = new Stack<Character>();
		char ch = ' ';
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (ch == ' ')
				continue;
			if (ch == '+' || ch == '-') {
				operator.push(ch);
			}

			if (ch == '(') {
				nums.push("(");
			}
			if (ch == ')') {
				int b = "(".equals(nums.peek()) ? 0 : Integer.valueOf(nums.pop());
				while (!"(".equals(nums.peek())) {
					int a = Integer.valueOf(nums.pop());
					b = operate(a, operator.pop(), b);
				}
				nums.pop();
				
				
				if (!nums.isEmpty() && !nums.peek().equals("(")) {
					int a = Integer.valueOf(nums.pop());
					b = operate(a, operator.pop(), b);
				}
				nums.push(String.valueOf(b));
			}
			if (Character.isDigit(ch)) {
				int b = 0;
				while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ') ) {
					if (s.charAt(i) != ' ') {
						b = b * 10 + s.charAt(i) - '0';
					}
					i++;
				}
				i--;

				if (!nums.isEmpty() && !nums.peek().equals("(")) {
					int a = Integer.valueOf(nums.pop());
					b = operate(a, operator.pop(), b);
				}
				nums.push(String.valueOf(b));

			}

		}
		int b = Integer.valueOf(nums.pop());
		while (!nums.isEmpty()) {
			b = operate(Integer.valueOf(nums.pop()), operator.pop(), b);
		}
		return b;
	}

	private static int operate(int a, Character op, int b) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		default:
			return 0;
		}
	}
	
    public static int calculate(String s) {
        int len = s.length(), res = 0, sign = 1;
        Stack<Integer> stack  = new Stack<>();
        for (int i = 0 ; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    sum += sum * 10 + s.charAt(i) - '0';
                }
                res += sum * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0; 
                sign = 1;
            } else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(calculate("2147483647"));
	}
}
