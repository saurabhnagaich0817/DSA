class Solution 
{
    public static int val(int mask2,int nums1[],int nums2[],int i,int n,HashMap<String,Integer> map)
    {
    
        
        if(mask2==((1<<(n))-1))
           {
               return 0;
           }
         if(map.containsKey(i+"$"+mask2))
         {
             return map.get(i+"$"+mask2);
         }
           int min1=Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
        {
            if((mask2&(1<<j))==0)
            {
                min1=Math.min(min1,(nums1[i]^nums2[j])+val((mask2|(1<<j)),nums1,nums2,i+1,n,map));
            }
        }
        map.put(i+"$"+mask2,min1);
        return min1;

    }
    public int minimumXORSum(int[] nums1, int[] nums2) 
    {
        int n=nums1.length;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
      return   val(0,nums1,nums2,0,n,map);
        
    }
}