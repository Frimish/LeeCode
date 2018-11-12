package leetcode;

public class FindtheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        
        int i = 0; 
        // to ensure each number has been placed at the supposed position
        while (i < nums.length) {
        	// if the number is at the supposed position
        	if (nums[i] == i + 1) {
        		i++;
        		continue;
        	} 
        	// if the supposed position has been placed the same number, this number is the duplicate one
        	if (nums[i] == nums[nums[i] - 1]) {
        		return nums[i];
        	} 
        	// place the number to the supposed position
        	swap(nums, i, nums[i] - 1);
        }
        
        return 0;
        
    }
    private void swap(int[] nums, int i, int j) {
    	nums[i] ^= nums[j];
    	nums[j] ^= nums[i];
    	nums[i] ^= nums[j];
    }
}
