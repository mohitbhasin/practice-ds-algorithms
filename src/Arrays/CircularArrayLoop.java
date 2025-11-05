import java.util.*;

class CircularArrayLoop {
	public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{5,4,-2,-1,3});
        list.add(new int[]{1,3,-2,-4,1});

        for(int[] arr: list) {
            System.out.println(circularArrayLoop(arr));
        }
    }

	public static boolean circularArrayLoop(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int slow = i;
            int fast = i;
            boolean sign = nums[i]>0;
            while(true) {
               slow = getIndex(nums, slow);
               fast = getIndex(nums, getIndex(nums, fast));
               // checking the next value is the same direction as the sign.
               if(nums[slow]>0 != sign || nums[fast]>0 != sign) {
                  break;
               }
               // Ensure the cycle has more than one element
               if(slow==fast) {
                  if(slow==getIndex(nums, slow)) {
                     break;
                  }
                 return true;
               }
            }
        }
        return false;
    }

    public static int getIndex(int[] nums, int index) {
        int next = index + nums[index];
        next = next % nums.length;
        if(next<0) {
           next+=nums.length;
        }
        return next;
    }
}