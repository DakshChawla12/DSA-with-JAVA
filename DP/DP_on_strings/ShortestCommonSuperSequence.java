import java.util.*;

public class ShortestCommonSuperSequence {

    public int helper(String s1, int idx1, String s2, int idx2, int[][] dp) { // *** Memoization using index shifting to help in tabulation
        // *** Memoization using index shifting to help in tabulation
        if (idx1 == 0 || idx2 == 0) return 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
            return dp[idx1][idx2] = 1 + helper(s1, idx1 - 1, s2, idx2 - 1, dp);
        }

        return dp[idx1][idx2] = Math.max(helper(s1, idx1, s2, idx2 - 1, dp),
                helper(s1, idx1 - 1, s2, idx2, dp));
    }

    public String shortestCommonSupersequence(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }


        int len = (n + m) - helper(str1, n, str2, m, dp); // this will be the length of shortest common supersequence

        int i = n, j = m;
        StringBuilder sb = new StringBuilder("");

        // Reconstruct the shortest common supersequence
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // If characters match, append one and move diagonally
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // If the length is greater by moving up, append from str1 and move up
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                // If the length is greater by moving left, append from str2 and move left
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Append remaining characters from str1 and str2
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        // Reverse and return the result
        return sb.reverse().toString();
    }


}
