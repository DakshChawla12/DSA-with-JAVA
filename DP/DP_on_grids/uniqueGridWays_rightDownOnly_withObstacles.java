package DP_on_grids;

import java.util.*;

public class uniqueGridWays_rightDownOnly_withObstacles {

    public int helper(int[][]arr , int sr , int sc , int[][]dp){  // *** memoization


        if(sr < 0 || sc < 0 || arr[sr][sc]==1) return 0;
        if(sr == 0 && sc == 0) return 1;

        if(dp[sr][sc] != -1){
            return dp[sr][sc];
        }

        int upWays = helper(arr , sr-1 , sc , dp);
        int leftWays = helper(arr , sr , sc-1 , dp);

        dp[sr][sc] = upWays+leftWays;

        return upWays+leftWays;

    }

    public int helper(int[][]obstacleGrid){

        if(obstacleGrid[0][0] == 1) return 0;

        int[][]dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int up = 0 , left = 0;
                    if(obstacleGrid[i][j] == 1){
                        dp[i][j] = 0;
                    }
                    else{
                        if(i > 0) up += dp[i-1][j];
                        if(j > 0) left += dp[i][j-1];
                        dp[i][j] = up + left;
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][]dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = helper(obstacleGrid, n-1 , m-1 , dp);
        return ans;
    }

}
