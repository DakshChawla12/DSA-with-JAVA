package DP_on_subsequences;

import java.util.*;

public class countDistinctSubsequences {

    // *** memoization with index-shifting
    public int helperI(int i , String s1 , int j , String s2 , int[][]dp){

        if(j < 1) return 1;
        if(i < 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = helper(i-1,s1,j-1,s2,dp) + helper(i-1,s1,j,s2,dp);
        }

        return dp[i][j] = helper(i-1,s1,j,s2,dp);

    }

    public int NumDistinct(String s, String t) {

        int n = s.length() , m = t.length();
        int[][]dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(n,s,m,t,dp);

    }

    // *** memoization without index-shifting
    public int helper(int i , String s1 , int j , String s2 , int[][]dp){

        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = helper(i-1,s1,j-1,s2,dp) + helper(i-1,s1,j,s2,dp);
        }

        return dp[i][j] = helper(i-1,s1,j,s2,dp);

    }

    public int numDistinct(String s, String t) {

        int n = s.length() , m = t.length();
        int[][]dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(n-1,s,m-1,t,dp);

    }

    // *** tabulation
    public int helperII(String s1 , String s2){

        int n = s1.length() , m = s2.length();
        int[][]dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for(int ind1 = 1; ind1 <= n; ind1++){
            for(int ind2 = 1; ind2 <= m; ind2++){
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1)){
                    dp[ind1][ind2] = dp[ind1-1][ind2-1] + dp[ind1-1][ind2];
                }
                else{
                    dp[ind1][ind2] = dp[ind1-1][ind2];
                }
            }
        }

        return dp[n][m];

    }

    public int Num_Distinct(String s, String t) {

        int n = s.length() , m = t.length();

        return helperII(s,t);

    }

}
