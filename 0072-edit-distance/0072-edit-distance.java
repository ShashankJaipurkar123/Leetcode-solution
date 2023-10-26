class Solution {
    private int memoizationUtil(String X, String Y, int m, int n, int[][] dp) {
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}
		if (dp[m][n] != -1) {
			return dp[m][n];
		}
		if (X.charAt(m - 1) == Y.charAt(n - 1)) {
			dp[m][n] = memoizationUtil(X, Y, m - 1, n - 1, dp);
		} else {
			dp[m][n] = 1 + Math.min(memoizationUtil(X, Y, m, n - 1, dp),/*insert*/
					Math.min(memoizationUtil(X, Y, m - 1, n, dp),/*delete*/ memoizationUtil(X, Y, m - 1, n - 1, dp)/*Replace*/));
		}
		return dp[m][n];
	}

	private int memoization(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return memoizationUtil(str1, str2, m, n, dp);
	}

	private int tabulation(String X, String Y) {
		int m = X.length();
		int n = Y.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
				}
			}
		}
		return dp[m][n];
	}
    
    private int tabulation2(String X, String Y) {
		int m = X.length();
		int n = Y.length();
		int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];
        for(int j = 0; j <= n; j++){
            prev[j] = j;
        }
		for (int i = 0; i <= m; i++) {
            // int[] cur = new int[n + 1];
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					cur[j] = j;
				} else if (j == 0) {
					cur[j] = i;
				} else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					cur[j] = prev[j - 1];
				} else {
					cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
				}
			}
            prev = (int[])(cur.clone());;
		}
		return prev[n];
	}
    
    public int minDistance(String word1, String word2) {
        // return tabulation(word1, word2);
        // return memoization(word1, word2);
        return tabulation2(word1, word2);
    }
}