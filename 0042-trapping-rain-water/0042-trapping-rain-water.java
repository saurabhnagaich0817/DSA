class Solution {
    public int trap(int[] h) {
        int n=h.length;
        int lmax=0;
        int rmax=0;
        int t=0;
        int l=0;
        int r=n-1;
        while(l<r){
            if(h[l]<=h[r]){
                if(h[l]>=lmax){
                    lmax=h[l];
                }else{
                    t+=lmax-h[l];
                }
                l++;
            }else{
                if(h[r]>=rmax){
                    rmax=h[r];
                }else{
                    t+=rmax-h[r];
                }
                r--;
            }
        }
        return t;
    }
}