//here we have to find the min difference between highest and lowest of k 
import java.util.*;
class minDiff {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min= Integer.MAX_VALUE;
        if(nums.length == 0) return 0;
        for(int i = 0;i+k-1<nums.length;i++){
                int diff = nums[i+k-1] - nums[i];
                int high = nums[i + k - 1];
                int low = nums[i];
                min = Math.min(min, high - low);
                if(min == 0) return 0;
        }
        return min;
    }
    public static void main(String[] args){
        minDiff obj = new minDiff();
        int[] nums = {9,4,1,7};
        int k = 2;
        int result = obj.minimumDifference(nums, k);
        System.out.println("Minimum difference: " + result);
    }
}
