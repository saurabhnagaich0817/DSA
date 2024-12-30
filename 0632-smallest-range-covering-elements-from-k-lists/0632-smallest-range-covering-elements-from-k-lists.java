class Solution {
    static public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size(), ind = 0, x = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) x += nums.get(i).size();
        int[][] arr = new int[x][2];
        for (int i = 0; i < n; i++) {
            int len = nums.get(i).size();
            for (int j = 0; j < len; j++) {
                arr[ind][0] = nums.get(i).get(j);
                arr[ind++][1] = i + 1;
            }
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int i = 0, j = 0, min = Integer.MAX_VALUE, r1 = -1, r2 = -1, differentPresent = 0;
        int[] present = new int[n + 1];
        while (j < ind) {
            if (differentPresent < n) {
                if (present[arr[j][1]] == 0) differentPresent++;
                present[arr[j][1]]++;
            }

            if (differentPresent == n) {
                int range = arr[j][0] - arr[i][0];
                if (range < min) {
                    min = range;
                    r1 = arr[i][0];
                    r2 = arr[j][0];
                }
                present[arr[i][1]]--;
                if (present[arr[i++][1]] == 0) differentPresent--;
            }

            if (differentPresent < n)
                j++;
        }
        return new int[] { r1, r2 };
    }
}