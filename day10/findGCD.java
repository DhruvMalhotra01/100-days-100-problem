class Solution {
    public int findGCD(int[] nums) { 
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int GCD = 1;
        for(int i = 1;i<=max;i++){
            if(min % i == 0 && max % i == 0){
                GCD  = i;
            }
        }
        return GCD;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3,3,1};
        System.out.println(sol.findGCD(nums)); // Output: 2
    }
}
