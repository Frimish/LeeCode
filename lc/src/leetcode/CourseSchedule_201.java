package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class CourseSchedule_201 {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		int[] inNum = new int[numCourses];
		int[] outNum = new int[numCourses];
		int[][] out = new int[numCourses][numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			inNum[prerequisites[i][1]]++;
			out[prerequisites[i][0]][outNum[prerequisites[i][0]]] = prerequisites[i][1];
			outNum[prerequisites[i][0]]++;
		}
		
		int count = numCourses;
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inNum[i] == 0) {
				queue.offer(i);
				count --;
			}
		}
		
		while (queue.size() > 0) {
			int cur = queue.poll(); 
			for (int i = 0; i < outNum[cur]; i++) {
				inNum[out[cur][i]]--;
				if (inNum[out[cur][i]] == 0) {
					queue.offer(out[cur][i]);
					count --;
				}
			}
		}
		return count == 0 ? true : false;
	}
	
	public static boolean canFinish2(int numCourses, int[][] prerequisites) {

		int[] inNum = new int[numCourses];
		Map<Integer, List<Integer>> out = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			out.put(i, new ArrayList<Integer>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			inNum[prerequisites[i][1]]++;
			List<Integer> list = out.get(prerequisites[i][0]);
			list.add(prerequisites[i][1]);
			out.put(prerequisites[i][0], list);
		}
		
		Iterator<Map.Entry<Integer, List<Integer>>> entries = out.entrySet().iterator();
		
		while (entries.hasNext()) {
			Map.Entry<Integer, List<Integer>> entry = entries.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		for (Map.Entry<Integer, List<Integer>> entry : out.entrySet()) {
		}
		
		while (out.size() > 0) {
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] {{1, 0},{0,1}}));
	}
}
