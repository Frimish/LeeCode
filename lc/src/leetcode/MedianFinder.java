package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
	
	Queue<Integer> leftQueue;
	Queue<Integer> rightQueue;
	
    /** initialize your data structure here. */
    public MedianFinder() {
    	leftQueue = new PriorityQueue<Integer>();
    	rightQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
    	leftQueue.add(num);
    	rightQueue.add(leftQueue.poll());
    	if (rightQueue.size() > leftQueue.size()) {
    		leftQueue.add(rightQueue.poll());
    	}
    }
    
    public double findMedian() {
        if (leftQueue.size() == rightQueue.size()) {
        	return (leftQueue.peek() + rightQueue.peek()) / 2.0;
        } 
        return leftQueue.peek();
    }
}
