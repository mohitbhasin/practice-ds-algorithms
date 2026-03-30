import java.util.*;

// Time complexity: O(n^2)
// Recursion and DP
class FindMinimumCostToRemoveArrayElements {
	public static void main(String[] args) {
		List<int[]> numsList = new ArrayList<>();
		numsList.add(new int[]{6,2,8,4});
		numsList.add(new int[]{2,1,3,3});
		
		for(int[] nums: numsList) {
			System.out.println(minCost(nums));
		}
	}

	public static int minCost(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n+1][n+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		return solve(0, 1, nums, dp);
    }

    public static int solve(int lastIndex, int index, int[] nums, int[][] dp) {
		int n = nums.length;
		if(index>=nums.length) {
			return nums[lastIndex];
		}
		if(index==nums.length-1) {
			return Math.max(nums[lastIndex], nums[index]);
		}
		if(dp[lastIndex][index]!=-1) {
			return dp[lastIndex][index];
		}
		int res1 = Math.max(nums[index], nums[index+1]) + solve(lastIndex, index+2, nums, dp);
		int res2 = Math.max(nums[lastIndex], nums[index]) + solve(index+1, index+2, nums, dp);
		int res3 = Math.max(nums[lastIndex], nums[index+1]) + solve(index, index+2, nums, dp);

		dp[lastIndex][index] = Math.min(res1, Math.min(res2, res3));

		return dp[lastIndex][index];
    }
}