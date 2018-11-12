package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

		int[] inNum = new int[numCourses];
		int[] outNum = new int[numCourses];
		int[][] out = new int[numCourses][numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			inNum[prerequisites[i][0]]++;
			out[prerequisites[i][1]][outNum[prerequisites[i][1]]] = prerequisites[i][0];
			outNum[prerequisites[i][1]]++;
		}
		
		int[] visited = new int[numCourses];
		int count = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inNum[i] == 0) {
				queue.offer(i);
				visited[count] = i;
				count ++;
			}
		}
		
		while (queue.size() > 0) {
			int cur = queue.poll(); 
			for (int i = 0; i < outNum[cur]; i++) {
				inNum[out[cur][i]]--;
				if (inNum[out[cur][i]] == 0) {
					queue.offer(out[cur][i]);
					visited[count] = out[cur][i];
                    count++;
				}
			}
		}
		return count == numCourses ? visited : new int[] {};
    }
}
