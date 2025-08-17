class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int len=0;
        int n=s.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        while(r<n){
         if(mp.containsKey(s.charAt(r))){
            l=Math.max(mp.get(s.charAt(r))+1,l);
         }
         mp.put(s.charAt(r),r);
         len=Math.max(len,r-l+1);
         r++;

        }
        return len;
    }
}