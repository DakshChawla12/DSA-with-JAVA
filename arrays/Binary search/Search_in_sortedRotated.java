public class Search_in_sortedRotated {
    
    
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
    
        // Find the middle index
        int mid = low + (high - low) / 2;
    
        while (low <= high) {
            // Check if the middle element is the target
            if (nums[mid] == target) {
                return mid; // Target found at mid index
            }
    
            // Check if the left half is ordered
            if (nums[low] <= nums[mid]) {
                // Determine if the target is within the ordered left half
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1; // Update 'high' to search in the left half
                } else {
                    low = mid + 1; // Update 'low' to search in the right half
                }
            } else { // Right half is ordered
                // Determine if the target is within the ordered right half
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1; // Update 'low' to search in the right half
                } else {
                    high = mid - 1; // Update 'high' to search in the left half
                }
            }
    
            // Recalculate mid based on updated 'low' and 'high'
            mid = low + (high - low) / 2;
        }
    
        return -1; // Target not found in the array
    }
    


}
