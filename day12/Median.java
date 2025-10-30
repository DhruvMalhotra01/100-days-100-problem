class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] arr = new int[n];
        int i = 0, j = 0, k = 0;

        // Merge both sorted arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        // Add remaining elements
        while (i < nums1.length) arr[k++] = nums1[i++];
        while (j < nums2.length) arr[k++] = nums2[j++];

        // Find median
        if (n % 2 == 1) {
            return arr[n / 2];
        } else {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        }
    }
    public static void main(String[] args) {
        Median solution = new Median();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("The median is: " + median); // Output: 2.0
    }
}
