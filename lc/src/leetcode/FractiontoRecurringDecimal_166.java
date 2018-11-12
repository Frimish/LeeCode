package leetcode;

import java.util.HashMap;

public class FractiontoRecurringDecimal_166 {
    public static String fractionToDecimal(int numerator, int denominator) {
    	if (numerator == 0) {
    		return "0";
    	}
	    StringBuilder res = new StringBuilder();
	    // "+" or "-"
	    res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
	    long num = Math.abs((long)numerator);
	    long den = Math.abs((long)denominator);
	    
	    // integral part
	    res.append(num / den);
	    num %= den;
	    if (num == 0) {
	        return res.toString();
	    }
	    
	    // fractional part
	    res.append(".");
	    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
	    map.put(num, res.length());
	    while (num != 0) {
	    	num = num * 10;
	    	res.append(num / den);
	    	num = num % den;
	    	Integer index = map.put(num, res.length());
	    	if (index != null) {
	    		res.insert(index, "(").append(")");
	    		return res.toString();
	    	}
	    }
	    return res.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(fractionToDecimal(1, 333));
	}
}
