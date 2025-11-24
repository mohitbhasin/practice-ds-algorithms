import java.util.*;

public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        List<int[]> numsList = new ArrayList<>();
        List<int[]> kList = new ArrayList<>();

        numsList.add(new int[]{2,1,4,3,2});
        kList.add(new int[]{2,3});

        for(int i=0; i<numsList.size(); i++) {
            System.out.println(countSubarrays_bf(numsList.get(i), kList.get(i)[0], kList.get(i)[1]));
        }

    }


    // Bruteforce O(n^3)
    public static long countSubarrays_bf(int[] nums, int minK, int maxK) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            List<Integer> subList = new ArrayList<>();
            for(int j=i; j<nums.length; j++) {
                subList.add(nums[j]);
                if(isValid(subList, minK, maxK)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static boolean isValid(List<Integer> list, int minK, int maxK) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int val: list) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        
        return min==minK && max==maxK;
    }
    
}