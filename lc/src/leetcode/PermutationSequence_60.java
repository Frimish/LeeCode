package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_60 {
    public static String getPermutation(int n, int k) {
       if (n <= 0 || k <=0) return "";
       int mul = 1;
       List<Integer> elements = new ArrayList<Integer>();
       for (int i = 1; i <= n; i++) {
    	   mul *= i;
    	   elements.add(i); 
       }
       StringBuilder res = new StringBuilder();
       while (!elements.isEmpty()) {
    	   int index = (k - 1) / (mul / n);
    	   res.append(elements.remove(index));
    	   k -= index * (mul / n);
    	   mul /= n;
    	   n--;
       }
       return res.toString();
    }
    public static void main(String[] args) {
//    	for (int i = 1; i <= 24; i++) {
//    		System.out.println(getPermutation(4, i));	
//    	}
    	System.out.println(getPermutation(9, 100000));	
	}
}
