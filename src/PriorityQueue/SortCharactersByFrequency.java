import java.util.*;

class SortCharactersByFrequency {
	public static void main(String args[]) {
		String[] arr = {"tree", "cccaaa", "aaaAbb"};
		for(String s: arr) {
			System.out.println(frequencySort(s));
		}
	}

	public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++)  {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue((a,b) -> map.get(b)-map.get(a));
        for(char key: map.keySet()) {
            pq.offer(key);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            char c = pq.poll();
            for(int i=0; i<map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}