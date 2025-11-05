import java.util.*;

class KEmptySlots {
	public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        List<Integer> kList = new ArrayList<>();

        list.add(new int[]{2,5,1,4,3});
        kList.add(1);
        list.add(new int[]{1,3,2});
        kList.add(1);
		list.add(new int[]{2,4,1,3});
        kList.add(0);

        for(int i=0; i<list.size(); i++) {
            System.out.println(kEmptySlots(list.get(i), kList.get(i)));
        }
    }

    // Bruteforce
    public static int kEmptySlots(int[] bulbs, int k) {
        boolean[] visited = new boolean[bulbs.length];
        for(int i=0; i<bulbs.length; i++) {
            visited[bulbs[i]-1]=true;
            if(helper(visited, k)) {
                return i+1;
            }
        }
        return -1;
    }

    public static boolean helper(boolean[] visited, int k) {
        int prev = 0;
        int curr = 1;
        int diff = 0;
        while(curr<visited.length) {
            if(visited[prev]==true && visited[curr]==true) {
                diff= curr-prev-1;
                if(diff==k) {
                    return true;
                }
                prev=curr;
            }
            if(visited[prev]==false) {
                prev++;
            }
            curr++;
        }
        return false;
    }
}