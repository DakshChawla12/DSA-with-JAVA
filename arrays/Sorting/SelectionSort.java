/*Selection sort works by iteratively selecting the minimum element from the unsorted part
     of the list and swapping it with the first element of the unsorted sublist until the entire list is sorted */

public class SelectionSort {

    public static void selection_sort(int arr[]) {

        int n = arr.length;
    

        for (int i = 0; i < n - 1; i++) {
            // Assume the current position is the minimum
            int minPos = i;
    
            // Find the index of the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                // If a smaller element is found, update the minimum position
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
    
            // Swap the found minimum element with the first element of the unsorted sublist
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
    

        public static void main(String[] args) {
            int[]arr = new int[]{3,5,4,6,7,8,9,1};
            selection_sort(arr);
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
        }
    
}