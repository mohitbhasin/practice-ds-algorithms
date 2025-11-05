import java.util.*;

class CheckIfItIsAStraightLine {
	public static void main(String[] ags) {
		List<int[][]> coordinatesList = new ArrayList<>();
		coordinatesList.add(new int[][] {{0,1},{2,3},{3,4},{4,5}});
		coordinatesList.add(new int[][] {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}});
		coordinatesList.add(new int[][] {{1,100},{7,100},{1,100},{7,100},{1,100},{7,100},{1,100},{7,100},{1,100},{7,100}});

		for(int[][] coordinates: coordinatesList) {
			System.out.println(checkStraightLine(coordinates));	
		}
	}

	public static boolean checkStraightLine(int[][] coordinates) {
      double y = Math.abs(coordinates[0][1] - coordinates[1][1]);
      double x = Math.abs(coordinates[0][0] - coordinates[1][0]);
      double slope = 0;
      if(x!=0) {
         slope = y/x;
      }
      
      for(int i=2; i<coordinates.length; i++) {
         y = Math.abs(coordinates[i-1][1] - coordinates[i][1]);
         x = Math.abs(coordinates[i-1][0] - coordinates[i][0]);
         double currSlope = 0;
         if(x!=0) {
            currSlope = y/x;
         }
         if(currSlope!=slope) return false;
      }
      return true;
   }
}