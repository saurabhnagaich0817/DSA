class Solution {
    private int rec(int i,int xor,int n,int[] nums)
    {
        if(i==n) return xor;
        if(i>=n) return 0;

        int pick = rec(i+1,xor^nums[i],n,nums);
        int dont = rec(i+1,xor,n,nums);
        return pick + dont;
    }
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        return  rec(0,0,n,nums);
    }
}