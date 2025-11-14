class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>current = new ArrayList<>();
        backtrack(0,candidates,target,current,result);
        return result;
    }
    public void backtrack(int start, int[] candidates, int target, List<Integer>current, List<List<Integer>>result)
    {
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0)return;
        for(int i = start;i<candidates.length;i++){
            current.add(candidates[i]);
            backtrack(i,candidates,target-candidates[i],current,result);
            current.remove(current.size()-1);
        }
    }
}
