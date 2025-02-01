class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] nge=new int[nums.length];
        Arrays.fill(nge,-1);
        int n=nums.length;
        for(int i=0;i<=n-1;i++){
            for(int j=i+1;j<=i+n-1;j++){
                int ind=j%n;
                if(nums[ind]>nums[i]){
                    nge[i]=nums[ind];
                    break;
                }
            }
        }
        return nge;
        

    }
}