package _1D_DP;

import java.util.*;
public class House_Robber {

    public int helper(int idx , int[]arr , HashMap<Integer,Integer>dp){ // *** memoization

        if(idx == 0) return arr[0];
        if(idx < 0) return 0;

        if(dp.get(idx) != -1) return dp.get(idx);

        int pick = arr[idx] + helper(idx-2,arr,dp);
        int skip = helper(idx-1,arr,dp);

        dp.put(idx,Math.max(pick,skip));
        return Math.max(pick,skip);

    }

    public int helperII(int idx , int[]arr , HashMap<Integer,Integer>dp){ // *** memoization using hashmap

        if(idx == 0) return arr[0];
        if(idx < 0) return 0;

        if (dp.get(idx) != -(int)1e9) return dp.get(idx);

        int pick = arr[idx] + helper(idx-2,arr,dp);
        int skip = helper(idx-1,arr,dp);

        dp.put(idx,Math.max(pick,skip));
        return Math.max(pick,skip);

    }

    public int helperIII(int[] nums) { // *** tabulation

        int[]dp = new int[nums.length+1];
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            int pick = nums[i];
            if(i > 1) pick += dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(pick,skip);
        }
        return dp[nums.length-1];

    }

    public int helperIV(int[] nums) { // *** space-optimised(tabulation)

        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++){
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int skip = prev;
            int curr = Math.max(pick,skip);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public int rob(int[] nums) {

        HashMap<Integer,Integer>dp = new HashMap<>();
        for(int i = 0; i <= nums.length; i++){
            dp.put(i,-1);
        }
        return helper(nums.length-1,nums,dp);

    }

}
