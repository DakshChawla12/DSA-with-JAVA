import java.util.*;

public class MinimumOperationsToMakeStringEqual {

    public int helper(String s1 , int idx1 , String s2 , int idx2 , int[][]dp){

        if(idx1 == 0 || idx2 == 0) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(s1.charAt(idx1-1) == s2.charAt(idx2-1)){
            return 1 + helper(s1,idx1-1,s2,idx2-1,dp);
        }

        return dp[idx1][idx2] = Math.max(helper(s1,idx1,s2,idx2-1,dp),helper(s1,idx1-1,s2,idx2,dp));

    }

    public int minDistance(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][]dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i],-1);
        }

        int lcs = helper(s1,n,s2,m,dp);

        return (n-lcs)+(m-lcs);

    }

}
