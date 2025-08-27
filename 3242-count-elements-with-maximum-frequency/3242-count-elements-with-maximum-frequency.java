class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>mp=new HashMap<>();

        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        int mf=0;
        int c=0;
        for(Map.Entry<Integer,Integer>e:mp.entrySet()){
            int cf=e.getValue();
            if(cf>mf){
                mf=cf;
                c=1;
            }else if(cf==mf){
                 c++; 
            }

        }
        return c*mf;
    }
}