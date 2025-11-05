import java.util.*;

class SumOfDistancesInATree {
	public static void main(String args[]) {
		int[][] edges = {{0,1},{0,2},{1,3},{2,4},{2,5}};
        int n = 6;
        int[] result = sumOfDistancesInTree(n, edges);
        for(int val: result) {
            System.out.print(val+",");
        }
	}
	// Bruteforce O(n^2)
	public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        if(n==1) return new int[]{0};
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int[] arr = new int[n];
        
        for(int[] edge: edges) {
            adjMap.putIfAbsent(edge[0], new ArrayList<>());
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.putIfAbsent(edge[1], new ArrayList<>());
            adjMap.get(edge[1]).add(edge[0]);
        }
        for(int i=0; i<n; i++) {
            total = 0;
            dfs(i, adjMap, new HashSet<Integer>(), 0);
            arr[i]=total;
        }
        return arr;
    }
    
    static int total;
    
    public static void dfs(int curr, Map<Integer, List<Integer>> adjMap, Set<Integer> visited, int count) {
        if(visited.contains(curr)) {
            return;
        }
        visited.add(curr);
        total+=count;
        for(int next: adjMap.get(curr)) {
            dfs(next, adjMap, visited, count+1);
        }
    }
}