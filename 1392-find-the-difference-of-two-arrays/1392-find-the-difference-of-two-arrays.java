class Solution {
    List<Integer> remove(List<Integer> a1) {
        List<Integer> x = new ArrayList<Integer>();
        for (int i : a1) {
            if (i == 1001)
                continue;
            x.add(i);
        }
        return x;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> x = new ArrayList<List<Integer>>();
        List<Integer> a1 = new ArrayList<Integer>();
        List<Integer> a2 = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i : nums1) {
            if (a1.contains(i) == false) {
                a1.add(i);
            }
        }
        for (int i : nums2) {
            if (a2.contains(i) == false) {
                a2.add(i);
            }
        }
        int l1 = a1.size();
        int l2 = a2.size();
        for (int i = 0; i < l1; i++) {
            if (a2.contains(a1.get(i)) == true) {
                int ind = a2.indexOf(a1.get(i));
                a2.remove(ind);
                a1.set(i, 1001);
            }
        }

        x.add(remove(a1));
        x.add(remove(a2));
        return x;
    }
}