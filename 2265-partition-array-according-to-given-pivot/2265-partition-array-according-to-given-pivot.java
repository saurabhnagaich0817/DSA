class Solution {
    public int[] pivotArray(int[] nums, int p) {
        int i=0;
        int [] res=new int [nums.length];
        for(int k=0;k<nums.length;k++){
            if(nums[k]<p){
                res[i]=nums[k];
                i++;
            }
        }
        for(int k=0;k<nums.length;k++){
            if(nums[k]==p){
                res[i]=nums[k];
                i++;
            }
        }
        for(int k=0;k<nums.length;k++){
            if(nums[k]>p){
                res[i]=nums[k];
                i++;
            }
        }
        return res;
    }
}