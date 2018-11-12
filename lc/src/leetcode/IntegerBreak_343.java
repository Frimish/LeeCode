package leetcode;

public class IntegerBreak_343 {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        return helper(n);
    }
    private int helper(int n){
        if (n == 2) return 2;
        if (n == 3) return 3;
        if (n == 4) return 4;
        return helper(n - 3) * 3; 
    }
}
