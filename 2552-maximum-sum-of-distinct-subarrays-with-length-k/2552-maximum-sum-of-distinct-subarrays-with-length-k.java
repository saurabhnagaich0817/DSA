class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> s=new HashSet<>();
        int l=0;
        int r=0;
        long sum=0;
        long max=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(s.contains(nums[i])){
                sum-=nums[j];
                s.remove(nums[j]);
                j++;
            }
            s.add(nums[i]);
            sum+=nums[i];
            if(s.size()==k){
                max=Math.max(sum,max);
                sum-=nums[j];
                s.remove(nums[j]);
                j++;
            }
        }
        return max;
    }
}