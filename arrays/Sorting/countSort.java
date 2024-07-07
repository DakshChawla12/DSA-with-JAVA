public class countSort {
    
    public static void count_sort(int[] arr) {
        
        int n = arr.length;
    
        // Find the maximum element in the input array
        int maxEle = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxEle = Math.max(maxEle, arr[i]);
        }
    
        // Create a count array with a size to accommodate elements from 0 to maxEle
        int[] count = new int[maxEle + 1];
    
        // Count the frequency of each element in the input array
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
    
        // Reconstruct the sorted array from the count array
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            // While the count of the current element is greater than 0
            while (count[i] > 0) {
                // Place the current element in the sorted array
                arr[k] = i;
                // Move to the next position in the sorted array
                k++;
                // Decrement the count of the current element
                count[i]--;
            }
        }
    }
    

}
