import java.util.*;

class WhereWillBallFall {
    public static void main(String args[]) {
        // int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        // int[][] grid = {{-1,1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,1}};
        int[][] grid = {{-1,1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,1,-1,-1,-1,1,1,1,-1,-1,1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,1,-1,1,-1,-1,1,1,-1,1,-1,-1,-1,-1,1,1,1,1,1,1,-1,1,1,1,-1,1,1,1,-1,-1,-1,1,-1,1,-1,-1,1,1,-1,-1,1,-1,1,-1,1,1,1,-1,-1,-1,-1}};

        int[] result = findBall(grid);
        for(int ball: result) {
            System.out.print(ball+",");
        }
    }

    public static int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];

        for(int i=0; i<grid[0].length; i++) {
            result[i] = dfs(0, i, grid);
        }

        return result;
    }

    public static int dfs(int row, int col, int[][] grid) {
        if(row==grid.length) {
            return col;
        }
        int y = grid[row][col] == 1 ? col+1 : col-1;
]
        if(y<0 || y>=grid[0].length || grid[row][col]!=grid[row][y]) {
            return -1;
        }
        return dfs(row+1, y, grid);
    }

    // intuitive
    public static int[] findBall_slow(int[][] grid) {
        Set<int[]> ballSet = new HashSet<>();
        for(int i=0; i<grid[0].length; i++) {
            int[] coordinates = new int[3];
            coordinates[0] = 0;
            coordinates[1] = i;
            coordinates[2] = i;
            ballSet.add(coordinates);
        }

        int[] result = new int[grid[0].length];
        
        while(!ballSet.isEmpty()) {
            Iterator<int[]> it = ballSet.iterator();
            while(it.hasNext()) {
                int[] ball = it.next();
                int x = ball[0];
                int y = ball[1];
                int next_y;
                if(grid[x][y]==1) {
                    next_y = y+1;
                } else {
                    next_y = y-1;
                }

                if(next_y<0 || next_y>=grid[0].length || grid[x][next_y]!=grid[x][y]) {
                    result[ball[2]]=-1;
                    it.remove();
                } else {
                    if(ball[0]==grid.length-1) {
                        result[ball[2]]=next_y;
                        it.remove();
                    }
                    else {
                        ball[0]=x+1;
                        ball[1]=next_y;
                    }
                }
            }
        }

        return result;
    }
}