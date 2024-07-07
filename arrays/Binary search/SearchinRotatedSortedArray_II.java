public class SearchinRotatedSortedArray_II { // this is for when duplicates are present in array
    
    public boolean search(int[] nums, int target) {
        int n = nums.length;
    
        int low = 0, high = n - 1;
        int mid = low + (high - low) / 2; 
    
        while (low <= high) {
            // If the element is found at mid index, return true
            if (nums[mid] == target) {
                return true;
            }
    
            // Handling scenario where duplicates exist in the search space
        if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
            // If duplicates are found at both ends and mid, narrow down the search space by moving towards the center
            low = low + 1;  // Move the low index towards the center
            high = high - 1;  // Move the high index towards the center
            continue;  // Continue to the next iteration to refine the search space
        }

    
            // Check if the left side of the array is sorted
            if (nums[low] <= nums[mid]) {
                // Check if the target is within the sorted left side
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1; // Adjust high index
                } else {
                    low = mid + 1; // Adjust low index
                }
            } else { // If the right side of the array is sorted
                // Check if the target is within the sorted right side
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1; // Adjust low index
                } else {
                    high = mid - 1; // Adjust high index
                }
            }
    
            mid = low + (high - low) / 2;
        }
    

        return false;
    }
    

}
