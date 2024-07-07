package DP_on_subsequences;

import java.util.*;

public class unboundedKnapsack {

    public static int helper(int idx, int maxWeight, int[] arr, int[] profit, int[][] dp) {

        if (idx == 0) {
            if (maxWeight % arr[0] == 0)
                return profit[0] * (maxWeight / arr[0]);
            return 0;
        }

        if (dp[idx][maxWeight] != -1)
            return dp[idx][maxWeight];

        int pick = Integer.MIN_VALUE;
        if (maxWeight >= arr[idx]) {
            pick = profit[idx] + helper(idx, maxWeight - arr[idx], arr, profit, dp);
        }
        int notPick = helper(idx - 1, maxWeight, arr, profit, dp);

        return dp[idx][maxWeight] = Math.max(pick, notPick);

    }

    public int helperII(int n, int w, int[] profit, int[] weight){

        int[][] dp = new int[n][w + 1];

        for(int W = 0; W <= w; W++){
            dp[0][W] = (W / weight[0]) * profit[0];
        }

        for(int ind = 1; ind < n; ind++){
            for(int wt = 0; wt <= w; wt++){
                int pick = Integer.MIN_VALUE;
                if (wt >= weight[ind]) {
                    pick = profit[ind] + dp[ind][wt - weight[ind]];
                }
                int notPick = dp[ind-1][wt];
                dp[ind][wt] = Math.max(pick, notPick);
            }
        }
        return dp[n-1][w];
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        int[][] dp = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(n - 1, w, weight, profit, dp);

    }

}
