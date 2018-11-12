package leetcode;

public class DivideTwoInteger {
    public static int divide(int divd, int divs) {
        long sign = ((divd < 0) ^  
                     (divs < 0)) ? -1 : 1; 
        // remove sign of operands 
        long dividend = Math.abs(divd); 
        long divisor = Math.abs(divs); 

        if (divd == Integer.MIN_VALUE) {
        	dividend = Integer.MAX_VALUE;
        	dividend++;
        }
        
        
        // Initialize the quotient 
        long quotient = 0, temp = 0; 

        // test down from the highest  
        // bit and accumulate the  
        // tentative value for 
        // valid bit 
        for (int i = 31; i >= 0; --i)  
        { 

            if (temp + (divisor << i) <= dividend)  
            { 
                temp += divisor << i; 
                quotient |= 1 << i; 
            } 
        } 

        return (int)(sign * quotient); 
    }
    
    public static void main(String[] args) {
		System.out.println(divide(-2147483648,
				-1));
	}
}
