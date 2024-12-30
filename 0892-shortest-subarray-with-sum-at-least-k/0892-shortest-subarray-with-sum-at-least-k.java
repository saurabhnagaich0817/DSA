class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
		
		long[] prefixSum = new long[n + 1];
		
        // Storing prefix
		for (int i = 1; i < n + 1; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}
		
		Deque<Integer> deque = new LinkedList<>();
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < prefixSum.length; i++) {
			
            // Take element in the left most side (smallest index) then if we can
            // add our left element with k and it is less than our curr element
            // then it is a possible solution
			while (!deque.isEmpty() && prefixSum[i] >= prefixSum[deque.peekFirst()] + k) {
				min = Math.min(min, i - deque.pollFirst());

                // after that remove that element because we dont need it anymore
			}
			
            // We always keep track of the smallest element
            // So if our current element is less than the last small number
            // pop our last element
			while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
				deque.pollLast();
			}


            // Finally adding our curr element index
			deque.addLast(i);
		}
		
        // If we haven't found any subarray return -1
		return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}