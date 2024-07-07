package DP_Stocks;
import java.util.*;

public class buyAndSell_withCooldown { // *** memoization

    public int helper(int idx , int canBuy , int[]arr , int[][]dp){

        if(idx >= arr.length) return 0;

        if(dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(-arr[idx]+helper(idx+1,0,arr,dp) , helper(idx+1,1,arr,dp));
        }
        else{
            profit = Math.max(arr[idx]+helper(idx+2,1,arr,dp) , helper(idx+1,0,arr,dp));
        }

        return dp[idx][canBuy] = profit;

    }

    public int helperII(int[]arr){ // *** tabulation

        int n = arr.length;
        int[][]dp = new int[n+2][2];

        for(int idx = n-1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;

                if(buy == 1){
                    profit = Math.max(-arr[idx]+dp[idx+1][0] , dp[idx+1][1]);
                }
                else{
                    profit = Math.max(arr[idx]+dp[idx+2][1] , dp[idx+1][0]);
                }

                dp[idx][buy] = profit;

            }
        }
        return dp[0][1];
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][]dp = new int[n][2];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(0,1,prices,dp);

    }

}
