class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int mv=0;
        for(int i=0;i<nums.length;i++){

            if(nums[i]>mv){
                mv=nums[i];
            }
        }
        int ml=0;
        int cl=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==mv){
                cl++;
            }else{
                ml=Math.max(cl,ml);
                cl=0;
            }
        }
        return Math.max(ml,cl);
    }
}