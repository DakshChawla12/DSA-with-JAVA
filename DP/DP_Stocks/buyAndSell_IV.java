package DP_Stocks;

import java.util.Arrays;

public class buyAndSell_IV {


    public int helper(int idx , int canBuy , int maxTr , int[]arr , int[][][]dp){ // *** memoization

        if(idx == arr.length || maxTr == 0) return 0;

        if(dp[idx][canBuy][maxTr] != -1) return dp[idx][canBuy][maxTr];

        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(-arr[idx]+helper(idx+1,0,maxTr,arr,dp) , helper(idx+1,1,maxTr,arr,dp));
        }
        else{
            profit = Math.max(arr[idx]+helper(idx+1,1,maxTr-1,arr,dp) , helper(idx+1,0,maxTr,arr,dp));
        }

        return dp[idx][canBuy][maxTr] = profit;

    }

    public int helperII(int[]arr , int k){ // *** tabulation

        int n = arr.length;
        int[][][]dp = new int[n+1][2][k+1];

        for(int i = 0 ; i <= n ; i++){
            for(int j = 0; j < 2; j++){
                for(int K = 0; K <= k; K++){
                    if(i == 0 || K == 0){
                        dp[i][j][K] = 0;
                    }
                }
            }
        }

        for(int idx = n-1; idx >= 0 ; idx--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-arr[idx]+dp[idx+1][0][cap] , dp[idx+1][1][cap]);
                    }
                    else{
                        profit = Math.max(arr[idx]+dp[idx+1][1][cap-1] , dp[idx+1][0][cap]);
                    }
                    dp[idx][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][k];
    }

    public int helperIII(int[]arr , int k){ // *** space-optimised

        int n = arr.length;

        int[][]after = new int[2][k+1];
        int[][]curr = new int[2][k+1];

        for(int idx = n-1; idx >= 0 ; idx--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-arr[idx]+after[0][cap] , after[1][cap]);
                    }
                    else{
                        profit = Math.max(arr[idx]+after[1][cap-1] , after[0][cap]);
                    }
                    curr[buy][cap] = profit;
                }
            }
            after = curr;
        }
        return after[1][k];
    }

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int[][][]dp = new int[n][2][k+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return helper(0,1,k,prices,dp);

    }

}
