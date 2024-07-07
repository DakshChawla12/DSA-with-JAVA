import java.util.*;

public class LongestCommonSubsequence {

    public int helper(String s1 , int idx1 , String s2 , int idx2 , int[][]dp){ // *** memoization using index shifting to help in tabulation

        if(idx1 == 0 || idx2 == 0) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(s1.charAt(idx1-1) == s2.charAt(idx2-1)){
            return dp[idx1][idx2] = 1 + helper(s1,idx1-1,s2,idx2-1,dp);
        }

        return dp[idx1][idx2] = Math.max(helper(s1,idx1,s2,idx2-1,dp),helper(s1,idx1-1,s2,idx2,dp));

    }

    public int LongestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(text1, n, text2, m, dp);
    }

    public int helperII(String s1 , int idx1 , String s2 , int idx2 , int[][]dp){ // *** memoization

        if(idx1 == -1 || idx2 == -1) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return 1 + helper(s1,idx1-1,s2,idx2-1,dp);
        }

        return dp[idx1][idx2] = Math.max(helper(s1,idx1,s2,idx2-1,dp),helper(s1,idx1-1,s2,idx2,dp));

    }

    public int helperIII(String text1, String text2) { // tabulation

        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int j = 0; j <= m; j++) dp[0][j] = 0;

        for(int ind1 = 1; ind1 <= n; ind1++){
            for(int ind2 = 1; ind2 <= m; ind2++){
                if(text1.charAt(ind1-1) == text2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }

        int len=dp[n][m];     /// ******** to print the lcs
        int i=n;
        int j=m;

        int index = len-1;
        String str="";
        for(int k=1; k<=len;k++){
            str +="$"; // dummy string
        }
        StringBuilder ss= new StringBuilder(text1);
        StringBuilder str2=new StringBuilder(text2);
        while(i>0 && j>0){
            if(ss.charAt(i-1) == str2.charAt(j-1)){
                str2.setCharAt(index,ss.charAt(i-1) );
                index--;
                i--;
                j--;
            }
            else if(ss.charAt(i-1)>str2.charAt(j-1)){
                i--;
            }
            else j--;
        }

        return dp[n][m];

    }


    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][]dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(text1,n-1,text2,m-1,dp);
    }

}
