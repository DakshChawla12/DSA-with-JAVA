package DP_on_subsequences;

import java.util.*;

public class partitionSumD {

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

    public static int helperII(int[]arr , int k){

        int n = arr.length;
        int[][] dp = new int[n][k+1];

        for(int i = 0 ; i < n ; i++){
            dp[i][0] = 1;
        }
        if(arr[0] <= k) dp[0][arr[0]] = 1;

        for(int i = 1 ; i < n ; i++){
            for(int target = 0 ; target <= k ; target++){
                int notPick = dp[i-1][target];
                int pick = 0;
                if(target >= arr[i]) pick = dp[i-1][target-arr[i]];
                dp[i][target] = notPick + pick;
            }
        }
        return dp[n-1][k];
    }
    public static int findWays(int[]num, int tar) {
        int n = num.length;
        int[][]dp = new int[n][tar+1];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,tar,num,dp);
    }

}
