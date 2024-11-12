class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a[]=new int[2];  int n=nums.length;
        a[0]=a[1]=-1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    a[0]=i;
                    a[1]=j;
                     return a;


                }
            }
        }
        return a;
        
    }
}