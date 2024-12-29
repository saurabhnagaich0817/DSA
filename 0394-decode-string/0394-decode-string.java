
class Solution {
    public String decodeString(String s) {
        List<String> ans = decodeString2(s, 0);

        return ans.get(0);
    }

    // returns string out of brackets 
    //AND on what index it stopped
    public List<String> decodeString2(String s, int x){

        StringBuilder ans = new StringBuilder();
        int num = 0;
        StringBuilder str = new StringBuilder();

        int n = s.length();
        // Starring from the character after '[' we go through each element
        for (int i=x; i<n; i++){
            char c = s.charAt(i);
            switch(c) {
            case '[':
                List<String> temp = decodeString2(s, i+1);
                for (int k=0; k<num; k++){
                    str.append(temp.get(0));
                }
                i = Integer.valueOf(temp.get(1));
                num = 0; 
                break;
            case ']':
                ans.append(str);
                return new ArrayList<>(Arrays.asList(ans.toString(), ""+i));
            default:
                if (c>='a' && c<='z'){
                    str.append(c);
                } else {
                    num = num*10 + (c-'0');
                }
            }
        }

        return new ArrayList<String>(Arrays.asList(ans.toString()+str.toString(), "0"));
    }
}
 