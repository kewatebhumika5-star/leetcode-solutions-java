class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int minCost = Integer.MAX_VALUE;

        // First subarray starts at 0
        for (int i = 1; i < n - 1; i++) {          // start of 2nd subarray
            for (int j = i + 1; j < n; j++) {      // start of 3rd subarray
                int cost = nums[0] + nums[i] + nums[j];
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }
}
