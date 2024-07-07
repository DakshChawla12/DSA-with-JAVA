package DP_on_grids;

import java.util.*;
public class MinimumPathSum {

    public int helper(int i , int j , int[][]arr , int[][]dp){

        if(i == 0 && j == 0) return arr[i][j];
        if(i < 0 || j < 0) return 1000;

        if(dp[i][j] != -1) return dp[i][j];

        int leftCost = arr[i][j] + helper(i,j-1,arr,dp);
        int upCost = arr[i][j] + helper(i-1,j,arr,dp);

        int mini = Math.min(leftCost,upCost);
        dp[i][j] = mini;

        return mini;

    }

    public int helperII(int[][]grid){

        int n = grid.length , m = grid[0].length;

        int[][]dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0) dp[0][0] = grid[i][j];
                else{
                    int upCost = 0 , leftCost = 0;
                    if(i > 0){ // if i-1th row is valid
                        upCost += grid[i][j] + dp[i-1][j];
                    }else{
                        upCost = 1000;
                    }
                    if(j > 0){ // if j-1th column is valid
                        leftCost += grid[i][j] + dp[i][j-1];
                    }else{
                        leftCost = 1000;
                    }

                    dp[i][j] = Math.min(upCost,leftCost);
                }
            }
        }
        return dp[n-1][m-1];
    }

    public int minPathSum(int[][] grid) {

        int n = grid.length , m = grid[0].length;

        int[][]dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(n-1,m-1,grid,dp);

    }

}
