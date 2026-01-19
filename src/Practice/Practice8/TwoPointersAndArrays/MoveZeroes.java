import java.util.*;

class MoveZeroes {
    public static void main(String[] args) {
        List<int[]> numsList = new ArrayList<>();
        numsList.add(new int[]{0,1,0,9,5});
        numsList.add(new int[]{2});

        for(int[] nums: numsList) {
            moveZeroes(nums);
            Arrays.stream(nums).forEach(val -> System.out.print(val+", "));
            System.out.println();
        }
    }

    public static void moveZeroes(int[] nums) {
        int prev = 0;
        int curr = 0;
        while(curr<nums.length) {
            if(nums[curr]!=0) {
                //swap
                int temp = nums[curr];
                nums[curr] = nums[prev];
                nums[prev] = temp;
                prev++;
            }
            curr++;
        }
    }
}