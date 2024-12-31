class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        if (set.size() < 3) {
            return set.last(); // Return maximum if there are fewer than 3 elements
        }

        set.pollLast(); // Remove the largest
        set.pollLast(); // Remove the second largest
        return set.last(); // Return the third largest
    }
}