import java.util.*;

class RandomPickWithWeight {
	public static void main(String[] args) {
		List<int[]> list = new ArrayList<>();
		// list.add(new int[]{1});
		list.add(new int[]{1,3});
		Solution obj;

		for(int[] weights: list) {
			obj = new Solution(weights);
			for(int i=0; i<weights.length; i++) {
				System.out.print(obj.pickIndex()+",");
			}
			System.out.println();
		}
	}
}


class Solution {
	int[] prefixSum;
	Random rand = new Random();
	int sum = 0;
	int n = -1;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
    	prefixSum[0] = w[0];
    	for(int i=1; i<w.length; i++) {
    		prefixSum[i]=prefixSum[i-1]+w[i];
    	}
        sum = prefixSum[prefixSum.length-1];
        n = w.length;
    }
    
    public int pickIndex() {
        int target = rand.nextInt(sum)+1;
        int left = 0;
        int right = prefixSum.length-1;

        while(left<right) {
        	int mid = left + (right-left)/2;
        	if(prefixSum[mid]<target) {
        		left=mid+1;
        	} else {
        		right=mid;
        	}
        }
        return left;
    }
}