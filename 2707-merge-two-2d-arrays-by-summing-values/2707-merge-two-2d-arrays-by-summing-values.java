class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // Create a list to store the merged result
        List<int[]> list = new ArrayList<>();
        
        // Initialize pointers for both input arrays
        int p1 = 0, p2 = 0;

        // Iterate through both arrays while pointers are valid
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1][0] == nums2[p2][0]) { 
                // Case: Same keys, merge by adding their second elements
                list.add(new int[]{nums1[p1][0], nums1[p1][1] + nums2[p2][1]});
                ++p1; // Move both pointers forward
                ++p2;
            } else if (nums1[p1][0] < nums2[p2][0]) { 
                // Case: nums1 key is smaller, add nums1[p1] and increment p1
                list.add(nums1[p1]);
                ++p1;
            } else {
                // Case: nums2 key is smaller, add nums2[p2] and increment p2
                list.add(nums2[p2]);
                ++p2;
            }
        }

        // Add remaining elements from nums1 (if any)
        while (p1 < nums1.length) {
            list.add(nums1[p1]);
            ++p1;
        }

        // Add remaining elements from nums2 (if any)
        while (p2 < nums2.length) {
            list.add(nums2[p2]);
            ++p2;
        }

        // Convert the list to a 2D array and return
        return list.toArray(new int[0][0]);
    }
}