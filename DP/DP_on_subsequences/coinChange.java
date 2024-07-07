package DP_on_subsequences;

import java.util.*;

public class coinChange {

    public int helper(int idx , int[]arr , int target , int[][]dp){ // *** memoization

        if(idx == 0){
            if(target % arr[0] == 0) return target / arr[0];
            return (int)1e9;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int pick = (int)1e9;
        if(arr[idx] <= target){
            pick = 1 + helper(idx,arr,target-arr[idx],dp);
        }

        int notPick = helper(idx-1,arr,target,dp);

        return dp[idx][target] =  Math.min(pick,notPick);

    }

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][]dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = helper(n-1,coins,amount,dp);

        if(ans == (int)1e9) return -1;

        return ans;

    }

}
