public class MaximumAverageSubarray_I {
    
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double windowSum = 0;
    
        // Initialize left and right pointers
        int left = 0;
        int right = 0;
    
        // Calculate sum of first 'k' elements
        while (right < k) {
            windowSum += nums[right];
            right++;
        }
    
        double maxAvg = windowSum;
    
        // Slide the window and calculate maximum average
        while (right < n) {
            windowSum += nums[right] - nums[left]; // Slide window by adding next element and subtracting first
            maxAvg = Math.max(maxAvg, windowSum);
            right++;
            left++;
        }
    
        return maxAvg / k; // Return the maximum average
    }
    

    public static void main(String[] args) {
        int[]arr = new int[]{1,12,-5,-6,50,3};
        double ans = findMaxAverage(arr,4);
        System.out.println(ans);
    }

}
