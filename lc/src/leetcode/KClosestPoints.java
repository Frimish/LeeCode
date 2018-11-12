package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPoints {

	// heap better
	// O(N lg K) running time + O(K) memory
	public List<Point> getKClosest(List<Point> points, int k) {
		if (points == null || points.size() == 0) {
			return new ArrayList<>();
		}
		for (Point p : points) {
			p.dis = distance(p);
		}
		Queue<Point> heap = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				return b.dis - a.dis;
			}
		});
		
		for (Point p : points) {
			if (heap.size() < k) {
				heap.offer(p);
			} else {
				if (heap.peek().dis > p.dis) {
					heap.poll();
					heap.offer(p);
				}
			}
			
		}
		List<Point> res = new ArrayList<>();
		while (!heap.isEmpty()) res.add(heap.poll());
		Collections.reverse(res);
		return res;
	}

	public int distance(Point p) {
		return (int) Math.sqrt(p.x * p.x + p.y * p.y);
	}

	private static class Point {
		int x;
		int y;
		int dis;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	public static void main(String[] args) {
		List<Point> points = new ArrayList<Point>();
		KClosestPoints a = new KClosestPoints();
		points.add(new Point(1, 1));
		points.add(new Point(1, 2));
		points.add(new Point(2, 1));
		points.add(new Point(3, 1));
		points.add(new Point(1, 4));
		points.add(new Point(-4, 1));
		points.add(new Point(-5, -5));
		List<Point> result = a.getKClosest(points, 3);
		for (Point p : result) {
			System.out.println(p);
		}
	}

}