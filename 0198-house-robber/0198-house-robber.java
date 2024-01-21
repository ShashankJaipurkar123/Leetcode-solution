class Solution {
// TC : O(n) ||  SC : (1)
    private int tabulationSpaceOptimize(int[] nums) {
		int rob1 = 0;
		int rob2 = 0;
		int max_val = 0;
		for (int ele : nums) {
			max_val = Math.max(ele + rob1, rob2);
			rob1 = rob2;
			rob2 = max_val;
		}
		return max_val;
	}
//TC : O(n) ||  SC : (n) 
	private int memoizationUtil(int[] nums, int index, int[] dp) {
		if (index == 0) {
			return 0;
		}
		if (index == 1) {
			return nums[0];
		}
		if (dp[index] != -1) {
			return dp[index];
		}
		int leave = memoizationUtil(nums, index - 1, dp);// do not take current element
		int take = nums[index - 1] + memoizationUtil(nums, index - 2, dp); // take current element and ignore next
																			// element
		dp[index] = Math.max(leave, take);
		return dp[index];
	}

	private int memoization(int[] nums) {
		int[] dp = new int[nums.length + 1];
		Arrays.fill(dp, -1);
		return memoizationUtil(nums, nums.length, dp);
	}
//TC : O(n) ||  SC : (n) 
	private int tabulation(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		if (nums.length == 1) {
			return dp[0];
		}
		dp[1] = Math.max(nums[1], dp[0]);
		for (int i = 2; i < nums.length; i++) {
			int leave = dp[i - 1];// do not take current element
			int take = dp[i - 2] + nums[i];// take current element and ignore next element
			dp[i] = Math.max(leave, take);
		}
		return dp[nums.length - 1];
	}

	public int rob(int[] nums) {
		// return tabulationSpaceOptimize(nums);
		// return memoization(nums);
		return tabulation(nums);
	}
}