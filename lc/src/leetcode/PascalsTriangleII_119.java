package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleII_119 {
    public static List<Integer> getRow(int n) {
		if (n < 0)
			return Collections.emptyList();
		List<Integer> row = new ArrayList<Integer>();
		long tmp = 0;
		row.add(1);
		for (int i = 1; i < n + 1; i++) {
			tmp = ((long)row.get(i - 1)) * (n - i + 1) / i;
			row.add((int)tmp);
		}
		
		return row;
    }
    public static void main(String[] args) {
		System.out.println(getRow(33));
	}
}
