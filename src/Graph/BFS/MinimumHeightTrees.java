import java.util.*;

class MinimumHeightTrees {
	public static void main(String[] args) {
		List<int[][]> edgesList = new ArrayList<>();
		// edgesList.add(new int[][]{{1,0},{1,2},{1,3}});
		edgesList.add(new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}});

		for(int[][] edges: edgesList) {
			System.out.println(findMinHeightTrees(6, edges));
		}
	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		int[] indegree = new int[n];

        for(int[] edge: edges) {
        	adjList.putIfAbsent(edge[0], new ArrayList<>());
        	adjList.putIfAbsent(edge[1], new ArrayList<>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<n; i++) {
        	if(indegree[i]==1) {
        		que.offer(i);
        	}
        }

        while(!que.isEmpty()) {
        	if(que.size()<=2) {
        		break;
        	}
        	int size = que.size();
        	for(int i=0; i<size; i++) {
        		int curr = que.poll();
        		indegree[curr]--;
        		for(int neighbor: adjList.get(curr)) {
        			if(indegree[neighbor]==0) {
        				continue;
        			}
        			indegree[neighbor]--;
        			if(indegree[neighbor]==1) {
        				que.offer(neighbor);
        			}
        		}
        	}
        }
        return new ArrayList<>(que);
	}
}