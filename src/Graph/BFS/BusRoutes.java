import java.util.*;
import java.util.stream.*;

// [[7,12],[4,5,15],[11,19,29,9],[15,19],[9,12,13]] source 15, target 12


// 15: <1, 3>
// 5: <1>
// 4: <1>
// 19: <2, 3>
// 11: <2>
// 19: <2>
// 29: <2>
// 9: <2, 4>

class BusRoutes {
    public static void main(String[] args) {
        List<TestCase> testCases = new ArrayList<>();
        testCases.add(new TestCase(new int[][]{{7,12},{4,5,15},{11,19,29,9},{15,19},{9,12,13}}, 15, 12));

        for(TestCase test: testCases) {
            System.out.println(numBusesToDestination(test.routes, test.source, test.target));
        }
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopMap = new HashMap<>();

        // Building graph
        for(int i=0; i<routes.length; i++) {
            int[] route = routes[i];

            for(int stop: route) {
                stopMap.putIfAbsent(stop, new ArrayList<>());
                stopMap.get(stop).add(i);
            }
        }
        if(!stopMap.containsKey(source) || !stopMap.containsKey(target)) {
            return -1;
        }

        // BFS
        Queue<Integer> routesQueue = new LinkedList<>();
        Set<Integer> visitedRoute = new HashSet<>();

        for(int route: stopMap.get(source)) {
            routesQueue.offer(route);
            visitedRoute.add(route);
        }

        int busCount = 0;

        while(!routesQueue.isEmpty()) {
            int size = routesQueue.size();
            busCount++;
            for(int i=0; i<size; i++) {
                int route = routesQueue.poll();
                
                for(int stop: routes[route]) {
                    if(stop == target) {
                        return busCount;
                    }
                    for(int r: stopMap.get(stop)) {
                        if(!visitedRoute.contains(r)) {
                            visitedRoute.add(r);
                            routesQueue.offer(r);
                        }
                    }

                }
            }
        }
        return -1;
    }

}
class TestCase {
        int[][] routes;
        int source;
        int target;

        public TestCase(int[][] routes, int source, int target) {
            this.routes = routes;
            this.source = source;
            this.target = target;
        }
    }