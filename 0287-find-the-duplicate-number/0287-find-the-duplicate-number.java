class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[i+1]){
                   continue;
            }else{

                   return nums[i+1];
            }
        }
        return -1;
    }
}