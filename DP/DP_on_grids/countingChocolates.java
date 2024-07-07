package DP_on_grids;

import java.util.*;
public class countingChocolates {

    public static int helper(int i , int j1 , int j2 , int[][]arr , int[][][]dp){

        if(j1 >= arr[0].length || j2 >= arr[0].length || j1 < 0 || j2 < 0) return -(int)1e8;
        if(i == arr.length-1){
            if(j1 == j2) return arr[i][j1];
            else return arr[i][j1] + arr[i][j2];
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi = 0;
        for (int deltaJ1 = -1; deltaJ1 <= 1; deltaJ1++) {
            for (int deltaJ2 = -1; deltaJ2 <= 1; deltaJ2++) {
                if (j1 == j2) maxi = Math.max(maxi, arr[i][j1] + helper(i + 1, j1 + deltaJ1, j2 + deltaJ2, arr, dp));
                else maxi = Math.max(maxi, arr[i][j1] + arr[i][j2] + helper(i + 1, j1 + deltaJ1, j2 + deltaJ2, arr, dp));
            }
        }
        dp[i][j1][j2] = maxi;
        return maxi;
    }

    public static int maximumChocolates(int r, int c, int[][] grid) {

        int[][][]dp = new int[r][c][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0,0,c-1,grid,dp);
    }


}
