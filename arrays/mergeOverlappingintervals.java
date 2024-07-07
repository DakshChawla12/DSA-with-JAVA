
import java.util.*;

public class mergeOverlappingintervals {
    
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
    
        // Sort intervals based on the element at 0th index of each row
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    
        // List to store merged intervals
        List<int[]> merged = new ArrayList<>();
    
        for (int i = 0; i < n; i++) {
            // Get the start and end of the current interval
            int start = intervals[i][0];  // element at 0th index of every row
            int end = intervals[i][1];   // element at 0th index of every row

            int size = merged.size(); // current size of list s
    
            // If there is an overlap between the current and last merged interval, extend the merged interval
            if (!merged.isEmpty() && end <= merged.get(size - 1)[1]) {
                continue; // Skip merging if there's an overlap
            }
    
            // Iterate through the remaining intervals to merge overlapping intervals
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) { // if the element at 0th index of next interval is less than or equal to element at 1st of current interval
                    // Update the end of the merged interval if there's an overlap
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break; // No overlap, break the inner loop
                }
            }
            // Add the merged interval to the list
            merged.add(new int[]{start, end});
        }
    
        // Convert the list of merged intervals to a 2D array and return
        return merged.toArray(new int[0][]);
    }
    

}
