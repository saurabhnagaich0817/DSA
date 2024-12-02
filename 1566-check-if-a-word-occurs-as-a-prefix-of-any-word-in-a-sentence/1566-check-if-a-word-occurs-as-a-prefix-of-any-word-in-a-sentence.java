class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] w =sentence.split(" ");
        for(int i=0;i < w.length;i++){
            if(w[i].startsWith(searchWord)){
                return i+1;

            }
        }
        return -1;
    }
}