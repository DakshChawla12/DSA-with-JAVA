
/*Insertion sort builds the sorted array one element at a time
by repeatedly taking an element from the unsorted part and inserting it into its correct position in the sorted part
resembling the way people organize a hand of playing cards */


public class insertionSort {

    public static void insertion_Sort(int arr[]) {
        
        int n = arr.length;
    
        
        for (int i = 1; i < n; i++) {
            // Store the current element to be inserted
            int key = arr[i];
            
            // Initialize the index for comparison to the left of the current element
            int j = i - 1;
    
            // Move elements of arr[0..i-1] that are greater than key to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                // Shift elements to the right to make space for the key
                arr[j + 1] = arr[j];
                // Move to the next position for comparison
                j = j - 1;
            }
            
            // Place the key in its correct position
            arr[j + 1] = key;
        }
    }
    
    
}
