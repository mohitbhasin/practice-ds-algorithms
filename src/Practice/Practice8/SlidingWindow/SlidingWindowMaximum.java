import java.util.*;
import java.util.stream.*;

class SlidingWindowMaximum {
	public static void main(String[] args) {
		List<Map.Entry<int[], Integer>> list = new ArrayList<>();
        list.add(Map.entry(new int[] {-4,2,-5,3,6}, 3));
        list.add(Map.entry(new int[] {1,3,-1,-3,5,3,6,7}, 3));
        list.add(Map.entry(new int[] {10,6,9,-3,23,-1,34,56,67,-1,-4,-8,-2,9,10,34,67}, 3));

        for(Map.Entry<int[], Integer> entry: list) {
            int[] result = maxSlidingWindow(entry.getKey(), entry.getValue());

            Arrays.stream(result).forEach(val -> System.out.print(val+", "));
            System.out.println();
        }
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];

        Deque<Integer> deq = new LinkedList<>();
        for(int i=0; i<k; i++) {
        	while(!deq.isEmpty() && nums[deq.peekLast()]<nums[i]) {
        		deq.removeLast();
        	}
        	deq.addLast(i);
        }
        result[0]=nums[deq.peekFirst()];

        for(int i=k; i<nums.length; i++) {
        	if(deq.peekFirst()<=i-k) {
        		deq.removeFirst();
        	}
        	while(!deq.isEmpty() && nums[deq.peekLast()]<nums[i]) {
        		deq.removeLast();
        	}
        	deq.addLast(i);

        	result[i-k+1]=nums[deq.peekFirst()];
        }

        return result;
    }
}