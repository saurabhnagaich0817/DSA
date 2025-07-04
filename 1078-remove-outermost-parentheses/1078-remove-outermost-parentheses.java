class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int st=0;
        int o=0;
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                o++;
            }else{
                c++;
            }
            if(o==c ){
                sb.append(s.substring(st+1,i));
                st=i+1;
            o=0;
            c=0;

            }
        }
        return sb.toString();
    }
}