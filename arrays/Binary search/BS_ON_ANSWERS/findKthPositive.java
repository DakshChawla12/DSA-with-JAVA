
public class findKthPositive {

    public static int helper(int[] arr, int k) {
        int s = 0, e = arr.length - 1;
        int mid = s + (e - s) / 2; 

        
        while (s <= e) {
            int missing = arr[mid] - (mid + 1); // Calculate the number of missing integers before the current element
            if (missing < k)
                s = mid + 1; // If the number of missing integers is less than k, move search to the right half
            else
                e = mid - 1; // If the number of missing integers is greater than or equal to k, move search to the left half
            mid = s + (e - s) / 2; // Recalculate the middle index
        }
        // The kth missing positive integer is between arr[e] and arr[e + 1], so return arr[e] + k + 1
        return arr[e] + k + 1;
    }

    // This method is the entry point to find the kth missing positive integer
    public static int find_Kth_Positive(int[] arr, int k) {
        return helper(arr, k); // Call the helper method with the given array and k
    }
    public static void main(String[] args) {
        int[]arr = {4,7,8,10};
        int k = 3;
        System.out.println(find_Kth_Positive(arr, k));
    }

}
