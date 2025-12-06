import java.util.*;


class MinimumCostToConnectSticks {
    public static void main(String[] args) {
        List<int[]> sticksList = new ArrayList<>();
        sticksList.add(new int[]{1,10,3,3,3});
        sticksList.add(new int[]{7,10,16});
        sticksList.add(new int[]{5,120,7,30,10});
        sticksList.add(new int[]{100,200,300,400,500});
        sticksList.add(new int[]{20,20,20,20});

        for(int[] sticks: sticksList) {
            System.out.println(connectSticks(sticks));
        }
    }

    public static int connectSticks (int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for(int stick: sticks) {
            pq.offer(stick);
        }
        int curr = 0;
        while(pq.size()>1) {
            curr=pq.poll();
            curr+=pq.poll();
            sum+=curr;
            pq.offer(curr);
        }
        return sum;
    }
}