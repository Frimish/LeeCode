package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber_179 {
    public static String largestNumber(int[] nums) {
    	List<String> numList = new ArrayList<String>();
    	for (Integer num : nums) {
    		numList.add(String.valueOf(num));
    	}
    	
    	numList.sort(((x, y) -> {
            	String xy = String.valueOf(x) + String.valueOf(y);
            	String yx = String.valueOf(y) + String.valueOf(x);
                return yx.compareTo(xy);
        }));
    	
    	StringBuilder res = new StringBuilder();
    	for (String num : numList) {
    		res.append(num);
    	}
    	return (res.length() != 0 && '0' == res.toString().charAt(0)) ? "0" : res.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(largestNumber(new int[] {0, 0, 1, 5, 21, 3}));
	}
}
