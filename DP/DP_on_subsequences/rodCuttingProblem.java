package DP_on_subsequences;

import java.util.*;

public class rodCuttingProblem {

    public static int helper(int idx , int N , int[]price , int[][]dp){

        if(idx == 0){
            return N*price[0];
        }

        if(dp[idx][N] != -1) return dp[idx][N];

        int notTake = helper(idx-1,N,price,dp);
        int take = Integer.MIN_VALUE;
        int rodLength = idx + 1;
        if(rodLength <= N){
            take = price[idx] + helper(idx,N-rodLength,price,dp);
        }

        return dp[idx][N] = Math.max(take,notTake);

    }

    public static int helperII(int[]arr , int n){

        int[][]dp = new int[n][n+1];
        for(int i = 0;  i <= n;  i++){
            dp[0][i] = i*arr[0];
        }

        for(int ind = 1; ind < n; ind++){
            for(int N = 0; N <= n; N++){
                int notTake = dp[ind-1][N];
                int take = Integer.MIN_VALUE;
                int rodLength = ind+1;
                if(rodLength <= N) take = arr[ind] + dp[ind][N-rodLength];
                dp[ind][N] = Math.max(take,notTake);
            }
        }
        return dp[n-1][n];

    }

    public static int cutRod(int price[], int n) {

        int[][]dp = new int[n][n+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        return helperII(price,n);

    }

}
