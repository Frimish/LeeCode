package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ThirdMaximumNumber_414 {
    public static int thirdMax(int[] nums) {
        if (nums == null || nums.length ==0) return 0;
        Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int x : nums) {
        	queue.offer(x);
        }
        if (queue.size() < 3) return queue.peek();
        int a = queue.poll();
        int b = queue.poll();
        while (!queue.isEmpty() && (b == a)) {
        	b = queue.poll();
        }
        if (queue.isEmpty()) return a;
        
        int c = queue.poll();
        while (!queue.isEmpty() && (c == b)) {
        	c = queue.poll();
        }
        if (c == b) return a;

        return c;
    }
    
    
    public static void main(String[] args) {
		System.out.println(thirdMax(new int[] {2, 2, 3}));
	}
}
