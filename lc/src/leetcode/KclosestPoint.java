package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KclosestPoint {
	
	   static class Point {
	       int x;
	       int y;
	       int disTotargetSqaure;
	       public Point(int x, int y) {
	           this.x = x;
	           this.y = y;
	       }
	   }
	    
	   
	   //maxHeap solution, O(nlogk) time, O(k) space
	   private static Point[] findKClosestPoints(Point[] points, int k, Point target) {
	       if (points == null || points.length == 0 || k < 1 || k > points.length) {
	           return points;
	       }
	       for (Point pt : points) {
	    	   pt.disTotargetSqaure = getDistance(pt, target);
	       }
	       
	       Queue<Point> maxHeap = new PriorityQueue<>(k, (x, y) -> y.disTotargetSqaure - x.disTotargetSqaure);
	       for (Point point : points) {
	           if (maxHeap.size() < k) {//put k points to heap
	               maxHeap.offer(point);
	               continue;
	           }
	           if (maxHeap.peek().disTotargetSqaure > point.disTotargetSqaure) {
	               maxHeap.poll();//if maxHeap's point's distance is far from target than point
	               maxHeap.offer(point);
	           }
	       }
	       Point[] res = new Point[k];
	       for (int i = k - 1; i >= 0; i--) {//it's index, so it should start from k - 1 !!!
	           res[i] = maxHeap.poll();
	       }
	       return res;
	   }

	   //QuickSelect solution, average O(n) time(O(n + klogk) time if output is sorted), worst case O(n^2) time, O(1) space
	   private static Point[] findKClosestPoints1(Point[] points, int k, Point target) {
	       //for the quickSelect solution, if we don't have Double dis, we use getDis() to get the dis of points
	       if (points == null || points.length == 0 || k < 1 || k > points.length) {
	           return points;
	       }
	       int left = 0;
	       int right = points.length - 1;
	       while (left <= right) {
	           int pos = findKthSmallest(points, left, right);
	           if (pos == k) break;
	           if (pos < k) {
	        	   left = pos + 1;
	           } else {
	        	   right = pos - 1;
	           }
	       }
	       Point[] res = new Point[k];
	       for (int i = 0; i < k; i++) {
	           res[i] = points[i];
	       }
	       //if the output should be sorted in acsending order, add the code below, which is O(klogk) time
	       //Arrays.sort(res);
	       return res;
	   }

	   private static int findKthSmallest(Point[] points, int l, int r) {
	     
	       Point pivot = points[l];
	       while (l < r) {
	           while (l < r && points[r].disTotargetSqaure >= pivot.disTotargetSqaure) 
	        	   r--;
	           points[l] = points[r];
	           while (l < r && points[l].disTotargetSqaure <= pivot.disTotargetSqaure) 
	        	   l++;
	           points[r] = points[l];
	       }
	       points[l] = pivot;
	       return l;
	   }

	   private static int getDistance(Point p, Point target) {
	       return (p.x - target.x) * (p.x - target.x) + (p.y - target.y) * (p.y - target.y);
	   }

	   private static void swap(Point[] points, int left, int right) {
	       Point temp = points[left];
	       points[left] = points[right];
	       points[right] = temp;
	   }
	   
	   public static void main(String[] args) {
		   Point[] p = new Point[5];
		   p[0] = new Point(4, 6);
		   p[1] = new Point(4, 7);
		   p[2] = new Point(4, 4);
		   p[3] = new Point(2, 5);
		   p[4] = new Point(1, 10);
		   Point targetP = new Point(0, 0);
		   findKClosestPoints(p, 2, targetP);
		   findKClosestPoints1(p, 2, targetP);
	   }

}