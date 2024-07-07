public class FindPeak {
    
    public int findPeakElement(int[] nums) {

        int n = nums.length;
    
        // Handling edge cases: array of size 1 or peaks at extremes
        if(n == 1) return 0; // Single element array
        if(nums[0] > nums[1]) return 0; // Peak at the beginning
        if(nums[n-1] > nums[n-2]) return n-1; // Peak at the end
        

        int low = 1 , high = n-2;
        int mid = low + (high - low)/2;
    
        while(low <= mid){
            // Check if the current mid is a peak
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid; // Return index of the peak element
            }
            // If mid element is in an ascending sequence, update the search range to the right
            else if(nums[mid] > nums[mid-1]){
                low = mid + 1; // Update lower bound
            }
            // If mid element is in a descending sequence, update the search range to the left
            else{
                high = mid - 1; // Update upper bound
            }
            // Recalculate the mid point within the updated search boundaries
            mid = low + (high - low)/2;
        }
        return -1; 
    }
    

}
