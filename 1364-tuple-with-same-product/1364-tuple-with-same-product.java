class Solution {
    public int tupleSameProduct(int[] nums) {
        Map <Integer,Integer>  mp=new HashMap<>();
        int c=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int m=nums[i]*nums[j];
                int fre=mp.getOrDefault(m,0);
                if(fre>0){
                    c+=fre; 
                }
                mp.put(m,fre+1);
            }
        }
        return c*8;
    }
}