class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        // Initialize with very small values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // Start position
        for (int k = 0; k < 3; k++) {
            if (coins[0][0] >= 0) {
                dp[0][0][k] = coins[0][0];
            } else {
                if (k > 0)
                    dp[0][0][k] = 0; // neutralize
                else
                    dp[0][0][k] = coins[0][0];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                for (int k = 0; k < 3; k++) {

                    int bestPrev = Integer.MIN_VALUE;

                    // from top
                    if (i > 0) {
                        bestPrev = Math.max(bestPrev, dp[i - 1][j][k]);
                    }

                    // from left
                    if (j > 0) {
                        bestPrev = Math.max(bestPrev, dp[i][j - 1][k]);
                    }

                    if (bestPrev != Integer.MIN_VALUE) {
                        // take value normally
                        dp[i][j][k] = Math.max(dp[i][j][k], bestPrev + coins[i][j]);
                    }

                    // if negative, try neutralizing
                    if (coins[i][j] < 0 && k > 0) {
                        int bestPrevNeutral = Integer.MIN_VALUE;

                        if (i > 0) {
                            bestPrevNeutral = Math.max(bestPrevNeutral, dp[i - 1][j][k - 1]);
                        }
                        if (j > 0) {
                            bestPrevNeutral = Math.max(bestPrevNeutral, dp[i][j - 1][k - 1]);
                        }

                        if (bestPrevNeutral != Integer.MIN_VALUE) {
                            dp[i][j][k] = Math.max(dp[i][j][k], bestPrevNeutral);
                        }
                    }
                }
            }
        }

        return Math.max(dp[m - 1][n - 1][0],
               Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}
