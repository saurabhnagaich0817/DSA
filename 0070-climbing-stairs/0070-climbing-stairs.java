class Solution {
    
    public int climbStairs(int n) {
        
        // Create an array to store the number of ways to reach each step.
        int[] dp = new int[n + 2];
        
        // Base cases: There is 0 way to reach step 0, and 1 way to reach step 1.
        dp[0] = 0;
        dp[1] = 1;
        
        // Iterate through the steps, starting from step 2.
        for (int i = 2; i <= n + 1; i++) {
            // The number of ways to reach the current step is the sum of
            // the ways to reach the previous two steps.
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // The result is the number of ways to reach the final step (step n).
        return dp[n + 1];
    }
}