class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      int n = s1.length(), m = s2.length(), l = s3.length(); 
      if (n + m != l) return false;  // If lengths don't match, return false

      boolean dp[][] = new boolean[n + 1][m + 1];
      dp[0][0] = true;  // Empty strings case

      // Fill the first row
      for (int i = 1; i <= n; i++) {
        dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
      } 

      // Fill the first column
      for (int j = 1; j <= m; j++) {
        dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
      }

      // Fill the rest of the DP table
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            boolean takes1 = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
            boolean takes2 = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            dp[i][j] = takes1 || takes2;
        }
      }
      return dp[n][m];  // Return the result
    }
}