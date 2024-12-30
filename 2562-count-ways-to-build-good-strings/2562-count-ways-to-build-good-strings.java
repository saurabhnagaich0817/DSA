public class Solution
{
    public int countGoodStrings(int low, int high, int zero, int one)
    {
        final int MOD = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1; // Step 1: Base case - one way to form an empty string
        
        // Step 2: Iterate over all lengths from 1 to high
        for (int length = 1; length <= high; length++)
        {
            // Step 3: Check if 'zero' can be appended
            if (length >= zero)
            {
                dp[length] = (dp[length] + dp[length - zero]) % MOD;
            }
            
            // Step 4: Check if 'one' can be appended
            if (length >= one)
            {
                dp[length] = (dp[length] + dp[length - one]) % MOD;
            }
        }
        
        // Step 5: Sum dp values for valid lengths in the range [low, high]
        int result = 0;
        for (int length = low; length <= high; length++)
        {
            result = (result + dp[length]) % MOD;
        }
        
        return result; // Step 6: Return the result
    }
}