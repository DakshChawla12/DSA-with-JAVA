public class LongestCommonSubstring {

    public static int lcs(String str1, String str2){

        int n = str1.length();
        int m = str2.length();

        int[][]dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int j = 0; j <= m; j++) dp[0][j] = 0;

        int maxi = 0;

        for(int ind1 = 1; ind1 <= n; ind1++){
            for(int ind2 = 1; ind2 <= m; ind2++){
                if(str1.charAt(ind1-1) == str2.charAt(ind2-1)){
                    int val = 1 + dp[ind1-1][ind2-1];
                    dp[ind1][ind2] = val;
                    maxi = Math.max(maxi,val);
                }
                else dp[ind1][ind2] = 0;
            }
        }
        return maxi;
    }

}
