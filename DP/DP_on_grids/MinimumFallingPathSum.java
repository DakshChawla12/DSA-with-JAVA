package DP_on_grids;

import java.util.*;
public class MinimumFallingPathSum {

    public int helper(int i , int j , int[][]arr , int[][]dp){ // *** memoization  (TLE de raha h bht bde test cases m)

        if(j < 0 || j >= arr[0].length) return (int)1e9;
        if(i == 0) return arr[0][j];

        if(dp[i][j] != -1) return dp[i][j];

        int leftDiagonal = arr[i][j] + helper(i-1,j-1,arr,dp);
        int rightDiagonal = arr[i][j] + helper(i-1,j+1,arr,dp);
        int downWards = arr[i][j] + helper(i-1,j,arr,dp);

        int mini = Math.min(leftDiagonal,Math.min(rightDiagonal,downWards));
        dp[i][j] = mini;

        return mini;

    }

    public int helperII(int[][]arr){ // *** tabulation

        int n = arr.length;
        int m = arr[0].length;

        int[][]dp = new int[n][m];
        for(int j = 0; j < m; j++){
            dp[0][j] = arr[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                int leftDiagonal = (int)1e9 , rightDiagonal = (int)1e9;
                if(j-1 >= 0) leftDiagonal =  arr[i][j] + dp[i-1][j-1];
                if(j+1 < m) rightDiagonal = arr[i][j] + dp[i-1][j+1];
                int downWards = arr[i][j] + dp[i-1][j];
                dp[i][j] = Math.min(leftDiagonal,Math.min(rightDiagonal,downWards));;
            }
        }
        int minimumSum = (int)1e9;
        for(int j = 0; j < m; j++){
            minimumSum = Math.min(minimumSum,dp[n-1][j]);
        }
        return minimumSum;

    }
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][]dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        int mini = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            int ans = helper(n-1,j,matrix,dp);
            mini = Math.min(ans,mini);
        }
        return mini;
    }

}
