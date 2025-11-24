import java.util.*;

class MaximumProductSubarray {
	public static void main(String[] args) {
        List<int[]> numsList = new ArrayList<>();

        numsList.add(new int[] {2,3,-2,4});
        numsList.add(new int[] {-2,0,-1,5});
        numsList.add(new int[] {-9,0,5,0});
        numsList.add(new int[] {-2,0,-1});

        for(int i=0; i<numsList.size(); i++) {
            System.out.println(maxProduct(numsList.get(i)));
        }
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0]; 
        int product = 1;

        for(int num : nums) {
            if(num == 0) {
                product = 1; 
                max = Math.max(max, 0); 
            } else {
                product *= num;
                max = Math.max(max, product);
            }
        }

        product = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if(num == 0) {
                product = 1;
            } else {
                product *= num;
                max = Math.max(max, product);
            }
        }
        
        return max;
   }
}