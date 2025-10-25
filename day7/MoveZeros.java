public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int[] n = new int[nums.length];
        int index = 0;
    for (int i : nums) {
        if (i != 0) n[index++] = i;
    }
    while (index < nums.length) n[index++] = 0;
    System.arraycopy(n, 0, nums, 0, nums.length);
}
    public static void main(String[] args) {
        MoveZeros obj = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        obj.moveZeroes(nums);
        System.out.print("Array after moving zeros: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
