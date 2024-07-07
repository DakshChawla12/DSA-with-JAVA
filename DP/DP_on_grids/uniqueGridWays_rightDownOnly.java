package DP_on_grids;

import java.util.*;
public class uniqueGridWays_rightDownOnly {

    public class pair{
        int rowIdx , colIdx;
        pair(int r , int c){
            this.rowIdx = r;
            this.colIdx = c;
        }
    }

    public int helper(int i , int j , HashMap<pair,Integer>dp){ // *** memoization

        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp.get(new pair(i,j)) != -1){
            return dp.get(new pair(i,j));
        }

        int leftTotal = helper(i,j-1,dp);
        int upTotal = helper(i-1,j,dp);

        dp.put(new pair(i,j),leftTotal+upTotal);

        return leftTotal + upTotal;

    }

    public int helperII(int m, int n) { // *** tabulation

        int[][]dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int up = 0 , left = 0;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];

    }

    public int uniquePaths(int m, int n) {

        HashMap<pair,Integer>dp = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp.put(new pair(i,j),-1);
            }
        }
        return helper(m-1,n-1,dp);
    }

}
