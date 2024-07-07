package DP_on_subsequences;

import java.util.*;

public class _0_1knapsack {

    public static int helper(int idx ,  int[]arr , int[]value , int maxWeight ,  int[][]dp) {

        if(idx == 0){
            if(maxWeight >= arr[0]) return value[0];
            return 0;
        }

        if(dp[idx][maxWeight] != -1) return dp[idx][maxWeight];

        int notPick = helper(idx - 1, arr, value, maxWeight, dp);
        int pick = Integer.MIN_VALUE;
        if(arr[idx] <= maxWeight) pick = value[idx] + helper(idx - 1 , arr , value , maxWeight-arr[idx] , dp);

        return dp[idx][maxWeight] = Math.max(pick,notPick);

    }

    public static int helperII(int[] weight, int[] value, int n, int maxWeight){

        int[][]dp = new int[n][maxWeight+1];
        for(int i = weight[0]; i <= maxWeight; i++){
            dp[0][i] = value[0];
        }

        for(int ind = 1; ind < n; ind++){
            for(int wt = 0; wt <= maxWeight; wt++){
                int notPick = dp[ind-1][wt];
                int pick = Integer.MIN_VALUE;
                if(weight[ind] <= maxWeight) pick = dp[ind][wt] + dp[ind-1][wt - weight[ind]];
                dp[ind][wt] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][maxWeight];
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[][]dp = new int[n][maxWeight+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(n-1,weight,value,maxWeight,dp);

    }

}
