import java.util.*;

class FindSecondMaximumValue {
	public static void main(String args[]) {
		List<int[]> list = new ArrayList<>();
		list.add(new int[]{11,10,2,10,4,5,6,7});
		list.add(new int[]{1,1,1,1});
		
		list.stream()
		.forEach(arr -> System.out.println("\nfindSecondMax(): "+findSecondMax(arr)+"\nfindSecondLargest(): "+findSecondLargest(arr)));
	}

	public static int findSecondMax(int[] arr) {
		if(arr.length==0) throw new IllegalArgumentException();
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				secondMax=max;
				max=arr[i];
			}
			// arr[i]!=a is used to if there are duplicate values for max
			else if(arr[i]>secondMax && arr[i]!=max) {
				secondMax=arr[i];
			}
		}
		return secondMax;
	}

	public static int findSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int val: arr) {
            if(val>max) {
                secondMax=max;
                max=val;
            } else if(val<max && val>secondMax) {
                secondMax = val;
            }
        }
        return secondMax==Integer.MIN_VALUE ? -1 : secondMax;
    }
}