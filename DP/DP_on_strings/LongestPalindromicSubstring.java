import java.util.*;

public class LongestPalindromicSubstring {

    public int helper(String s1 , int idx1 , String s2 , int idx2 , int[][]dp){

        if(idx1 == 0 || idx2 == 0) return  0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(s1.charAt(idx1-1) == s2.charAt(idx2-1)){
            return 1 + helper(s1,idx1-1,s2,idx2-1,dp);
        }

        return dp[idx1][idx2] =  Math.max(helper(s1,idx1,s2,idx2-1,dp),helper(s1,idx1-1,s2,idx2,dp));

    }

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        int[][]dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(s,n,sb.toString(),n,dp);
    }

}
