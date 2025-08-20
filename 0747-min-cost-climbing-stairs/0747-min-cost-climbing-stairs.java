class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int []dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<dp.length;i++){
            int first=dp[i-1];
            int sec=dp[i-2];
            dp[i]=Math.min(first,sec)+cost[i];
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}