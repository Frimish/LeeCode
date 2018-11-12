package leetcode;

public class SingleNumberII_137 {
    public static int singleNumber(int[] nums) {
        int res = 0, sum = 0;
        for (int i = 0; i< 32; i++) {
        	sum = 0;
        	for (int j = 0; j < nums.length; j ++) {
        		sum = (sum + ((nums[j] >> i) & 1)) % 3;
        	}
        	if (sum != 0) {
        		res = res + (1 << i);
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
		int[] nums = new int[] {2,2,3,2};
		System.out.println(singleNumber(nums));
	}
}
