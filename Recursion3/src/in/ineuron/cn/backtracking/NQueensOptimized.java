package in.ineuron.cn.backtracking;

import java.util.ArrayList;
import java.util.List;


public class NQueensOptimized {

	private static void placeNQueens(int[][] board, int N, int n, int m, int col, int[] upperDiagHash, 
			int[] leftRowHash, int[] lowerDiagHash, List<int[][]> list) {

		//baseCase:
		if(col == m) {
			list.add(board);
			return;
		}

		//checking each row of the given column where we can place the Queen as 1:
		for(int row = 0; row < n; row++) {
			
			if(upperDiagHash[(n-1) + (col - row)] == 0 && leftRowHash[row] == 0 && lowerDiagHash[row + col] == 0) {
				
				board[row][col] = 1;
				upperDiagHash[(n-1) + (col - row)] = 1;
				leftRowHash[row] = 1;
				lowerDiagHash[row + col] = 1;
				
				placeNQueens(board, N, n, m, col+1, upperDiagHash, leftRowHash, lowerDiagHash, list);
				
				//re-setting that row-col back to 0:
				board[row][col] = 0;
				upperDiagHash[(n-1) + (col - row)] = 0;
				leftRowHash[row] = 0;
				lowerDiagHash[row + col] = 0;
			}
		}
	}

	

	public static List<int[][]> solveNQueens(int[][] board, int N, int n, int m){

		List<int[][]> ansList = new ArrayList<>();

		int col = 0;
		int[] upperDiagHash = new int[2*n - 1];
		int[] leftRowHash = new int[n];
		int[] lowerDiagHash = new int[2*n - 1];
		
		placeNQueens(board, N, n, m, col, upperDiagHash, leftRowHash, lowerDiagHash, ansList);

		return ansList;
	}

}
