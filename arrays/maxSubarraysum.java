import java.util.*;

public class maxSubarraysum {
    
    public static int maxSum(int[]nums , int n){
        int sum = 0;
        int maxi = nums[0];

        for(int i = 0; i < n; i++){
            sum += nums[i];

            maxi = Math.max(maxi, sum);

            if(sum < 0){
                sum = 0;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the size of array : ");
        int n = input.nextInt();
        int[]arr = new int[n];
        System.out.println("enter the elements of array : ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("max subarray sum is --> " + maxSum(arr, n));

        input.close();
    }

}
