import java.util.*;

public class insertInterval {

    public static int[][] insert_Interval(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int iend = newInterval[1];
        ArrayList<int[]> result = new ArrayList<>();

        int i = 0;

        // Add intervals that come before the newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= iend) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            iend = Math.max(iend, intervals[i][1]);
            i++;
        }

        // Add the merged interval
        result.add(new int[]{newInterval[0], iend});

        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        // Example usage
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] result = insert_Interval(intervals, newInterval);

        for (int[] intervalArray : result) {
            System.out.println(Arrays.toString(intervalArray));
        }
    }
}
