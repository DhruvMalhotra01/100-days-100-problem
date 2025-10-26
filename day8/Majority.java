import java.util.*;
class Majority{
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int majorityCount = nums.length / 2;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() > majorityCount){
                return e.getKey();
            }
        }

        return -1; // this line will never be reached if a majority element always exists
    }
    public static void main(String[] args) {
        Majority obj = new Majority();
        int[] nums = {3, 2, 3};
        int result = obj.majorityElement(nums);
        System.out.println("Majority element is: " + result);
    }
}
