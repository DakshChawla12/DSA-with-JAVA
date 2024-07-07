package DP_on_grids;

import java.util.Arrays;

public class NinjasTraining {

    public static int helper(int day, int lastDay, int[][] points, int[][] dp) { // *** memoization
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != lastDay) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        if (dp[day][lastDay] != -1) {
            return dp[day][lastDay];
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != lastDay) {
                int currPoints = points[day][task] + helper(day - 1, task, points, dp);
                maxi = Math.max(maxi, currPoints);
            }
        }
        return dp[day][lastDay] = maxi;
    }

    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(n - 1, 3, points, dp);
    }

}
