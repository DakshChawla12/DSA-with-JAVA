package DP_on_subsequences;

import java.util.*;

public class countPartitionsWithGivenSum { // memoization    (tabulation waala code same h phle jaisa he bs array size ka frk h)

    public static int helper(int idx , int target , int[]arr , int[][]dp){

        if(idx == 0){
            if(target == 0 && arr[0] == 0) return 2;
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notPick = helper(idx-1,target,arr,dp);
        int pick = 0;
        if(target >= arr[idx]) pick = helper(idx-1,target-arr[idx],arr,dp);

        return dp[idx][target] = notPick + pick;

    }
    public static int countPartitions(int n, int d, int[] arr) {

        int sum = 0;
        for(int it : arr) sum += it;

        if(sum - d < 0 || (sum-d)%2 != 0) return 0;

        int[][]dp = new int[n][(sum - d)/2+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        int mod = (int)(1e9+7);

        return helper(n-1,(sum - d)/2,arr,dp) % mod;

    }

}
