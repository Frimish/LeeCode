package leetcode;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray_581 {
	public static int findUnsortedSubarray(int[] nums) {
		int[] tmp = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		tmp[i] = nums[i];
    	}
        Arrays.sort(nums);
        int count = nums.length;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != tmp[i]) {
        		count = i;
        		break;
        	}
        }
        
        for (int j = nums.length - 1; j > count - 1; j--) {
        	if (nums[j] != tmp[j]) {
        		count += (nums.length - j - 1);
        		break;
        	}
        }
        
        return nums.length - count;
    }
	
	public static void main(String[] args) {
		System.out.println(findUnsortedSubarray(new int[] {}));
	}
}
