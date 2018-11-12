package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight_406 {
	public static int[][] reconstructQueue(int[][] people) {
		if (people.length == 0 || people[0].length == 0) return people;
		Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < people.length; i++) {
			list.add(people[i][1], people[i]);
		}
		return list.toArray(new int[people.length][people[0].length]);
	}
	
	public static void main(String[] args) {
		System.out.println(reconstructQueue(new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}));
	}
}
