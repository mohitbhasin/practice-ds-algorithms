class LongestSubarrayWithMaximumBitwiseAND {
	public static void main(String[] args) {
		// int[] nums = {2,1,3,3};
	    // int[] nums = {1,1,2,8};
	    int[] nums = {1,2,3,3,2,2};
	    System.out.println(longestSubarray(nums));
	}

	// Bitwise AND property to keep in mind is:
	// A & B is always less than or equal to min of A and B
	// A & B <= min(A,B)
	// eg. 1 & 2 = 0 (0 <= min(1,2))
	//     5 & 7 = 5
	
	// Therefor maximum bitwise AND will be equal to the max element in the array.
	// To find the max length of max possible bitwise AND will be,
	// max length of contigous max element in array.
    public static int longestSubarray(int[] nums) {
        int max = 0;
        for(int val: nums) {
            max = Math.max(max, val);
        }
        int maxLen = 1;
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==max) {
                count++;
                maxLen = Math.max(maxLen, count);
            } else {
                count=0;
            }
        }
        return maxLen; 
    }
}