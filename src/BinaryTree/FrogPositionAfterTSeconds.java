import java.util.*;

class FrogPositionAfterTSeconds {
	public static void main(String[] args) {
        List<TestCase> testList = new ArrayList<>();
        // testList.add(new TestCase(3, new int[][]{{1,2},{2,3}}, 2, 3));
        testList.add(new TestCase(5, new int[][]{{1,2},{1,4},{2,3},{2,5}}, 5, 5));

        for(TestCase obj: testList) {
            System.out.println(frogPosition(obj.n, obj.edges, obj.t, obj.target));
        }
    }

    public static double frogPosition(int n, int[][] edges, int t, int target) {
    	map = new HashMap<>();
        for(int i=1; i<=n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return dfs(1, 0, t, target, 1.0);
    }
    static Map<Integer, List<Integer>> map;
    public static double dfs(int curr, int parent, int t, int target, double prob) {
    	int numJumps = map.get(curr).size();
    	if(curr!=1) {
    		numJumps--;
    	}
    	if(curr==target && (t==0 || numJumps==0)) {
    		return prob;
    	}

    	if(t==0.0) {
    		return 0.0;
    	}

    	if(numJumps>0) {
    		for(int next: map.get(curr)) {
    			if(next!=parent) {
    				double result = dfs(next, curr, t-1, target, prob*(1.0/numJumps));
    				if(result>0) {
    					return result;
    				}
    			}
    		}
    	}
    	return 0.0;
    }
}

class TestCase {
    int n;
    int[][] edges;
    int t;
    int target;

    public TestCase(int n, int[][] edges, int t, int target) {
        this.n = n;
        this.edges = edges;
        this.t = t;
        this.target = target;
    }
}