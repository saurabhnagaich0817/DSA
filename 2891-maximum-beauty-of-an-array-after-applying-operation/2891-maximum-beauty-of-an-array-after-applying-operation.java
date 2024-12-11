class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Step 1: Sort the array to facilitate binary search
        Arrays.sort(nums);

        int n = nums.length;
        int max = 1; // Variable to track the maximum size of a valid subsequence

        // Step 2: Iterate through each element to find the maximum valid subsequence size
        for (int i = 0; i < n; i++) {
            // Find the upper bound index where nums[j] <= nums[i] + 2*k using binary search
            int ub = find(nums, nums[i] + 2 * k);
            // Update max with the size of the current valid subsequence
            max = Math.max(max, ub - i + 1);
        }
        return max; // Return the maximum valid subsequence size
    }

    // Helper method to find the upper bound index where nums[j] <= val
    private int find(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        int res = -1; // Stores the index of the last element <= val

        while (l <= r) {
            int mid = l + (r - l) / 2; // Calculate mid-point to prevent overflow
            if (nums[mid] <= val) {
                res = mid; // Update result and search in the right half
                l = mid + 1;
            } else {
                r = mid - 1; // Search in the left half
            }
        }
        return res; // Return the index of the last element <= val
    }
}