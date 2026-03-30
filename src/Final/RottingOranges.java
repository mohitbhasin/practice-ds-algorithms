import java.util.*;

class RottingOranges {
	public static void main(String args[]) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(orangesRotting(grid));
	}


     public static int orangesRotting(int[][] grid) {
       int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        Queue<int[]> que = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==2) {
                    que.offer(new int[]{i,j});
                } else if(grid[i][j]==1) {
                    fresh++;
                }
            }
        }

        if(fresh==0) {
            return 0;
        }

        int count = 0;
        boolean rotting = false;

        while(!que.isEmpty()) {
            int size = que.size();
            for(int i=0; i<size; i++) {
                int[] curr = que.poll();
                for(int[] dir: directions) {
                    int x = curr[0]+dir[0];
                    int y = curr[1]+dir[1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1) {
                        grid[x][y]=2;
                        que.offer(new int[] {x, y});
                        fresh--;
                        rotting = true;
                    }
                }
            }
            if(rotting) {
                count++;
                rotting = false;
            }
        }
        return fresh==0 ? count : -1;
    }
}