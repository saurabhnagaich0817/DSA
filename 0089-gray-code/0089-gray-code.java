class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> li = new ArrayList<>();
        int range = 1<<n;
        for(int i=0;i<range;i++){
            int num= i^(i>>1);
            li.add(num);
        }
        return li;
    }
}