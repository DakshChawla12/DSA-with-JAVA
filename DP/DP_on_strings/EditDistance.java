import java.util.*;

public class EditDistance {

    // *** memoization with index-shifting
    public int helper(int i , String s1 , int j , String s2 , int[][]dp){

        if(j == 0) return i;
        if(i == 0) return j;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = helper(i-1,s1,j-1,s2,dp);
        }

        int insert = 1 + helper(i,s1,j-1,s2,dp);
        int delete = 1 + helper(i-1,s1,j,s2,dp);
        int replace = 1 + helper(i-1,s1,j-1,s2,dp);

        return dp[i][j] = Math.min(insert,Math.min(delete,replace));

    }

    public int minDistance(String s1, String s2) {

        int n = s1.length() , m = s2.length();
        int[][]dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(n,s1,m,s2,dp);

    }

    // *** memoization without index-shifting
    public int helperI(int i , String s1 , int j , String s2 , int[][]dp){

        if(j < 0) return i+1;
        if(i < 0) return j+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = helper(i-1,s1,j-1,s2,dp);
        }

        int insert = 1 + helper(i,s1,j-1,s2,dp);
        int delete = 1 + helper(i-1,s1,j,s2,dp);
        int replace = 1 + helper(i-1,s1,j-1,s2,dp);

        return dp[i][j] = Math.min(insert,Math.min(delete,replace));

    }

    public int MinDistance(String s1, String s2) {

        int n = s1.length() , m = s2.length();
        int[][]dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(n-1,s1,m-1,s2,dp);

    }

    // *** tabulation
    public int min_Distance(String s1, String s2) {

        int n = s1.length() , m = s2.length();
        int[][]dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) dp[i][0] = i;
        for(int j = 0; j <= m; j++) dp[0][j] = j;

        for(int ind1 = 1; ind1 <= n; ind1++){
            for(int ind2 = 1; ind2 <= m; ind2++){
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1)){
                    dp[ind1][ind2] = dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2] = 1 + Math.min(dp[ind1][ind2-1],Math.min(dp[ind1-1][ind2],dp[ind1-1][ind2-1]));
                }
            }
        }
        return dp[n][m];
    }

}
