class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String>map=new HashMap<>();
        String []arr=s.split(" ");
        if(arr.length!=pattern.length()){
            return false;
        }
        char c1;
        for(int i=0;i<pattern.length();i++){
            c1=pattern.charAt(i);
            if(!map.containsKey(c1)&&!map.containsValue(arr[i])){
                map.put(c1,arr[i]);
            }else if(map.containsKey(c1)){
                if(!map.get(c1).equals(arr[i])){
                    return false;
                }
            }else if(map.containsValue(arr[i])){
                if(!map.containsKey(c1)){
                    return false;
                }
            }
        }
        return true;
    }
}