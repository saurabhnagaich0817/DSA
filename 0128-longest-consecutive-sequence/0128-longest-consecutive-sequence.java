class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashMap<Integer,Integer> hm= new HashMap<>();
        int max=-1;
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);

        } 
        for(int i=0;i<nums.length;i++){
            int cnt=0;
            if(hm.containsKey(nums[i]-1)){
                continue;
            }
        else{
            int k=nums[i];
            while(hm.containsKey(k)){
                k++;
                cnt++;
            }
         max=Math.max(cnt,max);
        }
        
    }
        return max;
    }
    
}