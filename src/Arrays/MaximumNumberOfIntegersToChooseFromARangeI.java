import java.util.*;

class MaximumNumberOfIntegersToChooseFromARangeI {
	public static void main(String[] args) {
		System.out.println(maxCount(new int[]{2,4}, 5, 10));
		System.out.println(maxCount(new int[]{1,2,3,4,5}, 5, 15));
		System.out.println(maxCount(new int[]{10,20,30}, 50, 6));
	}

	public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        
        for(int val: banned) {
            set.add(val);
        }
        
        int count = 0;
        int currSum = 0;
        for(int i=1; i<=n; i++) {
            if(!set.contains(i)) {
                if(currSum+i>maxSum) {
                    return count;
                }
                count++;
                currSum+=i;
            }
        }
        return count;
    }
}