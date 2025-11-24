import java.util.*;

class TwoSumLessThanK {
    public static void main(String[] args) {
        List<int[]> numsList = new ArrayList<>();
        List<Integer> kList = new ArrayList<>();

        numsList.add(new int[]{4,2,11,2,5,3,5,8});
        kList.add(7);
        
        numsList.add(new int[]{10,20,30});
        kList.add(15);
        
        numsList.add(new int[]{34,23,1,24,75,33,54,8});
        kList.add(60);

        for(int i=0; i<numsList.size(); i++) {
            System.out.println(twoSumLessThanK(numsList.get(i), kList.get(i)));
        }
    }

    public static int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length-1;
        int result = -1;
        while(left<right) {
            int sum = nums[left]+nums[right];
            if(sum>=k) {
                right--;
            } else {
                result = Math.max(result, sum);
                left++;
            }
        }
        return result;
    }
}