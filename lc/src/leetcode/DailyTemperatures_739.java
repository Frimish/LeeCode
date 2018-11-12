package leetcode;

import java.util.Stack;

public class DailyTemperatures_739 {
    public static int[] dailyTemperatures(int[] T) {
        if (T.length == 0) return new int[]{};
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.empty() && T[i] >= T[stack.peek()]) stack.pop();
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
    
    public static void main(String[] args) {
		System.out.println(dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73}));
	}
}
