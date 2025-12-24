public class Solution {
    public int[][] MergeArrays(int[][] nums1, int[][] nums2) {
        
        int i=0;
        int j=0;
        List<int []> res=new List<int []>();
        while(i<nums1.Length && j<nums2.Length){
            int idx1=nums1[i][0];
            int val1=nums1[i][1];
            int idx2=nums2[j][0];
            int val2=nums2[j][1];

            if(idx1<idx2){
                res.Add(new int[]{idx1,val1});
                i++;

            }else if(idx2<idx1){
                res.Add(new int []{idx2,val2});
                j++;
            }else{
                res.Add(new int[]{idx1,val1+val2});
                i++;
                j++;
            }


        }
        while(i<nums1.Length){
            res.Add(nums1[i]);
            i++;
        }
        while(j<nums2.Length){
            res.Add(nums2[j]);
            j++;
        }
        return res.ToArray();
    }
}