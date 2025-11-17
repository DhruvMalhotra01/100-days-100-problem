import java.util.*;
public class subset {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> curr, int i){
        if (i == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // PICK
        curr.add(nums[i]);
        backtrack(nums, curr, i + 1);

        // NOT PICK
        curr.remove(curr.size() - 1);
        backtrack(nums, curr, i + 1);
    }

    public static void main(String[] args) {
        subset s = new subset();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = s.subsets(nums);
        System.out.println(res);
    }
}
