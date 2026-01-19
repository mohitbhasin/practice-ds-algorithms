import java.util.*;

class SubarraySumEqualsK {
	public static void main(String[] args) {
		List<Map.Entry<int[], Integer>> entryList = new ArrayList<>();
		entryList.add(Map.entry(new int[]{1,2,3}, 3));
		entryList.add(Map.entry(new int[]{1,1,1}, 2));
        entryList.add(Map.entry(new int[]{-1,-1,1}, 0));

		for(Map.Entry<int[], Integer> entry: entryList) {
			System.out.println(subarraySum(entry.getKey(), entry.getValue()));
		}
	}

	public static int subarraySum_bf(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            sum=0;
            for(int j=i; j<nums.length; j++) {
                sum+=nums[j];
                if(sum==k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int result = 0;
        int sum = 0;
        for(int num: nums) {
            sum+=num;
            if(map.containsKey(sum-k)) {
                result+=map.get(sum-k);
            }
            map.put(sum,1);
        }
        return result;
	}
}