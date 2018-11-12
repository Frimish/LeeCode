package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations_254 {
    
    private static List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public static List<List<Integer>> getFactors(int n) {
        if (n < 2) return res;
        helper(res, new ArrayList<Integer>(), 2, n);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> tmp, int start, int remains) {
        if (remains == 1) 
        {
            return;
        }
        for (int i = start; i <= remains; i++) {
            if (remains % i == 0 && remains / i >= i) {
                tmp.add(i);
                tmp.add(remains / i);
                res.add(new ArrayList<Integer>(tmp));
                tmp.remove(tmp.size() - 1);
                helper(res, tmp, i, remains / i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> res = getFactors(32);
    	for (List<Integer> list : res) {
    		System.out.println(list);
    	}
		
	}
}
