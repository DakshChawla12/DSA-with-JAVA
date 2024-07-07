package DP_Stocks;

public class buyAndSell_withFee {

    public int helper(int idx , int canBuy , int fee , int[]arr , int[][]dp){

        if(idx == arr.length) return 0;

        if(dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(-arr[idx]+helper(idx+1,0,fee,arr,dp) , helper(idx+1,1,fee,arr,dp));
        }
        else{
            profit = Math.max((arr[idx]+helper(idx+1,1,fee,arr,dp)-fee) , helper(idx+1,0,fee,arr,dp));
        }

        return dp[idx][canBuy] = profit;

    }

    public int helperII(int[]arr , int fee){

        int n = arr.length;
        int[][]dp = new int[n+1][2];

        for(int idx = n-1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){

                int profit = 0;

                if(buy == 1){
                    profit = Math.max(-arr[idx]+dp[idx+1][0] , dp[idx+1][1]);
                }
                else{
                    profit = Math.max((arr[idx]+dp[idx+1][1])-fee , dp[idx+1][0]);
                }

                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public int maxProfit(int[] prices, int fee) {

        return helperII(prices,fee);

    }

}
