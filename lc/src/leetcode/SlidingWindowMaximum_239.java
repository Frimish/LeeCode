package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum_239 {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0)
			return new int[] {};
		Deque<Integer> queue = new LinkedList<Integer>();
		int[] res = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			while (!queue.isEmpty() && (i - queue.peekFirst() >= k))
				queue.pollFirst();
			while (!queue.isEmpty() && (nums[queue.peekLast()] <= nums[i]))
				queue.pollLast();
			queue.offer(i);
			if (i >= k - 1) {
				res[i - k + 1] = nums[queue.peek()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(maxSlidingWindow(new int[] {1, -1}, 1));
	}
}
