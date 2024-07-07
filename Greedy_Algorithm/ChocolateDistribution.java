import java.util.Arrays;

public class ChocolateDistribution {

    public static int getMinDiff(int[]arr , int n , int m){

        Arrays.sort(arr);
        int i = 0 , j = m-1;

        int mini = Integer.MAX_VALUE;

        while(j < arr.length){
            int diff = arr[j] - arr[i];
            mini = Math.min(mini,diff);
            i++;j++;
        }

        return mini;

    }

    public static void main(String[] args) {
        int[]arr = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(getMinDiff(arr,arr.length,5));
    }

}
