package _1D_DP;

public class climbingStairs {

    public int climbStairs(int n) { // tabulation

        if(n == 0 || n == 1) {
            return 1;
        }
        int[]dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];

    }

    public int climbStairs_memo(int n , int[]dp){

        if(n == 0 || n == 1) return 1;
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = climbStairs_memo(n-2,dp) + climbStairs_memo(n-1,dp);
        return dp[n];

    }

}
