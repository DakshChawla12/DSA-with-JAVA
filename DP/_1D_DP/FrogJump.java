package _1D_DP;

import java.util.*;
public class FrogJump {

    public static int helper(int idx , int[]dp , int[]arr){ // *** memoization

        if(idx == 0) return 0;
        if(dp[idx] != -1){
            return dp[idx];
        }
        int oneStep = helper(idx-1, dp, arr) + Math.abs(arr[idx]-arr[idx-1]);
        int twoStep = Integer.MAX_VALUE;
        if(idx > 1)  twoStep = helper(idx-2, dp, arr) + Math.abs(arr[idx]-arr[idx-2]);

        dp[idx] = Math.min(oneStep , twoStep);
        return dp[idx];

    }

    public static int helperII(int n, int[]arr) { // *** tabulation

        int[]dp = new int[n+1];
        dp[0] = 0;

        for(int i = 1; i < arr.length; i++){
            int oneStep = dp[i-1] + Math.abs(arr[i]-arr[i-1]);
            int twoStep =  Integer.MAX_VALUE;
            if(i != 1){
                twoStep = dp[i-2] + Math.abs(arr[i]-arr[i-2]);
            }
            dp[i] = Math.min(oneStep,twoStep);
        }
        return dp[n-1];

    }

    public static int helperIII(int n, int[]arr) { // *** tabulation


        int prev2 = 0;
        int prev = 0;

        for(int i = 1; i < arr.length; i++) {

            int oneStep = prev + Math.abs(arr[i]-arr[i-1]);
            int twoStep = Integer.MAX_VALUE;
            if(i != 1){
                twoStep = prev2 + Math.abs(arr[i]-arr[i-2]);
            }

            int curr = Math.min(oneStep,twoStep);
            prev2 = prev;
            prev = curr;

        }
        return prev;
    }
    public static int frogJump(int n, int heights[]) {

        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helperIII(n,heights);

    }

    public static void main(String[] args) {
        int[]arr = {30,10,60,10,60,50};
        System.out.println(frogJump(6,arr));
    }

}
