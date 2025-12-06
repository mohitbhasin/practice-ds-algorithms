import java.util.*;

class LuckyNumbersInAMatrix {
	public static void main(String[] args) {
		List<int[][]> matrixList = new ArrayList<>();
		matrixList.add(new int[][]{{3,7,8},{9,11,13},{15,16,17}});
		matrixList.add(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		matrixList.add(new int[][]{{10,20,30,40},{5,25,35,50},{60,70,80,90},{100,110,120,130}});

		for(int[][] matrix: matrixList) {
			System.out.println(luckyNumbers(matrix));
		}
	}

	public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<matrix.length; i++) {
            int minInRow = Integer.MAX_VALUE;
            int[] index = {-1,-1};
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]<minInRow) {
                    index[0]=i;
                    index[1]=j;
                    minInRow=matrix[i][j];
                }
            }
            // check column wise
            int maxInColumn = Integer.MIN_VALUE;
            int colIndex = index[1];
            for(int x=0; x<matrix.length; x++) {
                maxInColumn = Math.max(maxInColumn, matrix[x][colIndex]);
            }
            if(minInRow==maxInColumn) {
                result.add(minInRow);
            }
        }
        return result;
    }
}