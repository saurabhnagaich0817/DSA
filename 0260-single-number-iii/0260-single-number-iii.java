class Solution {
    public int[] singleNumber(int[] nums) {
        int a=0;
        for(int i=0;i<nums.length;i++){
            a^=nums[i];
        }
        int mask=(a&(~(a-1)));
        int b=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & mask) !=0){
                b ^=nums[i];
            }
        }
        int c=a^b;
       int d[]={b,c};
       return d;

    }
}