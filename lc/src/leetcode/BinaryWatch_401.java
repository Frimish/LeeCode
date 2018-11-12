package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch_401 {
	public static List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<String>();
		for (int h = 0; h <12; h++) {
			for (int m = 0; m < 60; m++) {
				if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
					res.add(new StringBuilder(h + ":" + m / 10 + m % 10).toString());
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(readBinaryWatch(2));
	}
}
