import java.util.*;

class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        if (n <= 1) {
            return false;
        } else {
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                if (set.contains(nums[i])) {
                    return true; // duplicate found
                }
                set.add(nums[i]);
            }
        }

        return false; // no duplicates found
    }

    // main method to test
    public static void main(String[] args) {
        containsDuplicate obj = new containsDuplicate();
        int[] nums = {1, 2, 3, 1};
        System.out.println(obj.containsDuplicate(nums)); // Output: true
    }
}
