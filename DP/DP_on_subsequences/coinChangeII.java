package DP_on_subsequences;

import java.util.*;

public class coinChangeII {

    public int helper(int idx , int[]arr , int target , int[][]dp){ // *** memoization

        if(idx == 0){
            if(target % arr[idx] == 0) return 1;
            return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int pick = 0;
        if(target >= arr[idx]){
            pick = helper(idx,arr,target-arr[idx],dp);
        }
        int notPick = helper(idx-1,arr,target,dp);

        return dp[idx][target] = pick+notPick;

    }

    public int helperII(int amount , int[]coins){ // tabulation

        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i = 0 ; i <= amount ; i++){
            if(i % coins[0] == 0) dp[0][i] = 1;
        }

        for(int ind = 1; ind < n; ind++){
            for(int target = 0 ; target <= amount ; target++){
                int notPick = dp[ind-1][target];
                int pick = 0;
                if(target >= coins[ind]){
                    pick = dp[ind][target - coins[ind]];
                }
                dp[ind][target] = pick+notPick;
            }
        }
        return dp[n-1][amount];
    }

    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][]dp = new int[n][amount+1];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(n-1,coins,amount,dp);

    }

}
