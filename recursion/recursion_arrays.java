import java.util.ArrayList;

public class recursion_arrays {
    
    public static boolean isSorted(int[]arr , int s , int n){
        if(n == 0 || n == 1){
            return true;
        }

        if(arr[s] > arr[s+1]) return false;

        return isSorted(arr , s+1 , n-1);
    }

    public static int sumOfarray(int[]arr , int s , int n , int sum){
        if(n == 0){
            return sum;
        }
        sum += arr[s];

        return sumOfarray(arr, s+1, n-1, sum);
    }

    public static boolean linearSearch(int[] arr, int s, int n, int key) {
        if (n == 0) {
            return false;
        }
        if (arr[s] == key) {
            return true;
        }
    
        return linearSearch(arr, s + 1, n - 1, key);
    }
    
    public static ArrayList<Integer> getIndices(int[]arr , int s , int n , ArrayList<Integer>ls , int key){
        if(n == 0){
            return ls;
        }
        if(arr[s] == key) ls.add(s);

        return getIndices(arr, s+1, n-1, ls, key);
    }

    
    public static void Bubble_Sort(int[]arr , int n){
        if(n == 0 || n == 1){
            return;
        }

        for(int i = 0; i < n-1; i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        Bubble_Sort(arr , n-1);
    }

    public static void main(String[] args) {
        int[]arr = new int[]{4,3,5,2,1};
        // boolean ans = isSorted(arr, 0, 4);
        // int res = sumOfarray(arr, 0, 4, 0);

        // boolean ans = linearSearch(arr, 0, 4, 4);
        // System.out.println(ans);

        // ArrayList<Integer>ls = new ArrayList<>();
        // ls = getIndices(arr, 0, 5, ls, 1);
        // System.out.println(ls);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Bubble_Sort(arr , 5);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

}
