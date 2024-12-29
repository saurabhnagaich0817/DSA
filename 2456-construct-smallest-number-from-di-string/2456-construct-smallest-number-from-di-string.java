class Solution {
    public String smallestNumber(String pattern) {

        // Approach-1 (My Thinking)
        String str = "";
        int val = 1;
        for (int i = 0; i <= pattern.length(); i++) {
            // Checking if the value at the "i" index is 'I'
            // then just add the 'val' to the string
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                str += Integer.toString(val);
                val++;
            } else {
                // Counting the number of 'D'(Decreasment Value) are their
                // In the Given Pattern in a sequence
                int count = 0;
                while (i < pattern.length() && pattern.charAt(i) == 'D') {
                    count++;
                    i++;
                }

                // Adding value to the string
                // As the String(Pattern) consist of 'D'
                for (int idx = count; idx >= 0; idx--) {
                    str += Integer.toString(idx + val);
                }
                val += (count + 1);
            }
        }
        return str;




        // Approach-2
        // Got SomeWhere from the Discusssion
        // StringBuilder sb = new StringBuilder();
        // StringBuilder res = new StringBuilder();
        // for (int i = 0; i <= pattern.length(); i++) {
        //     sb.append((char) ('1' + i));
        //     if (i == pattern.length() || pattern.charAt(i) == 'I') {
        //         res.append(sb.reverse());
        //         sb = new StringBuilder();
        //     }
        // }
        // return res.toString();
    }
}