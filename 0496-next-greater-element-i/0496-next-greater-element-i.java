class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            int n=nums2[i];
            while(!st.isEmpty()&& st.peek()<=n){
                st.pop();
            }
            if(st.isEmpty()){
                mp.put(n,-1);
            }else{
               mp.put(n,st.peek());
            }
         st.push(n);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=mp.containsKey(nums1[i])?mp.get(nums1[i]):-1;
        }
        return nums1;
    }


}