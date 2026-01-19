import java.util.*;

class RandomPickIndex {
	Map<Integer, List<Integer>> map;
    Random rand;
    public RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        rand = new Random();
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        
    }
    
    public int pick(int target) {
        List<Integer> indexList = map.get(target);
        return indexList.get(rand.nextInt(indexList.size()));
    }
}