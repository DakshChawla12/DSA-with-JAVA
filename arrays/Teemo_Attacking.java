public class Teemo_Attacking {
    
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int poisoned_time = 0;
    
        
        for (int i = 0; i < n - 1; i++) {
            // If the next element is more than 'duration' time units ahead of the current one
            if (timeSeries[i + 1] > timeSeries[i] + duration) {
                // The poisoned duration adds 'duration' units
                poisoned_time += duration;
            } else {
                // If the next element is within 'duration' units of the current one
                int temp = timeSeries[i];
                // Increment 'poisoned_time' for each time unit between the two consecutive elements
                while (temp < timeSeries[i + 1]) {
                    poisoned_time++;
                    temp++;
                }
            }
        }
        // Add the duration for the last element (as it doesn't have a next element to compare with)
        poisoned_time += duration;
    
        return poisoned_time;
    }
    

    public static void main(String[] args) {
        int[]arr = new int[]{1,4};
        int ans = findPoisonedDuration(arr,2);
        System.out.println(ans);
    }

}
