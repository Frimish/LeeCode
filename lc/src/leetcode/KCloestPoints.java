package leetcode;

public class KCloestPoints {

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public int[][] findKClosetPoints(int[][] pts, int k) {
		int l = 0, r = pts.length - 1;
		Point[] points = new Point[pts.length];
		for (int i = 0; i < pts.length; i++) {
			points[i].x = pts[i][0];
			points[i].y = pts[i][1];
		}
		while (l <= r) {
			int mid = partion(points, l, r);
			if (mid == k) break;
			if (mid < k) l = mid + 1;
			else r = mid - 1;
		}
		int[][] res = new int[k][2];
		for (int i = 0; i < k; i++) {
			res[i][0] = points[i].x;
			res[i][1] = points[i].y;
		}
		return res;
	}
	
	private int partion(Point[] points, int l, int r) {
		Point pviot = points[l];
		while (l < r) {
			while (l < r && compare(points[r], pviot) >= 0) r--;
			points[l] = points[r];
			while (l < r && compare(points[l], pviot) <= 0) l++;
			points[r] = points[l];
		}
		points[l] = pviot;
		return l;
	}
	
	private int compare(Point px, Point py) {
		return (px.x * px.x + px.y * px.y) - (py.x * py.x + py.y * py.y);
	}
}
