class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int p=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                int t=nums[i];
                nums[i]=nums[p];
                nums[p]=t;
                p++;
            }
        }
        return  nums;
    }
}