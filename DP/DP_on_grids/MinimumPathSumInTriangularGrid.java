package DP_on_grids;

import java.util.*;
public class MinimumPathSumInTriangularGrid {

    public int helper(int i , int j , List<List<Integer>>grid , int[][]dp){ // *** memoization

        if(i == grid.size()-1) return grid.get(i).get(j);
        if(i >= grid.size() || j >= grid.size()) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;

        int downCost = grid.get(i).get(j) + helper(i+1,j,grid,dp);
        int diagonalCost = grid.get(i).get(j) + helper(i+1,j+1,grid,dp);
        mini = Math.min(downCost,diagonalCost);

        dp[i][j] = mini;
        return mini;
    }

    public int helperII(List<List<Integer>> triangle) { // *** tabulation  (tabulation always works in reverse order of memoization)

        int n = triangle.size();
        int[][]dp = new int[n][n];

        for(int j = 0; j < n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int downCost = Integer.MAX_VALUE;
                int diagonalCost = Integer.MAX_VALUE;

                if(i + 1 >= 0) downCost = triangle.get(i).get(j) + dp[i+1][j];
                if(i + 1 >= 0 && j + 1 >= 0) diagonalCost = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(downCost,diagonalCost);
            }
        }
        return dp[0][0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][]dp = new int[triangle.size()][triangle.size()];
        for(int i = 0; i < triangle.size(); i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,triangle,dp);
    }

}
