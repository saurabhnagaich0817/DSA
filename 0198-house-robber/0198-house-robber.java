class Solution {
    public int rob(int[] nums) {
        return find(nums);

    }
    public static int find(int []nums){
        if(nums.length==1){
            return nums[0];
        }
        int []dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<dp.length;i++){
            int rob=nums[i]+dp[i-2];
            int dn_rob=dp[i-1];
            dp[i]=Math.max(rob,dn_rob);
        }
        return dp[dp.length-1];

    }
    
}