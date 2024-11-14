class Solution {
    public int minimizedMaximum(int n, int[] q) {
        
        int l=1;
        int h=Integer.MIN_VALUE;
        int res=0;
        for(int i=0;i<q.length;i++){
            h=Math.max(h,q[i]);
        }
        while(l<=h){
            int mid = l+(h-l)/2;
            int store=0;
            for(int i=0;i<q.length;i++){
                store+=(q[i]+mid-1)/mid;

            }
            if(store<=n){
                res=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}