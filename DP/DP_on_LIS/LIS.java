package DP_on_LIS;
import java.util.*;

public class LIS {

    public static int helper(int idx , int prevIDX , int[]arr , int[][]dp){ // *** memoization

        if(idx == arr.length) return 0;

        if(dp[idx][prevIDX+1] != -1) return dp[idx][prevIDX+1];

        int pick = 0;
        if(prevIDX == -1 || arr[idx] > arr[prevIDX]){
            pick = 1 + helper(idx+1,idx,arr,dp);
        }
        int notPick = helper(idx+1,prevIDX,arr,dp);

        return dp[idx][prevIDX+1] = Math.max(pick,notPick);

    }

    public static int helperII(int[]arr , int n){ // *** tabulation

        int dp[][]=new int[n+1][n+1];

        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){

                int notTake = 0 + dp[ind+1][prev_index +1];

                int take = 0;

                if(prev_index == -1 || arr[ind] > arr[prev_index]){

                    take = 1 + dp[ind+1][ind+1];
                }

                dp[ind][prev_index+1] = Math.max(notTake,take);

            }
        }

        return dp[0][0];

    }

    public static  int helperIII(int[]arr , int n){ // space-optimised

        int next[]=new int[n+1];
        int cur[]=new int[n+1];

        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){

                int notTake = next[prev_index + 1];

                int take = 0;

                if(prev_index == -1 || arr[ind] > arr[prev_index]){

                    take = 1 + next[ind+1];
                }

                cur[prev_index+1] = Math.max(notTake,take);
            }
            next = cur.clone();
        }

        return cur[0];

    }

    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[][]dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

//        return helper(0,-1,nums,dp);
          int ans = helper(0,-1,nums,dp);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {10,2,5,3,7};
        int ans = lengthOfLIS(arr);
        System.out.println(ans);
    }

}
