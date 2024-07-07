package DP_Stocks;
import java.util.*;

public class buyAndSell_II {

    public int helper(int idx , int[]arr , int canBuy , int[][]dp){ // *** memoization

        if(idx == arr.length) return 0;

        if(dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int opt1 = 0;
        int opt2 = 0;

        if(canBuy == 1){
            opt1 = -arr[idx] + helper(idx+1,arr,0,dp); // buying if we can
            opt2 = helper(idx+1,arr,1,dp); // not buying even if we can
        }
        else{
            opt1 = arr[idx] + helper(idx+1,arr,1,dp); // selling if we can
            opt2 = helper(idx+1,arr,0,dp); // not selling even if we can
        }

        return dp[idx][canBuy] =  Math.max(opt1,opt2);

    }

    public int helperII(int[]arr){ // *** tabulation

        int n = arr.length;
        int[][]dp = new int[n+1][2];

        dp[n][0] = dp[n][1] = 0;

        for(int idx = n-1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-arr[idx] + dp[idx+1][0] , dp[idx+1][1]);
                }
                else{
                    profit = Math.max(arr[idx] + dp[idx+1][1] , dp[idx+1][0]);
                }
                dp[idx][buy] = profit;
            }
        }

        return dp[0][1];

    }

    public int helperIII(int[] arr) { // *** space-optimised

        int[]ahead = new int[2];
        int[]curr = new int[2];

        for(int idx = arr.length-1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-arr[idx] + ahead[0] , ahead[1]);
                }else{
                    profit = Math.max(arr[idx]+ahead[1] , ahead[0]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return curr[1];
    }

    public int maxProfit(int[] prices) {

        int[][]dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(0,prices,1,dp);

    }

}
