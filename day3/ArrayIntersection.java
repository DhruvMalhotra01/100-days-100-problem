import java.util.*;
class ArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int i : nums1) {
            set1.add(i); 
        }
        
        for (int i : nums2) {
            if (set1.contains(i)) { 
                set2.add(i); 
            }
        }
        int[] arr = new int[set2.size()];
        int i = 0;
        for (int num : set2) arr[i++] = num;
    return arr;
    }
    public static void main(String[] args){
        ArrayIntersection obj = new ArrayIntersection();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = obj.intersection(nums1, nums2);
        System.out.println("Intersection: " + Arrays.toString(result));
    }
}
