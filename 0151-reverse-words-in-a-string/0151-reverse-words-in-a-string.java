class Solution {
    public String reverseWords(String s) {
       return reverse( s); 
       
    }
    static String reverse(String s){
        String [] w =s.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i=w.length-1;i>=0;i--){
            sb.append(w[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}