package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappeared_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            while(nums[i] != i + 1 && nums[i] != nums[nums[i]-1]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != i + 1){
                res.add(i + 1);
            }
        }
        return res;
    }
}
