class Solution {
    public int[] diStringMatch(String s) {
        int res [] = new int[s.length()+1];
        int I =0;
        int j=0;

        int D =s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)== 'I'){
                res[j++]=I;
                I++;
            }else{
                res[j++]=D;
                D--;
            }
        }
        res[j]=I;
        return res;
    }
}