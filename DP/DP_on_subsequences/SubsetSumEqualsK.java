package DP_on_subsequences;

import java.util.*;

public class SubsetSumEqualsK {

    public static boolean helper(int idx , int target , int[]arr , int[][]dp){ // *** memoization

        if(target == 0) return true;
        if(idx == 0) return arr[0] == target;

        if(dp[idx][target] != -1){
            return dp[idx][target] != 0;
        }

        boolean take = false;
        boolean notTake = helper(idx-1, target, arr, dp);
        if(target >= arr[idx]){
            take = helper(idx-1, target-arr[idx], arr, dp);
        }

        if(take || notTake) dp[idx][target] = 1;
        else dp[idx][target] = 0;

        return take || notTake;

    }

    public static boolean helperII(int n , int k , int[]arr){ // tabulation

        boolean dp[][] = new boolean[n][k + 1];
        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;
            }
        }

        // The result is stored in the last cell of the DP table
        return dp[n - 1][k];
    }


    public static boolean subsetSumToK(int n, int k, int arr[]){

        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,k,arr,dp);
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4};
        System.out.println(helperII(4,45,arr));
    }

}
