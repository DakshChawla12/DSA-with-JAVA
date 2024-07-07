package _1D_DP;

import java.util.*;
public class FrogJumpWith_Ksteps {

    public static int helper(int k , int[]arr , int idx , int[]dp){ // *** memoization

        if(idx == 0) return 0;
        if(dp[idx] != -1){
            return dp[idx];
        }
        int minEnergy = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            if(idx-i >= 0){
                int currEnergy = helper(k, arr, idx-i,dp) + Math.abs(arr[idx]-arr[idx-i]);
                minEnergy = Math.min(minEnergy, currEnergy);
            }
        }
        dp[idx] = minEnergy;
        return dp[idx];
    }

    public static int helperIII(int n, int k, int []heights){ // *** tabulation

        int[]dp = new int[n+1];
        dp[0] = 0;

        for(int i = 1; i < heights.length; i++){
            int minEnergy = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    int currEnergy = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
                    minEnergy = Math.min(minEnergy,currEnergy);
                }
            }
            dp[i] = minEnergy;
        }
        return dp[n-1];
    }
    public static int minimizeCost(int n, int k, int []height){

        int[]dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(k , height,n-1,dp);

    }

}
