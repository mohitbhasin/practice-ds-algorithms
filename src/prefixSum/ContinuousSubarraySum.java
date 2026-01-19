import java.util.*;

class ContinuousSubarraySum {
	public static void main(String[] args) {
        List<Map.Entry<int[], Integer>> numsList = new ArrayList<>();
        
        numsList.add(Map.entry(new int[]{23,2,4,6,7}, 6) );
        numsList.add(Map.entry(new int[]{23,2,4,6,6}, 7) );
        numsList.add(Map.entry(new int[]{5,0,0,0}, 3) );

        for(Map.Entry<int[], Integer> entry: numsList) {
            System.out.println(checkSubarraySum(entry.getKey(), entry.getValue()));
        }
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        // map of remainder and index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            int remainder = sum%k;
            if(map.containsKey(remainder)) { 
                if(i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}