class MostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentArea = width * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer of the smaller line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
    public static void main(String[] args) {
        MostWater obj = new MostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = obj.maxArea(height);
        System.out.println("Maximum area of water that can be contained: " + result);
    }
}
