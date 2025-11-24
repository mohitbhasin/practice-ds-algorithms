import java.util.*;

class SetMatrixZeros {
	public static void main(String args[]) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
 		setZeroes(matrix);
 		for(int i=0; i<matrix.length; i++) {
 			System.out.println();
            for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
		}
	}

	public static void setZeroes(int[][] matrix) {
		Set<Integer> row = new HashSet<Integer>();
		Set<Integer> column = new HashSet<Integer>();

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
        		if(matrix[i][j]==0) {
        			row.add(i);
        			column.add(j);
        		}
            }
        }

        for(int r: row) {
        	int temp=0;
        	while(temp<matrix[0].length) {
        		matrix[r][temp++]=0;
        	}
        }

         for(int c: column) {
        	int temp=0;
        	while(temp<matrix.length) {
        		matrix[temp++][c]=0;
        	}
        }
    }
}