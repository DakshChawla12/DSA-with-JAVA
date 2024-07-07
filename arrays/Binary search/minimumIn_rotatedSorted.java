public class minimumIn_rotatedSorted {
    
    public int findMin(int[] nums) {

        int n = nums.length;
    

        int low = 0, high = n - 1;
        int mid = low + (high - low) / 2;
    
        int ans = Integer.MAX_VALUE; 
    
        while (low <= high) {
            // this condition checks whether the left part of array is sorted or not (if yes the the minimum will arr[low])
            if (nums[low] <= nums[mid]) {
                // Update the answer by taking the minimum of the current answer and the element at the low index
                ans = Math.min(ans, nums[low]);
                low = mid + 1; // updating the low as we have already compared the lowest element in left side
            }
            else { // condition for if the right part is sorted
                // Update the answer by taking the minimum of the current answer and the element at the mid index
                ans = Math.min(ans, nums[mid]);
                high = mid - 1; // Move the high index to the left of the current mid
            }
            mid = low + (high - low) / 2;
        }
        return ans;
    }

    
}
