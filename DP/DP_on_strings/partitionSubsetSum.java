import java.util.*;

public class partitionSubsetSum {

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
    public boolean helperII(int[]arr) {

        int n = arr.length;

        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        // If the total sum is odd, it cannot be partitioned into equal subsets
        if (totSum % 2 == 1)
            return false;
        else {
            // Calculate the target sum for each subset
            int k = totSum / 2;
            // Create a DP table to store the results of subproblems
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
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;

        int k = sum/2;
        int[][]dp = new int[nums.length][k+1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(nums.length-1 , k , nums , dp);
    }

}
