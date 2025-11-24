import java.util.*;


class MaximumRunningTimeOfNComputers {
	public static void main(String[] args) {
        List<int[]> battriesList = new ArrayList<>();
        List<Integer> nList = new ArrayList<>();
        battriesList.add(new int[]{3,3,3});
        nList.add(2);
        battriesList.add(new int[]{1,6,2,6,8});
        nList.add(5);
        battriesList.add(new int[]{1,2,3,4,5});
        nList.add(2);
        // expected: 11880
        battriesList.add(new int[]{2,3,1,7,10,5,8,6,61194,11838,96988,68446,85362,84935,33660,85385});
        nList.add(8);

        for(int i=0; i<battriesList.size(); i++) {
            System.out.println(maxRunTime(battriesList.get(i), nList.get(i)));
        }
    }

    public static int maxRunTime(int[] batteries, int n) {
        long total = 0;
        for(int battery: batteries) {
            total+=battery;
        }
        long low = 0;
        long high = total/n;

        while(low<=high) {
            long mid = low+((high-low)/2);
            if(canRun(mid, batteries, n)) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return (int) high;

    }

    public static boolean canRun(long time, int[] batteries, int n) {
        long requiredTime = time * n;
        long available = 0;
        for(int battery: batteries) {
            available+=Math.min(time, battery);
        }
        return available>=requiredTime;
    }
}