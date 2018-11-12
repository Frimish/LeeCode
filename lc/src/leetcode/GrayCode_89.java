package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
    public static List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
        	res.add(i ^ i >> 1);
        }
        return res;
    }
    
    public static void main(String[] args) {
		System.out.println(grayCode(2));
	}
    
}
