
import java.util.*;

public class largestConsecutiveSequence {
    
    public int longestConsecutive(int[] nums) {
        // Check if the array is empty
        if (nums.length == 0) return 0;
        
        Arrays.sort(nums);
    
        // Initialize variables to track the current consecutive sequence
        int lastSmaller = nums[0];
        int cnt = 1;  // Current consecutive sequence length
        int len = 1;  // Length of the longest consecutive sequence

        for (int i = 1; i < nums.length; i++) {
            // Check if the current element is consecutive to the last smaller element
            if (nums[i] == lastSmaller + 1) {
                cnt += 1;  // Increment the consecutive sequence length
            } else if (nums[i] != lastSmaller) {
                cnt = 1;  // Reset the consecutive sequence length if not consecutive
            }
    
            // Update the length of the longest consecutive sequence
            len = Math.max(cnt, len);
    
            // Update the last smaller element for the next iteration
            lastSmaller = nums[i];
        }
        return len;
    }
    

}
