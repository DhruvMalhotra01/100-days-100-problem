class subSequenceII {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backtrack(nums, new ArrayList<>(),0);
        return result;
    }
    public void backtrack(int[] nums, List<Integer> curr, int start){
        result.add(new ArrayList<>(curr));
        
        for(int i = start;i<nums.length;i++){
            if (i > start && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            backtrack(nums,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
    public public static void main(String[] args) {
        subSequenceII s = new subSequenceII();
        int[] nums = {1,2,2};
        Arrays.sort(nums); // Important to sort the array to handle duplicates
        List<List<Integer>> res = s.subsetsWithDup(nums);
        System.out.println(res);   
    }
}
