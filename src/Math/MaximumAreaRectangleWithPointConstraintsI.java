import java.util.*;


class MaximumAreaRectangleWithPointConstraintsI {
	public static void main(String[] args) {
        List<int[][]> pointsList = new ArrayList<>();

        pointsList.add(new int[][] {{1,1},{1,3},{4,1},{4,3}});
        pointsList.add(new int[][] {{0,0},{1,1},{2,2},{3,3}});
        pointsList.add(new int[][] {{1,1},{1,5},{2,2},{2,4},{10,1},{10,5}});
        pointsList.add(new int[][] {{0,0},{0,4},{4,0},{4,4},{3,2}});

        for(int i=0; i<pointsList.size(); i++) {
            System.out.println(maxRectangleArea(pointsList.get(i)));
        }
    }

    public static int maxRectangleArea(int[][] points) {
        Set<String> set = new HashSet<>();
        for(int[] point: points) {
            set.add(point[0]+","+point[1]);
        }
        int maxArea = -1;
        for(int i=0; i<points.length-1; i++) {
            for(int j=i+1; j<points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];
                if (a[0]==b[0] || a[1]==b[1]) {
                    continue; 
                }
                String x = a[0]+","+b[1];
                String y = b[0]+","+a[1];
                int minX = Math.min(a[0], b[0]);
                int maxX = Math.max(a[0], b[0]);
                int minY = Math.min(a[1], b[1]);
                int maxY = Math.max(a[1], b[1]);
                
                if(set.contains(x) && set.contains(y)) {
                    boolean isRectangle = true;
                    for(int[] point: points) {
                        String curr = point[0]+","+point[1];
                        if(point[0]>minX && point[0]<maxX && point[1]>minY && point[1]<maxY) {
                            isRectangle = false;
                            break;
                        }
                    }
                    if(isRectangle) {
                        int area = Math.abs(a[0]-b[0]) * Math.abs(a[1]-b[1]);
                        maxArea = Math.max(maxArea, area);   
                    }
                }
            }
        }
        return maxArea;
    }
}