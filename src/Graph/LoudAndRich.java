import java.util.*;


class LoudAndRich {
	public static void main(String[] args) {
        List<int[][]> richerList = new ArrayList<>();
        List<int[]> quietList = new ArrayList<>();

        richerList.add(new int[][] {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}});
        quietList.add(new int[] {3,2,5,4,6,1,7,0});
        
        richerList.add(new int[][] {{0,4},{1,3},{2,3},{3,4},{5,1},{6,0}});
        quietList.add(new int[] {2,4,6,0,5,3,1});

        for(int i=0; i<quietList.size(); i++) {
            int[] answer = loudAndRich(richerList.get(i), quietList.get(i));
            for(int val: answer) {
                System.out.print(val+", ");
            }
            System.out.println();
        }
    }

    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pair: richer) {
            int key = pair[1];
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(pair[0]);
        }

        int[] ans = new int[quiet.length];
        Arrays.fill(ans, -1);
        for(int i=0; i<quiet.length; i++) {
            dfs(i, map, quiet, ans);
        }
        return ans;
    }
    
    public static int dfs(int curr, Map<Integer, List<Integer>> map, int[] quiet, int[] ans) {
        if(ans[curr]!=-1) {
            return ans[curr];
        }
        int result = curr;
        if(map.containsKey(curr)) {
            for(int next: map.get(curr)) {
                int val = dfs(next, map, quiet, ans);
                if(quiet[val]<quiet[result]) {
                    result = val;
                }
            }
        }
        
        ans[curr] = result;
        return ans[curr];
    }
}