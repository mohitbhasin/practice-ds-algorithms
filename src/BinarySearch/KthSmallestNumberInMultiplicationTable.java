import java.util.*;

class KthSmallestNumberInMultiplicationTable {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        // 1    2   3   4   5
        // 2    4   6   8   10
        // 3    6   9   12  15
        // 4    8   12  16  20
        // 
        list.add(new int[]{5,7,20});

        for(int[] arr: list) {
            print(arr[0],arr[1],arr[2]);
            System.out.println(findKthNumber(arr[0],arr[1],arr[2]));
        }
    }

    public static int findKthNumber (int m, int n, int k) {
        int left = 1;
        int right = m*n;
        int result = 0;
        while(left<=right) {
            int mid = left + (right-left)/2;
            int count = helper(m,n,mid);
            if(count<k) {
                left=mid+1;
            }
            else {
                result = mid;
                right=mid-1;
            }
        }
        return result;
    }

    public static int helper(int m, int n, int target) {
        int count = 0;
        for(int i=1; i<=m; i++) {
            count+=Math.min(n, target/i);
        }
        return count;
    }

    public static void print(int m, int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                list.add(i*j);
            }
        }
        Collections.sort(list);
        System.out.println(list);
    }
}